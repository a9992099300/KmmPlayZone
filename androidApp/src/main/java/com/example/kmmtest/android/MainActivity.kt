package com.example.kmmtest.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import navigation.setupThemeNavigation


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupThemeNavigation()
    }
}
