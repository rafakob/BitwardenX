object TestDeps {

    object Versions {
        const val espresso = "3.2.0"
        const val espressoRunner = "1.2.0"
    }

    const val junit = "junit:junit:4.13"
    const val mockk = "io.mockk:mockk:1.9.3"
    const val elmyr = "com.github.xgouchet:Elmyr:1.0.0"

    const val espressoRunner = "androidx.test:runner:${Versions.espressoRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoRules = "androidx.test:rules:${Versions.espressoRunner}"
    const val orchestrator = "androidx.test:orchestrator:${Versions.espressoRunner}"
}