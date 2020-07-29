package com.enieber.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enieber.dogs.model.DogBreed

class ListViewModel: ViewModel() {

    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 = DogBreed("1", "Corgi", "15 years", "breedGroup", "bredFor", "temperament", "")
        val dog2 = DogBreed("2", "Pincher", "2 years", "breedGroup", "bredFor", "temperament", "")
        val dog3 = DogBreed("3", "Pitbull", "10 years", "breedGroup", "bredFor", "temperament", "")
        val dog4 = DogBreed("4", "Labrador", "5 years", "breedGroup", "bredFor", "temperament", "")
        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3, dog4)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false
    }
}