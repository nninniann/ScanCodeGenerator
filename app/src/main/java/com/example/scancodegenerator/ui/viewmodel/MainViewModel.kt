package com.example.scancodegenerator.ui.viewmodel

import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.scancodegenerator.R
import com.example.scancodegenerator.di.components.DaggerMainViewComponent
import com.example.scancodegenerator.di.modules.MainViewModule
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import javax.inject.Inject

class MainViewModel : ViewModel() {



    @Inject
    lateinit var barcodeEncoder : BarcodeEncoder

    init {
        DaggerMainViewComponent.builder()
            .mainViewModule(MainViewModule())
            .build().inject(this)
    }

    fun generateScancode(scancodeInputText: String, format: BarcodeFormat) : Bitmap? =
        try {
             barcodeEncoder.encodeBitmap(scancodeInputText, format, 400, getScancodeHeight(format))
        } catch (e: Exception) {
            Log.e(javaClass.name, e.localizedMessage!!)
            null
        }

    private fun getScancodeHeight(format: BarcodeFormat) : Int {
        if (format == BarcodeFormat.QR_CODE || format == BarcodeFormat.DATA_MATRIX) {
            return 400
        }
        return 200
    }


}


