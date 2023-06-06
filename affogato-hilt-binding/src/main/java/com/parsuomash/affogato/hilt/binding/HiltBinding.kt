package com.parsuomash.affogato.hilt.binding

import dagger.hilt.GeneratesRootInput
import javax.inject.Singleton
import kotlin.reflect.KClass

/**
 * Annotation used to indicate that a class should be bound to a Hilt component.
 *
 * Example usage:
 *
 * ```
 * @HiltBinding(
 *   component = SingletonComponent::class,
 *   scope = Singleton::class,
 *   qualifier = DefaultRepository::class
 * )
 * class ExampleRepositoryImpl : ExampleRepository {
 *   override suspend fun getData() = "data"
 * }
 * ```
 *
 * This will generate a Hilt module
 * that binds ExampleRepositoryImpl to the Singleton scope using the SingletonComponent.
 *
 * ```
 * @Module
 * @InstallIn(SingletonComponent::class)
 * @OriginatingElement(
 *   topLevelClass = ExampleRepositoryImpl::class
 * )
 * interface ExampleRepositoryImplModule {
 *   @Binds
 *   @DefaultRepository
 *   @Singleton
 *   fun bindExampleRepository(
 *     exampleRepositoryImpl: ExampleRepositoryImpl
 *   ): ExampleRepository
 * }
 * ```
 *
 * @property component The Hilt component to which the class should be bound.
 * @property scope The scope to which the class should be bound.
 * @property qualifier The qualifier used to distinguish between multiple bindings of the same type.
 * @property named A string used to distinguish between multiple bindings of the same type.
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
@GeneratesRootInput
annotation class HiltBinding(
  val component: KClass<*>,
  val scope: KClass<*> = Any::class,
  val qualifier: KClass<*> = Any::class,
  val named: String = "",
)

/**
 * Annotation used to indicate that a class should be bound to a [Singleton] scope using Hilt.
 * This annotation should be used on the implementation class and not on the interface.
 *
 * Example usage:
 *
 * ```
 * @SingletonBinding
 * class FooImpl : Foo
 * interface Foo
 * ```
 *
 * This will generate the following Hilt module:
 *
 * ```
 * @Module
 * @InstallIn(SingletonComponent::class)
 * @OriginatingElement(
 *   topLevelClass = FooImpl::class
 * )
 * interface FooImplModule {
 *   @Binds
 *   @Singleton
 *   fun bindFoo(
 *     fooImpl: FooImpl
 *   ): Foo
 * }
 * ```
 *
 * @property qualifier The qualifier used to distinguish between multiple bindings of the same type.
 * @property named A string used to distinguish between multiple bindings of the same type.
 */
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
