package com.parsuomash.affogato.pdfviewer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.parsuomash.affogato.pdfviewer.internal.base64ToPdf
import com.parsuomash.affogato.pdfviewer.internal.generateFileName
import com.parsuomash.affogato.pdfviewer.network.getDownloadInterface
import com.parsuomash.affogato.pdfviewer.state.ResourceType
import com.parsuomash.affogato.pdfviewer.state.VerticalPdfReaderState
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableDefaults
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableState
import com.parsuomash.affogato.pdfviewer.zoomable.rememberZoomableState
import java.io.File
import kotlinx.coroutines.launch

@Composable
fun VerticalPDFView(
  modifier: Modifier = Modifier,
  state: VerticalPdfReaderState,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
) {
  val coroutineScope = rememberCoroutineScope()
  var currentPage by rememberSaveable { mutableIntStateOf(0) }
  var isDefaultPageLoaded by rememberSaveable { mutableStateOf(false) }

  AndroidView(
    modifier = modifier,
    factory = { context ->
      PDFView(context, null)
    },
    update = { pdfView ->
      coroutineScope.launch {
        runCatching {
          pdfView.apply {
            if (state.isLoaded) {
              fromFile(state.mFile)
            } else {
              when (val res = state.resource) {
                is ResourceType.Asset -> {
                  val bufferSize = 8192
                  val inputStream = context.resources.openRawResource(res.assetId)
                  val outFile = File(context.cacheDir, generateFileName())
                  inputStream.use { input ->
                    outFile.outputStream().use { output ->
                      var data = ByteArray(bufferSize)
                      var count = input.read(data)
                      while (count != -1) {
                        output.write(data, 0, count)
                        data = ByteArray(bufferSize)
                        count = input.read(data)
                      }
                    }
                  }
                  state.mFile = outFile
                  fromFile(outFile)
                }

                is ResourceType.Base64 -> {
                  val file = context.base64ToPdf(res.file)
                  state.mFile = file
                  fromFile(file)
                }

                is ResourceType.Local -> {
                  fromUri(res.uri)
                }

                is ResourceType.Remote -> {
                  val bufferSize = 8192
                  var downloaded = 0
                  val file = File(context.cacheDir, generateFileName())
                  val response = getDownloadInterface(
                    res.headers
                  ).downloadFile(
                    res.url
                  )
                  val byteStream = response.byteStream()
                  byteStream.use { input ->
                    file.outputStream().use { output ->
                      val totalBytes = response.contentLength()
                      var data = ByteArray(bufferSize)
                      var count = input.read(data)
                      while (count != -1) {
                        if (totalBytes > 0) {
                          downloaded += bufferSize
                          state.mLoadPercent =
                            (downloaded * (100 / totalBytes.toFloat())).toInt()
                        }
                        output.write(data, 0, count)
                        data = ByteArray(bufferSize)
                        count = input.read(data)
                      }
                    }
                  }
                  state.mFile = file
                  fromFile(file)
                }
              }
            }.apply {
              minZoom = zoomableState.minScale
              midZoom = zoomableState.doubleTapScale
              maxZoom = zoomableState.maxScale
              pageFitPolicy(FitPolicy.WIDTH)
              useBestQuality(true)

              if (isDefaultPageLoaded.not()) {
                defaultPage(currentPage)
                isDefaultPageLoaded = true
              }
            }.load()
          }
        }.onFailure {
          state.mError = it
        }
      }
    },
    onRelease = { pdfView ->
      currentPage = pdfView.currentPage
      isDefaultPageLoaded = false
    }
  )
}
