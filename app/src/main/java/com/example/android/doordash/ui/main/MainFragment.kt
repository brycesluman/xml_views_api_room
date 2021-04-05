package com.example.android.doordash.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.doordash.R
import com.example.android.doordash.model.Store
import com.example.android.doordash.ui.adapter.StoreAdapter
import com.example.android.doordash.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogsEvent)

        linearLayoutManager = LinearLayoutManager(this.context)
        store_feed.layoutManager = linearLayoutManager

        super.onActivityCreated(savedInstanceState)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState) {
                is DataState.Success<List<Store>> -> {
                    displayProgressBar(false)
                    store_feed.adapter = StoreAdapter(this, dataState.data)
//                    appendBlogTitles(dataState.data)
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

    private fun displayError(message: String?) {
        if(message!= null){
            text.text = message
        } else {
            text.text = "Unknown Error"
        }
    }
    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }

    private fun appendBlogTitles(stores: List<Store>) {
        val sb = StringBuilder()
        for (store in stores) {
            sb.append(store.name).append("\n")
        }
        text.text = sb.toString()
    }
}