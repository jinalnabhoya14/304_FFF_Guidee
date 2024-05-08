plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.dailydiamond"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dailydiamond"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        buildFeatures {
            viewBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.browser)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    implementation("com.zeugmasolutions.localehelper:locale-helper-android:1.5.1")
    implementation ("org.imaginativeworld.oopsnointernet:oopsnointernet:2.0.0")

    implementation("androidx.security:security-crypto:1.1.0-alpha02")
    implementation ("com.intuit.sdp:sdp-android:1.1.1")
    implementation ("com.tbuonomo:dotsindicator:4.3")

    implementation ("androidx.recyclerview:recyclerview:1.1.0")

    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.17")
    implementation ("com.github.bumptech.glide:glide:4.16.0")


}