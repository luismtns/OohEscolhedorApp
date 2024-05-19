package br.com.luisbovo.ohescolhedor

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.luisbovo.ohescolhedor.components.Confetti
import br.com.luisbovo.ohescolhedor.components.CustomButton
import br.com.luisbovo.ohescolhedor.components.CustomText
import br.com.luisbovo.ohescolhedor.components.CustomTextField
import br.com.luisbovo.ohescolhedor.components.CustomTitle
import br.com.luisbovo.ohescolhedor.components.DisplayVersion
import br.com.luisbovo.ohescolhedor.components.OptionsList
import br.com.luisbovo.ohescolhedor.components.RouletteWheel
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

  if (hasResult) {
    LaunchedEffect(key1 = true) {
      delay(6000)
      hasResult = false
    }
    Confetti(
      modifier = Modifier
        .fillMaxSize()
        .zIndex(10f)
    )
  }

  Scaffold(
    bottomBar = {
      DisplayVersion()
    },
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .padding(innerPadding),
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

      Column(modifier = Modifier.padding(16.dp)) {
        CustomText(
          text = stringResource(R.string.app_emoji),
          fontSize = 52.sp,
          textAlign = TextAlign.Center
        )
        CustomTitle(text = stringResource(R.string.app_title))
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(16.dp),
          verticalAlignment = Alignment.CenterVertically,
        ) {

          CustomTextField(
            value = currentOption,
            onValueChange = { currentOption = it },
            placeholder = stringResource(R.string.field_placeholder),
            modifier = Modifier.weight(1f)
          )
          FilledIconButton(
            onClick = {
              if (currentOption.text.isNotEmpty()) {
                options = options + currentOption.text
                currentOption = TextFieldValue("")
              } else {
                Toast.makeText(context, R.string.toast_error, Toast.LENGTH_SHORT).show()
              }
            },
          ) {
            Icon(Icons.Filled.Add, contentDescription = stringResource(R.string.icon_add))
          }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomText(
          text = stringResource(id = R.string.field_label),
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.secondary,
          textAlign = TextAlign.Center
        )
        OptionsList(options)
        Spacer(modifier = Modifier.height(16.dp))
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier.fillMaxWidth()
        ) {

          CustomButton(
            onClick = {
              if (options.isNotEmpty() && !isSpinning) {
                isSpinning = true
                selectedOption = options.random()
                focusManager.clearFocus()
              } else if (options.isEmpty()) {
                Toast.makeText(context, R.string.toast_error_action, Toast.LENGTH_SHORT).show()
              }
            },
            text = stringResource(id = R.string.custom_button_text),
            enabled = options.size > 1
          )
        }
        Spacer(modifier = Modifier.height(8.dp))
        RouletteWheel(options, selectedOption, isSpinning) {
          isSpinning = false
          hasResult = true
        }
      }
    }
  }
}
