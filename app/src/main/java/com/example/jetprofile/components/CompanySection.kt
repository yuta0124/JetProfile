package com.example.jetprofile.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompanySection(
    @StringRes companyName: Int,
    @StringRes groupName: Int
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {//fillMaxで外のカラムいっぱいに幅を取る

        //会社名
        Text(
            text = stringResource(id = companyName),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        //部署・グループ名
        Text(text = stringResource(id = groupName), color = Color.Gray, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(20.dp))
        //eメール
        Label(icon = Icons.Default.Email, text = "Email")

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "exsample@gmail.com", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(5.dp))

        //線、角丸
        Divider(
            thickness = 2.dp,
            modifier = Modifier.clip(RoundedCornerShape(1000.dp))
        )
    }
}