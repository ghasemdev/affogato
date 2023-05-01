package com.parsuomash.affogato.hilt.binding

import dagger.hilt.GeneratesRootInput
import javax.inject.Singleton
import kotlin.reflect.KClass

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
@GeneratesRootInput
annotation class HiltBinding(
  val component: KClass<*>,
  val scope: KClass<*> = Any::class,
  val qualifier: KClass<*> = Any::class,
  val named: String = "",
)

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
@GeneratesRootInput
@HiltBinding(
  component = SingletonBinding::class,
  scope = Singleton::class,
)
annotation class SingletonBinding(
  val qualifier: KClass<*> = Any::class,
  val named: String = "",
)
