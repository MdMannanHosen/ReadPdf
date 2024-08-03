import java.util.regex.Pattern.compile

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.readpdf"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.readpdf"
        minSdk = 27
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
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    testImplementation(libs.testng)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //noinspection UseTomlInstead
    implementation(libs.android.pdf.viewer)
    androidTestImplementation(libs.junit.jupiter)
    implementation (libs.core)
    androidTestImplementation (libs.espresso.core)

    implementation ("com.squareup.picasso:picasso:2.71828")






}