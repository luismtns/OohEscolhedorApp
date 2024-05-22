package br.com.luisbovo.ohescolhedor.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.luisbovo.ohescolhedor.R
import br.com.luisbovo.ohescolhedor.modifier.verticalScrollWithScrollbar

@Composable
fun OptionsList(options: List<String>, onDrop: (opt:String)->Unit) {
    Box(modifier = Modifier
      .fillMaxWidth()
      .heightIn(max = 124.dp, min = 0.dp)) {
        Column(
            modifier = Modifier
              .fillMaxWidth()
              .verticalScrollWithScrollbar(rememberScrollState())
        ) {
            var index = 0;
            options.forEach { option ->
                Row(
                  modifier = Modifier
                    .fillMaxWidth().padding(end=8.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically,
                ) {
                  CustomText(option, fontSize = 20.sp, modifier = Modifier.width(100.dp))
                  IconButton(onClick =  {
                    onDrop(option)
                  }, modifier = Modifier.size(20.dp)) {
                    Icon(Icons.Filled.Clear, contentDescription = stringResource(R.string.icon_remove), tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f))
                  }
                }
                if(index >= options.size-1){
                  Spacer(modifier = Modifier.height(8.dp))
                }
                index++
              }
            if(options.isEmpty()){
                CustomText(stringResource(
                    id = R.string.field_empty),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    modifier=Modifier.padding(24.dp))
            }
          Spacer(modifier = Modifier.height(16.dp))
        }

        Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(32.dp)
              .align(Alignment.BottomCenter)
              .background(
                brush = Brush.verticalGradient(
                  colors = listOf(
                    Color.Transparent,
                    MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
                    MaterialTheme.colorScheme.background
                  )
                )
              )
              .zIndex(1f)
        )
    }
}
