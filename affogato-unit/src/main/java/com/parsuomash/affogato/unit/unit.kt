@file:Suppress("RemoveRedundantQualifierName")

package com.parsuomash.affogato.unit

typealias unit = com.parsuomash.affogato.unit.R.dimen

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class Unit(
    val type: String,
    val values: Array<String>,
)
