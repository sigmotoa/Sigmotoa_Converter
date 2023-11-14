package com.sigmotoa.sigmotoaconverter.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmotoa.sigmotoaconverter.data.ResultRepository
import kotlinx.coroutines.launch

/**
 *
 * Created by sigmotoa on 11/11/23.
 * @author sigmotoa
 *
 * www.sigmotoa.com
 */
class ConverterViewModel(val repository: ResultRepository) : ViewModel() {

    private var _result by mutableStateOf("")
    val result: String get() = _result
    private var _number by mutableStateOf("")
    val number: String get() = _number

    private var _base = mutableStateOf("")
    val base: String get() = _base.value

    //create the setter of the viewmodel

    fun setNumber(newNumber: String) {
        _number = newNumber
    }

    fun setBase(newBase: String) {
        _base.value = newBase
    }

    fun getResult() {
        val from = "10"
        val to = {
            when (base) {
                "Octal" -> "8"
                "Hexadecimal" -> "16"
                "Binary" -> "2"
                else -> {
                    "10"
                }
            }
        }

        viewModelScope.launch {
            _result = try {
                val result = repository.getResult(from, to(), number)
                result.converted
            } catch (e: Exception) {
                "Error: ${e.message}"
            }
        }
    }
}