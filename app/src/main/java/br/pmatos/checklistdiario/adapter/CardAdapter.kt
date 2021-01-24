package br.pmatos.checklistdiario.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.pmatos.checklistdiario.R
import br.pmatos.checklistdiario.enum.CardType
import br.pmatos.checklistdiario.model.Card
import br.pmatos.checklistdiario.model.CheckListCard
import br.pmatos.checklistdiario.model.FolderCard

class CardAdapter(private val dataSet: Array<Card>) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class FolderViewHold(view: View) : ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
    }

    class CheckListCardViewHold(view: View) : ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
    }

    private fun onCreateFolderViewHold(viewGroup: ViewGroup) : ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_folder, viewGroup, false)
        return FolderViewHold(view)
    }

    private fun onCheckListViewHold(viewGroup: ViewGroup) : ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_card_check_list, viewGroup, false)
        return CheckListCardViewHold(view)
    }


    override fun getItemViewType(position: Int): Int {
        return when(dataSet[position]){
            is FolderCard -> CardType.FOLDER.ordinal
            is CheckListCard -> CardType.CHECK_LIST.ordinal
            else -> 0
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            CardType.FOLDER.ordinal -> onCreateFolderViewHold(viewGroup)
            CardType.CHECK_LIST.ordinal -> onCheckListViewHold(viewGroup)
            else -> ViewHolder(View(viewGroup.context))
        }
    }


    private fun onBindFolderViewHold(viewHolder: ViewHolder, position: Int) {
        val view = viewHolder as FolderViewHold
        view.title.text = dataSet[position].title
    }

    private fun onBindCheckListViewHold(viewHolder: ViewHolder, position: Int) {
        val view = viewHolder as CheckListCardViewHold
        view.title.text = dataSet[position].title
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        when(viewHolder.itemViewType){
            CardType.FOLDER.ordinal -> onBindFolderViewHold(viewHolder, position)
            CardType.CHECK_LIST.ordinal -> onBindCheckListViewHold(viewHolder, position)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

