package com.parsuomash.affogato.pdfviewer.internal

import android.content.Context
import android.os.ParcelFileDescriptor
import com.parsuomash.affogato.pdfviewer.network.getDownloadInterface
import com.parsuomash.affogato.pdfviewer.state.PdfReaderState
import com.parsuomash.affogato.pdfviewer.state.ResourceType
import java.io.File
import java.io.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal fun loadPdf(
    coroutineScope: CoroutineScope,
    context: Context,
    state: PdfReaderState,
    width: Int,
    height: Int,
    portrait: Boolean
) {
  runCatching {
    if (state.isLoaded) {
      coroutineScope.launch(Dispatchers.IO) {
        runCatching {
          val pFD =
            ParcelFileDescriptor.open(state.mFile, ParcelFileDescriptor.MODE_READ_ONLY)
          val textForEachPage =
            if (state.isAccessibleEnable) getTextByPage(context, pFD) else emptyList()
          state.pdfRender =
            PdfRenderer(pFD, textForEachPage, width, height, portrait)
        }.onFailure {
          state.mError = it
        }
      }
    } else {
      when (val res = state.resource) {
        is ResourceType.Local -> {
          coroutineScope.launch(Dispatchers.IO) {
            runCatching {
              context.contentResolver.openFileDescriptor(res.uri, "r")?.let {
                val textForEachPage = if (state.isAccessibleEnable) {
                  getTextByPage(context, it)
                } else emptyList()
                state.pdfRender =
                  PdfRenderer(it, textForEachPage, width, height, portrait)
                state.mFile = context.uriToFile(res.uri)
              } ?: throw IOException("File not found")
            }.onFailure {
              state.mError = it
            }
          }
        }

        is ResourceType.Remote -> {
          coroutineScope.launch(Dispatchers.IO) {
            runCatching {
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
              val pFD = ParcelFileDescriptor.open(
                file,
                ParcelFileDescriptor.MODE_READ_ONLY
              )
              val textForEachPage = if (state.isAccessibleEnable) {
                getTextByPage(context, pFD)
              } else emptyList()
              state.pdfRender =
                PdfRenderer(pFD, textForEachPage, width, height, portrait)
              state.mFile = file
            }.onFailure {
              state.mError = it
            }
          }
        }

        is ResourceType.Base64 -> {
          coroutineScope.launch(Dispatchers.IO) {
            runCatching {
              val file = context.base64ToPdf(res.file)
              val pFD = ParcelFileDescriptor.open(
                file,
                ParcelFileDescriptor.MODE_READ_ONLY
              )
              val textForEachPage = if (state.isAccessibleEnable) {
                getTextByPage(context, pFD)
              } else emptyList()
              state.pdfRender =
                PdfRenderer(pFD, textForEachPage, width, height, portrait)
              state.mFile = file
            }.onFailure {
              state.mError = it
            }
          }
        }

        is ResourceType.Asset -> {
          coroutineScope.launch(Dispatchers.IO) {
            runCatching {
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
              val pFD = ParcelFileDescriptor.open(
                outFile,
                ParcelFileDescriptor.MODE_READ_ONLY
              )
              val textForEachPage = if (state.isAccessibleEnable) {
                getTextByPage(context, pFD)
              } else emptyList()
              state.pdfRender =
                PdfRenderer(pFD, textForEachPage, width, height, portrait)
              state.mFile = outFile
            }.onFailure {
              state.mError = it
            }
          }
        }
      }
    }
  }.onFailure {
    state.mError = it
  }
}
