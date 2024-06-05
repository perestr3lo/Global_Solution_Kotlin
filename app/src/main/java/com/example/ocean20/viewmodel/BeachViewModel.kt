package com.example.ocean20.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ocean20.model.BeachModel

class BeachViewModel : ViewModel() {

    private var items = mutableListOf<BeachModel>()
    val itemsLiveData = MutableLiveData<List<BeachModel>>()

    fun addItem(name: String, city: String, state: String) {
        val item = BeachModel(id = 0, name = name, city = city, state = state, onRemove = ::removeItem)
        items.add(item)
        itemsLiveData.value = items
    }

    private fun removeItem(item: BeachModel) {
        items.remove(item)
        itemsLiveData.value = items
    }

}