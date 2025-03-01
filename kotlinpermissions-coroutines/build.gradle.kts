plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    id ("maven-publish")

}

android {
    namespace = "com.kotlinpermissions_coroutines"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(project(":kotlinPermissionsModule"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing{
    publications{
        register<MavenPublication>("release"){
            groupId = "com.github.webtest-1230"
            artifactId = "KotlinPermission" //"Kotlin-Permission-Handle"
            version = "1.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}



