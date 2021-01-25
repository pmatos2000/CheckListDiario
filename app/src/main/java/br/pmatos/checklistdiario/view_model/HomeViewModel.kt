package br.pmatos.checklistdiario.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pmatos.checklistdiario.model.Card
import br.pmatos.checklistdiario.model.CheckListCard
import br.pmatos.checklistdiario.model.FolderCard

class HomeViewModel : ViewModel() {


    private val _folderLiveData = MutableLiveData<Array<Card>>()
    private val _checkListCardLiveData = MutableLiveData<Array<Card>>()

    val folderCardLiveData: MutableLiveData<Array<Card>>
        get() = _folderLiveData

    val checkListCardLiveData: MutableLiveData<Array<Card>>
        get() = _checkListCardLiveData

    init {
        _folderLiveData.value = Array<Card>(20) { i ->
            when (i) {
                in 0..8 -> FolderCard("Pasta $i")
                else -> CheckListCard("Check ${i - 8}")
            }
        }
    }

}