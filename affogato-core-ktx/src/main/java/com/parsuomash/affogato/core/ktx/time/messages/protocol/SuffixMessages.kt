package com.parsuomash.affogato.core.ktx.time.messages.protocol

/**
 * [SuffixMessages] template for [LookupMessages].
 * @since 1.1.0
 */
interface SuffixMessages {
  /** Example: `prefixAgo()` 1 min `suffixAgo()` */
  fun suffixAgo(): String = ""

  /** Example: `prefixFromNow()` 1 min `suffixFromNow()` */
  fun suffixFromNow(): String = ""
}
