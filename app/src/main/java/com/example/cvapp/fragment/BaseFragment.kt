package com.example.cvapp.fragment

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    lateinit var rootView: View

    var ctx: Context
    get() = rootView.context
    private set(value) {
        //do nothing
    }

    fun getStringWith(id: Int) = ctx.resources.getString(id)
    fun getStringArrayWith(id: Int) = ctx.resources.getStringArray(id).toList()


    open fun onClickFAB() {

    }
}