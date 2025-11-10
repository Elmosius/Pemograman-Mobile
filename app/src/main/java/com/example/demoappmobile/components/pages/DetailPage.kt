package com.example.demoappmobile.components.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoappmobile.R
import com.example.demoappmobile.components.ui.TopBar
import com.example.demoappmobile.models.Weather

@Composable
fun DetailPage(weather: Weather, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopBar(
                title = weather.kota,
                color = MaterialTheme.colorScheme.primary,
                isBack = true,
                onBackClick = { onBackClick() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.city_background_small),
                contentDescription = "City Background",
                modifier = Modifier
                    .size(250.dp)
                    .padding(16.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "${weather.suhu} C",
                    fontSize = 25.sp
                )


                Text("|", fontSize = 25.sp)

                Text(text = "${weather.kelembapan} %", fontSize = 25.sp)
            }

            Text(
                text = weather.kondisi,
                modifier = Modifier.padding(vertical = 8.dp),
                fontSize = 25.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "${weather.kecepatanAngin} m/s",
                    fontSize = 15.sp
                )

                Text(text = weather.arahAngin, fontSize = 15.sp)
            }
        }
    }
}

