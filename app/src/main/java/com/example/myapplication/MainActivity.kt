package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val mockData = listOf(
            Item(
                id = 1,
                title = "Beautiful Landscape",
                description = "A serene view of mountains during sunset with vibrant colors in the sky.",
                imageUrl = "https://images.unsplash.com/photo-1506744626753-eda8151a734b"
            ),
            Item(
                id = 2,
                title = "City Skyline",
                description = "Modern skyscrapers lit up against the night sky, showcasing the bustling city life.",
                imageUrl = "https://images.unsplash.com/photo-1477959858617-67f85cf4f1df"
            ),
            Item(
                id = 3,
                title = "Forest Path",
                description = "A quiet, misty path winding through a dense, green forest.",
                imageUrl = "https://images.unsplash.com/photo-1441974231531-c6227db76b6e"
            ),
            Item(
                id = 4,
                title = "Ocean Waves",
                description = "Powerful blue ocean waves crashing onto a sandy beach.",
                imageUrl = "https://images.unsplash.com/photo-1505118380757-91f5f5632de0"
            ),
             Item(
                id = 5,
                title = "Desert Dunes",
                description = "Vast, golden sand dunes stretching as far as the eye can see under a clear blue sky.",
                imageUrl = "https://images.unsplash.com/photo-1509316785289-025f5b846b35"
            )
        )

        val adapter = ItemAdapter(mockData) { item ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_ITEM", item)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
