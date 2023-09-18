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
import com.parsuomash.affogato.pdfviewer.internal.tapToZoomVertical
import com.parsuomash.affogato.pdfviewer.state.VerticalPdfReaderState

@Composable
fun VerticalPDFReader(
  state: VerticalPdfReaderState,
  modifier: Modifier
) {
  BoxWithConstraints(
    modifier = modifier,
    contentAlignment = Alignment.TopCenter
  ) {
    val ctx = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val lazyState = state.lazyState
    DisposableEffect(state.resource) {
      loadPdf(
        coroutineScope,
        ctx,
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
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .tapToZoomVertical(state, constraints),
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
