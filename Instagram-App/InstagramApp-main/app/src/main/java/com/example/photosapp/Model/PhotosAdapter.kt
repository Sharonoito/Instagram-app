package com.example.photosapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.photosapp.Model.Photos
import com.squareup.picasso.Picasso

class PhotosAdapter(var context: Context, var photosList:List<Photos>):RecyclerView.Adapter<PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        var itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.photos_list_item,parent,false)
        return PhotosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        var photos=photosList.get(position)
        holder.tvImageId.text=photos.imageId
        holder.tvCaption.text=photos.imageCaption
        Picasso.get().load(photos.imageUrl).resize(80,80).centerCrop().into(holder.ivImageUrl)
        }

    override fun getItemCount(): Int {
        return photosList.size
    }
}

class PhotosViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var ivImageUrl=itemView.findViewById<ImageView>(R.id.ivImageUrl)
    var tvImageId=itemView.findViewById<TextView>(R.id.tvImageId)
    var tvCaption=itemView.findViewById<TextView>(R.id.tvImageCaption)
    var rvPhotos=itemView.findViewById<RecyclerView>(R.id.rvPhotos)
}