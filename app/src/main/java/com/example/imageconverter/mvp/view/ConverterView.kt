package com.example.imageconverter.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import java.lang.Error

@StateStrategyType(AddToEndSingleStrategy::class)
interface ConverterView : MvpView {

    fun showDialogForRequestPermission()
    fun showDialogForClosedPermission()
    fun showLoading()
    fun hideLoading()
    fun makeToastSuccess(pack: String)
    fun makeToastError(error: Throwable)
    fun makeToastGallery()
}