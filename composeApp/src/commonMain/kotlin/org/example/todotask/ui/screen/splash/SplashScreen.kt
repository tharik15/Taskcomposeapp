package org.example.todotask.ui.screen.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import org.example.todotask.util.Actions
import kotlinx.coroutines.delay
import org.example.todotask.resources.Res
import org.example.todotask.resources.logo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen(
    navigateListScreen:(String) -> Unit
){
    var isStartAnimation by remember { mutableStateOf(false) }
    val offSetState by animateDpAsState(targetValue =
    if (isStartAnimation) 0.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    val alphaState by animateFloatAsState(
        targetValue = if (isStartAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect(key1 = true) {
        isStartAnimation = true
        delay(3000)
        navigateListScreen(Actions.NO_ACTION)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center

    ) {
        Column(modifier = Modifier
            .alpha(alphaState).offset(offSetState).padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(getDrawable()),
                contentDescription = "Logo")

            Text(modifier = Modifier,
                text = "Todo Task",
                color = Color.Black,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1)
        }
    }
}

@Composable
fun getDrawable(): DrawableResource {
    return if (isSystemInDarkTheme()){
        Res.drawable.logo
    }else{
        Res.drawable.logo
    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen({

    })
}