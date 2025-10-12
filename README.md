# DailyPulse KMP

DailyPulse is a modern, cross-platform news app for Android and iOS built with **Kotlin Multiplatform (KMP)**.

This repository serves as an educational project based on the "Kotlin Multiplatform Masterclass" by Petros Efthymiou, updated to reflect the latest 2025 KMP standards and tooling.

## 🌟 Features & Architecture

-   **Cross-Platform:** Shared Kotlin code for business logic, networking, and data persistence.
-   **Native UI:** Utilizes Jetpack Compose for Android and SwiftUI for iOS for a true platform-native look and feel.
-   **Offline First:** Caches articles using a local SQLite database, allowing for offline access and a seamless user experience.
-   **Architecture:** Uses a MVVM-like architecture ( UI-ViewModel-UseCase-Data )

## 🛠️ Tech Stack 

This project is built with a modern tech stack.

-   **Shared Kotlin Module (`/composeApp`)**:
    -   **Ktor**: For making asynchronous HTTP requests to the [NewsAPI](https://newsapi.org/).
    -   **SQLDelight**: To generate and communicate to the local SQL DB.
    -   **Koin**: For dependency injection across the shared module.
    -   **Kotlin Coroutines & Flow**: For managing asynchronous operations and reactive data streams.

-   **Android UI (`/androidApp`)**:
    -   **Jetpack Compose**: For building the entire UI declaratively.
    -   **Coil**: For efficient image loading from network URLs.

-   **iOS UI (`/iosApp`)**:
    -   **SwiftUI**: For building the native iOS UI.


