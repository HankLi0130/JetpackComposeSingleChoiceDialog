package app.hankdev.jc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun SingleChoiceDialog() {
    // items
    val cars = listOf("Benz", "BMW", "Ferrari", "Lamborghini", "Porsche")

    // states
    var openDialog by remember { mutableStateOf(false) }
    var selectedCar by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { openDialog = true }) {
            Text(text = "Show Dialog")
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = selectedCar)
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                // like setCancelable
                openDialog = false
            },
        ) {
            Surface(
                shape = RoundedCornerShape(25.dp)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(12.dp)
                ) {
                    items(cars) { car ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .selectable(
                                    selected = selectedCar == car,
                                    onClick = {
                                        selectedCar = car
                                        openDialog = false
                                    }
                                ),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(text = car)
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun SingleChoiceDialogPreview() {
    SingleChoiceDialog()
}