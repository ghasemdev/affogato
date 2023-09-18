package com.parsuomash.affogato.pdfviewer

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import com.parsuomash.affogato.pdfviewer.internal.BlackPage
import com.parsuomash.affogato.pdfviewer.internal.PageContentInt
import com.parsuomash.affogato.pdfviewer.internal.PdfImage
import com.parsuomash.affogato.pdfviewer.internal.loadPdf
import com.parsuomash.affogato.pdfviewer.state.VerticalPdfReaderState
import com.parsuomash.affogato.pdfviewer.zoomable.Zoomable
import com.parsuomash.affogato.pdfviewer.zoomable.ZoomableDefaults
import com.parsuomash.affogato.pdfviewer.zoomable.rememberZoomableState

@Composable
fun VerticalPDFReader(
  state: VerticalPdfReaderState,
  modifier: Modifier
) {
  BoxWithConstraints(
    modifier = modifier,
    contentAlignment = Alignment.TopCenter
  ) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val lazyState = state.lazyState

    DisposableEffect(state.resource) {
      loadPdf(
        coroutineScope,
        context,
        state,
        constraints.maxWidth,
        constraints.maxHeight,
        true
      )
      onDispose {
        state.close()
      }
    }

    state.pdfRender?.let { pdf ->
      val zoomableState = rememberZoomableState(
        minScale = ZoomableDefaults.DefaultScale
      )

      Zoomable(
        state = zoomableState,
        enabled = state.isZoomEnable
      ) {
        LazyColumn(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          state = lazyState
        ) {
          items(pdf.pageCount) {
            val pageContent = pdf.pageLists[it].stateFlow.collectAsState().value
            DisposableEffect(key1 = Unit) {
              pdf.pageLists[it].load()
              onDispose {
                pdf.pageLists[it].recycle()
              }
            }
            when (pageContent) {
              is PageContentInt.PageContent -> {
                PdfImage(
                  bitmap = { pageContent.bitmap.asImageBitmap() },
                  contentDescription = pageContent.contentDescription
                )
              }

              is PageContentInt.BlankPage -> {
                BlackPage(
                  width = pageContent.width,
                  height = pageContent.height
                )
              }
            }
          }
        }
      }
    }
  }
}
