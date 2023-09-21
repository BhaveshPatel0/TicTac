package com.color.tools.tictactoe.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.color.tools.tictactoe.R
import com.color.tools.tictactoe.adapter.AdapterTicTacToe

class MainActivity : AppCompatActivity() {
    private lateinit var rcvTicTacToe:RecyclerView
    private lateinit var mAdapterTicTacToe: AdapterTicTacToe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        bindClick()
    }

    private fun bindView() {
        rcvTicTacToe=findViewById(R.id.rcvTicTacToe)
        mAdapterTicTacToe= AdapterTicTacToe(this)

        rcvTicTacToe.apply {
            layoutManager=GridLayoutManager(this@MainActivity,3)
            adapter=mAdapterTicTacToe
        }

    }
    private fun bindClick() {

    }
}