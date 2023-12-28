@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("maven-publish")
}

android {
    namespace = "com.example.patternlocklib"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.patternlocklib"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.megha-tavrech"
            artifactId = "PatternLockLib"
            version = "1.0.0"
            pom {
                description = "library"
            }
            repositories {
                maven {
//                    val releasesRepoUrl = layout.buildDirectory.dir("repos/releases")
//                    val snapshotsRepoUrl = layout.buildDirectory.dir("repos/snapshots")
//                    url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
                    // change to point to your repo, e.g. http://my.org/repo
                    url = uri("https://github.com/megha-tavrech/PatternLockLib")
                }
            }
        }
    }
}
dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(project(":patternlocklibrary"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}