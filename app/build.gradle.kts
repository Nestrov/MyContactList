plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.pets.mycontactlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pets.mycontactlist"
        minSdk = 26
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

    buildFeatures {
        viewBinding = true

    }
}

dependencies {

    val nav_version = "2.7.7"
    val lottie_version = "6.4.0"
    val retrofit_version = "2.9.0"
    val gson_version = "2.10"
    val fragment_ktx_varsion = "1.6.2"
    val recyclerview_version ="1.3.2"
    val glide_version = "4.15.1"
    val lifecycle_version = "2.7.0"
    val room_version = "2.6.1"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //ViewModels delegation extensions for fragment
    implementation ("androidx.fragment:fragment-ktx:$fragment_ktx_varsion")
    //Shared ViewModel
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0" )

    //
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    //Lottie
    implementation("com.airbnb.android:lottie:$lottie_version")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    // Gson Converter
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    //GSON
    implementation("com.google.code.gson:gson:$gson_version")

    //recyclerview
    implementation("androidx.recyclerview:recyclerview:$recyclerview_version")

    //glide
    implementation ("com.github.bumptech.glide:glide:$glide_version")

    //room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
}