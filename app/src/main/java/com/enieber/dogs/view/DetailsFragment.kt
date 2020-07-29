package com.enieber.dogs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.enieber.dogs.R
import com.enieber.dogs.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private var dogUuid = "0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        arguments?.let {
            dogUuid =  DetailsFragmentArgs.fromBundle(it).dogUuid
            viewModel.fetch(dogUuid)
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.dogLiveData.observe(this, Observer { dog ->
            dog?.let {
                dogName.text = dog.dogBreed
                dogPropouse.text = dog.bredFor
                dogTemperament.text = dog.temperament
                dogLifespan.text = dog.lifeSpan
            }
        })
    }

}
