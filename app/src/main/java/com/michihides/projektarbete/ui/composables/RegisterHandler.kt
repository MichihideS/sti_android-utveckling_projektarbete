package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.michihides.projektarbete.models.User

/* Component for the username and password fields on the sign in page
** The Password field is set to hidden
 */
@Composable
fun RegisterHandler(
    user: User,
    onChangeUser: (User) -> Unit
) {
    Column {
        OutlinedTextField(
            value = user.username,
            onValueChange = { onChangeUser(user.copy(username = it)) },
            label = { Text(text = "Username") }
        )

        OutlinedTextField(
            value = user.password,
            onValueChange = { onChangeUser(user.copy(password = it)) },
            label = { Text(text = "Password") },

            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}