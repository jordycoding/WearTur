package com.example.weartur.presentation.ui

import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.ListHeader
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import androidx.wear.input.wearableExtender

@Composable
fun Search(modifier: Modifier = Modifier) {
    val search = remember { mutableStateOf("search") }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.data?.let { data ->
                val result: Bundle = RemoteInput.getResultsFromIntent(data)
                val searchText: CharSequence? = result.getCharSequence("search")
                search.value = "" + searchText
            }
        }

    ScalingLazyColumn(modifier = Modifier.fillMaxHeight()) {
        item {
            ListHeader {
                Text(text = search.value, style = MaterialTheme.typography.title1)
            }
        }
        item {
            Chip(onClick = {
                val intent: Intent = RemoteInputIntentHelper.createActionRemoteInputIntent()
                val remoteInputs: List<RemoteInput> = listOf(
                    RemoteInput.Builder("search").setLabel("Search").wearableExtender {
                        setInputActionType(
                            EditorInfo.IME_ACTION_DONE
                        )
                    }.build()
                )
                RemoteInputIntentHelper.putRemoteInputsExtra(intent, remoteInputs)
                launcher.launch(intent)
            },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Search", maxLines = 1, overflow = TextOverflow.Ellipsis) },
                icon =
                { Icon(Icons.Rounded.Search, contentDescription = "search") })
        }
    }
}