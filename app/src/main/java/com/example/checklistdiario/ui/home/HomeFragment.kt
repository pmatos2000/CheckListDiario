package com.example.checklistdiario.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.checklistdiario.R
import com.example.checklistdiario.adapter.FolderAdapter
import com.example.checklistdiario.view_model.HomeViewModel
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
        layoutManager.justifyContent = JustifyContent.SPACE_BETWEEN
        recycleView.layoutManager = layoutManager

        homeViewModel.folderLiveData.observe(viewLifecycleOwner, Observer { folderArray ->
            recycleView.adapter =  FolderAdapter(folderArray)
        })

        return root
    }

}