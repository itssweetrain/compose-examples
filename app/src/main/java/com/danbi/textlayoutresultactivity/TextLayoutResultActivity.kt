package com.danbi.textlayoutresultactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danbi.textlayoutresultactivity.ui.theme.TextLayoutResultActivityTheme
import com.danbi.textlayoutresultactivity.ui.theme.Typography
import com.danbi.textlayoutresultactivity.ui.theme.primary50

class TextLayoutResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextLayoutResultActivityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PocketMonCharacter()
                }
            }
        }
    }
}

@Composable
fun PocketMonCharacter() {
    var layout by remember { mutableStateOf<TextLayoutResult?>(null) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
            },
            border = BorderStroke(1.dp, primary50),
            shape = RoundedCornerShape(8.dp),
            elevation = null,
        ) {
            Column(
            ) {
                Text(
                    modifier = Modifier
                        .padding(0.dp,0.dp,0.dp,6.dp)
                        .drawBehind {
                            layout?.let {
                                val thickness = 5f
                                val dashPath = 15f
                                val spacingExtra = 4f
                                val offsetY = 6f

                                for (i in 0 until it.lineCount) {
                                    drawPath(
                                        path = Path().apply {
                                            moveTo(it.getLineLeft(i), it.getLineBottom(i) - spacingExtra + offsetY)
                                            lineTo(it.getLineRight(i), it.getLineBottom(i) - spacingExtra + offsetY)
                                        },
                                        primary50,
                                        style = Stroke(width = thickness,
                                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashPath, dashPath), 0f)
                                        )
                                    )
                                }
                            }
                        },
                    text = "pachirisu",
                    style = Typography.h1,
                    fontSize = 20.sp,
                    onTextLayout = {
                        layout = it
                    }
                )
                Text(
                    text= "포켓몬스터DP DP019 파치리스는 아무도 못 말려!",
                    style = Typography.h3,
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                )
            }

            Spacer(
                modifier = Modifier.width(10.dp)
            )

            Row(
            ) {
                Image(
                    painter = painterResource(R.drawable.pachirisu),
                    contentDescription = "char",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextLayoutResultActivityTheme {
        PocketMonCharacter()
    }
}