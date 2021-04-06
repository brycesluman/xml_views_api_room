package com.example.android.doordash.ui.main

import androidx.lifecycle.*
import com.example.android.doordash.model.Store
import com.example.android.doordash.repository.MainRepository
import com.example.android.doordash.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val mainRepository: MainRepository,
        private val savedStateHandle: SavedStateHandle
    ) : ViewModel()
{
    private val _dataState: MutableLiveData<DataState<List<Store>>> = MutableLiveData()

    val  dataState: LiveData<DataState<List<Store>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {
                is MainStateEvent.GetStoresEvent -> {
                    mainRepository.getStore()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    //who cares
                }
            }
        }
    }
}

sealed class MainStateEvent{
    object GetStoresEvent: MainStateEvent()

    object None: MainStateEvent()
}