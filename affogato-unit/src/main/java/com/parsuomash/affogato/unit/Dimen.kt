package com.parsuomash.affogato.unit

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class Dimen(
    val type: String,
    val values: Array<String>,
)
