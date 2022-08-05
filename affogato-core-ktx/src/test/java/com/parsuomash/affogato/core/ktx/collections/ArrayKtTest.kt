package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ArrayKtTest {
  @Nested
  @DisplayName("Array Builders")
  inner class Builder {
    @Nested
    @DisplayName("from Range")
    inner class Range {
      @Test
      @DisplayName("build integer array")
      fun integer() {
        val intArray = arrayOf(1..10)
        assertThat(intArray.size).isEqualTo(10)
        assertThat(intArray).isInstanceOf(Array<Int>::class.java)
        assertThat(intArray).isEqualTo((1..10).toList().toTypedArray())

        val intArray2: IntArray = intArrayOf(1..10)
        assertThat(intArray2.size).isEqualTo(10)
        assertThat(intArray2).isInstanceOf(IntArray::class.java)
        assertThat(intArray2).isEqualTo((1..10).toList().toIntArray())
      }

      @Test
      @DisplayName("build long array")
      fun long() {
        val longArray = arrayOf(1..10L)
        assertThat(longArray.size).isEqualTo(10)
        assertThat(longArray).isInstanceOf(Array<Long>::class.java)
        assertThat(longArray).isEqualTo((1..10L).toList().toTypedArray())

        val longArray2: LongArray = longArrayOf(1..10L)
        assertThat(longArray2.size).isEqualTo(10)
        assertThat(longArray2).isInstanceOf(LongArray::class.java)
        assertThat(longArray2).isEqualTo((1..10L).toList().toLongArray())
      }

      @Test
      @DisplayName("build char array")
      fun char() {
        val charArray = arrayOf('a'..'z')
        assertThat(charArray.size).isEqualTo(26)
        assertThat(charArray).isInstanceOf(Array<Char>::class.java)
        assertThat(charArray).isEqualTo(('a'..'z').toList().toTypedArray())

        val charArray2: CharArray = charArrayOf('a'..'z')
        assertThat(charArray2.size).isEqualTo(26)
        assertThat(charArray2).isInstanceOf(CharArray::class.java)
        assertThat(charArray2).isEqualTo(('a'..'z').toList().toCharArray())
      }

      @OptIn(ExperimentalUnsignedTypes::class)
      @Test
      @DisplayName("build un sign integer")
      fun uInteger() {
        val uIntArray: Array<UInt> = arrayOf(1u..10u)
        assertThat(uIntArray.size).isEqualTo(10)
        assertThat(uIntArray).isInstanceOf(Array<UInt>::class.java)
        assertThat(uIntArray.contentEquals((1u..10u).toList().toTypedArray())).isTrue()

        val uIntArray2: UIntArray = uintArrayOf(1u..10u)
        assertThat(uIntArray2.size).isEqualTo(10)
        assertThat(uIntArray2).isInstanceOf(UIntArray::class.java)
        assertThat(uIntArray2.contentEquals((1u..10u).toList().toUIntArray())).isTrue()
      }

      @OptIn(ExperimentalUnsignedTypes::class)
      @Test
      @DisplayName("build un sign long array")
      fun uLong() {
        val uLongArray: Array<ULong> = arrayOf(1uL..10uL)
        assertThat(uLongArray.size).isEqualTo(10)
        assertThat(uLongArray).isInstanceOf(Array<ULong>::class.java)
        assertThat(uLongArray.contentEquals((1uL..10uL).toList().toTypedArray())).isTrue()

        val uLongArray2: ULongArray = ulongArrayOf(1uL..10uL)
        assertThat(uLongArray2.size).isEqualTo(10)
        assertThat(uLongArray2).isInstanceOf(ULongArray::class.java)
        assertThat(uLongArray2.contentEquals((1uL..10uL).toList().toULongArray())).isTrue()
      }
    }

    @Nested
    @DisplayName("from Progression")
    inner class Progression {
      @Test
      @DisplayName("build integer array")
      fun integer() {
        val intArray = arrayOf(1..10 step 2)
        assertThat(intArray.size).isEqualTo(5)
        assertThat(intArray).isInstanceOf(Array<Int>::class.java)
        assertThat(intArray).isEqualTo((1..10 step 2).toList().toTypedArray())

        val intArray2: IntArray = intArrayOf(1..10 step 2)
        assertThat(intArray2.size).isEqualTo(5)
        assertThat(intArray2).isInstanceOf(IntArray::class.java)
        assertThat(intArray2).isEqualTo((1..10 step 2).toList().toIntArray())
      }

      @Test
      @DisplayName("build long array")
      fun long() {
        val longArray = arrayOf(1..10L step 2)
        assertThat(longArray.size).isEqualTo(5)
        assertThat(longArray).isInstanceOf(Array<Long>::class.java)
        assertThat(longArray).isEqualTo((1..10L step 2).toList().toTypedArray())

        val longArray2: LongArray = longArrayOf(1..10L step 2)
        assertThat(longArray2.size).isEqualTo(5)
        assertThat(longArray2).isInstanceOf(LongArray::class.java)
        assertThat(longArray2).isEqualTo((1..10L step 2).toList().toLongArray())
      }

      @Test
      @DisplayName("build char array")
      fun char() {
        val charArray = arrayOf('a'..'z' step 2)
        assertThat(charArray.size).isEqualTo(13)
        assertThat(charArray).isInstanceOf(Array<Char>::class.java)
        assertThat(charArray).isEqualTo(('a'..'z' step 2).toList().toTypedArray())

        val charArray2: CharArray = charArrayOf('a'..'z' step 2)
        assertThat(charArray2.size).isEqualTo(13)
        assertThat(charArray2).isInstanceOf(CharArray::class.java)
        assertThat(charArray2).isEqualTo(('a'..'z' step 2).toList().toCharArray())
      }

      @OptIn(ExperimentalUnsignedTypes::class)
      @Test
      @DisplayName("build un sign integer array")
      fun uInteger() {
        val uIntArray: Array<UInt> = arrayOf(1u..10u step 2)
        assertThat(uIntArray.size).isEqualTo(5)
        assertThat(uIntArray).isInstanceOf(Array<UInt>::class.java)
        assertThat(uIntArray.contentEquals((1u..10u step 2).toList().toTypedArray())).isTrue()

        val uIntArray2: UIntArray = uintArrayOf(1u..10u step 2)
        assertThat(uIntArray2.size).isEqualTo(5)
        assertThat(uIntArray2).isInstanceOf(UIntArray::class.java)
        assertThat(uIntArray2.contentEquals((1u..10u step 2).toList().toUIntArray())).isTrue()
      }

      @OptIn(ExperimentalUnsignedTypes::class)
      @Test
      @DisplayName("build un sign long array")
      fun uLong() {
        val uLongArray: Array<ULong> = arrayOf(1uL..10uL step 2)
        assertThat(uLongArray.size).isEqualTo(5)
        assertThat(uLongArray).isInstanceOf(Array<ULong>::class.java)
        assertThat(uLongArray.contentEquals((1uL..10uL step 2).toList().toTypedArray())).isTrue()

        val uLongArray2: ULongArray = ulongArrayOf(1uL..10uL step 2)
        assertThat(uLongArray2.size).isEqualTo(5)
        assertThat(uLongArray2).isInstanceOf(ULongArray::class.java)
        assertThat(uLongArray2.contentEquals((1uL..10uL step 2).toList().toULongArray())).isTrue()
      }
    }
  }

  @Nested
  @DisplayName("Getter")
  inner class Get {
    @Nested
    @DisplayName("get sub-array with range")
    inner class GetRange {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val array = arrayOf(1..10)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(Array<Int>::class.java)
        assertThat(array).isEqualTo((1..5).toList().toTypedArray())
      }

      @Test
      @DisplayName("ByteArray")
      fun byteArray() {
        val array: ByteArray = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(ByteArray::class.java)
        assertThat(array).isEqualTo(byteArrayOf(1, 2, 3, 4, 5))
      }

      @Test
      @DisplayName("CharArray")
      fun charArray() {
        val array: CharArray = charArrayOf('a'..'z')[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(CharArray::class.java)
        assertThat(array).isEqualTo(charArrayOf('a'..'e'))
      }

      @Test
      @DisplayName("ShortArray")
      fun shortArray() {
        val array: ShortArray = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(ShortArray::class.java)
        assertThat(array).isEqualTo(shortArrayOf(1, 2, 3, 4, 5))
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val array: IntArray = intArrayOf(1..10)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(IntArray::class.java)
        assertThat(array).isEqualTo(intArrayOf(1..5))
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val array: LongArray = longArrayOf(1..10L)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(LongArray::class.java)
        assertThat(array).isEqualTo(longArrayOf(1..5L))
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val array: FloatArray = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(FloatArray::class.java)
        assertThat(array).isEqualTo(floatArrayOf(1F, 2F, 3F, 4F, 5F))
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val array: DoubleArray =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(DoubleArray::class.java)
        assertThat(array).isEqualTo(doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0))
      }

      @Test
      @DisplayName("BooleanArray")
      fun booleanArray() {
        val array: BooleanArray =
          booleanArrayOf(false, true, false, true, false, false, true, false, true, false)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(BooleanArray::class.java)
        assertThat(array).isEqualTo(booleanArrayOf(false, true, false, true, false))
      }
    }

    @Nested
    @DisplayName("get sub-array with progression")
    inner class GetProgression {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val array = arrayOf(1..10)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(Array<Int>::class.java)
        assertThat(array).isEqualTo(arrayOf(1..10 step 2))
      }

      @Test
      @DisplayName("ByteArray")
      fun byteArray() {
        val array: ByteArray = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(ByteArray::class.java)
        assertThat(array).isEqualTo(byteArrayOf(1, 3, 5, 7, 9))
      }

      @Test
      @DisplayName("CharArray")
      fun charArray() {
        val array: CharArray = charArrayOf('a'..'z')[0..25 step 2]
        assertThat(array.size).isEqualTo(13)
        assertThat(array).isInstanceOf(CharArray::class.java)
        assertThat(array).isEqualTo(charArrayOf('a'..'z' step 2))
      }

      @Test
      @DisplayName("ShortArray")
      fun shortArray() {
        val array: ShortArray = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(ShortArray::class.java)
        assertThat(array).isEqualTo(shortArrayOf(1, 3, 5, 7, 9))
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val array: IntArray = intArrayOf(1..10)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(IntArray::class.java)
        assertThat(array).isEqualTo(intArrayOf(1..10 step 2))
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val array: LongArray = longArrayOf(1..10L)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(LongArray::class.java)
        assertThat(array).isEqualTo(longArrayOf(1..10L step 2))
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val array: FloatArray = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(FloatArray::class.java)
        assertThat(array).isEqualTo(floatArrayOf(1F, 3F, 5F, 7F, 9F))
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val array: DoubleArray =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(DoubleArray::class.java)
        assertThat(array).isEqualTo(doubleArrayOf(1.0, 3.0, 5.0, 7.0, 9.0))
      }

      @Test
      @DisplayName("BooleanArray")
      fun booleanArray() {
        val array: BooleanArray =
          booleanArrayOf(false, true, false, true, false, true, false, true, false, true)
        val subArray = array[0..9 step 2]
        assertThat(subArray.size).isEqualTo(5)
        assertThat(subArray).isInstanceOf(BooleanArray::class.java)
        assertThat(subArray).isEqualTo(booleanArrayOf(false, false, false, false, false))
      }
    }

    @Nested
    @DisplayName("getOrNull sub-array with range")
    inner class GetOrNullRange {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val array = arrayOf(1..10)
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(Array<Int>::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo((1..5).toList().toTypedArray())
        assertThrows<IndexOutOfBoundsException> { array[0..10] }
        assertThat(array.getOrNull(0..10)).isNull()
      }

      @Test
      @DisplayName("ByteArray")
      fun byteArray() {
        val array: ByteArray = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(ByteArray::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo(byteArrayOf(1, 2, 3, 4, 5))
        assertThat(array.getOrNull(0..10)).isNull()
      }

      @Test
      @DisplayName("CharArray")
      fun charArray() {
        val array: CharArray = charArrayOf('a'..'z')
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(CharArray::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo(charArrayOf('a'..'e'))
        assertThat(array.getOrNull(0..26)).isNull()
      }

      @Test
      @DisplayName("ShortArray")
      fun shortArray() {
        val array: ShortArray = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..5]
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(ShortArray::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo(shortArrayOf(1, 2, 3, 4, 5))
        assertThat(array.getOrNull(0..10)).isNull()
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val array: IntArray = intArrayOf(1..10)
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(IntArray::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo(intArrayOf(1..5))
        assertThat(array.getOrNull(0..10)).isNull()
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val array: LongArray = longArrayOf(1..10L)
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(LongArray::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo(longArrayOf(1..5L))
        assertThat(array.getOrNull(0..10)).isNull()
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val array: FloatArray = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)[0..5]
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(FloatArray::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo(floatArrayOf(1F, 2F, 3F, 4F, 5F))
        assertThat(array.getOrNull(0..10)).isNull()
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val array: DoubleArray =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)[0..5]
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(DoubleArray::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo(doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0))
        assertThat(array.getOrNull(0..10)).isNull()
      }

      @Test
      @DisplayName("BooleanArray")
      fun booleanArray() {
        val array: BooleanArray =
          booleanArrayOf(false, true, false, true, false, false, true, false, true, false)[0..5]
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(BooleanArray::class.java)
        assertThat(array.getOrNull(0..4)!!)
          .isEqualTo(booleanArrayOf(false, true, false, true, false))
        assertThat(array.getOrNull(0..10)).isNull()
      }
    }

    @Nested
    @DisplayName("getOrNull sub-array with progression")
    inner class GetOrNullProgression {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val array = arrayOf(1..10)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(Array<Int>::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!).isEqualTo(arrayOf(1..10 step 2))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }

      @Test
      @DisplayName("ByteArray")
      fun byteArray() {
        val array: ByteArray = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(ByteArray::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!).isEqualTo(byteArrayOf(1, 3, 5, 7, 9))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }

      @Test
      @DisplayName("CharArray")
      fun charArray() {
        val array: CharArray = charArrayOf('a'..'z')
        assertThat(array.getOrNull(0..25 step 2)!!.size).isEqualTo(13)
        assertThat(array.getOrNull(0..25 step 2)!!).isInstanceOf(CharArray::class.java)
        assertThat(array.getOrNull(0..25 step 2)!!).isEqualTo(charArrayOf('a'..'z' step 2))
        assertThat(array.getOrNull(0..26 step 2)).isNull()
      }

      @Test
      @DisplayName("ShortArray")
      fun shortArray() {
        val array: ShortArray = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(ShortArray::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!).isEqualTo(shortArrayOf(1, 3, 5, 7, 9))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val array: IntArray = intArrayOf(1..10)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(IntArray::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!).isEqualTo(intArrayOf(1..10 step 2))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val array: LongArray = longArrayOf(1..10L)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(LongArray::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!).isEqualTo(longArrayOf(1..10L step 2))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val array: FloatArray = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(FloatArray::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!).isEqualTo(floatArrayOf(1F, 3F, 5F, 7F, 9F))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val array: DoubleArray =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(DoubleArray::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!)
          .isEqualTo(doubleArrayOf(1.0, 3.0, 5.0, 7.0, 9.0))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }

      @Test
      @DisplayName("BooleanArray")
      fun booleanArray() {
        val array: BooleanArray =
          booleanArrayOf(false, true, false, true, false, true, false, true, false, true)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(BooleanArray::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!)
          .isEqualTo(booleanArrayOf(false, false, false, false, false))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }
    }

    @Nested
    @DisplayName("getOrElse sub-array with range")
    inner class GetOrElseRange {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val array = arrayOf(1..10)
        assertThat(array.getOrElse(0..4) { emptyArray() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { emptyArray() }).isInstanceOf(Array<Int>::class.java)
        assertThat(array.getOrElse(0..4) { emptyArray() })
          .isEqualTo((1..5).toList().toTypedArray())
        assertThat(array.getOrElse(0..10) { emptyArray() }).isEmpty()
      }

      @Test
      @DisplayName("ByteArray")
      fun byteArray() {
        val array: ByteArray = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(array.getOrElse(0..4) { byteArrayOf() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { byteArrayOf() }).isInstanceOf(ByteArray::class.java)
        assertThat(array.getOrElse(0..4) { byteArrayOf() })
          .isEqualTo(byteArrayOf(1, 2, 3, 4, 5))
        assertThat(array.getOrElse(0..10) { byteArrayOf() }).isEmpty()
      }

      @Test
      @DisplayName("CharArray")
      fun charArray() {
        val array: CharArray = charArrayOf('a'..'z')
        assertThat(array.getOrElse(0..4) { charArrayOf() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { charArrayOf() }).isInstanceOf(CharArray::class.java)
        assertThat(array.getOrElse(0..4) { charArrayOf() }).isEqualTo(charArrayOf('a'..'e'))
        assertThat(array.getOrElse(0..26) { charArrayOf() }).isEmpty()
      }

      @Test
      @DisplayName("ShortArray")
      fun shortArray() {
        val array: ShortArray = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(array.getOrElse(0..4) { shortArrayOf() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { shortArrayOf() }).isInstanceOf(ShortArray::class.java)
        assertThat(array.getOrElse(0..4) { shortArrayOf() })
          .isEqualTo(shortArrayOf(1, 2, 3, 4, 5))
        assertThat(array.getOrElse(0..10) { shortArrayOf() }).isEmpty()
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val array: IntArray = intArrayOf(1..10)
        assertThat(array.getOrElse(0..4) { intArrayOf() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { intArrayOf() }).isInstanceOf(IntArray::class.java)
        assertThat(array.getOrElse(0..4) { intArrayOf() }).isEqualTo(intArrayOf(1..5))
        assertThat(array.getOrElse(0..10) { intArrayOf() }).isEmpty()
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val array: LongArray = longArrayOf(1..10L)
        assertThat(array.getOrElse(0..4) { longArrayOf() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { longArrayOf() }).isInstanceOf(LongArray::class.java)
        assertThat(array.getOrElse(0..4) { longArrayOf() }).isEqualTo(longArrayOf(1..5L))
        assertThat(array.getOrElse(0..10) { longArrayOf() }).isEmpty()
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val array: FloatArray = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)
        assertThat(array.getOrElse(0..4) { floatArrayOf() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { floatArrayOf() }).isInstanceOf(FloatArray::class.java)
        assertThat(array.getOrElse(0..4) { floatArrayOf() })
          .isEqualTo(floatArrayOf(1F, 2F, 3F, 4F, 5F))
        assertThat(array.getOrElse(0..10) { floatArrayOf() }).isEmpty()
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val array: DoubleArray =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
        assertThat(array.getOrElse(0..4) { doubleArrayOf() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { doubleArrayOf() }).isInstanceOf(DoubleArray::class.java)
        assertThat(array.getOrElse(0..4) { doubleArrayOf() })
          .isEqualTo(doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0))
        assertThat(array.getOrElse(0..10) { doubleArrayOf() }).isEmpty()
      }

      @Test
      @DisplayName("BooleanArray")
      fun booleanArray() {
        val array: BooleanArray =
          booleanArrayOf(false, true, false, true, false, false, true, false, true, false)
        assertThat(array.getOrElse(0..4) { booleanArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..4) { booleanArrayOf() })
          .isInstanceOf(BooleanArray::class.java)
        assertThat(array.getOrElse(0..4) { booleanArrayOf() })
          .isEqualTo(booleanArrayOf(false, true, false, true, false))
        assertThat(array.getOrElse(0..10) { booleanArrayOf() })
          .isEmpty()
      }
    }

    @Nested
    @DisplayName("getOrElse sub-array with progression")
    inner class GetOrElseProgression {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val array = arrayOf(1..10)
        assertThat(array.getOrElse(0..9 step 2) { emptyArray() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { emptyArray() })
          .isInstanceOf(Array<Int>::class.java)
        assertThat(array.getOrElse(0..9 step 2) { emptyArray() })
          .isEqualTo(arrayOf(1..10 step 2))
        assertThat(array.getOrElse(0..10 step 2) { emptyArray() })
          .isEmpty()
      }

      @Test
      @DisplayName("ByteArray")
      fun byteArray() {
        val array: ByteArray = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(array.getOrElse(0..9 step 2) { byteArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { byteArrayOf() })
          .isInstanceOf(ByteArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { byteArrayOf() })
          .isEqualTo(byteArrayOf(1, 3, 5, 7, 9))
        assertThat(array.getOrElse(0..10 step 2) { byteArrayOf() })
          .isEmpty()
      }

      @Test
      @DisplayName("CharArray")
      fun charArray() {
        val array: CharArray = charArrayOf('a'..'z')
        assertThat(array.getOrElse(0..9 step 2) { charArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { charArrayOf() })
          .isInstanceOf(CharArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { charArrayOf() })
          .isEqualTo(charArrayOf('a'..'j' step 2))
        assertThat(array.getOrElse(0..26 step 2) { charArrayOf() })
          .isEmpty()
      }

      @Test
      @DisplayName("ShortArray")
      fun shortArray() {
        val array: ShortArray = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(array.getOrElse(0..9 step 2) { shortArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { shortArrayOf() })
          .isInstanceOf(ShortArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { shortArrayOf() })
          .isEqualTo(shortArrayOf(1, 3, 5, 7, 9))
        assertThat(array.getOrElse(0..10 step 2) { shortArrayOf() })
          .isEmpty()
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val array: IntArray = intArrayOf(1..10)
        assertThat(array.getOrElse(0..9 step 2) { intArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { intArrayOf() })
          .isInstanceOf(IntArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { intArrayOf() })
          .isEqualTo(intArrayOf(1..10 step 2))
        assertThat(array.getOrElse(0..10 step 2) { intArrayOf() })
          .isEmpty()
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val array: LongArray = longArrayOf(1..10L)
        assertThat(array.getOrElse(0..9 step 2) { longArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { longArrayOf() })
          .isInstanceOf(LongArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { longArrayOf() })
          .isEqualTo(longArrayOf(1..10L step 2))
        assertThat(array.getOrElse(0..10 step 2) { longArrayOf() })
          .isEmpty()
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val array: FloatArray = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)
        assertThat(array.getOrElse(0..9 step 2) { floatArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { floatArrayOf() })
          .isInstanceOf(FloatArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { floatArrayOf() })
          .isEqualTo(floatArrayOf(1F, 3F, 5F, 7F, 9F))
        assertThat(array.getOrElse(0..10 step 2) { floatArrayOf() })
          .isEmpty()
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val array: DoubleArray =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
        assertThat(array.getOrElse(0..9 step 2) { doubleArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { doubleArrayOf() })
          .isInstanceOf(DoubleArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { doubleArrayOf() })
          .isEqualTo(doubleArrayOf(1.0, 3.0, 5.0, 7.0, 9.0))
        assertThat(array.getOrElse(0..10 step 2) { doubleArrayOf() })
          .isEmpty()
      }

      @Test
      @DisplayName("BooleanArray")
      fun booleanArray() {
        val array: BooleanArray =
          booleanArrayOf(false, true, false, true, false, true, false, true, false, true)
        assertThat(array.getOrElse(0..9 step 2) { booleanArrayOf() }.size)
          .isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { booleanArrayOf() })
          .isInstanceOf(BooleanArray::class.java)
        assertThat(array.getOrElse(0..9 step 2) { booleanArrayOf() })
          .isEqualTo(booleanArrayOf(false, false, false, false, false))
        assertThat(array.getOrElse(0..10 step 2) { booleanArrayOf() })
          .isEmpty()
      }
    }

    @Test
    @DisplayName("get or empty")
    fun getOrEmpty() {
      assertThat(arrayOf("a", "b", "c").getOrEmpty(3)).isEmpty()
    }
  }

  @Nested
  @DisplayName("Head")
  inner class Head {
    @Test
    @DisplayName("Array<T>")
    fun array() {
      val list = arrayOf(1..10).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(1..5))
      assertThat(emptyArray<Int>().head(10)).isEmpty()
      assertThat(arrayOf(1, 2, 3).head(0)).isEmpty()
    }

    @Test
    @DisplayName("ByteArray")
    fun byteArray() {
      val list = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf<Byte>(1, 2, 3, 4, 5))
      assertThat(byteArrayOf().head(10)).isEmpty()
      assertThat(byteArrayOf(1, 2, 3).head(0)).isEmpty()
    }

    @Test
    @DisplayName("CharArray")
    fun charArray() {
      val list = charArrayOf('a'..'z').head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf('a', 'b', 'c', 'd', 'e'))
      assertThat(charArrayOf().head(10)).isEmpty()
      assertThat(charArrayOf('a', 'b', 'c').head(0)).isEmpty()
    }

    @Test
    @DisplayName("ShortArray")
    fun shortArray() {
      val list = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf<Short>(1, 2, 3, 4, 5))
      assertThat(shortArrayOf().head(10)).isEmpty()
      assertThat(shortArrayOf(1, 2, 3).head(0)).isEmpty()
    }

    @Test
    @DisplayName("IntArray")
    fun intArray() {
      val list = intArrayOf(1..10).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(1..5))
      assertThat(intArrayOf().head(10)).isEmpty()
      assertThat(intArrayOf(1, 2, 3).head(0)).isEmpty()
    }

    @Test
    @DisplayName("LongArray")
    fun longArray() {
      val list = longArrayOf(1..10L).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(1..5L))
      assertThat(longArrayOf().head(10)).isEmpty()
      assertThat(longArrayOf(1, 2, 3).head(0)).isEmpty()
    }

    @Test
    @DisplayName("FloatArray")
    fun floatArray() {
      val list = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(1F, 2F, 3F, 4F, 5F))
      assertThat(floatArrayOf().head(10)).isEmpty()
      assertThat(floatArrayOf(1F, 2F, 3F).head(0)).isEmpty()
    }

    @Test
    @DisplayName("DoubleArray")
    fun doubleArray() {
      val list = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
      assertThat(doubleArrayOf().head(10)).isEmpty()
      assertThat(doubleArrayOf(1.0, 2.0, 3.0).head(0)).isEmpty()
    }

    @Test
    @DisplayName("BooleanArray")
    fun booleanArray() {
      val list =
        booleanArrayOf(false, true, false, true, false, false, true, false, true, false).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(false, true, false, true, false))
      assertThat(booleanArrayOf().head(10)).isEmpty()
      assertThat(booleanArrayOf(false, true, false).head(0)).isEmpty()
    }
  }

  @Nested
  @DisplayName("Tail")
  inner class Tail {
    @Test
    @DisplayName("Array<T>")
    fun array() {
      val list = arrayOf(1..10).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(6..10))
      assertThat(emptyArray<Int>().tail(10)).isEmpty()
      assertThat(arrayOf(1, 2, 3).tail(0)).isEmpty()
    }

    @Test
    @DisplayName("ByteArray")
    fun byteArray() {
      val list = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf<Byte>(6, 7, 8, 9, 10))
      assertThat(byteArrayOf().tail(10)).isEmpty()
      assertThat(byteArrayOf(1, 2, 3).tail(0)).isEmpty()
    }

    @Test
    @DisplayName("CharArray")
    fun charArray() {
      val list = charArrayOf('a'..'z').tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf('v', 'w', 'x', 'y', 'z'))
      assertThat(charArrayOf().tail(10)).isEmpty()
      assertThat(charArrayOf('a', 'b', 'c').tail(0)).isEmpty()
    }

    @Test
    @DisplayName("ShortArray")
    fun shortArray() {
      val list = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf<Short>(6, 7, 8, 9, 10))
      assertThat(shortArrayOf().tail(10)).isEmpty()
      assertThat(shortArrayOf(1, 2, 3).tail(0)).isEmpty()
    }

    @Test
    @DisplayName("IntArray")
    fun intArray() {
      val list = intArrayOf(1..10).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(6..10))
      assertThat(intArrayOf().tail(10)).isEmpty()
      assertThat(intArrayOf(1, 2, 3).tail(0)).isEmpty()
    }

    @Test
    @DisplayName("LongArray")
    fun longArray() {
      val list = longArrayOf(1..10L).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(6..10L))
      assertThat(longArrayOf().tail(10)).isEmpty()
      assertThat(longArrayOf(1, 2, 3).tail(0)).isEmpty()
    }

    @Test
    @DisplayName("FloatArray")
    fun floatArray() {
      val list = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(6F, 7F, 8F, 9F, 10F))
      assertThat(floatArrayOf().tail(10)).isEmpty()
      assertThat(floatArrayOf(1F, 2F, 3F).tail(0)).isEmpty()
    }

    @Test
    @DisplayName("DoubleArray")
    fun doubleArray() {
      val list = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(6.0, 7.0, 8.0, 9.0, 10.0))
      assertThat(doubleArrayOf().tail(10)).isEmpty()
      assertThat(doubleArrayOf(1.0, 2.0, 3.0).tail(0)).isEmpty()
    }

    @Test
    @DisplayName("BooleanArray")
    fun booleanArray() {
      val list =
        booleanArrayOf(false, true, false, true, false, false, true, false, true, false).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(false, true, false, true, false))
      assertThat(booleanArrayOf().tail(10)).isEmpty()
      assertThat(booleanArrayOf(false, true, false).tail(0)).isEmpty()
    }
  }

  @Nested
  @DisplayName("find sum of")
  inner class FindSum {
    @Nested
    @DisplayName("Pair")
    inner class Pair {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val pair = arrayOf(1..10).findPairOfSum(4)
        pair?.let { (x, y) -> assertThat(x + y).isEqualTo(4) }

        val floatPair = arrayOf(1F, 2F, 3F, 4F).findPairOfSum(4F)
        floatPair?.let { (x, y) -> assertThat(x + y).isEqualTo(4F) }

        val doublePair = arrayOf(1.0, 2.0, 3.0, 4.0).findPairOfSum(4.0)
        doublePair?.let { (x, y) -> assertThat(x + y).isEqualTo(4.0) }

        val longPair = arrayOf(1..5L).findPairOfSum(4)
        longPair?.let { (x, y) -> assertThat(x + y).isEqualTo(4) }
      }

      @Test
      @DisplayName("null Pair")
      fun nullArray() {
        val pair = arrayOf(1..5).findPairOfSum(20)
        assertThat(pair).isNull()
        val floatPair = arrayOf(1F, 2F, 3F, 4F).findPairOfSum(20F)
        assertThat(floatPair).isNull()
        val doublePair = arrayOf(1.0, 2.0, 3.0, 4.0).findPairOfSum(20.0)
        assertThat(doublePair).isNull()
        val longPair = arrayOf(1..5L).findPairOfSum(20L)
        assertThat(longPair).isNull()
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val pair = intArrayOf(1..10).findPairOfSum(4)
        pair?.let { (x, y) -> assertThat(x + y).isEqualTo(4) }
        val nullPair = intArrayOf(1..5).findPairOfSum(20)
        assertThat(nullPair).isNull()
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val pair = longArrayOf(1..10L).findPairOfSum(4)
        pair?.let { (x, y) -> assertThat(x + y).isEqualTo(4) }
        val nullPair = longArrayOf(1..5L).findPairOfSum(20)
        assertThat(nullPair).isNull()
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val pair = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).findPairOfSum(4F)
        pair?.let { (x, y) -> assertThat(x + y).isEqualTo(4F) }
        val nullPair = floatArrayOf(1F, 2F, 3F, 4F, 5F).findPairOfSum(20F)
        assertThat(nullPair).isNull()
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val pair =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).findPairOfSum(4.0)
        pair?.let { (x, y) -> assertThat(x + y).isEqualTo(4.0) }
        val nullPair = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0).findPairOfSum(20.0)
        assertThat(nullPair).isNull()
      }
    }

    @Nested
    @DisplayName("Triple")
    inner class Triple {
      @Test
      @DisplayName("Array<T>")
      fun array() {
        val triple = arrayOf(1..10).findTripleOfSum(4)
        triple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4) }

        val floatTriple = arrayOf(1F, 2F, 3F, 4F).findTripleOfSum(4F)
        floatTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4F) }

        val doubleTriple = arrayOf(1.0, 2.0, 3.0, 4.0).findTripleOfSum(4.0)
        doubleTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4.0) }

        val longTriple = arrayOf(1..5L).findTripleOfSum(4)
        longTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4) }
      }

      @Test
      @DisplayName("null Pair")
      fun nullList() {
        val triple = arrayOf(1..5).findTripleOfSum(20)
        assertThat(triple).isNull()
        val floatTriple = arrayOf(1F, 2F, 3F, 4F).findTripleOfSum(20F)
        assertThat(floatTriple).isNull()
        val doubleTriple = arrayOf(1.0, 2.0, 3.0, 4.0).findTripleOfSum(20.0)
        assertThat(doubleTriple).isNull()
        val longTriple = arrayOf(1..5L).findTripleOfSum(20L)
        assertThat(longTriple).isNull()
      }

      @Test
      @DisplayName("IntArray")
      fun intArray() {
        val triple = intArrayOf(1..10).findTripleOfSum(4)
        triple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4) }
        val nullTriple = intArrayOf(1..5).findTripleOfSum(20)
        assertThat(nullTriple).isNull()
      }

      @Test
      @DisplayName("LongArray")
      fun longArray() {
        val triple = longArrayOf(1..10L).findTripleOfSum(4)
        triple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4) }
        val nullTriple = longArrayOf(1..5L).findTripleOfSum(20)
        assertThat(nullTriple).isNull()
      }

      @Test
      @DisplayName("FloatArray")
      fun floatArray() {
        val triple = floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).findTripleOfSum(4F)
        triple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4F) }
        val nullTriple = floatArrayOf(1F, 2F, 3F, 4F, 5F).findTripleOfSum(20F)
        assertThat(nullTriple).isNull()
      }

      @Test
      @DisplayName("DoubleArray")
      fun doubleArray() {
        val triple =
          doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).findTripleOfSum(4.0)
        triple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4.0) }
        val nullTriple = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0).findTripleOfSum(20.0)
        assertThat(nullTriple).isNull()
      }
    }
  }

  @Nested
  @DisplayName("rotate")
  inner class Rotate {
    @Nested
    @DisplayName("left")
    inner class Left {
      @Test
      @DisplayName("array")
      fun array() {
        assertThat(arrayOf(1..10).rotateLeft(3)).isEqualTo(arrayOf(8..10) + arrayOf(1..7))
        assertThat(arrayOf(1..10).rotateLeft()).isEqualTo(arrayOf(10) + arrayOf(1..9))
      }

      @Test
      @DisplayName("byteArray")
      fun byteArray() {
        assertThat(byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateLeft(3))
          .isEqualTo(byteArrayOf(8, 9, 10, 1, 2, 3, 4, 5, 6, 7))
        assertThat(byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateLeft())
          .isEqualTo(byteArrayOf(10, 1, 2, 3, 4, 5, 6, 7, 8, 9))
      }

      @Test
      @DisplayName("charArray")
      fun charArray() {
        assertThat(charArrayOf('a'..'z').rotateLeft(3))
          .isEqualTo(charArrayOf('x'..'z') + charArrayOf('a'..'w'))
        assertThat(charArrayOf('a'..'z').rotateLeft())
          .isEqualTo(charArrayOf('z') + charArrayOf('a'..'y'))
      }

      @Test
      @DisplayName("shortArray")
      fun shortArray() {
        assertThat(shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateLeft(3))
          .isEqualTo(shortArrayOf(8, 9, 10, 1, 2, 3, 4, 5, 6, 7))
        assertThat(shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateLeft())
          .isEqualTo(shortArrayOf(10, 1, 2, 3, 4, 5, 6, 7, 8, 9))
      }

      @Test
      @DisplayName("intArray")
      fun intArray() {
        assertThat(intArrayOf(1..10).rotateLeft(3))
          .isEqualTo(intArrayOf(8..10) + intArrayOf(1..7))
        assertThat(intArrayOf(1..10).rotateLeft())
          .isEqualTo(intArrayOf(10) + intArrayOf(1..9))
      }

      @Test
      @DisplayName("longArray")
      fun longArray() {
        assertThat(longArrayOf(1..10L).rotateLeft(3))
          .isEqualTo(longArrayOf(8..10L) + longArrayOf(1..7L))
        assertThat(longArrayOf(1..10L).rotateLeft())
          .isEqualTo(longArrayOf(10) + longArrayOf(1..9L))
      }

      @Test
      @DisplayName("floatArray")
      fun floatArray() {
        assertThat(floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).rotateLeft(3))
          .isEqualTo(floatArrayOf(8F, 9F, 10F, 1F, 2F, 3F, 4F, 5F, 6F, 7F))
        assertThat(floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).rotateLeft())
          .isEqualTo(floatArrayOf(10F, 1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F))
      }

      @Test
      @DisplayName("doubleArray")
      fun doubleArray() {
        assertThat(doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).rotateLeft(3))
          .isEqualTo(doubleArrayOf(8.0, 9.0, 10.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0))
        assertThat(doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).rotateLeft())
          .isEqualTo(doubleArrayOf(10.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0))
      }

      @Test
      @DisplayName("booleanArray")
      fun booleanArray() {
        assertThat(booleanArrayOf(false, true, false, true, false, true, false).rotateLeft(3))
          .isEqualTo(booleanArrayOf(false, true, false, false, true, false, true))
        assertThat(booleanArrayOf(false, true, false, true, false, true, false).rotateLeft())
          .isEqualTo(booleanArrayOf(false, false, true, false, true, false, true))
      }
    }

    @Nested
    @DisplayName("right")
    inner class Right {
      @Test
      @DisplayName("array")
      fun array() {
        assertThat(arrayOf(1..10).rotateRight(3)).isEqualTo(arrayOf(4..10) + arrayOf(1..3))
        assertThat(arrayOf(1..10).rotateRight()).isEqualTo(arrayOf(2..10) + arrayOf(1))
      }

      @Test
      @DisplayName("byteArray")
      fun byteArray() {
        assertThat(byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateRight(3))
          .isEqualTo(byteArrayOf(4, 5, 6, 7, 8, 9, 10, 1, 2, 3))
        assertThat(byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateRight())
          .isEqualTo(byteArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 1))
      }

      @Test
      @DisplayName("charArray")
      fun charArray() {
        assertThat(charArrayOf('a'..'z').rotateRight(3))
          .isEqualTo(charArrayOf('d'..'z') + charArrayOf('a'..'c'))
        assertThat(charArrayOf('a'..'z').rotateRight())
          .isEqualTo(charArrayOf('b'..'z') + charArrayOf('a'))
      }

      @Test
      @DisplayName("shortArray")
      fun shortArray() {
        assertThat(shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateRight(3))
          .isEqualTo(shortArrayOf(4, 5, 6, 7, 8, 9, 10, 1, 2, 3))
        assertThat(shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).rotateRight())
          .isEqualTo(shortArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 1))
      }

      @Test
      @DisplayName("intArray")
      fun intArray() {
        assertThat(intArrayOf(1..10).rotateRight(3))
          .isEqualTo(intArrayOf(4..10) + intArrayOf(1..3))
        assertThat(intArrayOf(1..10).rotateRight())
          .isEqualTo(intArrayOf(2..10) + intArrayOf(1))
      }

      @Test
      @DisplayName("longArray")
      fun longArray() {
        assertThat(longArrayOf(1..10L).rotateRight(3))
          .isEqualTo(longArrayOf(4..10L) + longArrayOf(1..3L))
        assertThat(longArrayOf(1..10L).rotateRight())
          .isEqualTo(longArrayOf(2..10L) + longArrayOf(1))
      }

      @Test
      @DisplayName("floatArray")
      fun floatArray() {
        assertThat(floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).rotateRight(3))
          .isEqualTo(floatArrayOf(4F, 5F, 6F, 7F, 8F, 9F, 10F, 1F, 2F, 3F))
        assertThat(floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).rotateRight())
          .isEqualTo(floatArrayOf(2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F, 1F))
      }

      @Test
      @DisplayName("doubleArray")
      fun doubleArray() {
        assertThat(doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).rotateRight(3))
          .isEqualTo(doubleArrayOf(4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 1.0, 2.0, 3.0))
        assertThat(doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).rotateRight())
          .isEqualTo(doubleArrayOf(2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 1.0))
      }

      @Test
      @DisplayName("booleanArray")
      fun booleanArray() {
        assertThat(booleanArrayOf(false, true, false, true, false, true, false).rotateRight(3))
          .isEqualTo(booleanArrayOf(true, false, true, false, false, true, false))
        assertThat(booleanArrayOf(false, true, false, true, false, true, false).rotateRight())
          .isEqualTo(booleanArrayOf(true, false, true, false, true, false, false))
      }
    }
  }
}
