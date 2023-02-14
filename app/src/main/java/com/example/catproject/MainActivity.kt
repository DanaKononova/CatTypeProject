package com.example.catproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.catproject.ui.CatViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val catTypes = resources.getStringArray(R.array.cats)
        val catTypesKeys = resources.getStringArray(R.array.catsKeys)
        val image = findViewById<ImageView>(R.id.iv_cat)
        val button = findViewById<Button>(R.id.button)

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, catTypes
            )
            spinner.adapter = adapter

            button.setOnClickListener {
                viewModel.catLiveData.observe(this) {
                    Glide
                        .with(this)
                        .load(it[0].imageUrl)
                        .into(image)
                }

                viewModel.getCatImage(catTypesKeys[spinner.selectedItemPosition])
            }
        }
    }
}