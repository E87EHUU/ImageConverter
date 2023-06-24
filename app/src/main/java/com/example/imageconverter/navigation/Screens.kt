package com.example.imageconverter.navigation

import com.example.imageconverter.ui.ConverterFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun converter() = FragmentScreen { ConverterFragment.newInstance() }
}