package com.gpillaca.kotlintest.restApi

/**
 * Created by gefer on 28/05/2017.
 */
object ApiConstants {

    const val API_KEY = "d47aeb1459021b410a120a9b6d43cf8f"
    const val BASE_URL = "http://ws.audioscrobbler.com"
    const val VERSION = "/2.0"
    const val PARAM_METHOD = "method"
    const val PARAM_FORMAT = "format"
    const val PARAM_API_KEY = "api_key"
    const val PARAM_ARTIST = "artist"


    const val VALUE_ARTIST_METHOD = "artist.getSimilar"
    const val VALUE_JSON = "json"
    const val VALUE_ARTIST = "maluma"


    const val URL_ARTIST =  "$VERSION/?$PARAM_API_KEY=$API_KEY&$PARAM_METHOD=$VALUE_ARTIST_METHOD &$PARAM_ARTIST=$VALUE_ARTIST&$PARAM_FORMAT=$VALUE_JSON"
}