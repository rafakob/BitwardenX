object TestDeps {

    object Versions {
        const val espresso = "3.2.0"
        const val espressoRunner = "1.2.0"
    }

    const val junit = "junit:junit:4.12"

    const val espressoRunner = "androidx.test:runner:${Versions.espressoRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoRules = "androidx.test:rules:${Versions.espressoRunner}"
    const val orchestrator = "androidx.test:orchestrator:${Versions.espressoRunner}"
}