package com.aliayali.weather.presenter.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheetSample(
    showDialog: Boolean,
) {

    if (showDialog) {
        ModalBottomSheet(
            modifier = Modifier,
            onDismissRequest = { }
        ) {

        }
    }
}
