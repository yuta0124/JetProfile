package com.example.jetprofile.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailSection(expanded: Boolean) {
    AnimatedVisibility(
        visible = expanded,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.LightGray.copy(alpha = 0.3f))
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 20.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Label(icon = Icons.Default.Favorite, text = "趣味：　筋トレ", color = Color.Gray)
            Spacer(modifier = Modifier.height(10.dp))
            Label(icon = Icons.Default.LocationOn, text = "居住地： 東京都江東区", color = Color.Gray)
        }
    }
}