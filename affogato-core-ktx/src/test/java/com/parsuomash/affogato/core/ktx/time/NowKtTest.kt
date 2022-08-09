package com.parsuomash.affogato.core.ktx.time

import org.junit.jupiter.api.Test

internal class NowKtTest {
  @Test
  fun testIsImpossible() {
    now()
    nowInMilliseconds()
    nowInDate()
    nowInCalendar()
    nowInLocalDate()
    nowInLocalDateTime()
  }
}
