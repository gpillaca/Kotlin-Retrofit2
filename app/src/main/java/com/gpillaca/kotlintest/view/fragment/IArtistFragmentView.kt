package com.gpillaca.kotlintest.view.fragment

import com.gpillaca.kotlintest.adapter.ArtistRecyclerViewAdapter
import com.gpillaca.kotlintest.model.Artist

/**
 * Created by gefer on 28/05/2017.
 */
interface IArtistFragmentView {

    fun generateGridLayout()
    fun createAdapter(artists: ArrayList<Artist>): ArtistRecyclerViewAdapter
    fun initAdapter(adapter: ArtistRecyclerViewAdapter)


}