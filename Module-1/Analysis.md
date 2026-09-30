# Module 1 Analysis – UI Design and Event Handling

## Techniques Learned

In this module, I learned how to create a user interface using Jetpack Compose. I used components such as Text, OutlinedTextField, and Button. I also learned how state can be used to update the user interface when the user interacts with the application.

## How I Implemented the Feature

I created a simple Student Interaction App. The application allows the user to enter a name in a text field and press the Submit button. After pressing the button, the application displays a greeting message. I also added a counter button that increases the counter value whenever the user presses it.

## Event Handling Used

I used `onValueChange` to detect changes in the text field and update the name value. I used `onClick` for the Submit button and the Increase Counter button. When the user presses a button, the related state value changes and Jetpack Compose automatically updates the screen.

## Strengths of the Approach

One advantage I noticed is that Jetpack Compose makes it easier to build the UI using Kotlin code. I did not need to create a separate XML layout file. The state-based approach also made it easier for me to update the interface after a button click.

## Limitations

At first, I found state management slightly confusing because I needed to understand how the UI reacts when a state value changes. I also had to understand how different Compose components and modifiers work together.

## Technical Decision

I used Jetpack Compose because it provides a modern declarative approach for Android UI development. I used `rememberSaveable` for the name, message, and counter values because I wanted the application to preserve simple UI state during recreation when possible.

## Problems I Faced

During this module, I faced some difficulty while setting up the Android emulator and waiting for the Gradle project to finish syncing. I also needed to understand how the Compose state variables were connected to the UI.

## How I Solved Them

I waited for the Gradle build and synchronization process to complete before running the application. I tested the application step by step by entering a name, submitting the form, and pressing the counter button. This helped me confirm that each feature was working correctly.

## Evidence

The following screenshots are included as evidence:

- `01-initial-ui.png`
- `02-empty-name-validation.png`
- `03-event-handling-output.png`

These screenshots show the initial interface, empty-name validation, successful greeting message, and counter interaction.

## What I Learned

From this module, I learned the basic structure of a Jetpack Compose application and how user interaction can change the UI. I now understand the basic use of `Text`, `OutlinedTextField`, `Button`, `onClick`, `onValueChange`, and state variables in Compose.