package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContainQuadrants("Android")
                }
            }
        }
    }
}

@Composable
fun DisplayQuadrant(
    title: String,
    subTitle: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = subTitle, textAlign = TextAlign.Justify)
    }
}

@Composable
fun ContainQuadrants(name: String) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            DisplayQuadrant(title = stringResource(R.string.title1), subTitle = stringResource(R.string.subTitle1), color = Color.Green, modifier = Modifier.weight(1f))
            DisplayQuadrant(title = stringResource(R.string.title2), subTitle = stringResource(R.string.subTitle2), color = Color.Yellow, modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            DisplayQuadrant(title = stringResource(R.string.title3), subTitle = stringResource(R.string.subTitle3), color = Color.Cyan, modifier = Modifier.weight(1f))
            DisplayQuadrant(title = stringResource(R.string.title4), subTitle = stringResource(R.string.subTitle4), color = Color.LightGray, modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ContainQuadrants("Android")
    }
}