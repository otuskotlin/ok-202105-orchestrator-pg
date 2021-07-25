rootProject.name = "orchestrator"

pluginManagement {

    val kotlinVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
    }
}

include("ok-m1l1")
include("ok-m1l7-kmp")
include("ok-m2l2-testing")
