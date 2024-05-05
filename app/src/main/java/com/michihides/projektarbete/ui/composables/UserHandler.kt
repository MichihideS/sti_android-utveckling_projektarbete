package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.theme.DarkerWhite

/* Component for the username and password fields on the sign in page
** The Password field is set to hidden
 */
@Composable
fun UserHandler(
    user: User,
    onChangeUser: (User) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
            ){
        OutlinedTextField(
            value = user.username,
            onValueChange = { onChangeUser(user.copy(username = it)) },
            label = { Text(text = "Username") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = DarkerWhite,
                unfocusedContainerColor = DarkerWhite,
                disabledContainerColor = DarkerWhite
            )
        )

        OutlinedTextField(
            value = user.password,
            onValueChange = { onChangeUser(user.copy(password = it)) },
            label = { Text(text = "Password") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = DarkerWhite,
                unfocusedContainerColor = DarkerWhite,
                disabledContainerColor = DarkerWhite
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}