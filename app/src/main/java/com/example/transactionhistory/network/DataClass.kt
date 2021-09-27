package com.example.transactionhistory.network


import com.google.gson.annotations.SerializedName

data class DataClass(
    @SerializedName("receipeintId")
    val receipeintId: Int,
    @SerializedName("transactions")
    val transactions: List<Transaction>,
    @SerializedName("userId")
    val userId: Int
)