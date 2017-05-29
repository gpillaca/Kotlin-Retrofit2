package com.gpillaca.kotlintest.restApi.adapter

import android.provider.SyncStateContract
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.gpillaca.kotlintest.restApi.ApiConstants
import com.gpillaca.kotlintest.restApi.LastFmApiservice
import com.gpillaca.kotlintest.restApi.deserialize.ArtisDeserializer
import com.gpillaca.kotlintest.restApi.model.ArtistResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gefer on 28/05/2017.
 */
class RestApiAdapter {

    fun conexionRestApi(gson: Gson): LastFmApiservice{
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        return retrofit.create(LastFmApiservice::class.java)
    }

    fun GsonDeserializerArtist(): Gson{
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(ArtistResponse::class.java, ArtisDeserializer())

        val gson = gsonBuilder.create()
        return  gson
    }

}