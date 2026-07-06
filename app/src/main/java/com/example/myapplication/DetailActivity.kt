package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.CollapsingToolbarLayout

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val item = intent.getParcelableExtra<Item>("EXTRA_ITEM")

        val titleTextView: TextView = findViewById(R.id.detailTitleTextView)
        val descriptionTextView: TextView = findViewById(R.id.detailDescriptionTextView)
        val imageView: ImageView = findViewById(R.id.detailImageView)
        val collapsingToolbar: CollapsingToolbarLayout = findViewById(R.id.collapsingToolbar)

        if (item != null) {
            titleTextView.text = item.title
            descriptionTextView.text = item.description
            collapsingToolbar.title = item.title

            Glide.with(this)
                .load(item.imageUrl)
                .apply(
                    RequestOptions()
                        .transform(CenterCrop())
                        .placeholder(R.drawable.circle_placeholder)
                        .error(R.drawable.circle_placeholder)
                )
                .into(imageView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
