package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Bai_tapbuoi5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreen() {
    var selectedPaymentMethod by remember { mutableStateOf("") }
    val backgroundColors = listOf(
        Color(0xFF4CAF50), // Màu xanh lá cây
        Color(0xFFFFEB3B), // Màu vàng
        Color(0xFFFF9800), // Màu cam
        Color(0xFF9C27B0), // Màu tím
        Color(0xFFF44336)  // Màu đỏ
    )

        Text(
            text = "Thanh Toán",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(3.dp)
        )

    var count = 0 // Biến đếm

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF964B00)) // Màu nâu
            .padding(16.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Thanh Toán",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(3.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Địa chỉ nhận hàng",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.img_6),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(5.dp)
                )
                Text(text = "Trí | 2222222\n22/333 đường Trung Mỹ Tây 1\nphường Tân Thới Nhất\nquận 12, Thành phố Hồ Chí Minh")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Vui lòng chọn một trong những phương thức sau:",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        val paymentMethods = listOf(
            "PayPal" to R.drawable.img_1,
            "VISA" to R.drawable.img_2,
            "Momo" to R.drawable.img,
            "Zalo Pay" to R.drawable.img_5,
            "Thanh toán trực tiếp" to R.drawable.img_4
        )
        items(paymentMethods) { (method, icon) ->
            PaymentMethodItem(
                method = method,
                icon = icon,
                selected = selectedPaymentMethod == method,
                onSelect = { selectedPaymentMethod = method },
                backgroundColor = backgroundColors[count % backgroundColors.size] // Sử dụng biến đếm
            )
            count++ // Tăng biến đếm sau mỗi vòng lặp
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Button(
                onClick = { /* Handle button click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Tiếp theo", color = Color.White)
            }
        }
    }
}



@Composable
fun PaymentMethodItem(
    method: String,
    icon: Int,
    selected: Boolean,
    onSelect: () -> Unit,
    backgroundColor: Color // Thêm một tham số cho màu nền
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

            .clickable { onSelect() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(backgroundColor)
                .heightIn(70.dp) // Thiết lập màu nền cho Row
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = method, fontSize = 16.sp, modifier = Modifier.weight(1f), color = Color.White
            )
            RadioButton(selected = selected, onClick = { onSelect() })
        }
    }
}



