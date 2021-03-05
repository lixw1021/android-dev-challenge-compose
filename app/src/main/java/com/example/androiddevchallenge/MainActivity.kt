/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dogs = DogRepository().getDogs()
        setContent {
            MyTheme {
                MyApp(dogs) {
                    startActivity(DetailActivity.newInstance(this, it))
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(dogs: List<Dog>, onclick: (Dog) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = {
                    Text(text = "Dog Finder")
                }
            )
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                dogs.forEach {
                    item {
                        DogItem(dog = it, onclick = onclick)
                    }
                }
            }
        }
    }
}

@Composable
fun DogItem(
    dog: Dog,
    onclick: ((Dog) -> Unit)
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { onclick.invoke(dog) }
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = dog.image),
                contentDescription = "",
                Modifier.size(100.dp, 100.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(text = "Name: ")
                    Text(text = dog.name)
                }
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(text = "Age: ")
                    Text(text = dog.age.toString())
                }
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(text = "Breed: ")
                    Text(text = dog.category.breed)
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    val dogs = DogRepository().getDogs()
    MyTheme {
        MyApp(dogs, onclick = {})
    }
}

//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    val dogs = DogRepository().getDogs()
    MyTheme(darkTheme = true) {
        MyApp(dogs, onclick = {})
    }
}
