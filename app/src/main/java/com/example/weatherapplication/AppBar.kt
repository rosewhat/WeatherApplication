package com.example.weatherapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp),
                textAlign = TextAlign.Start
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier
                    .padding(start = 6.dp, top = 8.dp, bottom = 8.dp)
                    .clickable {
                        navController.navigate("Menu")
                    }
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .padding(end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .clickable {
                    }
            )
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Settings",
                modifier = Modifier
                    .padding(end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .clickable {
                    }
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}