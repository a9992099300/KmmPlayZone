package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme
import widgets.CommonTextField

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Now",
            color = Theme.colors.thirdTextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome back to PlayZone! Enter your email" +
                    "address and your password to enjov the latest" +
                    "features PlayZone",
            color = Theme.colors.hintTextColor,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))

        CommonTextField(
            text = state.email,
            hint = "Your Login",
            enabled = !state.isSending,
            onValueChanged = {
                eventHandler.invoke(LoginEvent.EmailChanged(it))
            })

        Spacer(modifier = Modifier.height(24.dp))

        CommonTextField(
            text = state.password,
            enabled = !state.isSending,
            hint = "Your password",
            isSecure = state.passwordHidden,
            onValueChanged = {
                eventHandler.invoke( LoginEvent.PasswordChanged(it))
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        eventHandler.invoke(LoginEvent.PasswordShowClick)
                    },
                    imageVector = if (state.passwordHidden) {
                        Icons.Outlined.Clear
                    } else {
                        Icons.Outlined.Lock
                    }, contentDescription = "Password hidden",
                    tint = Theme.colors.hintTextColor
                )
            }
            )

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.clickable { eventHandler.invoke(LoginEvent.ForgotClick) },
                text = "Forgot password", color = Theme.colors.primaryAction,
                fontSize = 12.sp
            )
        }


        Spacer(modifier = Modifier.height(30.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            enabled = !state.isSending,

            shape = RoundedCornerShape(10.dp),
            onClick = {
                eventHandler.invoke(LoginEvent.LoginClick)
            }) {
            Text(
                text = "Login Now!", color = Theme.colors.primaryTextColor,
                fontSize = 16.sp, fontWeight = FontWeight.Bold
            )
        }
    }
}