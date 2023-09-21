package com.color.tools.tictactoe.adapter

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.color.tools.tictactoe.R

class AdapterTicTacToe(val reqContext: Context) :
    RecyclerView.Adapter<AdapterTicTacToe.HolderTicTacToe>() {

    val listOfPlayer1 = arrayListOf<Int>()
    val listOfPlayer2 = arrayListOf<Int>()
    val count = arrayListOf<Int>()


    class HolderTicTacToe(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val crdSelectBox: CardView = itemView.findViewById(R.id.crdSelectBox)
        val tvTicTacToe: TextView = itemView.findViewById(R.id.tvTicTacToe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HolderTicTacToe(
        LayoutInflater.from(reqContext).inflate(R.layout.item_select_box, parent, false)
    )


    override fun getItemCount() = 9

    override fun onBindViewHolder(holder: HolderTicTacToe, position: Int) {
        holder.crdSelectBox.setCardBackgroundColor(reqContext.getColor(R.color.white))
        holder.crdSelectBox.setOnClickListener {

            if (!count.contains(position))
                count.add(position)
            if (listOfPlayer1.size == listOfPlayer2.size) {
                if (!listOfPlayer1.contains(position) && !listOfPlayer2.contains(position)) {
                    listOfPlayer1.add(position)
                    holder.crdSelectBox.setCardBackgroundColor(reqContext.getColor(R.color.blue))
                    holder.tvTicTacToe.text = "O"
                }

            } else {
                if (!listOfPlayer1.contains(position) && !listOfPlayer2.contains(position)) {
                    listOfPlayer2.add(position)
                    holder.crdSelectBox.setCardBackgroundColor(reqContext.getColor(R.color.red))
                    holder.tvTicTacToe.text = "X"
                }

            }
            if (count.size == 9) {
                if (checkWinner(listOfPlayer1))
                    Log.d("TAG", "onBindViewHolder:Player1 is Win ")
                else if (checkWinner(listOfPlayer2))
                    Log.d("TAG", "onBindViewHolder:Player2 is Win ")
                else
                    Log.d("TAG", "onBindViewHolder:Match Draw ")
                reset()
            } else {
                if (checkWinner(listOfPlayer1)) {
                    Log.d("TAG", "onBindViewHolder:Player1 is Win ")
                    reset()
                } else if (checkWinner(listOfPlayer2)) {
                    Log.d("TAG", "onBindViewHolder:Player2 is Win ")
                    reset()
                }
            }
        }
    }

    fun reset() {
        Handler(Looper.getMainLooper()).postDelayed({
            listOfPlayer1.clear()
            listOfPlayer2.clear()
            count.clear()
            notifyDataSetChanged()
        }, 500)
    }

    fun checkWinner(list: ArrayList<Int>): Boolean {
        if (list.contains(0) &&
            list.contains(1) &&
            list.contains(2)
            ||
            list.contains(3) &&
            list.contains(4) &&
            list.contains(5)
            ||
            list.contains(6) &&
            list.contains(7) &&
            list.contains(8)
            ||
            list.contains(0) &&
            list.contains(4) &&
            list.contains(8)
            ||
            list.contains(6) &&
            list.contains(4) &&
            list.contains(2)
            ||
            list.contains(0) &&
            list.contains(3) &&
            list.contains(6)
            ||
            list.contains(1) &&
            list.contains(4) &&
            list.contains(7)
            ||
            list.contains(2) &&
            list.contains(5) &&
            list.contains(8)
        )
            return true
        else
            return false
    }

}