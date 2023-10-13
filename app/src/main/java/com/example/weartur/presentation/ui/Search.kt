package com.example.weartur.presentation.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text

@Composable
fun Search(modifier: Modifier = Modifier) {
    ScalingLazyColumn(modifier = Modifier.fillMaxHeight()) {
        item {
            Chip(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Search", maxLines = 1, overflow = TextOverflow.Ellipsis) },
                icon =
                { Icon(Icons.Rounded.Search, contentDescription = "search") })
        }
    }
}