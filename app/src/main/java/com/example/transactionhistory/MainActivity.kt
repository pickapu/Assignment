package com.example.transactionhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transactionhistory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btTransactionHistory.setOnClickListener {
            val intent= Intent(this,TransactionHistory::class.java)
            startActivity(intent)
        }
    }
}