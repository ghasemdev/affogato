package com.parsuomash.affogato.unit

@Suppress("RemoveRedundantQualifierName")
typealias unit = com.parsuomash.affogato.unit.R.dimen

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class Udp(
    val sw320: Int = 0,
    val sw480: Int = 0,
    val sw600: Int = 0,
    val sw720: Int = 0,
)

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class Usp(
    val sw320: Int = 0,
    val sw480: Int = 0,
    val sw600: Int = 0,
    val sw720: Int = 0,
)
