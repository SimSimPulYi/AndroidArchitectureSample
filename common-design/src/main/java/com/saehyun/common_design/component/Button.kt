package com.saehyun.common_design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.common_design.theme.Body1
import com.saehyun.common_design.theme.HalfOrange
import com.saehyun.common_design.theme.PrimaryOrange
import com.saehyun.common_design.theme.SampleTypography

@Composable
fun RedButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(20.dp)
            .background(
                color = PrimaryOrange,
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

@Composable
fun YellowButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(if (enabled) PrimaryOrange else HalfOrange)
            .clickable(
                onClick = {
                    if (enabled) onClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = SampleTypography.body1)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    RedButton("NextStep") {

    }
}
