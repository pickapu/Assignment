package com.example.transactionhistory.network


import com.google.gson.annotations.SerializedName

data class Partner(
    @SerializedName("vPay")
    val vPay: String,
    @SerializedName("vPayId")
    val vPayId: Int
)