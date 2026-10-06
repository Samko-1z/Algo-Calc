package com.example.calculatorapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

val buttonList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "+",
    "1", "2", "3", "-",
    "AC", "0", ".", "="
)

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "123+123",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(0.5f))

            Text(
                text = "246",
                style = TextStyle(
                    fontSize = 60.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 2,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 4),
                modifier = Modifier.weight(1f)
            ) {
                items(buttonList) { item ->
                    CalculatorButton(btn = item)
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(btn: String) {
    Box(
        modifier = Modifier.padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        FloatingActionButton(
            onClick = { /* TODO: Handle click */ },
            modifier = Modifier.size(70.dp),
            shape = CircleShape,
            containerColor = getColor(btn),
            contentColor = if (btn in listOf("/", "*", "+", "-", "=")) Color.White else Color.Black
        ) {
            Text(
                text = btn,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


fun getColor(btn : String) : Color{
    if(btn == "C" || btn == "AC")
        return Color(0xFFD4D4D8)
    if(btn == "(" || btn == ")")
        return Color(0xFFE4E4E7)
    if(btn == "/" || btn == "*" || btn == "+" || btn == "-" || btn == "=" )
        return Color(0xFFFF9800)
    return Color(0xFFF4F4F5)
}



@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Calculator()
}