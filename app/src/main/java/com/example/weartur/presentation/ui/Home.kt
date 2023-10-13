package com.example.weartur.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text

@Composable
fun Home(navController: NavHostController) {
    val listState = rememberScalingLazyListState()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = listState
        ) {
            item {
                Item(
                    navController = navController,
                    title = "Search",
                    icon = rememberVectorPainter(image = Icons.Rounded.Search),
                    destination = "search"
                )
            }
        }
    }
}

@Composable
fun Item(navController: NavHostController, title: String, icon: Painter, destination: String?) {
    Chip(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }, icon = {
            Icon(icon, contentDescription = title)
        }
    )
}