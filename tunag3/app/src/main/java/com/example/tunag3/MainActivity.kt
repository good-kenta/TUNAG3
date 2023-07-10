package com.example.tunag3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tunag3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{ addButtonTapped(it) }
    }
    fun addButtonTapped(view: View?){
        val intent = Intent(this, AddUser::class.java)
        startActivity(intent)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)

//        binding.addButton.setOnClickListener{
//            binding.addUserText.text = "ボタンがタップされました。"
        }
    }