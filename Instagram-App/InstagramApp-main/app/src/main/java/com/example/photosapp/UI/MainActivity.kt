package com.example.photosapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photosapp.Api.ApiClient
import com.example.photosapp.Api.ApiInterface
import com.example.photosapp.Model.Photos
import com.example.photosapp.PhotosAdapter
import com.example.photosapp.R
import com.example.photosapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var rvPhotos:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayPhotos()
    }
    fun displayPhotos(){
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            val request = retrofit.getPhotos()
            request.enqueue(object: Callback<List<Photos>> {
                override fun onResponse(call: Call<List<Photos>>, response:
                Response<List<Photos>>
                ) {
                    if (response.isSuccessful){
                        var photos = response.body()
                        Toast.makeText(baseContext, "${photos!!.size} posts", Toast.
                        LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                }
            })
    }
}