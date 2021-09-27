package com.example.transactionhistory.network


import com.google.gson.annotations.SerializedName

data class Transaction(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("customer")
    val customer: Customer,
    @SerializedName("description")
    val description: String,
    @SerializedName("direction")
    val direction: Int,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("partner")
    val partner: Partner,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("type")
    val type: Int
)