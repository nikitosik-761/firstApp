package com.example.epl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class ListFragment(): BaseMainActivityFragment(R.layout.fragment_list) {
    private lateinit var soccerTileAdapter: SoccerTileAdapter

    private val soccerTileList: ArrayList<SoccerTile>

    get() = mainActivity.soccerTileList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
        }

        soccerTileAdapter = SoccerTileAdapter(soccerTileList, mainActivity)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = soccerTileAdapter
    }

    override fun onResume() {
        super.onResume()
        soccerTileAdapter.notifyDataSetChanged()
    }
    fun onFavoriteClicked(position: Int){
        soccerTileAdapter.notifyItemChanged(position)
    }
}