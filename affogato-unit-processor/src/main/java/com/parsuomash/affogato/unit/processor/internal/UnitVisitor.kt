package com.parsuomash.affogato.unit.processor.internal

import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

internal class UnitVisitor(
    private val declarations: MutableList<KSPropertyDeclaration>
) : KSVisitorVoid() {

    override fun visitPropertyDeclaration(property: KSPropertyDeclaration, data: Unit) {
        declarations += property
    }
}
