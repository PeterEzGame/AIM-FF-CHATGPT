package com.haridwg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HaridwgApp()
        }
    }
}

@Composable
fun HaridwgApp() {

    var engine by remember {
        mutableStateOf(false)
    }

    var login by remember {
        mutableStateOf(false)
    }

    var ninja by remember {
        mutableStateOf(false)
    }

    var freeze by remember {
        mutableStateOf(false)
    }

    var tele by remember {
        mutableStateOf(false)
    }

    MaterialTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(8, 8, 11)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Ib dis : mfxa_.",
                    color = Color.White,
                    fontSize = 23.sp
                )

                Text(
                    text = "HARIDWG",
                    color = Color.Gray,
                    fontSize = 12.sp
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                ServerCard(
                    running = engine,
                    onClick = {
                        engine = !engine
                    }
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                Text(
                    text = "CONTROL",
                    color = Color.Gray,
                    fontSize = 11.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceEvenly
                ) {

                    ControlButton(
                        name = "LOGIN",
                        active = login
                    ) {
                        login = !login
                    }

                    ControlButton(
                        name = "NINJA",
                        active = ninja
                    ) {
                        ninja = !ninja
                    }

                    ControlButton(
                        name = "FREEZE",
                        active = freeze
                    ) {
                        freeze = !freeze
                    }

                    ControlButton(
                        name = "TELE",
                        active = tele
                    ) {
                        tele = !tele
                    }
                }

                Spacer(
                    modifier = Modifier.height(28.dp)
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            Color(18, 18, 23)
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = "AIM TRAINER",
                            color = Color.White,
                            fontSize = 18.sp
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text =
                                "Reaction & hitbox practice",
                            color = Color.Gray,
                            fontSize = 13.sp
                        )

                        Spacer(
                            modifier = Modifier.height(15.dp)
                        )

                        Button(
                            modifier =
                                Modifier.fillMaxWidth(),

                            onClick = {
                                // Mở màn hình luyện aim
                            },

                            shape =
                                RoundedCornerShape(10.dp)
                        ) {

                            Text(
                                text = "OPEN AIM TRAINER"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ServerCard(
    running: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        colors = CardDefaults.cardColors(
            containerColor = Color(18, 18, 23)
        ),

        shape = RoundedCornerShape(14.dp)
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = "SERVER STATUS",
                color = Color.Gray,
                fontSize = 10.sp
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text =
                    if (running)
                        "● Engine running"
                    else
                        "● Engine stopped",

                color =
                    if (running)
                        Color(90, 220, 120)
                    else
                        Color.LightGray,

                fontSize = 14.sp
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClick,
                shape = RoundedCornerShape(10.dp)
            ) {

                Text(
                    text =
                        if (running)
                            "STOP ENGINE"
                        else
                            "START ENGINE"
                )
            }
        }
    }
}

@Composable
private fun ControlButton(
    name: String,
    active: Boolean,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,

        modifier = Modifier.size(70.dp),

        shape = CircleShape,

        colors = ButtonDefaults.buttonColors(
            containerColor =
                if (active)
                    Color(190, 45, 55)
                else
                    Color(35, 35, 40)
        ),

        contentPadding =
            androidx.compose.foundation.layout
                .PaddingValues(0.dp)
    ) {

        Text(
            text = name,
            fontSize = 9.sp
        )
    }
}
