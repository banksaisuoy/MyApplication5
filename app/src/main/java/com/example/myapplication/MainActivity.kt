package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FeatureAdapter()
        recyclerView.adapter = adapter

        val features = listOf(
            Feature("Cloud Sync", "Seamlessly sync data across all your devices instantly."),
            Feature("Ad-Free Experience", "Enjoy a pure, distraction-free environment with no ads."),
            Feature("Premium Support", "Get 24/7 priority customer support from our experts."),
            Feature("Advanced Analytics", "Unlock detailed insights and custom reports."),
            Feature("Unlimited Storage", "Never run out of space with infinite cloud storage.")
        )
        adapter.submitList(features)
    }
}
