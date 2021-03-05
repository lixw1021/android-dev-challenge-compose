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

class DogRepository {

    fun getDogs(): List<Dog> {
        return listOf<Dog>(
            Dog(
                id = 1,
                name = "xiao ming",
                age = 2,
                category = GogCategory.Terrier,
                address = "UK",
                introduce = "The Australian Terrier was developed in Australia, as their name implies. Bred to hunt rodents and snakes, Australian Terriers were also prized as watchdogs and companions. Today, the breed maintains those same traits: they’re delightful companions, fierce earthdog competitors, and conformation and obedience showdogs.",
                image = R.drawable.terrier
            ),
            Dog(
                id = 2,
                name = "xiao hong",
                age = 2,
                category = GogCategory.Basset_Hound,
                address = "USA",
                introduce = "The Basset Hound dog breed was bred for hunting small game such as rabbits and is still used for this purpose in some parts of the United States. When they’re not on the trail of a bunny, they’re laid-back family friends who love kids.",
                image = R.drawable.basset_hound
            ),
            Dog(
                id = 3,
                name = "xiao jun",
                age = 1,
                category = GogCategory.Basset_Retriever,
                address = "USA",
                introduce = "The Basset Retriever is a mixed breed dog–a cross between the Basset Hound and Golden Retriever dog breeds. Friendly, affectionate, and intelligent, these pups inherited some of the best qualities from both of their parents.",
                image = R.drawable.basset_retriever
            ),
            Dog(
                id = 4,
                name = "xiao peng",
                age = 3,
                category = GogCategory.Beagle,
                address = "Australian",
                introduce = "Small, compact, and hardy, Beagles are active companions for kids and adults alike. Canines of this dog breed are merry and fun loving, but being hounds, they can also be stubborn and require patient, creative training techniques.",
                image = R.drawable.beagle
            ),
            Dog(
                id = 5,
                name = "xiao xi",
                age = 2,
                category = GogCategory.Cavapoo,
                address = "Australian",
                introduce = "The Cavapoo is a mixed breed dog — a cross between the Cavalier King Charles Spaniel and Poodle dog breeds. Outgoing, playful, and curious, these pups inherit some of the best traits from both of their parents.",
                image = R.drawable.cavapoo
            ),
            Dog(
                id = 6,
                name = "xiao de",
                age = 3,
                category = GogCategory.Finnish_Spitz,
                address = "Australian",
                introduce = "Finnish Spitz were originally were bred to hunt a variety of small and large game, and then bark when they found something. Today they’re considered “talkative” companions who will keep you apprised of just about everything going on in your surroundings.",
                image = R.drawable.finnish_spitz
            )
        )
    }
}
