package com.gpillaca.kotlintest.presenter

import android.content.Context
import com.gpillaca.kotlintest.model.Artist
import com.gpillaca.kotlintest.restApi.adapter.RestApiAdapter
import com.gpillaca.kotlintest.restApi.model.ArtistResponse
import com.gpillaca.kotlintest.view.fragment.IArtistFragmentView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * Created by gefer on 28/05/2017.
 */
class ArtistFragmentPresenter(val iArtistFragmentView: IArtistFragmentView, val context: Context): IArtistFragmentPresenter {
    private var artists = ArrayList<Artist>()

    init {
        getArtist()
    }

    override fun getArtist() {
        val restApiAdapter = RestApiAdapter()
        val gsonArtist = restApiAdapter.GsonDeserializerArtist()

        val lastFmApiService = restApiAdapter.conexionRestApi(gsonArtist)

        val artistResponseCall = lastFmApiService.getArtists()

        artistResponseCall.enqueue(object : Callback<ArtistResponse>{
            override fun onResponse(call: Call<ArtistResponse>?, response: Response<ArtistResponse>?) {
                if (response!!.isSuccessful){
                    val artistResponse = response.body()
                    artists = artistResponse!!.artists
                    listArtist()
                }
            }

            override fun onFailure(call: Call<ArtistResponse>?, t: Throwable?) {
                t!!.printStackTrace()
            }

        })
    }

    override fun listArtist() {
        iArtistFragmentView.initAdapter(iArtistFragmentView.createAdapter(artists))
        iArtistFragmentView.generateGridLayout()

    }
}