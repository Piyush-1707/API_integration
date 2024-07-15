package com.example.api_integration.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.api_integration.Model.Data.User
import com.example.api_integration.ViewModel.UserViewModel


@Composable
fun UserScreen(userVM: UserViewModel) {
    val users by userVM.users.observeAsState(emptyList())
    Column(modifier = Modifier.background(Color.Black)){
        Text(text = "UserList",color=Color.White,fontSize = 50.sp, fontWeight = FontWeight.ExtraBold)

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            items(users) {
                userItem(user = it)
            }
        }
    }
}

@Composable
fun userItem(user: User) {
    Column(modifier = Modifier
        .background(Color.Black)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Card(
            modifier = Modifier
                .padding(8.dp)
                .width(360.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(5.dp),

                verticalArrangement = Arrangement.Center
            ) {
                Text("id: ${user.id}")
                Spacer(modifier = Modifier.height(3.dp))
                Row{
                    Text("EmailId:")
                    Text("${user.email}", color = Color.Blue, textDecoration = TextDecoration.Underline)
                }
                Spacer(modifier = Modifier.height(3.dp))
                Text("Username: ${user.username}")
                Spacer(modifier = Modifier.height(3.dp))
                Text("Password: ${user.password}")
                Spacer(modifier = Modifier.height(3.dp))
                Text("Name: ${user.name.firstname} ${user.name.lastname}")



            }

        }
    }
}
//
//@Composable
//fun ProductItem(product: Product) {
//    Column {
//        Card(
//            modifier = Modifier
//                .padding(8.dp)
//                .width(400.dp)
//                .height(600.dp),
//            shape = RoundedCornerShape(8.dp),
//            elevation = CardDefaults.cardElevation(
//                defaultElevation = 6.dp
//            ),
//            colors = CardDefaults.cardColors(containerColor = Color.White)
//        ) {
//            Column(
//                modifier = Modifier.padding(5.dp),
//
//                verticalArrangement = Arrangement.Center
//            ) {
//                AsyncImage(
//                    model = product.image,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(300.dp)
//                        .padding(5.dp),
//                    contentScale = ContentScale.Crop,
//                    alignment = Alignment.Center
//                )
//                Spacer(modifier = Modifier.height(10.dp))
//                RatingBarX(rating = product.rating.rate)
//                Text(text = "${product.rating.rate}(${product.rating.count})",modifier=Modifier.padding(5.dp))
//                Text(text = product.title, modifier = Modifier.padding(5.dp), fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
//                Spacer(modifier = Modifier.height(5.dp))
//
//            }
//            Text(text = "$ ${product.price}",color=Color.Red, modifier = Modifier.padding(5.dp))
//        }
//    }
//}
//
//@Composable
//fun RatingBarX(rating: Double) {
//    val colored = rating.toInt()
//    val halfColored = if (rating - colored >= 0.5) 1 else 0
//    val uncolored = 5 - colored - halfColored
//
//    Row {
//        repeat(colored) {
//            Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
//        }
//        repeat(halfColored) {
//            Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
//        }
//        repeat(uncolored) {
//            Icon(Icons.Default.Star, contentDescription = null, tint = Color.Gray)
//        }
//    }
//}
