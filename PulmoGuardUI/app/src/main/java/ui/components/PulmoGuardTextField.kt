package ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PulmoGuardTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    val coffeeBrown = Color(0xFF6B4A3A)
    val fieldBg = Color(0x22FFFFFF)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = coffeeBrown) },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = fieldBg,
            unfocusedContainerColor = fieldBg,
            focusedIndicatorColor = coffeeBrown,
            unfocusedIndicatorColor = coffeeBrown.copy(alpha = 0.4f),
            cursorColor = coffeeBrown
        )
    )
}
