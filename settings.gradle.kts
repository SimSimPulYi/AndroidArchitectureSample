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
include(":navigator")
include(":feature-notice")
include(":core-design-system")
include(":feature-auth")
include(":domain")
include(":data")
include(":remote")
include(":local")
include(":di")
include(":core")
