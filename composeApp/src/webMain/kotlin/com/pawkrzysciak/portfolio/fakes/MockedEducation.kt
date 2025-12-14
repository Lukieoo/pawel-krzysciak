package com.pawkrzysciak.portfolio.fakes

import com.pawkrzysciak.portfolio.section.education.EducationData
import com.pawkrzysciak.portfolio.translation.Strings

fun educationList(strings: Strings) = listOf(
    EducationData(
        school = strings.pkSchool,
        degree = strings.pkDegree,
        period = "2020 — 2024",
        description = strings.pkDescription
    ),
    EducationData(
        school = strings.zstSchool,
        degree = strings.zstDegree,
        period = "2015 — 2019",
        description = strings.zstDescription
    )
)