package com.example.scancodegenerator.di.components

import com.example.scancodegenerator.di.modules.MainViewModule
import com.example.scancodegenerator.ui.viewmodel.MainViewModel
import dagger.Component

@Component(modules = [MainViewModule::class])
interface MainViewComponent{

    fun inject(viewModel: MainViewModel)
}