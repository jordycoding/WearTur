/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.weartur.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.weartur.presentation.theme.WearTurTheme
import com.example.weartur.presentation.ui.Home
import com.example.weartur.presentation.ui.stopDetails.StopDetails
import com.example.weartur.presentation.ui.search.Search
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    val navController = rememberSwipeDismissableNavController()
    WearTurTheme {
        /* If you have enough items in your list, use [ScalingLazyColumn] which is an optimized
         * version of LazyColumn for wear devices with some added features. For more information,
         * see d.android.com/wear/compose.
         */
        SwipeDismissableNavHost(navController = navController, startDestination = "home") {
            composable("home") {
                Home(navController = navController)
            }
            composable("search") {
                Search(navController = navController)
            }
            composable("favorites") {
                Text("favorites")
            }
            composable("stopdetails/{stopId}") {
                StopDetails(stopId = it.arguments?.getString("stopId") ?: "")
            }
        }
    }
}