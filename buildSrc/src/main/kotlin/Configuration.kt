object Configuration {
  /** com.parsuomash.tick */
  const val APPLICATION_ID = "com.parsuomash.affogato"

  /** 34 */
  const val COMPILE_SDK = 34

  /** 34.0.0 */
  const val BUILD_TOOLS_VERSION = "34.0.0"

  /** 21 */
  const val MIN_SDK = 21

  /** 33 */
  const val TARGET_SDK = 33

  /** 1.0.0 */
  const val VERSION_NAME = "1.0.0"

  val VERSION_CODE = getVersionCode()

  private fun getVersionCode(): Int {
    val (major, minor, patch) = VERSION_NAME.split(".").map { it.toInt() }
    return (major * 100) + (minor * 10) + patch
  }
}
