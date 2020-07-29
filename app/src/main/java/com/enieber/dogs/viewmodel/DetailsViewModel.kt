package com.enieber.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enieber.dogs.model.DogBreed

class DetailsViewModel: ViewModel() {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(id: String) {
        val dog = DogBreed(id, "Corgi", "15 years", "breedGroup", "bredFor", "temperament", "")
        dogLiveData.value = dog
    }
}