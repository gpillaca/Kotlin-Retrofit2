package com.gpillaca.kotlintest.restApi.deserialize

import android.util.Log
import com.google.gson.*
import com.gpillaca.kotlintest.model.Artist
import com.gpillaca.kotlintest.restApi.JsonKeys
import com.gpillaca.kotlintest.restApi.model.ArtistResponse
import java.lang.reflect.Type

/**
 * Created by gefer on 28/05/2017.
 */
class ArtisDeserializer: JsonDeserializer<ArtistResponse> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): ArtistResponse {
        val gson = Gson()

        val artistResponse = gson.fromJson<ArtistResponse>(json, ArtistResponse::class.java)

        val artistResponseData = json!!.asJsonObject.getAsJsonObject(JsonKeys.RESPONSE_OBJECT_ARTIST)
        val artistResponseDataArray = artistResponseData.getAsJsonArray(JsonKeys.RESPONSE_ARRAY_ARTIST)

        artistResponse.artists = deserializeArtistJson(artistResponseDataArray)

        return artistResponse
    }

    fun deserializeArtistJson(artistResponseDataArray: JsonArray): ArrayList<Artist>{
        var artists = ArrayList<Artist>()

        for (i in 0..artistResponseDataArray.size() - 1) {
            val artistData = artistResponseDataArray.get(i).asJsonObject


            val name = artistData.get(JsonKeys.ARTIST_NAME).asString

            val imageArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGE)
            val images = artistImagesArray(imageArray)

            val artist = Artist(name, images[1].toString())

            artists.add(artist)
        }

        return artists

    }


    fun artistImagesArray(imagesArray: JsonArray): Array<String?>{
        var images = arrayOfNulls<String>(2)

        for ((index, item) in imagesArray.withIndex()){
            var imageData = imagesArray.get(index).asJsonObject

            var url = imageData.get(JsonKeys.ARTIST_URL).asString
            var size = imageData.get(JsonKeys.ARTIST_URL_SIZE).asString
            url.replace("\\/", "/")

            if (url.isEmpty()){
                url = null
            }

            if (size.matches(JsonKeys.IMAGE_MEDIUM.toRegex())) {
                images[0] = url
            } else if (size.matches(JsonKeys.IMAGE_LARGE.toRegex())) {
                images[1] = url
            }
        }

        return images
    }
}