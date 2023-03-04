package widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import theme.Theme

@Composable
fun CommonTextField(
    text: String,
    hint: String,
    enabled: Boolean = true,
    isSecure: Boolean = false,
    trailingIcon: @Composable () -> Unit = {},
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = text,
        enabled = enabled,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF1F2430),
            textColor = Color(0xFF696C75),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Theme.colors.highlightTextColor
        ),
        placeholder = {
            Text(hint, color = Theme.colors.hintTextColor)
        },
        visualTransformation =
        if (isSecure) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {
                       trailingIcon.invoke()
        },
        onValueChange = {
           onValueChanged.invoke(it)
        })
}