# DailyPulse KMP

DailyPulse is a modern, cross-platform news application for Android and iOS built with **Kotlin Multiplatform (KMP)**. This project demonstrates a state-of-the-art mobile architecture where business logic and infrastructure layers are shared between platforms, while the UI is built natively on each.

This repository serves as an educational project based on the "Kotlin Multiplatform Masterclass" by Petros Efthymiou, updated to reflect the latest 2025 KMP standards and tooling.

## 🌟 Features

-   **Cross-Platform:** Shared Kotlin code for business logic, networking, and data persistence.
-   **Native UI:** Utilizes Jetpack Compose for Android and SwiftUI for iOS for a true platform-native look and feel.
-   **Offline First:** Caches articles using a local SQLite database, allowing for offline access and a seamless user experience.
-   **Layered Architecture:** Organizes code into distinct layers (UI, Presentation, Application, Data) needs some dependency inversions to make it truly CLEAN
-   **Platform-Specific Info:** A dedicated screen displays device-specific information (OS, model, etc.) using `expect`/`actual` declarations.

## 🛠️ Tech Stack & Architecture

This project is built with a modern tech stack and follows the MVVM (Model-View-ViewModel) architectural pattern.

-   **Shared Kotlin Module (`composeApp`)**:
    -   **Ktor**: For making asynchronous HTTP requests to the [NewsAPI](https://newsapi.org/).
    -   **SQLDelight**: To generate type-safe Kotlin APIs from SQL for the local article cache.
    -   **Koin**: For simple and effective dependency injection across the shared module.
    -   **Kotlin Coroutines & Flow**: For managing asynchronous operations and reactive data streams.

-   **Android UI (`/androidApp`)**:
    -   **Jetpack Compose**: For building the entire UI declaratively.
    -   **Coil**: For efficient image loading from network URLs.

-   **iOS UI (`/iosApp`)**:
    -   **SwiftUI**: For building the native iOS UI, observing state from the shared KMP ViewModel.

## 🚀 Getting Started

To build and run this project, you will need:
1.  Android Studio (latest version recommended)
2.  Xcode (for the iOS app)
3.  A `NEWS_API_KEY` from [newsapi.org](https://newsapi.org/). You will need to add it to your local environment.

