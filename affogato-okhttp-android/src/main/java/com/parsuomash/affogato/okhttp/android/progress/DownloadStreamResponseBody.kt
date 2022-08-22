package com.parsuomash.affogato.okhttp.android.progress

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource
import okio.ForwardingSource
import okio.Source
import okio.buffer

/**
 * DownloadStreamResponseBody is a helper class for tracking download progress.
 * @since 1.5.0
 * @see ResponseBody
 * @see MediaType
 * @see ForwardingSource
 */
class DownloadStreamResponseBody(
  private val mediaType: String,
  private val responseBody: ResponseBody,
  private val onDownloadProgress: (Int) -> Unit,
) : ResponseBody() {
  private var bufferedSource: BufferedSource? = null

  override fun contentLength(): Long = responseBody.byteStream().available().toLong()
  override fun contentType(): MediaType? = mediaType.toMediaTypeOrNull()

  override fun source(): BufferedSource {
    if (bufferedSource == null) {
      bufferedSource = onProgress(responseBody.source()).buffer()
    }
    return bufferedSource!!
  }

  private fun onProgress(source: BufferedSource): Source {
    return object : ForwardingSource(source) {
      var totalBytesRead = 0f

      override fun read(sink: Buffer, byteCount: Long): Long {
        val bytesRead = super.read(sink, byteCount)

        totalBytesRead += if (bytesRead != -1L) bytesRead else 0
        val percent: Float = if (bytesRead == -1L) MAX_PROGRESS_PERCENTAGE.toFloat() else {
          (totalBytesRead / responseBody.contentLength()) * MAX_PROGRESS_PERCENTAGE
        }

        onDownloadProgress(percent.toInt())
        return bytesRead
      }
    }
  }

  companion object {
    private const val MAX_PROGRESS_PERCENTAGE = 100
  }
}
