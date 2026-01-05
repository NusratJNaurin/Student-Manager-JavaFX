# Student Manager (JavaFX)

A simple JavaFX desktop application for managing student records.  
The application focuses on **adding and removing students** using a clean, form-based user interface.


<img width="800" height="700" alt="Screenshot 2026-01-06 021640" src="https://github.com/user-attachments/assets/0fc3b2b4-c63e-4bc2-b3a4-cecc1244ad89" />


## Features
- Add students through input fields
- Remove students either by:
  - Selecting a student from the TableView, or
  - Entering the student’s name manually
- TableView-based student list
- Basic input validation for required fields
- Keyboard navigation (Enter key moves between fields)
- Clear user feedback through on-screen messages

## Technologies Used
- Java
- JavaFX

## Key Concepts Implemented
- JavaFX layouts (VBox, HBox, GridPane, etc.)
- Event handling using `setOnAction`
- TableView and column configuration
- ObservableList for dynamic data updates
- Input validation and focus management
- Basic UI styling (fonts, spacing, alignment)

## Future Improvements
- Edit/update existing student records
- Support additional student attributes
- Persist data using files or a database
- Improve UI styling using external CSS


## ▶ How to Run

**Requirements:**
- IntelliJ IDEA (recommended)
- Java 11 or higher
- JavaFX library installed

**Steps:**
1. Open the project in **IntelliJ IDEA**.
2. Ensure JavaFX is configured in the project (SDK, libraries).
3. Run the **Launcher** class to start the application.
   - Do **not** run the `MainApp` class directly; it depends on a class that has been removed.
4. Once the launcher runs, you can:
   - Add new students
   - Remove students
   - View the TableView-based student list
5. Note: Running the project in Eclipse may require additional configuration due to IntelliJ-specific project setup.


