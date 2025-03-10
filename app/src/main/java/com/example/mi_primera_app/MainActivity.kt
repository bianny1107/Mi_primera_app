package com.example.mi_primera_app

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mi_primera_app.ui.theme.Mi_primera_appTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola, buenas tardes"),
    MyMessage("Hola, buenas tardes 2"),
    MyMessage("Hola, buenas tardes 3"),
    MyMessage("Hola, buenas tardes 4"),
    MyMessage("Hola, buenas tardes 5"),
    MyMessage("Hola, buenas tardes 6")

)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalData(name = "Bianny")
        }
    }
}

@Composable
private fun PersonalData (name : String){
    MaterialTheme (){
        Column (modifier = Modifier.padding(10.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(R.drawable.logo_jetpackc),
                contentDescription = "Este es el logo de JetPack Compose",
                modifier = Modifier.height(200.dp)
            )
            Text(text = "Mi nombre es $name", style = MaterialTheme.typography.headlineLarge)
            Text("Soy Bianny")
            Text(text = "Estoy aprendiendo Jetpack Compose")

            MyComponent()
        }
    }
}

@Composable
private fun MyComponent(message: MyMessage){
    Row (modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(8.dp)){
        MyImage()
        MyTexts(message)
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages){message ->
            MyComponent((message))
        }
    }
    MyComponent()
}

@Composable
fun MyImage(){
    Image(
        painter = painterResource(R.drawable.logo_lorem),
        contentDescription = "Este es mi logo",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(80.dp)
    )
}

@Composable
fun MyTexts(message: MyMessage){
    Column (modifier = Modifier.padding(start = 8.dp)){
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun MyText(text : String, color : Color, style : TextStyle){
    Text(text, color = color, style = style)
}

@Preview
@Composable
fun PreviewPersonalData (){
    PersonalData(name = "Lorem")
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showSystemUi = true)
@Composable
fun PreviewComponents(){
    Mi_primera_appTheme (){

        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            MyMessages(messages)
        }
    }
}

