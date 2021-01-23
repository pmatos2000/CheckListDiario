package com.example.checklistdiario.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.checklistdiario.model.Folder

class HomeViewModel : ViewModel() {


    private val _folderLiveData = MutableLiveData<Array<Folder>>()

    val folderLiveData: MutableLiveData<Array<Folder>>
        get() = _folderLiveData


    init {
        _folderLiveData.value = Array(20) { Folder("Pasta") }
    }

}