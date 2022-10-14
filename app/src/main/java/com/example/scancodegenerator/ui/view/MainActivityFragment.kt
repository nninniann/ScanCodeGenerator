package com.example.scancodegenerator.ui.view

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.scancodegenerator.R
import com.example.scancodegenerator.ScancodeFormat
import com.example.scancodegenerator.Utils
import com.example.scancodegenerator.ui.viewmodel.MainViewModel
import com.google.zxing.BarcodeFormat


class MainActivityFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_activity, container, false)
        val formatSpinner = view.findViewById<Spinner>(R.id.spinner)
        formatSpinner.adapter = ArrayAdapter<ScancodeFormat>(
            requireActivity().applicationContext,
            android.R.layout.simple_spinner_dropdown_item, ScancodeFormat.values()
        )

        val btnGenerate = view.findViewById<Button>(R.id.btnGenerate)
        val scanTextInput = view.findViewById<EditText>(R.id.inputText)
        val outputText = view.findViewById<TextView>(R.id.outputText)
        val imageViewQrCode = view.findViewById<ImageView>(R.id.imgCode)

        btnGenerate.setOnClickListener {

            if (scanTextInput.text.isEmpty()) {
                Toast.makeText(
                    requireActivity().applicationContext,
                    "Please enter correct input data", Toast.LENGTH_SHORT
                ).show()
            } else {
                outputText.isVisible = true
                Utils.hideSoftKeyBoard(requireContext(), view)

                val selectedFormat = (formatSpinner.selectedItem as ScancodeFormat).name
                imageViewQrCode.setImageBitmap(
                    viewModel.generateScancode(
                        scanTextInput.text.toString(),
                        BarcodeFormat.valueOf(selectedFormat)
                    )
                )
            }
        }
        return view
    }


}

