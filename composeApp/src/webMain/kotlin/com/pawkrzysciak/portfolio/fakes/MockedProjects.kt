package com.pawkrzysciak.portfolio.fakes

import androidx.compose.ui.graphics.Color
import com.pawkrzysciak.portfolio.section.projects.ProjectItem
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import com.pawkrzysciak.portfolio.translation.Strings
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.bm_0
import portfolio.composeapp.generated.resources.bm_1
import portfolio.composeapp.generated.resources.bm_2
import portfolio.composeapp.generated.resources.bm_app_icon
import portfolio.composeapp.generated.resources.looked_2
import portfolio.composeapp.generated.resources.looked_3
import portfolio.composeapp.generated.resources.looked_app_icon
import portfolio.composeapp.generated.resources.note_app_1
import portfolio.composeapp.generated.resources.note_app_2
import portfolio.composeapp.generated.resources.note_app_3
import portfolio.composeapp.generated.resources.note_app_4
import portfolio.composeapp.generated.resources.note_app_5
import portfolio.composeapp.generated.resources.note_app_6
import portfolio.composeapp.generated.resources.note_app_7
import portfolio.composeapp.generated.resources.note_app_8
import portfolio.composeapp.generated.resources.note_app_icon
import portfolio.composeapp.generated.resources.quiz_app_1
import portfolio.composeapp.generated.resources.quiz_app_2
import portfolio.composeapp.generated.resources.quiz_app_3
import portfolio.composeapp.generated.resources.quiz_app_4
import portfolio.composeapp.generated.resources.quiz_app_5
import portfolio.composeapp.generated.resources.quiz_app_6
import portfolio.composeapp.generated.resources.quiz_app_icon
import portfolio.composeapp.generated.resources.smogus_1
import portfolio.composeapp.generated.resources.smogus_2
import portfolio.composeapp.generated.resources.smogus_3
import portfolio.composeapp.generated.resources.smogus_4
import portfolio.composeapp.generated.resources.smogus_5
import portfolio.composeapp.generated.resources.smogus_app_icon
import portfolio.composeapp.generated.resources.tree_1
import portfolio.composeapp.generated.resources.tree_2
import portfolio.composeapp.generated.resources.tree_3
import portfolio.composeapp.generated.resources.tree_4
import portfolio.composeapp.generated.resources.tree_app_icon


fun sampleProjects(strings: Strings) = listOf(
    ProjectItem(
        id = "1",
        title = "NoteApp",
        description = strings.noteAppDescription,
        previewImagesUrls = listOf(
            Res.drawable.note_app_1,
            Res.drawable.note_app_2,
            Res.drawable.note_app_3,
            Res.drawable.note_app_4,
            Res.drawable.note_app_5,
            Res.drawable.note_app_6,
            Res.drawable.note_app_7,
            Res.drawable.note_app_8,
        ),
        iconUrl = Res.drawable.note_app_icon,
        githubUrl = "https://github.com/Notes-Makers/notes-app-android",
        playStoreUrl = null,
        isArchived = false,
        backgroundColor = Color.LightGray
    ),
    ProjectItem(
        id = "2",
        title = "QuizUp",
        description = strings.quizUpDescription,
        previewImagesUrls = listOf(
            Res.drawable.quiz_app_1,
            Res.drawable.quiz_app_2,
            Res.drawable.quiz_app_3,
            Res.drawable.quiz_app_4,
            Res.drawable.quiz_app_5,
            Res.drawable.quiz_app_6,
        ),
        iconUrl = Res.drawable.quiz_app_icon,
        githubUrl = "https://github.com/Quiz-makers/quiz-up-android",
        playStoreUrl = null,
        isArchived = false,
        backgroundColor = Color(0xFF0277BD),
        cropPadding = true
    ),
    ProjectItem(
        id = "3",
        title = CurrentStrings.strings.drzewostan,
        description = strings.drzewostanDescription,
        previewImagesUrls = listOf(
            Res.drawable.tree_1,
            Res.drawable.tree_2,
            Res.drawable.tree_3,
            Res.drawable.tree_4,
        ),
        iconUrl = Res.drawable.tree_app_icon,
        githubUrl = null,
        playStoreUrl = null,
        youtubeUrl = "https://www.youtube.com/watch?v=VyzAM1om6iE",
        isArchived = true,
        backgroundColor = Color(0xFF048577)
    ),
    ProjectItem(
        id = "4",
        title = CurrentStrings.strings.spojrzyj,
        description = strings.quizUpDescription,
        previewImagesUrls = listOf(
            Res.drawable.looked_2,
            Res.drawable.looked_3,
        ),
        iconUrl = Res.drawable.looked_app_icon,
        githubUrl = null,
        playStoreUrl = null,
        youtubeUrl = "https://www.youtube.com/watch?v=f2in4gG7LoY",
        isArchived = true,
        backgroundColor = Color.LightGray
    ),
    ProjectItem(
        id = "5",
        title = CurrentStrings.strings.smogus,
        description = strings.smogusDescription,
        previewImagesUrls = listOf(
            Res.drawable.smogus_2,
            Res.drawable.smogus_1,
            Res.drawable.smogus_3,
            Res.drawable.smogus_4,
            Res.drawable.smogus_5,
        ),
        iconUrl = Res.drawable.smogus_app_icon,
        githubUrl = null,
        playStoreUrl = null,
        youtubeUrl = "https://www.youtube.com/watch?v=3D22nh299XI",
        isArchived = true,
        backgroundColor = Color.LightGray,
        cropPadding = false
    ),
)

fun verticalProjects(strings: Strings) = listOf(
    ProjectItem(
        id = "1",
        title = "Bounce Master",
        description = strings.bounceMasterDescription,
        previewImagesUrls = listOf(
            Res.drawable.bm_0,
            Res.drawable.bm_1,
            Res.drawable.bm_2,
        ),
        iconUrl = Res.drawable.bm_app_icon,
        githubUrl = null,
        playStoreUrl = "https://play.google.com/store/apps/details?id=com.anioncode.bouncemaster",
        externalUrl = "https://lukieoo.itch.io/bounce-master",
        backgroundColor = Color.Transparent
    ),
)

val technologies = listOf(
    "Kotlin", "Jetpack Compose", "Room", "Retrofit", "Ktor",
    "Coroutines", "Firebase", "MongoDB", "Koin", "GraphQL",
    "Compose Multiplatform", "Serialization", "Moshi", "Git", "Jetpack Libraries"
)

val tools = listOf(
    "Android Studio",
    "Postman",
    "Charles Proxy",
    "Perfetto",
    "Ollama",
    "Figma",
    "Jira",
    "Docker",
    "Jenkins",
    "Bitbucket",
    "Gitlab",
    "Github",
)

val hobbies = listOf(
    "Godot Engine", "Blender", "2D/3D graphics",
    "UI/UX", "Spring Boot"
)