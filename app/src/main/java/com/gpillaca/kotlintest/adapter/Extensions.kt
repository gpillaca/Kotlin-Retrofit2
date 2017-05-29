package com.gpillaca.kotlintest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

/**
 * Created by gefer on 28/05/2017.
 */

fun Context.toast(text: CharSequence, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}

fun ViewGroup.inflate(layoutRes: Int) = LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadUrl(url: String, placeholder: Int) {
    Picasso.with(context).load(url).placeholder(placeholder).into(this)
}
