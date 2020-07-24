package dependencies

object Versions {
    const val androidTargetSdkVersion = 29
    const val androidCompileSdkVersion = 29
    const val androidBuildToolsVersion = "29.0.2"
    const val androidMinSdkVersion = 23
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionOffset = 0
    const val androidVersionCode =
        (versionMajor * 10000 + versionMinor * 100 + versionPatch) * 100 + versionOffset

    const val androidVersionName = "$versionMajor.$versionMinor.$versionPatch"
}
