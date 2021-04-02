package br.pmatos.checklistdiario.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.pmatos.checklistdiario.R
import br.pmatos.checklistdiario.view_model.CheckListViewModel

class CheckListFragment : Fragment() {

    private lateinit var homeViewModel: CheckListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(CheckListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_check_list, container, false)
        return root
    }
}