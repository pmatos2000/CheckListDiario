package br.pmatos.checklistdiario.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pmatos.checklistdiario.model.Folder

class HomeViewModel : ViewModel() {


    private val _folderLiveData = MutableLiveData<Array<Folder>>()

    val folderLiveData: MutableLiveData<Array<Folder>>
        get() = _folderLiveData


    init {
        _folderLiveData.value = Array(21) { Folder("Pasta") }
    }

}