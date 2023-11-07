package com.parsuomash.affogato.pdfviewerandroid

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
import com.parsuomash.affogato.pdfviewerandroid.internal.BlackPage
import com.parsuomash.affogato.pdfviewerandroid.internal.PageContentInt
import com.parsuomash.affogato.pdfviewerandroid.internal.PdfImage
import com.parsuomash.affogato.pdfviewerandroid.internal.loadPdf
import com.parsuomash.affogato.pdfviewerandroid.state.VerticalPdfReaderState
import com.parsuomash.affogato.pdfviewerandroid.zoomable.Zoomable
import com.parsuomash.affogato.pdfviewerandroid.zoomable.ZoomableDefaults
import com.parsuomash.affogato.pdfviewerandroid.zoomable.ZoomableState
import com.parsuomash.affogato.pdfviewerandroid.zoomable.rememberZoomableState

@Composable
fun VerticalPDFReader(
  modifier: Modifier = Modifier,
  state: VerticalPdfReaderState,
  zoomableState: ZoomableState = rememberZoomableState(
    minScale = ZoomableDefaults.DefaultScale
  )
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
      Zoomable(
        zoomableState = zoomableState,
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
