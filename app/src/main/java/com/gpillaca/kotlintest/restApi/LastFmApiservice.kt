package com.gpillaca.kotlintest.restApi

import com.gpillaca.kotlintest.restApi.model.ArtistResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by gefer on 28/05/2017.
 */
interface LastFmApiservice {

    @GET(ApiConstants.URL_ARTIST)
    fun getArtists(): Call<ArtistResponse>
}