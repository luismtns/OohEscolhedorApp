package br.com.luisbovo.ohescolhedor

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomText( text: String,
                fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
                textAlign: TextAlign? = null,
                color: Color = MaterialTheme.colorScheme.onBackground,
style: TextStyle = MaterialTheme.typography.bodyMedium) {
    Text(
        text = text,
        style = style.copy(fontSize = fontSize),
        lineHeight = MaterialTheme.typography.displaySmall.lineHeight,
        textAlign = textAlign,
        color = color,
        modifier = Modifier.fillMaxWidth()
    )
}
