package com.parsuomash.affogato.unit.window

/**
 * Definition of the window size to be on the global scope.
 */
object GlobalWindowSize {
    /** Defines most phones in portrait mode */
    var compactWidth: Int = 600

    /** Defines most foldables and tablets in portrait mode */
    var mediumWidth: Int = 840

    /** Defines most phones in portrait mode */
    var compactHeight: Int = 480

    /** Defines most foldables and tablets in portrait mode */
    var mediumHeight: Int = 900

    /** A global factory class of the [WindowType]. */
    object Factory {
        var fromWidth: ((screenWidth: Int) -> WindowType)? = null
        var fromHeight: ((screenHeight: Int) -> WindowType)? = null
    }
}
