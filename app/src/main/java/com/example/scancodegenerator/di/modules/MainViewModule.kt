package com.example.scancodegenerator.di.modules

import com.journeyapps.barcodescanner.BarcodeEncoder
import dagger.Module
import dagger.Provides

@Module
class MainViewModule {

    @Provides
    fun provideBarcodeEncoder() : BarcodeEncoder = BarcodeEncoder()

}