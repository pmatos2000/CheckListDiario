package br.pmatos.checklistdiario.model

import br.pmatos.checklistdiario.enum.IconID

interface Card {
    val title: String
    val icon: IconID
}