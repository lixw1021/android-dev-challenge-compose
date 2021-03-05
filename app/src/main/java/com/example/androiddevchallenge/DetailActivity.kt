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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                MyApp(
                    dog = intent.getParcelableExtra(EXTRA_DOG)!!,
                    onClick = {
                        finish()
                    }
                )
            }
        }
    }

    companion object {
        const val EXTRA_DOG = "EXTRA_DOG"

        fun newInstance(context: Context, dog: Dog): Intent {
            return Intent(context, DetailActivity::class.java)
                .putExtra(EXTRA_DOG, dog)
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(
    dog: Dog,
    onClick: (() -> Unit)? = null
) {
    val typography = MaterialTheme.typography
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = {
                    Text(text = "Dog Details")
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                        contentDescription = null,
                        Modifier
                            .padding(16.dp)
                            .clickable { onClick?.invoke() }
                    )
                }
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Row {
                    Image(
                        painter = painterResource(id = dog.image),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds
                    )
                    Column {
                        Row(modifier = Modifier.padding(8.dp)) {
                            Text(text = "Name: ", style = typography.h6)
                            Text(text = dog.name, style = typography.h6)
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
                Text(text = "Introduce:", style = typography.h6)
                Text(text = dog.introduce, style = typography.body1)
            }
        }
    }
}

@Preview()
@Composable
fun lightViewPreview() {
    MyTheme {
        val dog = DogRepository().getDogs().first()
        MyApp(dog = dog)
    }
}
