package br.com.luisbovo.ohescolhedor.components

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue

@Composable
fun RouletteWheel(
    options: List<String>,
    selectedOption: String?,
    isSpinning: Boolean,
    onSpinEnd: () -> Unit
) {
    var rotation by remember { mutableFloatStateOf(0f) }
    var targetRotation by remember { mutableFloatStateOf(0f) }
    var currentIndex by remember { mutableIntStateOf(0) }
    var displayedOption by remember { mutableStateOf(options.getOrNull(currentIndex)) }
    var hasResult by remember { mutableStateOf(false) }

    LaunchedEffect(isSpinning) {
        if (isSpinning) {
            targetRotation += 360f * 10 // 10 full spins
            animate(
                initialValue = rotation,
                targetValue = targetRotation,
                animationSpec = tween(durationMillis = 6*1000, easing = CubicBezierEasing(0.5f, 1f, 0.89f, 1f))
            ) { value, _ ->
                rotation = value
                currentIndex = ((value / 360f * options.size) % options.size).absoluteValue.toInt()
                displayedOption = options.getOrNull(currentIndex)
            }
            hasResult=true;
            onSpinEnd()
        }
    }

    if (options.isNotEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(252.dp)
                .padding(top = 32.dp, bottom = 32.dp)
                .graphicsLayer(
                    rotationZ = rotation,
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                ),
            contentAlignment = Alignment.Center
        ) {
            CustomText(
                text = displayedOption ?: "escolha!",
                style = MaterialTheme.typography.displayMedium,
                fontSize = if(hasResult)42.sp else 32.sp,
                textAlign = TextAlign.Center,
                color = if(hasResult) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
            )
        }
    }
}
