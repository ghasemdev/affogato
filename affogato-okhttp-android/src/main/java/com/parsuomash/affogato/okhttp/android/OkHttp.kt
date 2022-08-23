package com.parsuomash.affogato.okhttp.android

import java.util.concurrent.ExecutorService
import okhttp3.Cache
import okhttp3.Call
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Response

/**
 * Factory for [calls][Call], which can be used to send HTTP requests and read their responses.
 *
 * ## OkHttpClients Should Be Shared
 *
 * OkHttp performs best when you create a single `OkHttpClient` instance and reuse it for all of
 * your HTTP calls. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. Conversely, creating a client
 * for each request wastes resources on idle pools.
 *
 * Use `OkHttpClient()` to create a shared instance with the default settings:
 *
 * ```
 * // The singleton HTTP client.
 * val client = OkHttpClient()
 * ```
 *
 * Or use `okHttp { }` to create a shared instance with custom settings:
 *
 * ```
 * // The singleton HTTP client.
 * val client = okHttp {
 *     addInterceptor(HttpLoggingInterceptor())
 *     cache(Cache(cacheDir, cacheSize))
 * }
 * ```
 *
 * ## Customize Your Client With newBuilder()
 *
 * You can customize a shared OkHttpClient instance with [new]. This builds a client that
 * shares the same connection pool, thread pools, and configuration. Use the builder methods to
 * configure the derived client for a specific purpose.
 *
 * This example shows a call with a short 500 millisecond timeout:
 *
 * ```
 * val eagerClient = okHttp {
 *     readTimeout(500, TimeUnit.MILLISECONDS)
 * }
 * val response = eagerClient.newCall(request).execute()
 * ```
 *
 * ## Shutdown Isn't Necessary
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources you may do
 * so.
 *
 * Shutdown the dispatcher's executor service with [shutdown()][ExecutorService.shutdown]. This will
 * also cause future calls to the client to be rejected.
 *
 * ```
 * client.dispatcher().executorService().shutdown()
 * ```
 *
 * Clear the connection pool with [evictAll()][ConnectionPool.evictAll]. Note that the connection
 * pool's daemon thread may not exit immediately.
 *
 * ```
 * client.connectionPool().evictAll()
 * ```
 *
 * If your client has a cache, call [close()][Cache.close]. Note that it is an error to create calls
 * against a cache that is closed, and doing so will cause the call to crash.
 *
 * ```
 * client.cache().close()
 * ```
 *
 * OkHttp also uses daemon threads for HTTP/2 connections. These will exit automatically if they
 * remain idle.
 * @since 1.5.0
 * @see OkHttpClient
 */
@JvmSynthetic
inline fun okHttp(
  init: OkHttpClient.Builder.() -> Unit
): OkHttpClient {
  val builder: OkHttpClient.Builder = OkHttpClient.Builder().also { init(it) }
  return builder.build()
}

/**
 * @since 1.5.0
 * @see OkHttpClient
 */
@JvmSynthetic
inline fun OkHttpClient.new(
  init: OkHttpClient.Builder.() -> Unit
): OkHttpClient {
  val builder: OkHttpClient.Builder = newBuilder().also { init(it) }
  return builder.build()
}

/**
 * @since 1.5.0
 * @see Response
 */
@JvmSynthetic
inline fun Response.new(
  init: Response.Builder.() -> Unit
): Response {
  val builder: Response.Builder = newBuilder().also { init(it) }
  return builder.build()
}
