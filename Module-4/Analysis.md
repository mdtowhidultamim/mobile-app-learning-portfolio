# Module 4 Analysis – Local Data Storage

## Techniques Learned
I learned how to store simple data locally in an Android application using SharedPreferences.

## Implementation
The app allows users to add, view, and delete notes. Saved notes remain available even after the application is closed and opened again.

## Strengths
SharedPreferences is simple and suitable for storing small amounts of local data.

## Limitations
It is not ideal for large or complex structured data. For larger applications, Room Database would be more suitable.

## Technical Decision
I used SharedPreferences because the application only needed to store a small list of simple notes.

## Problems and Solution
I needed to make sure the notes were saved after adding or deleting them. I solved this by updating SharedPreferences whenever the note list changed.

## Evidence
- 01-empty-notes-screen.png
- 02-note-saved.png
- 03-persistent-notes-after-restart.png
- 04-note-deleted.png

## What I Learned
I learned the difference between temporary UI state and persistent local storage.