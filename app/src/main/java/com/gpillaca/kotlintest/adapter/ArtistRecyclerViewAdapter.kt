package com.gpillaca.kotlintest.adapter

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gpillaca.kotlintest.R
import com.gpillaca.kotlintest.model.Artist
import kotlinx.android.synthetic.main.artist_item.view.*

/**
 * Created by gefer on 28/05/2017.
 */
class ArtistRecyclerViewAdapter(val context: Context, val artists: ArrayList<Artist>): RecyclerView.Adapter<ArtistRecyclerViewAdapter.ArtistViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        return ArtistViewHolder(parent.inflate(R.layout.artist_item))
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int)  =  with(holder.itemView){
            artist_item_name_text.text = artists[position].name
            artist_item_image.loadUrl(artists[position].urlFoto,R.drawable.microfono)

            artist_item_image.setOnClickListener {
                Snackbar.make(this, artists[position].name, Snackbar.LENGTH_LONG)
                        .show()
            }
    }

    override fun getItemCount() = artists.size

    class ArtistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}