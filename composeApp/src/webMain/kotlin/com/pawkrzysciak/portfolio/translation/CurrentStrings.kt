package com.pawkrzysciak.portfolio.translation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pawkrzysciak.portfolio.translation.countries.StringsPl

object CurrentStrings {
    var strings by mutableStateOf<Strings>(StringsPl)
}