package com.omegaplus.jetpackcomposeapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import java.io.RandomAccessFile
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            1. ImageView
//            val painter = painterResource(id = R.drawable.img)
//            val contentDesc  =  "India is the best country in the world"
//            val title = "Write about the India ?"
//            Box(modifier = Modifier.fillMaxWidth(.5f).padding(16.dp)) {
//                ImageCard(painter = painter, contentDesc = contentDesc, title = title)
//            }

//            2. BoxView with custom design text
//            BoxDesign(context = this)

//            3. ColorBox with mutable state as livedata
//            ColorBox(Modifier.fillMaxSize(), context = this)

        }
    }
}

@Composable
fun BoxDesign(context: Context){
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .clickable {
                Toast
                    .makeText(context, "Rakesh", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp,
                        textDecoration = TextDecoration.Underline,
                    )
                ){
                    append("S")
                }
                append("aki")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp,
                        textDecoration = TextDecoration.Underline
                    )
                ){
                    append("R")
                }
                append("aka")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ImageCard(painter: Painter, contentDesc: String, title: String, modifier: Modifier = Modifier){
    Card( 
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp 
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDesc,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.Black, fontSize = 12.sp))
                Text(text = contentDesc, style = TextStyle(color = Color.Black, fontSize = 12.sp))

            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, context: Context){
//    Toast.makeText(context, "Called", Toast.LENGTH_SHORT).show() :-  Called everytime when you click on the box
    val color = remember {
        mutableStateOf(Color.Red)
    }
    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }
    )
}
