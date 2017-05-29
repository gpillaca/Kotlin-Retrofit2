package com.gpillaca.kotlintest.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gpillaca.kotlintest.R
import com.gpillaca.kotlintest.adapter.ArtistRecyclerViewAdapter
import com.gpillaca.kotlintest.model.Artist
import com.gpillaca.kotlintest.presenter.ArtistFragmentPresenter



class ArtistFragmentView : Fragment(), IArtistFragmentView {

    var artistList: RecyclerView? = null

    companion object{
       const val NUM_COLUMNS = 2
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater!!.inflate(R.layout.fragment_artist, container, false)
        artistList = view.findViewById(R.id.artist_recycler_view) as RecyclerView
        val presenter = ArtistFragmentPresenter(this, context)
        return view
    }

    override fun generateGridLayout() {
        artistList!!.layoutManager = GridLayoutManager(activity, NUM_COLUMNS)
    }

    override fun createAdapter(artists: ArrayList<Artist>): ArtistRecyclerViewAdapter {
        val artistRecyclerViewAdapter = ArtistRecyclerViewAdapter(context, artists)
        return artistRecyclerViewAdapter
    }

    override fun initAdapter(adapter: ArtistRecyclerViewAdapter) {
        artistList!!.adapter = adapter
    }




}
