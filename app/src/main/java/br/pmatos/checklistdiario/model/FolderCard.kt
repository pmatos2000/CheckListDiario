package br.pmatos.checklistdiario.model

import br.pmatos.checklistdiario.enum.IconID

data class FolderCard(override  val title: String, override val icon: IconID = IconID.FOLDER): Card