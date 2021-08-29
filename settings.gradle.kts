rootProject.name = "orchestrator"

pluginManagement {


    plugins {
        val kotlinVersion: String by settings
        val openApiVersion: String by settings

        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion

        id("org.openapi.generator") version openApiVersion
    }
}

include("ok-m1l1")
include("ok-m1l7-kmp")
include("ok-m2l2-testing")
include("ok-marketplace-mp-transport")
