object Deps {

    object Versions {
        const val kotlin = "1.3.50"
        const val dagger = "2.24"
        const val retrofit = "2.6.1"
        const val okhttp = "4.2.0"
    }

    const val pluginAndroid = "com.android.tools.build:gradle:3.5.0"
    const val pluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val pluginVersions = "com.github.ben-manes:gradle-versions-plugin:0.25.0"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val androidAppCompat = "androidx.appcompat:appcompat:1.1.0"
    const val androidCoreKtx = "androidx.core:core-ktx:1.1.0"
    const val materialComponents = "com.google.android.material:material:1.1.0-alpha10"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val spongyCastle = "com.madgag.spongycastle:core:1.58.0.0"
    const val hkdfGenerator = "at.favre.lib:hkdf:1.0.2"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val timber = "com.github.ajalt:timberkt:1.5.1"
    const val ankoCommons = "org.jetbrains.anko:anko-commons:0.10.8"
    const val materialDialogs = "com.afollestad.material-dialogs:core:3.1.1"
    const val materialDialogsInput = "com.afollestad.material-dialogs:input:3.1.1"
    const val materialDialogsBottomsheets = "com.afollestad.material-dialogs:bottomsheets:3.1.1"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRx = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttpHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.12"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
}