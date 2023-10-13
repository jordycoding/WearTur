package com.example.weartur.presentation.ui

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.GpsFixed
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.wear.compose.foundation.ExperimentalWearFoundationApi
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.rememberActiveFocusRequester
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.ListHeader
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalWearFoundationApi::class)
@Composable
fun Home(navController: NavHostController) {
    val listState = rememberScalingLazyListState()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = rememberActiveFocusRequester()
        val coroutineScope = rememberCoroutineScope()

        ScalingLazyColumn(
            modifier = Modifier
                .onRotaryScrollEvent {
                    coroutineScope.launch {
                        listState.scrollBy(it.verticalScrollPixels)
                        listState.animateScrollBy(0f)
                    }
                    true
                }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            state = listState
        ) {
            item {
                ListHeader {
                    Text("Weartur", style = MaterialTheme.typography.title1)
                }
            }
            item {
                Item(
                    navController = navController,
                    title = "Search",
                    icon = rememberVectorPainter(image = Icons.Rounded.Search),
                    destination = "search"
                )
            }
            item {
                Item(
                    navController = navController,
                    title = "Favorites",
                    icon = rememberVectorPainter(image = Icons.Rounded.Favorite),
                    destination = "favorites"
                )
            }
            item {
                Item(
                    navController = navController, title = "Nearby", icon = rememberVectorPainter(
                        image = Icons.Rounded.GpsFixed
                    ), destination = "nearby"
                )
            }
        }
    }
}

@Composable
fun Item(navController: NavHostController, title: String, icon: Painter, destination: String?) {
    Chip(onClick = {
        if (destination != null) {
            navController.navigate(destination)
        }
    }, modifier = Modifier.fillMaxWidth(),
        colors = ChipDefaults.secondaryChipColors(),
        label = {
            Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }, icon = {
            Icon(icon, contentDescription = title)
        }
    )
}

@Preview
@Composable
fun ItemPreview() {
    val navController = rememberSwipeDismissableNavController()
    Home(navController)
}