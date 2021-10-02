package com.example.photosapp.Api

import com.example.photosapp.Model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    fun getPhotos(): Call<List<Photos>>
}