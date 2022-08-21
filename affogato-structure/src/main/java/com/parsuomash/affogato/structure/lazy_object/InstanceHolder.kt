@file:Suppress("PropertyName", "VariableNaming", "UnnecessaryAbstractClass")

package com.parsuomash.affogato.structure.lazy_object

/**
 * Instance holder store an instance of class to create object.
 * @since 1.4.0
 */
abstract class InstanceHolder<T> {
  @Volatile
  var _instance: T? = null

  protected inline fun getInstance(creator: () -> T): T {
    val checkInstance = _instance
    if (checkInstance != null) {
      return checkInstance
    }

    return synchronized(this) {
      val checkInstanceAgain = _instance
      if (checkInstanceAgain != null) {
        checkInstanceAgain
      } else {
        val created = creator()
        _instance = created
        created
      }
    }
  }
}
