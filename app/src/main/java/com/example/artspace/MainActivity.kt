package com.example.artspace


import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.shadow

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtworkIndex by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ImageComponent(artworks[currentArtworkIndex])
        ArtDescriptor(artworks[currentArtworkIndex])
        ControlPanel(
            onNextClicked = {
                currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
            },
            onPreviousClicked = {
                currentArtworkIndex = (currentArtworkIndex - 1 + artworks.size) % artworks.size
            }
        )
    }
}




@Composable
fun ImageComponent(artwork: Artwork
) {

    Box(
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 2.dp)
    )
    {
        Image(
            painter = painterResource(id = artwork.imageResId),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .size(width = 400.dp, height = 600.dp)
                .aspectRatio(1f)
                .padding(8.dp)
        )
    }
}


@Composable
fun ArtDescriptor(artwork: Artwork
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .background(color = Color.Green)
            .padding(8.dp)
    ) {
        Text(
            text = artwork.title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )


        Spacer(modifier = Modifier.width(4.dp))


        Text(
            text = artwork.description,
            style = TextStyle(

            )

        )
    }
}

@Composable
fun ControlPanel(
    onPreviousClicked: () -> Unit,
    onNextClicked: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(300.dp)

    ) {
        Button(
            onClick = onPreviousClicked,
            modifier = Modifier
                .weight(1f)
                .widthIn(min = 30.dp)
        ) {
            Text(text = stringResource(id = R.string.previousButton))
        }


        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = onNextClicked,
            modifier = Modifier
                .weight(1f)
                .widthIn(min = 30.dp)
        ) {
            Text(text = stringResource(id = R.string.nextButton))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}