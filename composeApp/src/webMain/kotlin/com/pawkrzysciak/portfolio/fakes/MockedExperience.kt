package com.pawkrzysciak.portfolio.fakes

import com.pawkrzysciak.portfolio.section.experience.ExperienceData
import com.pawkrzysciak.portfolio.translation.Strings

fun experiences(strings: Strings) = listOf(
    ExperienceData(
        company = "Silky Coders",
        role = strings.silkyRole,
        period = strings.silkyPeriod,
        location = strings.silkyLocation,
        description = strings.silkyDescription
    ),
    ExperienceData(
        company = "POSbistro",
        role = strings.posbistroRole,
        period = strings.posbistroPeriod,
        location = strings.posbistroLocation,
        description = strings.posbistroDescription
    ),
    ExperienceData(
        company = "Lasoft",
        role = strings.lasoftRole,
        period = strings.lasoftPeriod,
        location = strings.lasoftLocation,
        description = strings.lasoftDescription
    )
)