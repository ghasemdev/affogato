package utils

import com.google.common.truth.Truth.assertThat
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSNode
import com.parsuomash.affogato.unit.processor.utils.DimenValidator
import org.junit.Test

class DimenValidatorTest {

    private val logger = object : KSPLogger {
        override fun error(message: String, symbol: KSNode?) = Unit
        override fun exception(e: Throwable) = Unit
        override fun info(message: String, symbol: KSNode?) = Unit
        override fun logging(message: String, symbol: KSNode?) = Unit
        override fun warn(message: String, symbol: KSNode?) = Unit
    }

    @Test
    fun `is no dimen tag`() {
        val validator = DimenValidator(
            dimenTypes = listOf(),
            dimenValues = listOf(),
            dimenClassNames = listOf()
        )
        assertThat(validator.validate(logger)).isFalse()
    }

    @Test
    fun `is valid dimen types`() {
        val validator = DimenValidator(
            dimenTypes = listOf("double", "sp", "dp"),
            dimenValues = listOf(
                listOf("300:10", "480:20", "600:30"),
                listOf("300:2", "480:4", "600:6"),
                listOf("300:100", "480:200", "600:300"),
            ),
            dimenClassNames = listOf(
                "kotlin.Double",
                "androidx.compose.ui.unit.sp",
                "androidx.compose.ui.unit.dp"
            )
        )
        assertThat(validator.validate(logger)).isFalse()
    }

    @Test
    fun `is dimen type equals to class names`() {
        val validator = DimenValidator(
            dimenTypes = listOf("dp", "sp"),
            dimenValues = listOf(
                listOf("300:10", "480:20", "600:30"),
                listOf("300:2", "480:4", "600:6"),
            ),
            dimenClassNames = listOf(
                "androidx.compose.ui.unit.TextUnit",
                "androidx.compose.ui.unit.Dp"
            )
        )
        assertThat(validator.validate(logger)).isFalse()
    }

    @Test
    fun `is values equals size`() {
        val validator = DimenValidator(
            dimenTypes = listOf("dp", "sp"),
            dimenValues = listOf(
                listOf("300:10", "480:20", "600:30"),
                listOf("300:2", "480:4"),
            ),
            dimenClassNames = listOf(
                "androidx.compose.ui.unit.Dp",
                "androidx.compose.ui.unit.TextUnit"
            )
        )
        assertThat(validator.validate(logger)).isFalse()
    }

    @Test
    fun `is values split two part`() {
        val validator = DimenValidator(
            dimenTypes = listOf("dp", "sp"),
            dimenValues = listOf(
                listOf("300", "20", "600;30"),
                listOf("300:2", "480:4", "600:30"),
            ),
            dimenClassNames = listOf(
                "androidx.compose.ui.unit.Dp",
                "androidx.compose.ui.unit.TextUnit"
            )
        )
        assertThat(validator.validate(logger)).isFalse()
    }

    @Test
    fun `is valid values`() {
        val validator = DimenValidator(
            dimenTypes = listOf("dp", "sp"),
            dimenValues = listOf(
                listOf("sw300:10", "480:20;", "_600:30"),
                listOf("300:2", "480:4", "600:30"),
            ),
            dimenClassNames = listOf(
                "androidx.compose.ui.unit.Dp",
                "androidx.compose.ui.unit.TextUnit"
            )
        )
        assertThat(validator.validate(logger)).isFalse()
    }

    @Test
    fun `is keys unique`() {
        val validator = DimenValidator(
            dimenTypes = listOf("dp", "sp"),
            dimenValues = listOf(
                listOf("300:10", "300:20", "600:30"),
                listOf("300:2", "480:4", "600:30"),
            ),
            dimenClassNames = listOf(
                "androidx.compose.ui.unit.Dp",
                "androidx.compose.ui.unit.TextUnit"
            )
        )
        assertThat(validator.validate(logger)).isFalse()
    }

    @Test
    fun `is same keys`() {
        val validator = DimenValidator(
            dimenTypes = listOf("dp", "sp"),
            dimenValues = listOf(
                listOf("300:10", "480:20;", "600:30"),
                listOf("290:2", "480:4", "600:30"),
            ),
            dimenClassNames = listOf(
                "androidx.compose.ui.unit.Dp",
                "androidx.compose.ui.unit.TextUnit"
            )
        )
        assertThat(validator.validate(logger)).isFalse()
    }
}
