package com.parsuomash.affogato.hilt.binding.processor.internal

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

internal class SingletonBindingVisitor(
  private val declarations: MutableList<KSClassDeclaration>
) : KSVisitorVoid() {
  override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
    declarations += classDeclaration
  }
}
