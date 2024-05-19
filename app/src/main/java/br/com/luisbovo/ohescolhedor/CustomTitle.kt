package br.com.luisbovo.ohescolhedor

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import br.com.luisbovo.ohescolhedor.ui.theme.Purple40

@Composable
fun CustomTitle(text: String, fontSize: TextUnit = MaterialTheme.typography.displayMedium.fontSize, textAlign: TextAlign? = TextAlign.Center) {
    Text(text = text, style = MaterialTheme.typography.displayMedium.copy(fontSize = fontSize), textAlign = textAlign, color = Purple40, modifier = Modifier.fillMaxWidth().padding(top=32.dp, bottom = 32.dp))
}
