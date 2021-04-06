package com.example.android.doordash.ui.details

import androidx.lifecycle.*
import com.example.android.doordash.model.StoreDetails
import com.example.android.doordash.repository.DetailsRepository
import com.example.android.doordash.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject
constructor(
    private val detailsRepository: DetailsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
{
    private val _dataState: MutableLiveData<DataState<StoreDetails>> = MutableLiveData()

    val  dataState: LiveData<DataState<StoreDetails>>
        get() = _dataState

    fun setStateEvent(detailsStateEvent: DetailsStateEvent, id: Int) {
        viewModelScope.launch {
            when(detailsStateEvent) {
                is DetailsStateEvent.GetStoreEvent -> {
                    detailsRepository.getStoreDetails(id)
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is DetailsStateEvent.None -> {
                    //who cares
                }
            }
        }
    }

}

sealed class DetailsStateEvent{
    object GetStoreEvent: DetailsStateEvent()

    object None: DetailsStateEvent()
}