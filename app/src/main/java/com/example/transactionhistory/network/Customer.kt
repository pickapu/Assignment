package com.example.transactionhistory.network


import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("vPay")
    val vPay: String,
    @SerializedName("vPayId")
    val vPayId: Int
)