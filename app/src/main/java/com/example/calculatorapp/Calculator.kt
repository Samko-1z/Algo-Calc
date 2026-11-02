package com.example.calculatorapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme

val buttonList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "+",
    "1", "2", "3", "-",
    "AC", "0", ".", "="
)

@Composable
fun Calculator(modifier: Modifier = Modifier, viewModel: CalculatorViewModel) {

    val equationText = viewModel.EquationText.observeAsState()
    val resultText   = viewModel.resultText.observeAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier            = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {

            Row(
                modifier          = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { viewModel.toggleTheme() }) {
                    Icon(
                        imageVector = if (viewModel.isDarkTheme.value)
                            Icons.Filled.LightMode else Icons.Filled.DarkMode,
                        contentDescription = if (viewModel.isDarkTheme.value)
                            "Switch to Light Mode" else "Switch to Dark Mode",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Text(
                text = equationText.value ?: "",
                style = TextStyle(
                    fontSize  = 30.sp,
                    textAlign = TextAlign.End,
                    color     = MaterialTheme.colorScheme.onSurface
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(0.5f))

            Text(
                text = resultText.value ?: "",
                style = TextStyle(
                    fontSize  = 60.sp,
                    textAlign = TextAlign.End,
                    color     = MaterialTheme.colorScheme.onBackground
                ),
                maxLines = 2,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns  = GridCells.Fixed(count = 4),
                modifier = Modifier.weight(1f)
            ) {
                items(buttonList) { item ->
                    CalculatorButton(btn = item) {
                        viewModel.onButtonClick(item)
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(btn: String, onClick: () -> Unit) {
    Box(
        modifier         = Modifier.padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        FloatingActionButton(
            onClick        = onClick,
            modifier       = Modifier.size(70.dp),
            shape          = CircleShape,
            containerColor = getColor(btn),
            contentColor   = if (btn in listOf("/", "*", "+", "-", "="))
                Color.White else MaterialTheme.colorScheme.onTertiary
        ) {
            Text(
                text       = btn,
                fontSize   = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun getColor(btn: String): Color {
    if (btn == "C" || btn == "AC")
        return MaterialTheme.colorScheme.secondary
    if (btn == "(" || btn == ")")
        return MaterialTheme.colorScheme.secondary
    if (btn == "/" || btn == "*" || btn == "+" || btn == "-" || btn == "=")
        return MaterialTheme.colorScheme.primary
    return MaterialTheme.colorScheme.tertiary
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun CalculatorPreview() {
    CalculatorAppTheme(darkTheme = false) {
        Calculator(viewModel = CalculatorViewModel())
    }
}

@Preview(showBackground = true, name = "Dark Mode")
@Composable
fun CalculatorPreviewDark() {
    CalculatorAppTheme(darkTheme = true) {
        Calculator(viewModel = CalculatorViewModel())
    }
}
