package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import io.kotlintest.matchers.instanceOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class QueueKtTest {
  @Nested
  @DisplayName("Queue Builders")
  inner class Builder {
    @Nested
    @DisplayName("empty")
    inner class Empty {
      @Test
      @DisplayName("queue")
      fun queueOf() {
        with(assertThat(queueOf<Int>())) {
          isEmpty()
          instanceOf(Queue::class)
        }
        with(assertThat(emptyQueue<Int>())) {
          instanceOf(Queue::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("priority queue")
      fun priorityQueueOf() {
        with(assertThat(priorityQueueOf<Int>())) {
          instanceOf(PriorityQueue::class)
          isEmpty()
        }
        with(assertThat(emptyPriorityQueue<Int>())) {
          instanceOf(PriorityQueue::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("d queue")
      fun dequeOf() {
        with(assertThat(dequeOf<Int>())) {
          instanceOf(Deque::class)
          isEmpty()
        }
        with(assertThat(emptyDeque<Int>())) {
          instanceOf(Deque::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("array deque")
      fun arrayDequeOf() {
        with(assertThat(arrayDequeOf<Int>())) {
          instanceOf(ArrayDeque::class)
          isEmpty()
        }
        with(assertThat(emptyArrayDeque<Int>())) {
          instanceOf(ArrayDeque::class)
          isEmpty()
        }
      }
    }

    @Nested
    @DisplayName("from vararg")
    inner class VarArgs {
      @Test
      @DisplayName("queue")
      fun queueOf() {
        val queue = queueOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(queue.size).isEqualTo(7)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1..7).toList())
      }

      @Test
      @DisplayName("priority queue")
      fun priorityQueueOf() {
        val queue = priorityQueueOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(queue.size).isEqualTo(7)
        assertThat(queue).isInstanceOf(PriorityQueue::class.java)
        assertThat(queue.containsAll((1..7).toList())).isTrue()
      }

      @Test
      @DisplayName("d queue")
      fun dequeOf() {
        val queue = dequeOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(queue.size).isEqualTo(7)
        assertThat(queue).isInstanceOf(Deque::class.java)
        assertThat(queue).isEqualTo((1..7).toList())
      }

      @Test
      @DisplayName("array deque")
      fun arrayDequeOf() {
        val queue = arrayDequeOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(queue.size).isEqualTo(7)
        assertThat(queue).isInstanceOf(ArrayDeque::class.java)
        assertThat(queue).isEqualTo((1..7).toList())
      }
    }

    @Nested
    @DisplayName("from Range")
    inner class Range {
      @Test
      @DisplayName("build integer queue")
      fun integer() {
        val queue: Queue<Int> = queueOf(1..10)
        assertThat(queue.size).isEqualTo(10)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1..10).toList())

        val priorityQueue: PriorityQueue<Int> = priorityQueueOf(1..10)
        assertThat(priorityQueue.size).isEqualTo(10)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll((1..10).toList())).isTrue()

        val deque: Deque<Int> = dequeOf(1..10)
        assertThat(deque.size).isEqualTo(10)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1..10).toList())

        val arrayDeque: ArrayDeque<Int> = arrayDequeOf(1..10)
        assertThat(arrayDeque.size).isEqualTo(10)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1..10).toList())
      }

      @Test
      @DisplayName("build long queue")
      fun long() {
        val queue: Queue<Long> = queueOf(1..10L)
        assertThat(queue.size).isEqualTo(10)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1..10L).toList())

        val priorityQueue: PriorityQueue<Long> = priorityQueueOf(1..10L)
        assertThat(priorityQueue.size).isEqualTo(10)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll((1..10L).toList())).isTrue()

        val deque: Deque<Long> = dequeOf(1..10L)
        assertThat(deque.size).isEqualTo(10)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1..10L).toList())

        val arrayDeque: ArrayDeque<Long> = arrayDequeOf(1..10L)
        assertThat(arrayDeque.size).isEqualTo(10)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1..10L).toList())
      }

      @Test
      @DisplayName("build char queue")
      fun char() {
        val queue: Queue<Char> = queueOf('a'..'z')
        assertThat(queue.size).isEqualTo(26)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo(('a'..'z').toList())

        val priorityQueue: PriorityQueue<Char> = priorityQueueOf('a'..'z')
        assertThat(priorityQueue.size).isEqualTo(26)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll(('a'..'z').toList())).isTrue()

        val deque: Deque<Char> = dequeOf('a'..'z')
        assertThat(deque.size).isEqualTo(26)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo(('a'..'z').toList())

        val arrayDeque: ArrayDeque<Char> = arrayDequeOf('a'..'z')
        assertThat(arrayDeque.size).isEqualTo(26)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo(('a'..'z').toList())
      }

      @Test
      @DisplayName("build un sign integer queue")
      fun uInteger() {
        val queue: Queue<UInt> = queueOf(1u..10u)
        assertThat(queue.size).isEqualTo(10)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1u..10u).toList())

        val priorityQueue: PriorityQueue<UInt> = priorityQueueOf(1u..10u)
        assertThat(priorityQueue.size).isEqualTo(10)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll((1u..10u).toList())).isTrue()

        val deque: Deque<UInt> = dequeOf(1u..10u)
        assertThat(deque.size).isEqualTo(10)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1u..10u).toList())

        val arrayDeque: ArrayDeque<UInt> = arrayDequeOf(1u..10u)
        assertThat(arrayDeque.size).isEqualTo(10)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1u..10u).toList())
      }

      @Test
      @DisplayName("build un sign long queue")
      fun uLong() {
        val queue: Queue<ULong> = queueOf(1uL..10uL)
        assertThat(queue.size).isEqualTo(10)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1uL..10uL).toList())

        val priorityQueue: PriorityQueue<ULong> = priorityQueueOf(1uL..10uL)
        assertThat(priorityQueue.size).isEqualTo(10)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll((1uL..10uL).toList())).isTrue()

        val deque: Deque<ULong> = dequeOf(1uL..10uL)
        assertThat(deque.size).isEqualTo(10)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1uL..10uL).toList())

        val arrayDeque: ArrayDeque<ULong> = arrayDequeOf(1uL..10uL)
        assertThat(arrayDeque.size).isEqualTo(10)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1uL..10uL).toList())
      }
    }

    @Nested
    @DisplayName("from Progression")
    inner class Progression {
      @Test
      @DisplayName("build integer queue")
      fun integer() {
        val queue: Queue<Int> = queueOf(1..10 step 2)
        assertThat(queue.size).isEqualTo(5)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1..10 step 2).toList())

        val priorityQueue: PriorityQueue<Int> = priorityQueueOf(1..10 step 2)
        assertThat(priorityQueue.size).isEqualTo(5)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll(PriorityQueue((1..10 step 2).toList()))).isTrue()

        val deque: Deque<Int> = dequeOf(1..10 step 2)
        assertThat(deque.size).isEqualTo(5)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1..10 step 2).toList())

        val arrayDeque: ArrayDeque<Int> = arrayDequeOf(1..10 step 2)
        assertThat(arrayDeque.size).isEqualTo(5)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1..10 step 2).toList())
      }

      @Test
      @DisplayName("build long queue")
      fun long() {
        val queue: Queue<Long> = queueOf(1..10L step 2)
        assertThat(queue.size).isEqualTo(5)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1..10L step 2).toList())

        val priorityQueue: PriorityQueue<Long> = priorityQueueOf(1..10L step 2)
        assertThat(priorityQueue.size).isEqualTo(5)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll(PriorityQueue((1..10L step 2).toList()))).isTrue()

        val deque: Deque<Long> = dequeOf(1..10L step 2)
        assertThat(deque.size).isEqualTo(5)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1..10L step 2).toList())

        val arrayDeque: ArrayDeque<Long> = arrayDequeOf(1..10L step 2)
        assertThat(arrayDeque.size).isEqualTo(5)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1..10L step 2).toList())
      }

      @Test
      @DisplayName("build char queue")
      fun char() {
        val queue: Queue<Char> = queueOf('a'..'z' step 2)
        assertThat(queue.size).isEqualTo(13)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo(('a'..'z' step 2).toList())

        val priorityQueue: PriorityQueue<Char> = priorityQueueOf('a'..'z' step 2)
        assertThat(priorityQueue.size).isEqualTo(13)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll(('a'..'z' step 2).toList())).isTrue()

        val deque: Deque<Char> = dequeOf('a'..'z' step 2)
        assertThat(deque.size).isEqualTo(13)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo(('a'..'z' step 2).toList())

        val arrayDeque: ArrayDeque<Char> = arrayDequeOf('a'..'z' step 2)
        assertThat(arrayDeque.size).isEqualTo(13)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo(('a'..'z' step 2).toList())
      }

      @Test
      @DisplayName("build un sign integer queue")
      fun uInteger() {
        val queue: Queue<UInt> = queueOf(1u..10u step 2)
        assertThat(queue.size).isEqualTo(5)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1u..10u step 2).toList())

        val priorityQueue: PriorityQueue<UInt> = priorityQueueOf(1u..10u step 2)
        assertThat(priorityQueue.size).isEqualTo(5)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll(PriorityQueue((1u..10u step 2).toList()))).isTrue()

        val deque: Deque<UInt> = dequeOf(1u..10u step 2)
        assertThat(deque.size).isEqualTo(5)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1u..10u step 2).toList())

        val arrayDeque: ArrayDeque<UInt> = arrayDequeOf(1u..10u step 2)
        assertThat(arrayDeque.size).isEqualTo(5)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1u..10u step 2).toList())
      }

      @Test
      @DisplayName("build un sign long queue")
      fun uLong() {
        val queue: Queue<ULong> = queueOf(1uL..10uL step 2)
        assertThat(queue.size).isEqualTo(5)
        assertThat(queue).isInstanceOf(Queue::class.java)
        assertThat(queue).isEqualTo((1uL..10uL step 2).toList())

        val priorityQueue: PriorityQueue<ULong> = priorityQueueOf(1uL..10uL step 2)
        assertThat(priorityQueue.size).isEqualTo(5)
        assertThat(priorityQueue).isInstanceOf(PriorityQueue::class.java)
        assertThat(priorityQueue.containsAll((1uL..10uL step 2).toList())).isTrue()

        val deque: Deque<ULong> = dequeOf(1uL..10uL step 2)
        assertThat(deque.size).isEqualTo(5)
        assertThat(deque).isInstanceOf(Deque::class.java)
        assertThat(deque).isEqualTo((1uL..10uL step 2).toList())

        val arrayDeque: ArrayDeque<ULong> = arrayDequeOf(1uL..10uL step 2)
        assertThat(arrayDeque.size).isEqualTo(5)
        assertThat(arrayDeque).isInstanceOf(ArrayDeque::class.java)
        assertThat(arrayDeque).isEqualTo((1uL..10uL step 2).toList())
      }
    }
  }

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("toQueue")
    fun toQueue() {
      assertThat((1..10).toQueue()).isEqualTo(queueOf(1..10))
    }

    @Test
    @DisplayName("toPriorityQueue")
    fun toPriorityQueue() {
      assertThat((1..10).toPriorityQueue().containsAll(priorityQueueOf(1..10))).isTrue()
    }

    @Test
    @DisplayName("toDeque")
    fun toDeque() {
      assertThat((1..10).toDeque()).isEqualTo(dequeOf(1..10))
    }

    @Test
    @DisplayName("toArrayDeque")
    fun toArrayDeque() {
      assertThat((1..10).toArrayDeque()).isEqualTo(arrayDequeOf(1..10))
    }
  }

  @Test
  @DisplayName("queue functionality")
  fun testQueueOf() {
    val queue = queueOf(1, 2, 3, 4, 5, 6)
    assertThat(queue.size).isEqualTo(6)
    assertThat(queue.toList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    assertThat(queue.poll()).isEqualTo(1)
    assertThat(queue.peek()).isEqualTo(2)
    queue.add(4)
    assertThat(queue.peek()).isEqualTo(2)
    assertThat(queue.poll()).isEqualTo(2)
  }

  @Test
  @DisplayName("priority queue functionality")
  fun testPriorityQueueOf() {
    val pQueue = priorityQueueOf(2, 3, 6, 5, 9, 8, 4, 7)
    assertThat(pQueue.size).isEqualTo(8)
    assertThat(pQueue.toList()).isEqualTo(listOf(2, 3, 4, 5, 9, 8, 6, 7))
    assertThat(pQueue.poll()).isEqualTo(2)
    assertThat(pQueue.peek()).isEqualTo(3)
    pQueue.add(4)
    assertThat(pQueue.peek()).isEqualTo(3)
    assertThat(pQueue.poll()).isEqualTo(3)
  }

  @Test
  @DisplayName("deque functionality")
  fun testDequeOf() {
    val deque = dequeOf(1, 2, 3, 4, 5, 6)
    assertThat(deque.size).isEqualTo(6)
    assertThat(deque).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    assertThat(deque.pop()).isEqualTo(1)
    assertThat(deque.peek()).isEqualTo(2)
    deque.push(4)
    assertThat(deque.peek()).isEqualTo(4)
    assertThat(deque.poll()).isEqualTo(4)
    assertThat(deque.first).isEqualTo(2)
    assertThat(deque.last).isEqualTo(6)
    assertThat(deque.removeFirst()).isEqualTo(2)
    assertThat(deque.removeLast()).isEqualTo(6)
    deque.addFirst(14)
    deque.addLast(14)
    assertThat(deque.first).isEqualTo(14)
    assertThat(deque.last).isEqualTo(14)
  }

  @Test
  @DisplayName("array deque functionality")
  fun testArrayDequeOf() {
    val arrayDeque = arrayDequeOf(1, 2, 3, 4, 5, 6)
    assertThat(arrayDeque.size).isEqualTo(6)
    assertThat(arrayDeque).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    assertThat(arrayDeque[0]).isEqualTo(1)
    arrayDeque.removeFirst()
    assertThat(arrayDeque.first()).isEqualTo(2)
    assertThat(arrayDeque.last()).isEqualTo(6)
    assertThat(arrayDeque.removeFirst()).isEqualTo(2)
    assertThat(arrayDeque.removeLast()).isEqualTo(6)
    arrayDeque.addFirst(14)
    arrayDeque.addLast(14)
    assertThat(arrayDeque.first()).isEqualTo(14)
    assertThat(arrayDeque.last()).isEqualTo(14)
  }
}
