@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.random

import kotlin.random.Random

internal class RandomWeight(weights: List<Int>) {
  private var summedWt: IntArray = IntArray(weights.size)
  private var upBound = 0

  init {
    summedWt[0] = weights[0]
    for (i in weights.indices) {
      upBound += weights[i]
      if (i >= 1) summedWt[i] = weights[i] + summedWt[i - 1]
    }
  }

  fun pickIndex(): Int {
    // Generate a random index between 1 and upBound (both inclusive)
    val key = Random.nextInt(upBound) + 1
    // Search for the key in the sorted summedWt array
    return binSearch(key)
  }

  @Suppress("LoopWithTooManyJumpStatements")
  private fun binSearch(key: Int): Int {
    var lo = 0
    var hi = summedWt.size - 1
    var mid = lo + (hi - lo) / 2
    while (lo < hi) {
      // If the key belongs to the current bucket
      when {
        (summedWt[mid] == key) || (summedWt[mid] > key && mid - 1 >= 0) &&
          (summedWt[mid - 1] < key) -> {
          break
        }
        (summedWt[mid] < key) && (summedWt[mid + 1] >= key) -> {
          mid += 1
          break
        }
        summedWt[mid] < key -> lo = mid + 1
        else -> hi = mid - 1
      }

      // Compute the new mid
      mid = lo + (hi - lo) / 2
    }
    return mid
  }
}
