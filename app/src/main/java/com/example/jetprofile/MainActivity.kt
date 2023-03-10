package com.example.jetprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetprofile.components.CompanySection
import com.example.jetprofile.components.DetailSection
import com.example.jetprofile.ui.theme.JetProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetProfileTheme {
                MainContent(
                    name = R.string.name,
                    job = R.string.job,
                    companyName = R.string.companyName,
                    groupName = R.string.groupName,
                    profileImg = R.drawable.baseline_account,
                )
            }
        }
    }
}


@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    @StringRes name: Int,
    @StringRes job: Int,
    @StringRes companyName: Int,
    @StringRes groupName: Int,
    @DrawableRes profileImg: Int,
) {
    var expanded by remember { mutableStateOf(false) }

    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState()), //?????????????????????
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            //??????????????????????????????
            Image(  //???????????????painter???????????????imageVector??????OK
                painter = painterResource(id = profileImg),
                contentDescription = "??????????????????",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp))    //?????????????????????
            )
            Spacer(modifier = Modifier.height(20.dp))
            //??????
            Text(
                text = stringResource(id = name),
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(20.dp))

            //??????
            Text(text = stringResource(id = job), color = Color.Gray, fontSize = 16.sp)

            Spacer(modifier = Modifier.height(20.dp))

            //????????????
            CompanySection(companyName = companyName, groupName = groupName)

            Spacer(modifier = Modifier.height(20.dp))

            //?????????????????????
            Button(
                onClick = {
                    expanded = !expanded
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A))
            ) {
                Text(
                    text = "???????????????",
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            //?????? & ?????????
            DetailSection(expanded = expanded)
        }
    }
}

@Preview(widthDp = 320, showBackground = true)
@Composable
fun PreviewProfile()  {
    MainContent(
        name = R.string.name,
        job = R.string.job,
        companyName = R.string.companyName,
        groupName = R.string.groupName,
        profileImg = R.drawable.baseline_account,
    )
}
