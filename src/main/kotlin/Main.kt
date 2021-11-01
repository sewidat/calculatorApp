// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    val col1 = Color(0XF9F3DF)
    DesktopMaterialTheme {

        Column(
            modifier = Modifier
                .padding(top = 20.dp).fillMaxSize()
                .background(color = col1),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,


        ) {
            Row {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Number1") }, modifier = Modifier.padding(10.dp)
                )
                TextField(
                    value = text2,
                    onValueChange = { text2 = it },
                    label = { Text("Number2") }, modifier = Modifier.padding(10.dp)
                )
            }
            Divider(modifier = Modifier.padding(20.dp))
            Row {
                Button(onClick = {
                    output = output(txt1 = text, txt2 = text2, "+")

                }, modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text("+")
                }
                Button(onClick = {
                    output = output(txt1 = text, txt2 = text2, "-")
                }, modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text("-")
                }
                Button(onClick = {
                    output = output(txt1 = text, txt2 = text2, "*")
                }, modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text("*")
                }
                Button(onClick = {
                    output = output(txt1 = text, txt2 = text2, "/")
                }, modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text("/")
                }
            }
            Divider(modifier = Modifier.padding(horizontal = 50.dp, vertical = 20.dp))
            TextField(
                value = output,
                onValueChange = { output = it },
                label = { Text("Result") }, modifier = Modifier.padding(10.dp)
            )
        }
    }
}

fun output(txt1: String, txt2: String, op: String): String {
    val val1 = parseInt(txt1)
    val val2 = parseInt(txt2)
    if (val1 == null) {
        return "Wrong number format in arg1: '$val1'"
    }
    if (val2 == null) {
        return "Wrong number format in arg2: '$val2'"
    }
    when (op) {
        "+" -> return (val1 + val2).toString()
        "-" -> return (val1 - val2).toString()
        "*" -> return (val1 * val2).toString()
        "/" -> return (val1 / val2).toString()
    }
    return ""

}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Form Window") {
        App()
    }
}
