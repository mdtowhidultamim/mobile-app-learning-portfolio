# Module 5 Analysis – Lifecycle and State Preservation

## Techniques Learned
I learned how the Android Activity lifecycle works and how UI state can be preserved using `rememberSaveable`.

## Implementation
The application contains a name field and counter. The values are preserved when the device is rotated.

## Lifecycle Awareness
I used lifecycle callbacks such as `onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, and `onDestroy` and observed them in Logcat.

## Strengths
Using `rememberSaveable` helps preserve simple UI state during configuration changes such as device rotation.

## Limitations
`rememberSaveable` is suitable for simple state, but more complex application data may require ViewModel or persistent storage.

## Technical Decision
I used `rememberSaveable` because the app only needed to preserve simple text and counter values during Activity recreation.

## Problems and Solution
At first, I needed to understand why the Activity was recreated after rotation. I used Logcat lifecycle messages to observe the process and verify that the state was preserved.

## Evidence
- 01-initial-lifecycle-screen.png
- 02-state-before-rotation.png
- 03-state-preserved-after-rotation.png
- 04-lifecycle-logcat.png

## What I Learned
I learned how lifecycle events affect an Android Activity and how state preservation can improve the user experience.