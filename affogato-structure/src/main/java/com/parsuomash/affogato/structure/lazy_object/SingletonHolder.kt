@file:Suppress("unused")

package com.parsuomash.affogato.structure.lazy_object

import com.parsuomash.affogato.core.ktx.runBlock

/**
 * Create lazy singleton.
 *
 * Example:
 * ```Kotlin
 * class PrefsHelper private constructor(context: Context) {
 *   ...
 *   companion object : SingletonHolder<PrefsHelper, Context>(::PrefsHelper)
 * }
 * ```
 * @since 1.4.0
 */
open class SingletonHolder<R : Any, in T>(
  creator: (T) -> R
) : InstanceHolder<R>() {
  private var creator: ((T) -> R)? = creator

  operator fun invoke(arg: T): R = getInstance {
    creator!!(arg).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder2<R : Any, in T1, in T2>(
  creator: (T1, T2) -> R
) : InstanceHolder<R>() {
  private var creator: ((T1, T2) -> R)? = creator

  operator fun invoke(arg1: T1, arg2: T2): R = getInstance {
    creator!!(arg1, arg2).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder3<R : Any, in T1, in T2, in T3>(
  creator: (T1, T2, T3) -> R
) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3) -> R)? = creator

  operator fun invoke(arg1: T1, arg2: T2, arg3: T3): R = getInstance {
    creator!!(arg1, arg2, arg3).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder4<R : Any, in T1, in T2, in T3, in T4>(
  creator: (T1, T2, T3, T4) -> R
) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3, T4) -> R)? = creator

  operator fun invoke(arg1: T1, arg2: T2, arg3: T3, arg4: T4): R = getInstance {
    creator!!(arg1, arg2, arg3, arg4).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder5<R : Any, in T1, in T2, in T3, in T4, in T5>(
  creator: (T1, T2, T3, T4, T5) -> R
) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3, T4, T5) -> R)? = creator

  operator fun invoke(arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5): R = getInstance {
    creator!!(arg1, arg2, arg3, arg4, arg5).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder6<R : Any, in T1, in T2, in T3, in T4, in T5, in T6>(
  creator: (T1, T2, T3, T4, T5, T6) -> R
) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3, T4, T5, T6) -> R)? = creator

  operator fun invoke(arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6): R = getInstance {
    creator!!(arg1, arg2, arg3, arg4, arg5, arg6).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder7<R : Any, in T1, in T2, in T3, in T4, in T5, in T6, in T7>(
  creator: (T1, T2, T3, T4, T5, T6, T7) -> R
) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3, T4, T5, T6, T7) -> R)? = creator

  operator fun invoke(
    arg1: T1,
    arg2: T2,
    arg3: T3,
    arg4: T4,
    arg5: T5,
    arg6: T6,
    arg7: T7
  ): R = getInstance {
    creator!!(arg1, arg2, arg3, arg4, arg5, arg6, arg7).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder8<R : Any, in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8>(
  creator: (T1, T2, T3, T4, T5, T6, T7, T8) -> R
) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3, T4, T5, T6, T7, T8) -> R)? = creator

  operator fun invoke(
    arg1: T1,
    arg2: T2,
    arg3: T3,
    arg4: T4,
    arg5: T5,
    arg6: T6,
    arg7: T7,
    arg8: T8
  ): R = getInstance {
    creator!!(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder9<
  R : Any, in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9
  >(creator: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R)? = creator

  operator fun invoke(
    arg1: T1,
    arg2: T2,
    arg3: T3,
    arg4: T4,
    arg5: T5,
    arg6: T6,
    arg7: T7,
    arg8: T8,
    arg9: T9
  ): R = getInstance {
    creator!!(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9).runBlock { creator = null }
  }
}

/**
 * Create lazy singleton.
 * @since 1.4.0
 * @see SingletonHolder
 */
open class SingletonHolder10<
  R : Any, in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10
  >(creator: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R) : InstanceHolder<R>() {
  private var creator: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R)? = creator

  operator fun invoke(
    arg1: T1,
    arg2: T2,
    arg3: T3,
    arg4: T4,
    arg5: T5,
    arg6: T6,
    arg7: T7,
    arg8: T8,
    arg9: T9,
    arg10: T10
  ): R = getInstance {
    creator!!(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10).runBlock {
      creator = null
    }
  }
}
