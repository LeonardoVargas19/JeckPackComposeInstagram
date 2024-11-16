package com.example.jeckpackcomposeinstagram


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun LogginScreen(){
    Header()
}
@Composable
fun Header(){
    Icon(imageVector = Icons.Default.Close, contentDescription = null)
}