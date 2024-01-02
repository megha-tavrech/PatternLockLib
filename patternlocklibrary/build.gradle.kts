@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("maven-publish")
}

android {
    namespace = "com.patternlocklibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
afterEvaluate {
    publishing(){
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.github.megha-tavrech"
                artifactId = "patternlocklibrary"
                version = "1.0.4"
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

}