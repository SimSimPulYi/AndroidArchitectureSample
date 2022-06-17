pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "AndroidArchitectureSample"
include (":app")
include(":core-navigator")
include(":feature-notice")
include(":common-design")
include(":feature-auth")
include(":core-domain")
include(":core-data")
include(":core-remote")
include(":core-local")
include(":common-di")
include(":common-base")
