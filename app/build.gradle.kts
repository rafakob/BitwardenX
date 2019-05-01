plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.rafakob.bitwarden"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Deps.kotlin)
    implementation(Deps.androidAppCompat)
    implementation(Deps.androidCoreKtx)
    implementation(Deps.constraintLayout)

    testImplementation(TestDeps.junit)

    androidTestImplementation(TestDeps.espressoRunner)
    androidTestImplementation(TestDeps.espressoCore)
}