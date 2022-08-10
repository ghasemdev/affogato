package com.parsuomash.affogato.core.ktx.time.messages

/**
 * [PrefixMessages] template prefix message for [LookupMessages].
 * @since 1.1.0
 */
interface PrefixMessages {
  /** Example: `prefixAgo()` 1 min `suffixAgo()` */
  fun prefixAgo(): String = ""

  /** Example: `prefixFromNow()` 1 min `suffixFromNow()` */
  fun prefixFromNow(): String = ""
}
