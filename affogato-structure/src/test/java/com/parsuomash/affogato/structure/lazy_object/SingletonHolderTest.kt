@file:Suppress("LongParameterList")

package com.parsuomash.affogato.structure.lazy_object

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class SingletonHolderTest {
  @Test
  fun `test singleton holder1`() {
    Foo("A")
    Foo("A")
    Foo("A")
    assertThat(Foo.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder2`() {
    Foo2("A", "B")
    Foo2("A", "B")
    Foo2("A", "B")
    assertThat(Foo2.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder3`() {
    Foo3("A", "B", "C")
    Foo3("A", "B", "C")
    Foo3("A", "B", "C")
    assertThat(Foo3.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder4`() {
    Foo4("A", "B", "C", "D")
    Foo4("A", "B", "C", "D")
    Foo4("A", "B", "C", "D")
    assertThat(Foo4.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder5`() {
    Foo5("A", "B", "C", "D", "E")
    Foo5("A", "B", "C", "D", "E")
    Foo5("A", "B", "C", "D", "E")
    assertThat(Foo5.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder6`() {
    Foo6("A", "B", "C", "D", "E", "F")
    Foo6("A", "B", "C", "D", "E", "F")
    Foo6("A", "B", "C", "D", "E", "F")
    assertThat(Foo6.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder7`() {
    Foo7("A", "B", "C", "D", "E", "F", "G")
    Foo7("A", "B", "C", "D", "E", "F", "G")
    Foo7("A", "B", "C", "D", "E", "F", "G")
    assertThat(Foo7.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder8`() {
    Foo8("A", "B", "C", "D", "E", "F", "G", "H")
    Foo8("A", "B", "C", "D", "E", "F", "G", "H")
    Foo8("A", "B", "C", "D", "E", "F", "G", "H")
    assertThat(Foo8.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder9`() {
    Foo9("A", "B", "C", "D", "E", "F", "G", "H", "I")
    Foo9("A", "B", "C", "D", "E", "F", "G", "H", "I")
    Foo9("A", "B", "C", "D", "E", "F", "G", "H", "I")
    assertThat(Foo9.counter).isEqualTo(1)
  }

  @Test
  fun `test singleton holder10`() {
    Foo10("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    Foo10("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    Foo10("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    assertThat(Foo10.counter).isEqualTo(1)
  }
}

class Foo private constructor(bar: String) {
  init {
    println("${++counter}: Foo initialized with $bar")
  }

  companion object : SingletonHolder<Foo, String>(::Foo) {
    var counter = 0
  }
}

class Foo2 private constructor(bar: String, bar2: String) {
  init {
    println("${++counter}: Foo initialized with $bar $bar2")
  }

  companion object : SingletonHolder2<Foo2, String, String>(::Foo2) {
    var counter = 0
  }
}

class Foo3 private constructor(bar: String, bar2: String, bar3: String) {
  init {
    println("${++counter}: Foo initialized with $bar $bar2 $bar3")
  }

  companion object : SingletonHolder3<Foo3, String, String, String>(::Foo3) {
    var counter = 0
  }
}

class Foo4 private constructor(bar: String, bar2: String, bar3: String, bar4: String) {
  init {
    println("${++counter}: Foo initialized with $bar $bar2 $bar3 $bar4")
  }

  companion object : SingletonHolder4<Foo4, String, String, String, String>(::Foo4) {
    var counter = 0
  }
}

class Foo5 private constructor(
  bar: String,
  bar2: String,
  bar3: String,
  bar4: String,
  bar5: String
) {
  init {
    println("${++counter}: Foo initialized with $bar $bar2 $bar3 $bar4 $bar5")
  }

  companion object : SingletonHolder5<Foo5, String, String, String, String, String>(::Foo5) {
    var counter = 0
  }
}

class Foo6 private constructor(
  bar: String,
  bar2: String,
  bar3: String,
  bar4: String,
  bar5: String,
  bar6: String
) {
  init {
    println("${++counter}: Foo initialized with $bar $bar2 $bar3 $bar4 $bar5 $bar6")
  }

  companion object :
    SingletonHolder6<Foo6, String, String, String, String, String, String>(::Foo6) {
    var counter = 0
  }
}

class Foo7 private constructor(
  bar: String,
  bar2: String,
  bar3: String,
  bar4: String,
  bar5: String,
  bar6: String,
  bar7: String
) {
  init {
    println("${++counter}: Foo initialized with $bar $bar2 $bar3 $bar4 $bar5 $bar6 $bar7")
  }

  companion object :
    SingletonHolder7<Foo7, String, String, String, String, String, String, String>(::Foo7) {
    var counter = 0
  }
}

class Foo8 private constructor(
  bar: String,
  bar2: String,
  bar3: String,
  bar4: String,
  bar5: String,
  bar6: String,
  bar7: String,
  bar8: String
) {
  init {
    println("${++counter}: Foo initialized with $bar $bar2 $bar3 $bar4 $bar5 $bar6 $bar7 $bar8")
  }

  companion object :
    SingletonHolder8<Foo8, String, String, String, String, String, String, String, String>(::Foo8) {
    var counter = 0
  }
}

class Foo9 private constructor(
  bar: String,
  bar2: String,
  bar3: String,
  bar4: String,
  bar5: String,
  bar6: String,
  bar7: String,
  bar8: String,
  bar9: String
) {
  init {
    println(
      "${++counter}: Foo initialized with $bar $bar2 $bar3 $bar4 $bar5 $bar6 $bar7 $bar8 $bar9"
    )
  }

  companion object :
    SingletonHolder9<Foo9, String, String, String, String, String, String, String, String, String>(
      ::Foo9
    ) {
    var counter = 0
  }
}

class Foo10 private constructor(
  bar: String,
  bar2: String,
  bar3: String,
  bar4: String,
  bar5: String,
  bar6: String,
  bar7: String,
  bar8: String,
  bar9: String,
  bar10: String
) {
  init {
    println(
      "${++counter}: Foo initialized with $bar $bar2 $bar3 $bar4 $bar5 $bar6" +
        " $bar7 $bar8 $bar9 $bar10"
    )
  }

  companion object :
    SingletonHolder10<Foo10, String, String, String, String, String,
      String, String, String, String, String>(
      ::Foo10
    ) {
    var counter = 0
  }
}
