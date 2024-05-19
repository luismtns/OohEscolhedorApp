package br.com.luisbovo.ohescolhedor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun OptionsList(options: List<String>) {
    Box(modifier = Modifier.fillMaxWidth().heightIn(max=140.dp, min=0.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .verticalScrollWithScrollbar(rememberScrollState())
        ) {
            var index = 0;
            options.forEach { option ->
                index++
                CustomText(option, fontSize = 20.sp)
                if(index >= options.size){
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }// Gradiente no final
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp) // Altura do gradiente
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                ).zIndex(1f)
        )
    }
}
