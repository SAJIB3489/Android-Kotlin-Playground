# Kotlin Playground 🚀  
A collection of Kotlin Android apps and exercises for learning and experimenting with Android development.

## 📂 Repository Structure  

Android-Kotlin-Playground/
│── apps/
│ ├── FlagCardsApp/
│ ├── WeatherApp/
│ └── NotesApp/
│── shared-resources/
│   ├── fonts/
│   ├── icons/  
│   └── images/
│── README.md
│── .gitignore 

---

## 🛠️ How to Run the Apps  

1. **Clone the repository**  
   ```sh
   git clone https://github.com/SAJIB3489/Android-Kotlin-Playground.git
   cd Android-Kotlin-Playground

2. **Open in Android Studio**

   - Open Android Studio
   - Click "Open an Existing Project"
   - Check the ``compileSdk = 35`` and ``targetSdk = 35`` are set correctly in ``Gradle Scripts/build.gradle.kts``
   - Select the app folder, e.g., ``apps/FlagCardsApp/``
   - Place the images, icons, and font in the your project's ``/res/`` directory

3. **Build & Run**

   - Connect an emulator or device
   - Click Run ▶️


---


## 📱 Apps Overview  

### 5. LazyCounter
Triple Counter is a simple yet interactive Kotlin-based Android app that allows users to manage three independent counters. Each counter has its own + and - buttons to increment or decrement values. Users can also set a custom starting value through an editable text field.

<kbd>
  <img src="/apps/CounterApp/app-overview.png">
</kbd>


- **Features:**  
  - Three Independent Counters – Each counter operates separately.
  - Custom Starting Value – Users can enter an initial value in a text field.
  - Increment & Decrement Buttons – Each counter has + and - buttons.
  + Organized UI Layout – Uses a Column for structured alignment.

📂 **Path:** ![apps/CounterApp/](apps/CounterApp/) 

---

### 6. FlagCardsApp  🏁
FlagCards is a simple Kotlin-based Android app that displays the names and flags of four different countries in a visually appealing card layout. Each country's information is presented in a custom-styled card using Jetpack Compose. The app follows Material Design principles and supports both dark mode and dynamic color themes.

<kbd>
  <img src="/apps/FlagCardsApp/app-overview.png">
</kbd>


- **Features:**  
  - Displays 4 Countries
  - Custom Card Design
  - Geo Font
  - Dynamic Color Support
  - Dark Theme Enabled
  - Custom App Icon

📂 **Path:** ![apps/FlagCardsApp/](apps/FlagCardsApp/) 

---

### 7. LazyCounter
The Multi Counter App is a Kotlin-based Android application that provides a scrollable list of counters. Each counter is independently adjustable, allowing users to increase or decrease its value. The app uses LazyColumn for efficient rendering and supports adding or removing counters dynamically at runtime.

<kbd>
  <img src="/apps/LazyCounter/app-overview.png">
</kbd>


- **Features:**  
  - Scrollable Counter List – Uses LazyColumn to display multiple counters.
  - Independent Counter Control – Each counter can be increased or decreased separately.
  - Dynamic Counter Management – Users can add or remove counters anytime.
  - Auto-Labeled Counters – Each counter is named Counter_# automatically.
  - Smooth UI & State Management – Ensures a seamless experience with Jetpack Compose.

📂 **Path:** ![apps/LazyCounter/](apps/LazyCounter/) 

---

