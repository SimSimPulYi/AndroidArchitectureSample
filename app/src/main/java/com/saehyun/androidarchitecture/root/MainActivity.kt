package com.saehyun.androidarchitecture.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.saehyun.core_navigator.SampleRoute
import com.saehyun.feature_auth.navigation.authNavigation
import com.saehyun.feature_notice.navigation.noticeNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen()

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = SampleRoute.Auth.name
            ) {
                authNavigation(
                    composeNavigator = navController
                )

                noticeNavigation(
                    composeNavigator = navController
                )
            }
        }
    }
}