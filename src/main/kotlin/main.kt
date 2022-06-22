import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(width = 300.dp, height = 300.dp)
    ) {
        val countState = remember { mutableStateOf(0) }
        val textState = remember { mutableStateOf(TextFieldValue()) }
        val text = textState.value.text
        println("======")
        MaterialTheme {
            Column(Modifier.fillMaxSize().background(Color.Gray),
                Arrangement.SpaceAround) {
                Row {
                    Text("Edit me: ")
                    BasicTextField(textState.value,
                        modifier = Modifier.background(Color.White),
                        onValueChange = { textState.value = it })
                }
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    println("------")
                    Button(onClick = {
                        countState.value++
                    }) {
                        Text(if (countState.value == 0) "Click Me" else "${countState.value} clicks")
                        println("button with count rendered")
                    }
                    Button(onClick = {
                        countState.value++
                    }) {
                        Text(if (countState.value == 0) "Click Me" else text)
                        println("button with text rendered")
                    }
                }
            }
        }
    }
}
