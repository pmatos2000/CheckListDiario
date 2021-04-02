package br.pmatos.checklistdiario.model

import br.pmatos.checklistdiario.enum.IconID

data class CheckListCard(override val title: String) : Card{
    override val icon = IconID.CHECK
}