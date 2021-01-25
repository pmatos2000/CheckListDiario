package br.pmatos.checklistdiario.useful

import br.pmatos.checklistdiario.R
import br.pmatos.checklistdiario.enum.IconID

object Useful {
    fun getIdDrawable(id: IconID): Int{
        return when(id){
            IconID.FOLDER -> R.drawable.ic_baseline_folder_72
            IconID.CHECK -> R.drawable.ic_baseline_format_list_bulleted_72
        }
    }
}