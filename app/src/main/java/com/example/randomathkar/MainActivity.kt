package com.example.randomathkar

import android.content.Context
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomathkar.ui.theme.RandomAthkarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomAthkarTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RandomCardScreen(context = this)
                }
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    ThekrText("الحمد لله", count = 3)
//                }
            }
        }
    }
}

@Composable
fun ThekrText(thekr:String, count:Int, source: String = "",modifier: Modifier = Modifier){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = thekr,
                fontSize = 40.sp
            )
            Row (horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(text = count.toString(), fontSize = 25.sp)
                Text(text = "مرات", fontSize = 25.sp)
            }
        }
    }
}

@Composable
fun CardItem(card: Card) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Your card content here
        Text(text = card.text, modifier = Modifier.padding(16.dp))
    }
}

// Function to get a random card
fun getRandomCard(context: Context): Card {
    val cardTexts = context.resources.getStringArray(R.array.card_texts)
    val randomText = cardTexts.random()
    return Card(text = randomText) // You can assign a unique ID if needed
}

@Composable
fun RandomCardScreen(context: Context) {
    val randomCard = remember { getRandomCard(context) }
    CardItem(card = randomCard)
}





