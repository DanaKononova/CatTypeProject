package com.example.catproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.catproject.data.model.CatType
import com.example.catproject.di.ViewModelFactory
import com.example.catproject.ui.CatViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: CatViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as HiltApplication).appComponent.inject(this)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val types = listOf(CatType("pers", "Persian"), CatType("abys", "Abyssinian"),
            CatType("munc", "Munchkin"), CatType("orie", "Oriental"),
            CatType("siam", "Siamese"), CatType("sibe", "Siberian"),)
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

            viewModel.catLiveData.observe(this) {
                Glide
                    .with(this)
                    .load(it[0].imageUrl)
                    .into(image)
            }

            button.setOnClickListener {
                viewModel.getCatImage(catTypesKeys[spinner.selectedItemPosition])
            }
        }
    }
}