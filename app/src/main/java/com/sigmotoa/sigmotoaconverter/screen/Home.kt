package com.sigmotoa.sigmotoaconverter.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Calculate
import androidx.compose.material.icons.twotone.CatchingPokemon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sigmotoa.sigmotoaconverter.R

/**
 *
 * Created by sigmotoa on 11/11/23.
 * @author sigmotoa
 *
 * www.sigmotoa.com
 */

@ExperimentalMaterial3Api
@Composable
fun MScaffold() {

    Scaffold (
        topBar = {},
        bottomBar = {}){
            paddingValues: PaddingValues ->

    }

}

@ExperimentalMaterial3Api
@Composable
fun MTopBar() {
    TopAppBar(title = { Text(text = stringResource(id = R.string.topbar_title)) })
}

@Composable
fun MBottomBar() {
    BottomAppBar {
        NavigationBarItem(selected = false, onClick = {  }, icon = { Icon(
            imageVector = Icons.TwoTone.Calculate,
            contentDescription = stringResource(id = R.string.calculator)
        ) }, label = { Text(text = stringResource(id = R.string.calculator))})
        NavigationBarItem(selected = false, onClick = {  }, icon = { Icon(
            imageVector = Icons.TwoTone.CatchingPokemon,
            contentDescription = stringResource(id = R.string.pokemon)
        ) }, label = { Text(text = stringResource(id = R.string.pokemon))})

    }

}