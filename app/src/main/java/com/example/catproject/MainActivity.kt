package com.example.catproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.catproject.ui.CatViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CatViewModel>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.iv_cat)

        viewModel.catLiveData.observe(this) {
            Glide
                .with(this)
                .load(it[0].imageUrl)
                .into(image)
        }

        viewModel.getCatImage()
    }
}