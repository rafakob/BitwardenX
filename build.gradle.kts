buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Deps.pluginAndroid)
        classpath(Deps.pluginKotlin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}