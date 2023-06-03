package com.parsuomash.affogato.hilt.binding.processor.utils

internal object ErrorMassage {
  fun supperType(`class`: String, annotation: String) =
    """$`class` class doesn't have any supper type!!!

    Correct:
    @$annotation
    class FooImpl : Foo

    Wrong:
    @$annotation
    class FooImpl
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""

  fun namedQualifier(annotation: String) =
    """Can't use named and qualifier at the same time!!!

    Correct:
    @$annotation(named = "foo")
    class FooImpl : Foo
    @$annotation(qualifier = BarQualifier::class)
    class BarImpl : Bar

    Wrong:
    @$annotation(qualifier = FooQualifier::class, named = "foo")
    class FooImpl : Foo
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"""

  const val ERROR_MASSAGE_HILT_COMPONENT = "Invalid Hilt Component!! Please use this valid " +
    "components (SingletonComponent, ActivityComponent, ...)"

  const val ERROR_MASSAGE_HILT_SCOPE = "Invalid Hilt Scope!! Please use this valid " +
    "scopes (Singleton, ActivityScoped, FragmentScoped, ...)"
}
