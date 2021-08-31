val serializationVersion: String by project

plugins {
    kotlin("multiplatform")
    id("org.openapi.generator")
    kotlin("plugin.serialization")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    jvm()

    js()

    val generationDir =  "$buildDir/generated"
    sourceSets {

        val commonMain by getting {
             kotlin.srcDirs("$generationDir/src/commonMain/kotlin")
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmMain by getting {
            kotlin.srcDirs("$generationDir/src/commonMain/kotlin")
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jsMain by getting {
            kotlin.srcDirs("$generationDir/src/commonMain/kotlin")
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }

    openApiGenerate {
        val openapiGroup = "${rootProject.group}.openapi"
        generatorName.set("kotlin")
        outputDir.set(generationDir)
        library.set("multiplatform")
        packageName.set(openapiGroup)
        apiPackage.set("$openapiGroup.api")
        modelPackage.set("$openapiGroup.models")
        invokerPackage.set("$openapiGroup.invoker")
        inputSpec.set("$rootDir/specs/orchestrator.api-spec.yaml")


        globalProperties.apply {
            put("models", "")
            put("modelDocs", "false")
        }


        configOptions.set(
            mapOf(
                "dateLibrary" to "string",
                "enumPropertyNaming" to "UPPERCASE",
                "collectionType" to "list"
            )
        )


    }

    tasks{
        compileKotlinMetadata{
            dependsOn(openApiGenerate)
        }
    }
}