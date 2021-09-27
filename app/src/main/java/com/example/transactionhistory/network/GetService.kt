package com.example.transactionhistory.network


import com.example.transactionhistory.TransactionHistory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetService {
    @GET("assignment.asmx/GetTransactionHistory")
    fun getdata(
        @Query("userId") userId:String,
        @Query("recipientId") recipientId:String
    ): Call<DataClass>
}