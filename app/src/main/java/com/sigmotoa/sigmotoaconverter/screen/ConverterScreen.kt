package com.sigmotoa.sigmotoaconverter.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sigmotoa.sigmotoaconverter.R
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 *
 * Created by sigmotoa on 11/11/23.
 * @author sigmotoa
 *
 * www.sigmotoa.com
 */
@ExperimentalMaterial3Api
@Composable
fun MConverter(viewModel: ConverterViewModel) {
   // var selected by remember {
     //   mutableStateOf("")
    //}


    //conect with number of viewmodel
    val selected = viewModel.base ?: ""
  //instance a viewmodel for the state for number
    val number = viewModel.number ?: ""
    //var number by remember {
      //  mutableStateOf("")
    //}
    Log.d("base", selected)
    ElevatedCard {
        OutlinedTextField(
            value = number,
            onValueChange = { viewModel.setNumber(  it.replace(".", "").replace(",", "").replace("-", "").replace(" ","")) },
            maxLines = 1,
            label = {
                Text(
                    text = stringResource(
                        R.string.number
                    )
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        //create a radiogroup with 3 options
        MRadioGroup(
            bases = stringArrayResource(R.array.systems),
            selected = selected,
            onItemSelected = { viewModel.setBase(  it )})
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            onClick = { viewModel.getResult() }) {
            Text(text = stringResource(id = R.string.convert))
        }
        Text(text = viewModel.result)
    }
}

@Composable
fun MRadioButton(
    system: String,
    selected: String,
    onItemSelected: (String) -> Unit,
    enable: Boolean = true
) {
    Column {
        RadioButton(
            selected = selected == system,
            onClick = { onItemSelected(system) },
            enabled = enable,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary,
                unselectedColor = MaterialTheme.colorScheme.primaryContainer,
                disabledUnselectedColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
        Text(text = system)

    }
}

@Composable
fun MRadioGroup(bases: Array<String>, selected: String, onItemSelected: (String) -> Unit) {

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        val elements = mutableListOf<String>()
        bases.forEach { elements.add(it) }
        bases.forEach {
            MRadioButton(system = it, selected = selected, onItemSelected = onItemSelected)
        }

    }


}

