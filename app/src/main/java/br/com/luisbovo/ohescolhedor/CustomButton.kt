package br.com.luisbovo.ohescolhedor

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.luisbovo.ohescolhedor.ui.theme.Purple40

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) Purple40 else Color.Gray
        )
    ) {
        Text(text = text, color = Color.White)
    }
}
