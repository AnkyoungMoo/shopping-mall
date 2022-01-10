package com.km.shoppingmall.presenter.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.km.shoppingmall.ui.theme.ShoppingMallTheme

class SignUpActivity : ComponentActivity() {
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingMallTheme {
                SignUpScreen(viewModel)
            }
        }
    }
}

@Composable
fun SignUpScreen(viewModel: SignUpViewModel = SignUpViewModel()) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }

    Column {
        InputComponent("e-mail", email.value, onValueChange = { email.value = it })
        InputComponent("password", password.value, onValueChange = { password.value = it })
        InputComponent("name", name.value, onValueChange = { name.value = it })
        Button(onClick = { viewModel.signUp(email.value, password.value, name.value) }) {
            Text(text = "완료")
        }
    }
}

@Composable
fun InputComponent(label: String, textValue: String, onValueChange: (String) -> Unit) {
    Column {
        Text(text = label)
        TextField(value = textValue, onValueChange = onValueChange)
    }
}

@Preview
@Composable
fun Preview() {
    ShoppingMallTheme {
        SignUpScreen()
    }
}
