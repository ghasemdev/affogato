@file:Suppress("unused")

package com.parsuomash.affogato.core.ktx.time.messages

/**
 * Thrown to indicate that a method has been passed an illegal message.
 * @since 1.1.0
 */
class NoSuchMessageException : RuntimeException {
  /**
   * Constructs an NoSuchMessageException with no detail message.
   * @since 1.1.0
   */
  constructor() : super()

  /**
   * Constructs an NoSuchMessageException with the specified detail message.
   * @since 1.1.0
   * @param message the detail message.
   */
  constructor(message: String) : super(message)

  /**
   * Constructs a new exception with the specified cause and a detail message of
   * (cause==null ? null : cause.toString()) (which typically contains the class and detail message
   * of cause). This constructor is useful for exceptions that are little more than wrappers for
   * other throwable.
   * @since 1.1.0
   * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method).
   * (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   */
  constructor(cause: Throwable) : super(cause)

  /**
   * Constructs a new exception with the specified detail message and cause.
   * Note that the detail message associated with cause is not automatically incorporated in this
   * exception's detail message.
   * @since 1.1.0
   * @param message the detail message (which is saved for later retrieval by the
   * Throwable.getMessage() method).
   * @param cause the cause (which is saved for later retrieval by the
   * Throwable.getCause() method). (A null value is permitted, and indicates that the cause is
   * nonexistent or unknown.)
   */
  constructor(message: String, cause: Throwable) : super(message, cause)
}
