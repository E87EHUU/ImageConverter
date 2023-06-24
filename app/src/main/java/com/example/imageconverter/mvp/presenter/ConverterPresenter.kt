package com.example.imageconverter.mvp.presenter

import com.example.imageconverter.mvp.view.ConverterView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ConverterPresenter(private val router: Router) : MvpPresenter<ConverterView>() {

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}