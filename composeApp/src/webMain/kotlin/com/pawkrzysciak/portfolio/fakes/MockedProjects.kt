package com.pawkrzysciak.portfolio.fakes

import androidx.compose.ui.graphics.Color
import com.pawkrzysciak.portfolio.section.projects.ProjectItem
import portfolio.composeapp.generated.resources.Res
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
import portfolio.composeapp.generated.resources.note_app_9
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


val sampleProjects = listOf(
    ProjectItem(
        id = "1",
        title = "NoteApp",
        description = "Aplikacja Android do tworzenia inteligentnych notatek. Umożliwia tworzenie i organizowanie notatek tekstowych oraz graficznych, obsługę indywidualnych kont użytkowników, a także pracę w trybie offline. Zastosowane narzędzia sztucznej inteligencji wspierają użytkownika, m.in. poprzez automatyczną poprawę gramatyki. Projekt stworzony z wykorzystaniem natywnych technologii Android.",
        previewImagesUrls = listOf(
            Res.drawable.note_app_1,
            Res.drawable.note_app_2,
            Res.drawable.note_app_3,
            Res.drawable.note_app_4,
            Res.drawable.note_app_5,
            Res.drawable.note_app_6,
            Res.drawable.note_app_7,
            Res.drawable.note_app_8,
            Res.drawable.note_app_9,
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
        description = "Aplikacja do tworzenia i rozwiązywania quizów. Oferuje wiele trybów rozgrywki: prywatne quizy do samodzielnej nauki, rywalizację ze znajomymi oraz dostęp do quizów publicznych tworzonych przez społeczność. Dodatkowo wykorzystuje narzędzia sztucznej inteligencji do generowania nowych zestawów pytań, co zapewnia nieograniczone możliwości rozwoju wiedzy i zabawy.",
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
        backgroundColor = Color(0xFF0277BD)
    ),
    ProjectItem(
        id = "3",
        title = "Drzewostan - szacunki brakarskie",
        description = "Aplikacja do notowania liczby drzew z podziałem na klasy oraz średnice. Ułatwia pracę przy wykonywaniu szacunków brakarskich, umożliwia zapisywanie wyników oraz ich przesyłanie na inne urządzenia za pomocą wygenerowanego pliku PDF. \nNiestety obecnie została wycofana ze sklepu google play",
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
        title = "Spojrzyj - Soczewki kontaktowe",
        description = "Aplikacja ułatwiająca zarządzanie terminami wymiany soczewek kontaktowych. Użytkownik wybiera typ soczewki oraz datę pierwszego założenia, a system automatycznie przypomina o konieczności ich wymiany we właściwym czasie. W aktualnej wersji dostępny jest również praktyczny widget, umożliwiający szybki podgląd informacji prosto z ekranu głównego. \nNiestety obecnie została wycofana ze sklepu google play",
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
        title = "Smoguś - Jakość powietrza ",
        description = "Aplikacja stworzona z myślą o zwiększeniu świadomości użytkowników na temat jakości powietrza, którym oddychają na co dzień. Dane pomiarowe pobierane są z oficjalnych stacji monitorujących GIOŚ, co zapewnia wysoką wiarygodność informacji. Użytkownik może przeglądać wartości zanieczyszczeń na interaktywnej mapie Polski oraz sprawdzać szczegółowe wyniki dla wybranych regionów. \nNiestety obecnie została wycofana ze sklepu google play",
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
        backgroundColor = Color.LightGray
    ),
)