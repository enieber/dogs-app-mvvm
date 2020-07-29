package com.enieber.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.enieber.dogs.R
import com.enieber.dogs.model.DogBreed
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.item_dog.view.*

class DogListAdapter(val dogsList: ArrayList<DogBreed>) : RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = inflate.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogsList[position].dogBreed
        holder.view.description.text = dogsList[position].lifeSpan
        holder.view.setOnClickListener {
            val action = ListFragmentDirections.actionDetailsFragment()
            action.dogUuid = dogsList[position].breedId.toString()

            Navigation.findNavController(it).navigate(action)
        }
    }

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}