# Android Secure Messenger

This project is a conceptual, Java-based model of an end-to-end encrypted (E2EE) messaging application for the Android platform. It is designed to showcase the fundamental software design and security principles involved in creating a secure communication tool.

Rather than building a full Android application, which involves extensive UI code and platform-specific APIs, this project focuses on the core backend logic. It simulates the process of a user sending a message, the message being encrypted, and the recipient decrypting it.

## Core Concepts Demonstrated

* **Security Software Development:** The primary goal is to demonstrate an understanding of E2EE principles.
    * **Encryption/Decryption Flow:** The `MessagingService` class simulates the core cryptographic operations. In a real application, this would be replaced by a robust, well-vetted library like the **Signal Protocol**.
    * **Data Transformation:** The simulation uses Base64 encoding to represent the transformation of plaintext into an unreadable ciphertext format. This makes the concept of encryption tangible.

* **Object-Oriented Design (OOD):** The system is modeled using clear, single-responsibility classes.
    * `Message`: A simple data class (POJO) that represents a message, encapsulating all its relevant data (sender, receiver, content, etc.).
    * `SecureMessenger`: The main class that orchestrates the simulation.
    * `MessagingService`: A service class responsible for the core logic of encryption and decryption. This separation of concerns is a key OOD principle.

* **Mobile Application Architecture:** Although this is a command-line simulation, the design reflects how a real Android app would be structured. The `MessagingService` would be part of the app's business logic layer, completely separate from the UI (Activities and Fragments). The `Message` object is analogous to the data model that would be used throughout the app and potentially stored in a local database (like SQLite or Room).

## Full Implementation Vision

A full-fledged Android application based on this concept would include:
* **UI Layer:** Activities and Fragments built with XML layouts and Jetpack Compose, following Google's Material Design principles for a clean and intuitive user experience.
* **Networking Layer:** A networking library like Retrofit or Ktor to send and receive the encrypted `Message` objects from a server.
* **Persistence Layer:** A local database using Android's Room library to store message history securely on the device.
* **Real Cryptography:** Integration of the Signal Protocol library to handle key exchange, forward secrecy, and the double ratchet algorithm, providing true E2EE.

## Tech Stack (for this simulation)
* **Core Language:** Java
* **Key Libraries:** Standard Java libraries (java.util.Base64, java.util.UUID). No external dependencies are required.

## How to Run
This is a command-line application.
1.  Clone the repository and navigate into the `src` directory.
2.  Compile the Java file:
    ```bash
    javac SecureMessenger.java
    ```
3.  Run the simulation:
    ```bash
    java SecureMessenger
    ```
