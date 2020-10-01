package com.elitizamaty.foodapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.elitizamaty.foodapp.R
import com.elitizamaty.foodapp.models.data_models.StateModel

class StateAdapter(var context: Context, var list: List<StateModel?>) : BaseAdapter() {

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.row_state_layout, p2, false)
        var tvHeading = view.findViewById<TextView>(R.id.tvStateName)
        tvHeading.text = list[position]?.StateName
        return view
    }

    override fun getItem(p0: Int): Any {
        return list[p0]!!
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }
}