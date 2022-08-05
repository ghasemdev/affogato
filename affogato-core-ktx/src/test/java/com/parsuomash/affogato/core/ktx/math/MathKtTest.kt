package com.parsuomash.affogato.core.ktx.math

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MathKtTest {
  @Test
  @DisplayName("almost equals")
  fun almostEq() {
    assertThat(5 almostEq 5).isFalse()
    assertThat(24.2 almostEq 24).isTrue()
    assertThat(1.999 almostEq 2).isTrue()
    assertThat(2 almostEq 1.9999).isTrue()
    assertThat(1.00001 almostEq 1).isTrue()
    assertThat(2.5F almostEq 2F).isTrue()
    assertThat(2.5F almostEq 2.5).isTrue()
    assertThat(2.5F almostEq 3F).isFalse()
  }

  @Test
  @DisplayName("percentage")
  fun percentage() {
    assertThat(24 perc 2).isEqualTo(0.48)
    assertThat(24 perc 3.3).isEqualTo(0.7919999999999999)
    assertThat(24 perc 5L).isEqualTo(1.2)
    assertThat(24 perc 2.3F).isEqualTo(0.5519999885559081)

    assertThat(24.2 perc 2).isEqualTo(0.484)
    assertThat(24.2 perc 3.3).isEqualTo(0.7986)
    assertThat(24.2 perc 5L).isEqualTo(1.21)
    assertThat(24.2 perc 2.3F).isEqualTo(0.5565999884605407)

    assertThat(24F perc 2).isEqualTo(0.48)
    assertThat(24F perc 3.3).isEqualTo(0.7919999999999999)
    assertThat(24F perc 5L).isEqualTo(1.2)
    assertThat(24F perc 2.3).isEqualTo(0.5519999999999999)

    assertThat(24L perc 2).isEqualTo(0.48)
    assertThat(24L perc 3.3).isEqualTo(0.7919999999999999)
    assertThat(24L perc 5L).isEqualTo(1.2)
    assertThat(24L perc 2.3F).isEqualTo(0.5519999885559081)
  }

  @Test
  @DisplayName("logaritm")
  fun logaritm() {
    assertThat(2 log 3).isEqualTo(0.6309297535714574)
    assertThat(2 log 3.3).isEqualTo(0.5805629752883311)
    assertThat(2 log 5L).isEqualTo(0.43067655807339306)
    assertThat(2 log 2.3F).isEqualTo(0.8322002709858297)

    assertThat(1.2 log 2).isEqualTo(0.2630344058337938)
    assertThat(1.2 log 3.3).isEqualTo(0.15270803725406568)
    assertThat(1.2 log 5L).isEqualTo(0.11328275255937834)
    assertThat(1.2 log 2.3F).isEqualTo(0.2188973038134799)

    assertThat(5F log 2).isEqualTo(2.321928094887362)
    assertThat(5F log 3.3).isEqualTo(1.3480254831733733)
    assertThat(5F log 5L).isEqualTo(1)
    assertThat(5F log 2.3).isEqualTo(1.9323091416775124)

    assertThat(100L log 2).isEqualTo(6.643856189774725)
    assertThat(100L log 3.3).isEqualTo(3.8571769169234096)
    assertThat(100L log 5L).isEqualTo(2.8613531161467867)
    assertThat(100L log 2.3).isEqualTo(5.529018783897873)
  }

  @Test
  @DisplayName("power")
  fun power() {
    assertThat(2 pow 3).isEqualTo(8)
    assertThat(2 pow 3.3).isEqualTo(9.849155306759329)
    assertThat(2 pow 5L).isEqualTo(32)
    assertThat(2 pow 2.3F).isEqualTo(4.924577490613348)

    assertThat(1.2 pow 2).isEqualTo(1.44)
    assertThat(1.2 pow 3.3).isEqualTo(1.8251481054630379)
    assertThat(1.2 pow 5L).isEqualTo(2.4883199999999994)
    assertThat(1.2 pow 2.3F).isEqualTo(1.5209567413296845)

    assertThat(5F pow 2).isEqualTo(25)
    assertThat(5F pow 3.3).isEqualTo(202.58207458659524)
    assertThat(5F pow 5L).isEqualTo(3125)
    assertThat(5F pow 2.3).isEqualTo(40.51641491731905)

    assertThat(100L pow 2).isEqualTo(10000.0)
    assertThat(100L pow 3.3).isEqualTo(3981071.7055349695)
    assertThat(100L pow 5L).isEqualTo(1.0E10)
    assertThat(100L pow 2.3).isEqualTo(39810.71705534969)
  }
}
