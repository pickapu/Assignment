package com.example.transactionhistory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.transactionhistory.databinding.ItemHistoryRowBinding
import com.example.transactionhistory.network.DataClass


class PaymentStatusAdapter(private val item: DataClass, private val context: Context):
RecyclerView.Adapter<PaymentStatusAdapter.ViewHolder>(){
    companion object{
        var date:String? = null
        var day:String?=null
        var month:String?=null
        var year:String?=null
    }
    class ViewHolder(binding:ItemHistoryRowBinding):RecyclerView.ViewHolder(binding.root){
        val date=binding.tvTopDate
        val lldat=binding.lldate
        val dateTime=binding.tvDateTime
        val tvtransactionId=binding.tvTransactionIdNumber
        val amount=binding.tvAmount
        val status=binding.tvStatus
        val statusImg=binding.ivCheck
        val details=binding.detail
        val lltransactionId=binding.transactionId
        val cancelButton=binding.btCancel
        val payButton=binding.btPay
        val declineButton=binding.btDecline
        val ldateTime=binding.ltvDateTime
        val ltvtransactionId=binding.ltvTransactionIdNumber
        val lamount=binding.ltvAmount
        val lstatus=binding.ltvStatus
        val lstatusImg=binding.livCheck
        val ldetails=binding.ldetail
        val llltransactionId=binding.ltransactionId
        val lcancelButton=binding.lbtCancel
        val lpayButton=binding.lbtPay
        val ldeclineButton=binding.lbtDecline
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemHistoryRowBinding.inflate(LayoutInflater.from(context),parent,false)
    return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val model = item.transactions[position]

        if(date==null){

            date= model.startDate.subSequence(0,10).toString()
            holder.date.text= dateSetter(model.startDate.subSequence(0,10).toString())
            if(model.direction==1){
                holder.amount.text=model.amount.toString()
                when(model.status){
                    1->{
                        holder.status.text="you requested"
                        holder.lltransactionId.visibility=View.GONE
                        holder.cancelButton.visibility=View.VISIBLE
                        holder.statusImg.setImageResource(R.drawable.ic_baseline_link_24)
                        holder.dateTime.text=model.startDate?.subSequence(11,16)
                        holder.cancelButton.setOnClickListener {
                            Toast.makeText(context,"payment canceled",Toast.LENGTH_LONG).show()
                        }

                    }
                    2->{
                        holder.status.text="you paid"
                        holder.lltransactionId.visibility=View.VISIBLE
                        holder.tvtransactionId.text=model.id.toString()
                        holder.dateTime.text=model.startDate?.subSequence(11,16)

                    }
                }
            }else{
                holder.details.visibility=View.GONE
                holder.ldetails.visibility=View.VISIBLE
                holder.lamount.text=model.amount.toString()

                when(model.status){
                    1->{
                        holder.lstatus.text="request received"
                        holder.llltransactionId.visibility=View.GONE

                        holder.lpayButton.visibility=View.GONE
                        holder.ldeclineButton.visibility=View.GONE
                         holder.lstatusImg.setImageResource(R.drawable.ic_baseline_link_24)
                        holder.ldateTime.text=model.startDate?.subSequence(11,16)
                        holder.lpayButton.setOnClickListener {
                            Toast.makeText(context,"payment paid",Toast.LENGTH_LONG).show()
                        }
                        holder.ldeclineButton.setOnClickListener {
                            Toast.makeText(context,"payment declined",Toast.LENGTH_LONG).show()
                        }

                    }
                    2->{
                        holder.lstatus.text="you Received"
                        holder.llltransactionId.visibility=View.VISIBLE
                        holder.ltvtransactionId.text=model.id.toString()
                        holder.ldateTime.text=model.startDate?.subSequence(11,16)

                    }
                }

            }
        }else if(date==model.startDate.subSequence(0,10)){

            holder.lldat.visibility=View.GONE
            if(model.direction==1){
                holder.amount.text=model.amount.toString()
                when(model.status){
                    1->{
                        holder.status.text="you requested"
                        holder.lltransactionId.visibility=View.GONE
                        holder.cancelButton.visibility=View.VISIBLE
                        holder.statusImg.setImageResource(R.drawable.ic_baseline_link_24)
                        holder.dateTime.text=model.startDate?.subSequence(11,16)
                        holder.cancelButton.setOnClickListener {
                            Toast.makeText(context,"payment canceled",Toast.LENGTH_LONG).show()
                        }

                    }
                    2->{
                        holder.status.text="you paid"
                        holder.lltransactionId.visibility=View.VISIBLE
                        holder.tvtransactionId.text=model.id.toString()
                        holder.dateTime.text=model.startDate?.subSequence(11,16)

                    }
                }
            }else{
                holder.details.visibility=View.GONE
                holder.ldetails.visibility=View.VISIBLE
                holder.lamount.text=model.amount.toString()
                holder.date.text= dateSetter(model.startDate.subSequence(0,10).toString())

                when(model.status){
                    1->{
                        holder.lstatus.text="request received"
                        holder.llltransactionId.visibility=View.GONE

                        holder.lpayButton.visibility=View.VISIBLE
                        holder.ldeclineButton.visibility=View.VISIBLE
                        holder.lstatusImg.setImageResource(R.drawable.ic_baseline_link_24)
                        holder.ldateTime.text=model.startDate?.subSequence(11,16)
                        holder.lpayButton.setOnClickListener {
                            Toast.makeText(context,"payment paid",Toast.LENGTH_LONG).show()
                        }
                        holder.ldeclineButton.setOnClickListener {
                            Toast.makeText(context,"payment declined",Toast.LENGTH_LONG).show()
                        }

                    }
                    2->{
                        holder.lstatus.text="you Received"
                        holder.llltransactionId.visibility=View.VISIBLE
                        holder.ltvtransactionId.text=model.id.toString()
                        holder.ldateTime.text=model.startDate?.subSequence(11,16)

                    }
                }

            }
        }else{
            date= model.startDate.subSequence(0,10).toString()
            holder.lldat.visibility=View.VISIBLE
            holder.date.text= dateSetter(model.startDate.subSequence(0,10).toString())
            if(model.direction==1){

                holder.amount.text=model.amount.toString()
                when(model.status){
                    1->{
                        holder.status.text="you requested"
                        holder.lltransactionId.visibility=View.GONE
                        holder.cancelButton.visibility=View.VISIBLE
                        holder.statusImg.setImageResource(R.drawable.ic_baseline_link_24)
                        holder.dateTime.text=model.startDate?.subSequence(12,16)
                        holder.cancelButton.setOnClickListener {
                            Toast.makeText(context,"payment canceled",Toast.LENGTH_LONG).show()
                        }

                    }
                    2->{
                        holder.status.text="you paid"
                        holder.lltransactionId.visibility=View.VISIBLE
                        holder.tvtransactionId.text=model.id.toString()
                        holder.dateTime.text=model.startDate?.subSequence(12,16)

                    }
                }
            }else{

                holder.details.visibility=View.GONE
                holder.ldetails.visibility=View.VISIBLE
                holder.lamount.text=model.amount.toString()

                when(model.status){
                    1->{
                        holder.lstatus.text="request received"
                        holder.llltransactionId.visibility=View.GONE

                        holder.lpayButton.visibility=View.VISIBLE
                        holder.ldeclineButton.visibility=View.VISIBLE
                        holder.lstatusImg.setImageResource(R.drawable.ic_baseline_link_24)
                        holder.ldateTime.text=model.startDate?.subSequence(11,16)
                        holder.lpayButton.setOnClickListener {
                            Toast.makeText(context,"payment paid",Toast.LENGTH_LONG).show()
                        }
                        holder.ldeclineButton.setOnClickListener {
                            Toast.makeText(context,"payment declined",Toast.LENGTH_LONG).show()
                        }

                    }
                    2->{
                        holder.lstatus.text="you Received"
                        holder.llltransactionId.visibility=View.VISIBLE
                        holder.ltvtransactionId.text=model.id.toString()
                        holder.ldateTime.text=model.startDate?.subSequence(11,16)

                    }
                }

            }
        }


    }

    override fun getItemCount(): Int {
        return item?.transactions?.size ?: 0
    }
private fun dateSetter(date:String):String{
     day= date.subSequence(8,10).toString()
    val mon=date.subSequence(5,7).toString()
    when(mon){
        "01"->{
             month="Jan"
        }
        "02"->{
             month="Feb"
        }
        "03"->{
             month="Mar"
        }
        "04"->{
             month="Apr"
        }
        "05"->{
             month="May"
        }
        "06"->{
            month="Jun"
        }
        "07"->{
             month="Jul"
        }
        "08"->{
             month="Aug"
        }
        "09"->{
             month="Sep"
        }
        "10"->{
             month="Oct"
        }
        "11"->{
             month="Nov"
        }
        "12"->{
            month="Dec"
        }


    }
    year= date.subSequence(0,4).toString()
    return "$day $month $year"
}


}