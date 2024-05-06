package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
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
    var hideUi by rememberSaveable { mutableStateOf(false) }

    if (!hideUi) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
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

    BoxWithConstraints(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .offset(x = 30.dp)
    ) {
        if (maxWidth > 500.dp) {
            hideUi = true
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
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
        } else {
            hideUi = false
        }
    }
}