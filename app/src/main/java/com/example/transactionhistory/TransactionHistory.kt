package com.example.transactionhistory

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.transactionhistory.databinding.ActivityTransactionHistoryBinding
import com.example.transactionhistory.network.DataClass
import com.example.transactionhistory.network.GetService
import com.example.transactionhistory.network.Transaction

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TransactionHistory : AppCompatActivity() {
    private lateinit var customProgressDialog: Dialog
    private lateinit var binding: ActivityTransactionHistoryBinding
    private var arrayOfTransaction: ArrayList<Transaction>? = ArrayList()
    private var paymentStatusAdapter: PaymentStatusAdapter? = null
    private var id: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTransactionHistoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.tbTransactionHistory)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "John Doe"
            actionBar.subtitle = "+91 76722345"
        }
        binding.tbTransactionHistory.setNavigationOnClickListener {
            onBackPressed()
        }
        Log.i("userIgggd", "$id")
        startApiCall()




    }

    fun startApiCall() {

        showProgressDialog()

        makeApicall()


    }


    private fun makeApicall() {

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://dev.onebanc.ai/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service: GetService = retrofit.create<GetService>(GetService::class.java)
        val listcall: Call<DataClass> = service.getdata("1", "2")

        listcall.enqueue(object : Callback<DataClass> {
            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                if (response!!.isSuccessful) {
                    cancelProgressDialog()
                    setupPaymentStatusRecyclerView(response.body()!!)
                    Log.e("response", " ${response.body()}")

                } else {
                    val rc = response.code()
                    Log.e("error", "bad connection $rc")
                }
            }

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                cancelProgressDialog()
                Log.e("error", "bad connection ")
            }

        })
    }


    private fun showProgressDialog() {
        customProgressDialog = Dialog(this@TransactionHistory)
        customProgressDialog.setContentView(R.layout.dialog_custom_progress)
        customProgressDialog.setCancelable(false)
        customProgressDialog.show()
    }

    private fun cancelProgressDialog() {
        customProgressDialog.dismiss()
    }

    private fun setupPaymentStatusRecyclerView(data: DataClass) {
        binding.rvHistory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        paymentStatusAdapter = PaymentStatusAdapter(data!!, this)
        binding.rvHistory.adapter = paymentStatusAdapter
    }
}
