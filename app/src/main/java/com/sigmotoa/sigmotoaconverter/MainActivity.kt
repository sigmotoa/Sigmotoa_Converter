@file:OptIn(ExperimentalMaterial3Api::class)

package com.sigmotoa.sigmotoaconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sigmotoa.sigmotoaconverter.data.ResultRepository
import com.sigmotoa.sigmotoaconverter.screen.ConverterViewModel
import com.sigmotoa.sigmotoaconverter.screen.MConverter
import com.sigmotoa.sigmotoaconverter.ui.theme.SigmotoaConverterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //add the viewmodel instance
            //val viewModel = viewModel<ConverterViewModel>()
            //instance the viewmodel sending the repository
            //val viewModel = viewModel<ConverterViewModel>(ResultRepository(this))


            val converterViewModel : ConverterViewModel = viewModel()
            SigmotoaConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MConverter(converterViewModel)
                }
            }
        }
    }
}
