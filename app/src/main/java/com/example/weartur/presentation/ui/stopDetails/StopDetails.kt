package com.example.weartur.presentation.ui.stopDetails

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Directions
import androidx.compose.material.icons.rounded.DirectionsBus
import androidx.compose.material.icons.rounded.DirectionsTransit
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FlightTakeoff
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Train
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.foundation.CurvedAlignment
import androidx.wear.compose.foundation.CurvedLayout
import androidx.wear.compose.foundation.ExperimentalWearFoundationApi
import androidx.wear.compose.foundation.curvedColumn
import androidx.wear.compose.foundation.curvedComposable
import androidx.wear.compose.foundation.curvedRow
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.rememberActiveFocusRequester
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import kotlinx.coroutines.launch

@OptIn(ExperimentalWearFoundationApi::class)
@Composable
fun StopDetails(modifier: Modifier = Modifier, stopId: String) {
    val viewModel = hiltViewModel<StopDetailsViewModel>()
    val listState = rememberScalingLazyListState()

    val focusRequester = rememberActiveFocusRequester()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.findStop(stopId)
    }

    Scaffold(
        positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        ScalingLazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .onRotaryScrollEvent {
                    coroutineScope.launch {
                        listState.scrollBy(it.verticalScrollPixels)
                        listState.animateScrollBy(0f)
                    }
                    true
                }
                .focusRequester(focusRequester)
                .focusable(), state = listState
        ) {
            item {
                Text(
                    text = viewModel.stop?.properties?.name ?: "",
                    style = MaterialTheme.typography.title2,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            item {
                viewModel.stop?.properties?.category?.forEach {
                    Row(modifier = Modifier.padding(bottom = 16.dp)) {
                        when (it) {
                            "onstreetBus" -> Icon(
                                Icons.Rounded.DirectionsBus,
                                contentDescription = "bus"
                            )

                            "onstreetTram" -> Icon(
                                Icons.Rounded.DirectionsTransit,
                                contentDescription = "tram"
                            )

                            "airport" -> Icon(
                                Icons.Rounded.FlightTakeoff,
                                contentDescription = "airport"
                            )

                            "railStation" -> Icon(
                                Icons.Rounded.Train,
                                contentDescription = "train"
                            )
                        }
                    }
                }
            }
            item {
                Chip(
                    onClick = { viewModel.addToFavorites() },
                    label = { Text("Add to favorites") },
                    icon = { Icon(Icons.Rounded.Favorite, contentDescription = "favorite") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Chip(
                    onClick = {},
                    label = { Text("Directions") },
                    icon = {
                        Icon(
                            Icons.Rounded.Directions,
                            contentDescription = "directions"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Chip(
                    onClick = {},
                    label = { Text("Departures") },
                    icon = { Icon(Icons.Rounded.Schedule, contentDescription = "departures") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}