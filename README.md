## 📱 Android Click Counter App

This is a simple two-screen Android app built with Kotlin to demonstrate shared preferences, inter-activity communication, and UI interaction. The app allows users to increment and store counts for Android and iOS votes, simulating a preference counter.

DEMO 
![](https://github.com/user-attachments/assets/105a392b-9da4-46c0-9099-dac20bccfce0| width=100)


### 🚀 Features

- Two buttons to count Android and iOS clicks.
- Real-time UI updates to reflect click counts.
- Data persistence using **SharedPreferences**.
- A second screen to **view and edit** the counts.
- Safe return of updated counts to the main activity using `ActivityResultLauncher`.

### 🧠 How It Works

#### 📍 MainActivity

- Initializes and displays counts for Android and iOS.
- Uses SharedPreferences to persist click counts across sessions.
- Offers a "Results" button to launch a second activity where users can view/edit the counts.
- When returning from the second screen, updated counts are shown and saved again when the app is paused.

#### 📍 SecondActivity

- Retrieves counts passed from MainActivity.
- Displays them in editable `EditText` fields.
- Allows users to change the values manually.
- On clicking "Back to Main", sends updated values back to the main screen using `setResult`.

### 🗂️ File Structure

```plaintext
└── vidu.example.lab02
    ├── MainActivity.kt
    └── SecondActivity.kt
```

### 💾 Data Persistence

The following keys are used in `SharedPreferences`:
- `"android_count"` – stores number of Android votes
- `"ios count"` – stores number of iOS votes

### 🛠️ Technologies

- Language: Kotlin
- Android SDK
- SharedPreferences
- Activity Result API
- View components: `TextView`, `Button`, `EditText`

### 📸 UI Preview 

![Screenshot_1745184038](https://github.com/user-attachments/assets/b2568e1a-11cd-4d7a-a9bc-dd9d196fa274=250x250)

![Screenshot_1745184041](https://github.com/user-attachments/assets/f17dc0cb-df68-4fb5-b4cb-4b4f3c954be4=250x250)

![Screenshot_1745184052](https://github.com/user-attachments/assets/74bf8913-689b-44ff-96c0-4493ce9d4bc7=250x250)




