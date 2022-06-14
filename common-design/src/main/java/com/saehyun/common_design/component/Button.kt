package com.saehyun.common_design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.common_design.theme.Body1
import com.saehyun.common_design.theme.primaryBlue

@Composable
fun RedButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(20.dp)
            .background(
                color = primaryBlue,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 12.dp)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Body1(text = text, modifier = Modifier.padding(vertical = 6.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    RedButton("NextStep") {

    }
}
