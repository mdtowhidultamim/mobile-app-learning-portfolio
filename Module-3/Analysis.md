# Module 3 Analysis – Form Handling and Validation

## Techniques Learned
I learned how to collect user input using TextField components and validate the entered data before processing it.

## Validation Used
The app checks for empty fields and validates the email format before allowing registration.

## Strengths
Input validation helps prevent incomplete or incorrect data from being accepted.

## Limitations
The validation used in this app is simple and could be improved with more detailed rules.

## Technical Decision
I used Jetpack Compose state variables because they make it easy to update the form and validation messages dynamically.

## Problems and Solution
I initially needed to understand how multiple validation conditions should be checked. I solved this by using a `when` statement to handle each condition clearly.

## Evidence
- 01-registration-form.png
- 02-empty-field-validation.png
- 03-invalid-email-validation.png
- 04-successful-registration.png

## What I Learned
I learned how to create forms, validate user input, and display appropriate error and success messages.