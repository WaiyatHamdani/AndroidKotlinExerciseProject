package com.example.waiyatcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waiyatcalculator.ui.theme.WaiyatCalculatorTheme

class MainActivity : ComponentActivity() {                              //MainActivity: This is like the front page of your app.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)                              //onCreate(): This runs as soon as your app is opened. It sets up the calculator's display and buttons.
        setContent {
            WaiyatCalculatorTheme {
                // Call our custom calculator UI
                CalculatorUI()
            }
        }
    }
}

// The main Composable function for the calculator
@Composable                                                                    //The Blueprint
fun CalculatorUI() {
    // State for the display text
    var displayText by remember { mutableStateOf("0") }

    // Variables to store calculation state
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var isSecondNumber by remember { mutableStateOf(false) }

    // Creating a column layout for the calculator buttons and display
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // The display text at the top
        Text(
            text = displayText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 32.sp
        )

        // First row of buttons (7, 8, 9, /)
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "7"
                    displayText = secondNumber
                } else {
                    firstNumber += "7"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("7") }

            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "8"
                    displayText = secondNumber
                } else {
                    firstNumber += "8"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("8") }

            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "9"
                    displayText = secondNumber
                } else {
                    firstNumber += "9"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("9") }

            Button(onClick = {
                if (firstNumber.isNotEmpty()) {
                    operator = "/"
                    isSecondNumber = true
                }
            }, modifier = Modifier.weight(1f)) { Text("/") }
        }



        //------------------------------------------------------------------------------------------------

        // Second row of buttons (4, 5, 6, *)
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "4"
                    displayText = secondNumber
                } else {
                    firstNumber += "4"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("4") }

            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "5"
                    displayText = secondNumber
                } else {
                    firstNumber += "5"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("5") }

            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "6"
                    displayText = secondNumber
                } else {
                    firstNumber += "6"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("6") }

            Button(onClick = {
                if (firstNumber.isNotEmpty()) {
                    operator = "*"
                    isSecondNumber = true
                }
            }, modifier = Modifier.weight(1f)) { Text("*") }
        }

        //------------------------------------------------------------------------------------------------


        // Third row of buttons (1, 2, 3, -)
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "1"
                    displayText = secondNumber
                } else {
                    firstNumber += "1"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("1") }

            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "2"
                    displayText = secondNumber
                } else {
                    firstNumber += "2"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("2") }

            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "3"
                    displayText = secondNumber
                } else {
                    firstNumber += "3"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("3") }

            Button(onClick = {
                if (firstNumber.isNotEmpty()) {
                    operator = "-"
                    isSecondNumber = true
                }
            }, modifier = Modifier.weight(1f)) { Text("-") }
        }


//-----------------------------------------------------------------------------------------------

        // Fourth row of buttons (0, C, =, +)
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (isSecondNumber) {
                    secondNumber += "0"
                    displayText = secondNumber
                } else {
                    firstNumber += "0"
                    displayText = firstNumber
                }
            }, modifier = Modifier.weight(1f)) { Text("0") }

            Button(onClick = {
                displayText = "0"
                firstNumber = ""
                secondNumber = ""
                operator = ""
                isSecondNumber = false
            }, modifier = Modifier.weight(1f)) { Text("C") }

            Button(onClick = {
                if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {                           // checking if the 1st number and second number is not empty
                    val result = when (operator) {                                                  // when  clause
                        "+" -> firstNumber.toDouble() + secondNumber.toDouble()
                        "-" -> firstNumber.toDouble() - secondNumber.toDouble()
                        "*" -> firstNumber.toDouble() * secondNumber.toDouble()
                        "/" -> firstNumber.toDouble() / secondNumber.toDouble()
                        else -> 0.0
                    }
                    displayText = result.toString()
                    firstNumber = result.toString()
                    secondNumber = ""
                    operator = ""
                    isSecondNumber = false
                }
            }, modifier = Modifier.weight(1f)) { Text("=") }

            Button(onClick = {
                if (firstNumber.isNotEmpty()) {
                    operator = "+"
                    isSecondNumber = true
                }
            }, modifier = Modifier.weight(1f)) { Text("+") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    WaiyatCalculatorTheme {
        CalculatorUI()
    }
}


//note :
// savedInstanceState is a bundle that Android provides to save information about your app when something interrupts it (like rotating the screen or the app getting backgrounded)


/*
    ------------------------------ What Should You Know About Compose?--------------------------------------------------------------------------
1)Composable Functions (@Composable):
    -Any function marked with @Composable can be used to build your UI. It could be for a button, a piece of text, or even an entire screen layout.
    -You already know how to make buttons and text, but you can also create your own composable functions that take parameters and build more complex components.


2) State Management (remember and mutableStateOf):
    -State is how Compose knows to update the UI when something changes. When you type a number, for example, it updates the displayText state, and Compose automatically redraws the display.
    -remember is used to keep the state across recompositions (like when the UI updates).


3)Layouts (Column, Row, Box, etc.):
    -Column: Stacks items vertically.
    -Row: Places items horizontally.
    -Box: Overlaps items on top of each other.
    -Modifiers: Control things like size, padding, and alignment.
*/

//Preview:
//The @Preview annotation lets you see a preview of the UI while coding. This is super useful because it allows you to quickly check how your layout looks without running the app.