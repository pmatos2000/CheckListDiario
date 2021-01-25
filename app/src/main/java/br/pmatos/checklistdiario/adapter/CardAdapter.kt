package br.pmatos.checklistdiario.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.pmatos.checklistdiario.R
import br.pmatos.checklistdiario.enum.CardType
import br.pmatos.checklistdiario.enum.FolderDisplayMode
import br.pmatos.checklistdiario.model.Card
import br.pmatos.checklistdiario.model.CheckListCard
import br.pmatos.checklistdiario.model.FolderCard
import br.pmatos.checklistdiario.useful.Useful

class CardAdapter(private val dataSet: Array<Card>, private val mode: FolderDisplayMode) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val iconView: ImageView = view.findViewById(R.id.icon)
    }

    class FolderViewHold(view: View) : ViewHolder(view)

    class CheckListCardViewHold(view: View) : ViewHolder(view)

    private fun onCreateFolderViewHold(viewGroup: ViewGroup) : ViewHolder {
        val idLayoutInflater = when(mode){
            FolderDisplayMode.DEFAULT -> R.layout.view_card
            FolderDisplayMode.RECTANGULE -> R.layout.view_card_rectangle
        }
        val view = LayoutInflater.from(viewGroup.context).inflate(idLayoutInflater, viewGroup, false)
        return FolderViewHold(view)
    }


    private fun onCheckListViewHold(viewGroup: ViewGroup) : ViewHolder {
        val idLayoutInflater = when(mode){
            FolderDisplayMode.DEFAULT -> R.layout.view_card
            FolderDisplayMode.RECTANGULE -> R.layout.view_card_check_list
        }
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(idLayoutInflater, viewGroup, false)
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

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataSet[position].title
        viewHolder.iconView.setImageResource(Useful.getIdDrawable(dataSet[position].icon))
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

