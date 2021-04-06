package com.example.android.doordash.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.android.doordash.R
import com.example.android.doordash.model.StoreDetails
import com.example.android.doordash.util.DataState
import com.example.android.doordash.util.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.*


/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class DetailsFragment : Fragment() {
    companion object {
        val STORE_KEY = "id"
        fun newInstance() = DetailsFragment()

    }

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        subscribeObservers()
        arguments?.getInt(STORE_KEY)?.let{
            viewModel.setStateEvent(DetailsStateEvent.GetStoreEvent, it)
        }

        super.onActivityCreated(savedInstanceState)

    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<StoreDetails> -> {
                    displayProgressBar(false)
                    Log.d("test", "data " + dataState.data)
                    displayUi(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayUi(details: StoreDetails) {
        itemName.text = details.name
        itemDescription.text = details.description
        ImageLoader().loadImage(this, details.cover_img_url, itemImage)
    }

    private fun displayError(message: String?) {
        if (message!= null) {
            text.text = message
        } else {
            text.text = "Unknown Error"
        }
    }
    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }
}