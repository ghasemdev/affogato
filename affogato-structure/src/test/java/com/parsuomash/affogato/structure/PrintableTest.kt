package com.parsuomash.affogato.structure

import com.google.common.truth.Truth.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PrintableTest {
  private val outContent = ByteArrayOutputStream()
  private val originalOut = System.out

  private val errContent = ByteArrayOutputStream()
  private val originalErr = System.err

  @BeforeAll
  fun setUpStreams() {
    System.setOut(PrintStream(outContent))
    System.setErr(PrintStream(errContent))
  }

  @AfterAll
  fun restoreStreams() {
    System.setOut(originalOut)
    System.setErr(originalErr)
  }

  @Test
  @DisplayName("printable implementation test")
  fun printable() {
    val printable = object : Printable {
      override fun print(message: Any?) {
        println(message)
      }
    }
    printable.print("test")
    assertThat(outContent.toString()).contains("test")
  }
}
