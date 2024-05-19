package br.com.luisbovo.ohescolhedor

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        content =  {
            Text(text =text, color = MaterialTheme.colorScheme.onPrimary, fontSize = 20.sp)
        }
    )
}
