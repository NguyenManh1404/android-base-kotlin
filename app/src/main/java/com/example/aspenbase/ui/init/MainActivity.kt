package com.example.aspenbase.ui.init

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aspenbase.databinding.ActivityMainBinding
import com.example.aspenbase.ui.main.HomeActivity

class MainActivity : AppCompatActivity(){

private var _binding: ActivityMainBinding? = null
private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnExplore?.setOnClickListener {
            // Toast.makeText(this@MainActivity, "Its a toast!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java).apply {
            })
        }
    }
}