package com.example.imageconverter.mvp.presenter

import com.example.imageconverter.mvp.model.ImagePickerImpl
import com.example.imageconverter.mvp.view.ConverterView
import com.example.imageconverter.utils.disposeBy
import com.example.imageconverter.utils.subscribeByDefault
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class ConverterPresenter(private val router: Router,
                         private val imagePicker: ImagePickerImpl
) : MvpPresenter<ConverterView>() {

    private val bag = CompositeDisposable()

    fun requestPermission() {
        imagePicker.requestPermission()
    }

    fun pickImage() {
        imagePicker.pickImageRx()
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.makeToastGallery()
                },
                {
                    viewState.makeToastError(it)
                })
            .disposeBy(bag)
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}