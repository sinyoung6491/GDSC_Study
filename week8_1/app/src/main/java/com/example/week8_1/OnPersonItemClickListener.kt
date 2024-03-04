package com.example.week8_1

import android.view.View

interface OnPersonItemClickListener {

    fun onItemClick(holder: PersonAdapter.ViewHolder?, view: View?,position:Int)
}