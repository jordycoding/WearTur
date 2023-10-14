package com.example.weartur.presentation.ui.stopDetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

@Composable
fun StopDetails(modifier: Modifier = Modifier, stopId: String) {
    val viewModel = hiltViewModel<StopDetailsViewModel>()

    LaunchedEffect(Unit) {
        viewModel.findStop(stopId)
    }

    ScalingLazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = viewModel.stop?.properties?.name ?: "",
                style = MaterialTheme.typography.title1
            )
        }
        item {
            Text(text = viewModel.stop?.properties?.id ?: "")
        }

    }
}