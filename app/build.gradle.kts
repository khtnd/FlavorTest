plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.flavortest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.flavortest"
        minSdk = 29
        targetSdk = 35
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
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    flavorDimensions += "version"
    productFlavors {
        create("original") {
            dimension = "version"
        }
        create("simplify") {
            dimension = "version"
        }
    }

    sourceSets {
        getByName("original") {
            java.srcDirs("src/original/java")
            res.srcDirs("src/original/res")
            manifest.srcFile("src/main/AndroidManifest.xml")
        }
        getByName("simplify") {
            java.srcDirs("src/simplify/java")
            res.srcDirs("src/simplify/res")
            manifest.srcFile("src/main/AndroidManifest.xml")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}