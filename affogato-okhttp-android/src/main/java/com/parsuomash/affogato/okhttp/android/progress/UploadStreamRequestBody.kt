package com.parsuomash.affogato.okhttp.android.progress

import java.io.File
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okio.BufferedSink

/**
 * UploadStreamRequestBody is a helper class for tracking upload progress.
 * @since 1.5.0
 * @see RequestBody
 * @see MediaType
 */
class UploadStreamRequestBody(
  private val mediaType: String,
  private val file: File,
  private val onUploadProgress: (Int) -> Unit,
) : RequestBody() {
  override fun contentLength(): Long = file.inputStream().available().toLong()
  override fun contentType(): MediaType? = mediaType.toMediaTypeOrNull()

  override fun writeTo(sink: BufferedSink) {
    val contentLength = file.inputStream().available().toFloat()
    // DEFAULT_BUFFER_SIZE constant from kotlin.io.ConstantsKt
    val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
    file.inputStream().use { inputStream ->
      var uploaded = 0
      var read: Int
      // Reads the stream until the content ends
      while (inputStream.read(buffer).also { read = it } != -1) {
        uploaded += read
        sink.write(buffer, 0, read)
        onUploadProgress(((uploaded / contentLength) * MAX_PROGRESS_PERCENTAGE).toInt())
      }
    }
  }

  companion object {
    private const val MAX_PROGRESS_PERCENTAGE = 100
  }
}
