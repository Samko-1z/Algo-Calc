# Application Summary

Algo-Calc is a calculator app developed using Kotlin and Jetpack Compose. It allows users to perform mathematical calculations and see the results instantly as they type. The app also includes both light and dark themes, making it easy to use in different lighting conditions.

## Features

- **Basic Calculations:** Supports addition, subtraction, multiplication, and division.
- **Order of Operations:** Supports parentheses `( )` to handle more complex expressions.
- **Live Results:** Displays the calculation result in real time as the user enters an expression.
- **Clear Options:**
  - **C:** Clears the current entry.
  - **AC:** Clears the entire expression and result.
- **Light and Dark Mode:** Users can switch between light and dark themes using a button.
- **User Interface:** Built with Jetpack Compose, providing a simple and responsive design.

## How It Works

Algo-Calc uses the Mozilla Rhino JavaScript engine to evaluate mathematical expressions. When a user enters an expression, the app sends it to the script engine as a string, which processes the calculation and returns the result. This makes it possible to handle different mathematical expressions without having to build a calculation parser from scratch.

The app follows the MVVM (Model-View-ViewModel) architecture, which separates the user interface from the app's logic.

- **View (Calculator.kt):** Built with Jetpack Compose. It displays the calculator and updates whenever the data in the ViewModel changes.
- **ViewModel (CalculatorViewModel.kt):** Handles the app's main logic and keeps track of the current expression and result. It also performs calculations using the Rhino engine.
- **LiveData:** Connects the ViewModel to the user interface, allowing the displayed information to update whenever the app's data changes.

## How to Run the App

To run Algo-Calc, you will need Android Studio installed on your computer.

1. **Clone the Repository**

   Open a terminal and run:

   ```bash
   git clone https://github.com/Samko-1z/Algo-Calc.git
   ```

2. **Open the Project in Android Studio**

   Select **Open an Existing Project**, then navigate to the folder where you cloned the repository.

3. **Build and Run**

   Allow Gradle to sync and download the required dependencies. Once the setup is complete, you can run the app using an Android emulator or a physical Android device.

## Technologies Used

- **Programming Language:** [Kotlin](https://kotlinlang.org/)
- **User Interface:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Architecture:** MVVM (Model-View-ViewModel)
- **State Management:** [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) and [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- **Expression Evaluation:** [Mozilla Rhino](https://github.com/mozilla/rhino)
- **Build and Dependency Management:** [Gradle](https://gradle.org/)
