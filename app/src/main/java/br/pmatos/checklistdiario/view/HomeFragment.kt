package br.pmatos.checklistdiario.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.pmatos.checklistdiario.R
import br.pmatos.checklistdiario.adapter.CardAdapter
import br.pmatos.checklistdiario.enum.FolderDisplayMode
import br.pmatos.checklistdiario.view_model.HomeViewModel
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recycleView = root.findViewById<RecyclerView>(R.id.recycleView)

        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.justifyContent = JustifyContent.CENTER
        recycleView.layoutManager = layoutManager

        homeViewModel.folderCardLiveData.observe(viewLifecycleOwner, Observer { folderArray ->
            recycleView.adapter =  CardAdapter(folderArray, FolderDisplayMode.DEFAULT)
        })

        return root
    }

}