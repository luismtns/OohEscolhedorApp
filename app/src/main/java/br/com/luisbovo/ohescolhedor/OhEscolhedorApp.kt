package br.com.luisbovo.ohescolhedor

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun OhEscolhedorApp() {
    var options by remember { mutableStateOf(listOf<String>()) }
    val focusManager = LocalFocusManager.current
    var currentOption by remember { mutableStateOf(TextFieldValue("")) }
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var isSpinning by remember { mutableStateOf(false) }
    var hasResult by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        CustomTitle(text = "Ooh Escolhedor!")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){

            CustomTextField(
                value = currentOption,
                onValueChange = { currentOption = it },
                placeholder = "Digite uma opção",
                modifier = Modifier.weight(1f)
            )
            FilledIconButton(
                onClick = {
                    if (currentOption.text.isNotEmpty()) {
                        options = options + currentOption.text
                        currentOption = TextFieldValue("")
                    } else {
                        Toast.makeText(context, "Por favor, insira uma opção", Toast.LENGTH_SHORT).show()
                    }
                },
            ){
                Icon(Icons.Filled.Add, contentDescription = "Adicionar opção")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OptionsList(options)
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            onClick = {
                if (options.isNotEmpty() && !isSpinning) {
                    isSpinning = true
                    selectedOption = options.random()
                    focusManager.clearFocus()
                } else if (options.isEmpty()) {
                    Toast.makeText(context, "Adicione algumas opções primeiro", Toast.LENGTH_SHORT).show()
                }
            },
            text = "Sortear",
            enabled = options.isNotEmpty()
        )
        Spacer(modifier = Modifier.height(8.dp))
        RouletteWheel(options, selectedOption, isSpinning ){
            isSpinning = false
            hasResult = true
        }
        if(hasResult){
            LaunchedEffect(key1 = true) {
                delay(10*1000)
                hasResult = false
            }
            Confetti(modifier = Modifier.fillMaxWidth().height(500.dp))
        }
    }
}
