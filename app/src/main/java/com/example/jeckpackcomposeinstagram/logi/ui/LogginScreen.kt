package com.example.jeckpackcomposeinstagram.logi.ui


import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jeckpackcomposeinstagram.R


@Composable
fun LogginScreen(loginViewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        val isLoading: State<Boolean> = loginViewModel.isLoading.observeAsState(initial = false)
        if (isLoading.value) {
            Box(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                   
            ) {
                CircularProgressIndicator()
            }
        } else {
            Header(Modifier.align(Alignment.TopEnd))
            Body(Modifier.align(Alignment.Center), loginViewModel)
            Footer(
                Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(
            Modifier
                .background(Color.Gray)
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "Dont have an account?", fontSize = 12.sp, color = Color(0xFFB5B5B5))
        Text(
            text = "Sign Up.",
            Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )

    }
}

@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    var email = loginViewModel.email.observeAsState(initial = "")
    var password = loginViewModel.password.observeAsState(initial = "")
    var isLoginEnable = loginViewModel.isLoginEnable.observeAsState(initial = false)
//    val email = rememberSaveable { mutableStateOf("") }
//    val password = rememberSaveable { mutableStateOf("") }
//    val isLoginEnable = rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        ImagesHeader(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Email(email.value) {
            loginViewModel.onLoginChange(email = it, password.value)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password.value) {
            loginViewModel.onLoginChange(email.value, password = it)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(8.dp))
        LoginButton(isLoginEnable.value, loginViewModel)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()


    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb_2),
            contentDescription = "Login Facebook",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Rei Ayanami", fontSize = 14.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp), color = Color(0xFF4EA8E9)

        )
    }
}

@Composable
fun LoginDivider() {
    Row(
        Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(isLoginEnable: Boolean, loginViewModel: LoginViewModel) {
    Button(
        onClick = {
            loginViewModel.onLoginSelected()
        },
        enabled = isLoginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF4E4E8),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Login")
    }
}


@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot your password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xff4EA8E9),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    val passwordVisibility = remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { newText ->
            onTextChanged(newText) // Llamamos a la función con el nuevo valor
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val icon = if (passwordVisibility.value) {
                Icons.Filled.AccountCircle
            } else {
                Icons.Filled.AccountCircle
            }
            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                Icon(
                    imageVector = icon,
                    contentDescription = if (passwordVisibility.value) "Hide password" else "Show password"
                )
            }
        },
        visualTransformation = if (passwordVisibility.value) {
            VisualTransformation.None // Texto visible
        } else {
            PasswordVisualTransformation() // Texto oculto con puntos
        },

        )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { newText -> onTextChanged(newText) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

        )
}


@Composable
fun ImagesHeader(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Logo Instagram",
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close App",
        modifier = modifier.clickable { activity.finish() })
}