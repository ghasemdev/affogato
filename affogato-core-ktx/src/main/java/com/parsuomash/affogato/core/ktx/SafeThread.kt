package com.parsuomash.affogato.core.ktx

class SafeThreadLazy<T>(val provider: () -> T) : Lazy<T> {
  private val threadLocal = object : ThreadLocal<Lazy<T>>() {
    override fun initialValue(): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, provider)
  }

  override val value get() = threadLocal.get()!!.value
  override fun isInitialized() = threadLocal.get()!!.isInitialized()
}

fun <T> safeThread(provider: () -> T) = SafeThreadLazy(provider)
