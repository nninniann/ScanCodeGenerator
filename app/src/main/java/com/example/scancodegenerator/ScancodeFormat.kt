package com.example.scancodegenerator

import com.google.zxing.BarcodeFormat

enum class ScancodeFormat(val barcodeFormat: String, val format: BarcodeFormat) {

    EAN_8("EAN-8", BarcodeFormat.EAN_8),
    EAN_13("EAN-13", BarcodeFormat.EAN_13),
    UPC_A("UPC-A", BarcodeFormat.UPC_A),
    UPC_E("UPC-E", BarcodeFormat.UPC_E),
    CODABAR("CODABAR", BarcodeFormat.CODABAR),
    CODE_39("CODE 39", BarcodeFormat.CODE_39),
    CODE_93("CODE 93", BarcodeFormat.CODE_93),
    CODE_128("CODE 128", BarcodeFormat.CODE_128),
    PDF_417("PDF 417", BarcodeFormat.PDF_417),
    QR_CODE("QR CODE", BarcodeFormat.QR_CODE),
    DATA_MATRIX("Data Matrix", BarcodeFormat.DATA_MATRIX);


    override fun toString(): String {
        return barcodeFormat
    }

    companion object {
        fun getByValue(value: String) = ScancodeFormat.values().find { it.barcodeFormat == value }
    }

}


