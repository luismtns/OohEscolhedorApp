package br.com.luisbovo.ohescolhedor.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.luisbovo.ohescolhedor.BuildConfig


@Composable
fun DisplayVersion() {
        val version =
            "version " + BuildConfig.VERSION_NAME
    Column (modifier =Modifier.padding(16.dp)){
        CustomText(
            text = version,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}