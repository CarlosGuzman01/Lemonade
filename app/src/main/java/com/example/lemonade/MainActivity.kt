package com.example.lemonade

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {

                    Application()
                }
            }
        }
    }
}


@Composable
fun Application(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppButton()
        Spacer(modifier = Modifier.height(16.dp))
        AppText()
    }


}

@SuppressLint("SuspiciousIndentation")
@Composable
fun AppButton(modifier: Modifier = Modifier) {

    val buttonColor = Color(0xFFc3ecd2)

    var result by remember {
        mutableStateOf(1)
    }

    var number2 by remember {
        mutableStateOf((2..4).random())
    }

    lateinit var imageButton: Painter


    when (result) {
        1 -> {
            imageButton = painterResource(id = R.drawable.lemon_tree)
            AppText()
        }

        2 -> {
            imageButton = painterResource(id = R.drawable.lemon_squeeze)
        }

        3 -> {
            imageButton = painterResource(id = R.drawable.lemon_drink)
        }

        4 -> {
            imageButton = painterResource(id = R.drawable.lemon_restart)

        }


        }

    Button(
        onClick = {
            if (result == 2) {
                number2--
                if (number2 <= 0) {
                    result++
                }
            } else if(result > 4) {
                result = 1

            }else{
                ++result
            }
        },
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = RoundedCornerShape(40.dp)

    ) {

        Image(
            painter = imageButton, contentDescription = stringResource(
                id = R.string.Lemon_tree_description
            ), 
        )
    }
}

@Composable
fun AppText(text: String = "", modifier: Modifier = Modifier) {

    Text(
        text = text,
        fontSize = 40.sp

    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Application()
    }
}