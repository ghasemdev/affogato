package com.parsuomash.affogato.hilt.binding

import dagger.hilt.components.SingletonComponent
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class HiltBinding(
  val component: KClass<*> = SingletonComponent::class,
  val scope: KClass<*> = NoneScope::class,
  val qualifier: KClass<*> = NoneQualifier::class,
  val named: String = "",
)

class NoneQualifier
class NoneScope
