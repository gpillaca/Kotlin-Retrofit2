package com.gpillaca.kotlintest


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gpillaca.kotlintest.view.fragment.ArtistFragmentView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            var artistFragment = ArtistFragmentView()

            var fm = supportFragmentManager
            var ft = fm.beginTransaction()
            ft.add(R.id.main_container ,artistFragment)
            ft.commit()
        }

    }
}
