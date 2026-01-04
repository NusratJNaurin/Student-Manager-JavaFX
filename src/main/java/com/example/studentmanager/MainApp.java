package com.example.studentmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    //1. View all students
    //2. Search student
    //3. Add student
    //4. Remove student
    //5. View grades
    //6. Exit
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Label windowTitle = new Label("Welcome to Student Manager!");
        windowTitle.setFont(Font.font("Poppins", FontWeight.BOLD, 30));
        VBox title = new VBox(50);
        title.setAlignment(Pos.CENTER);
        title.getChildren().addAll(windowTitle);

        GridPane viewStudents = new GridPane();
        viewStudents.setHgap(20);
        viewStudents.setVgap(20);
        viewStudents.setAlignment(Pos.CENTER);
        viewStudents.setPadding(new Insets(20, 20, 20, 20));

        viewStudents.addRow(0,new Label("ID"),new Label("Name"),
                new Label("Department"),new Label("CGPA"));
        int row = 0;
        for (Student student : TestApp.students){
            viewStudents.addRow(row++,new Label(student.getId()),new Label(student.getName()),new Label(student.getDepartment()),
                    new Label(String.valueOf(student.getCgpa())));
        }
        for (Node node : viewStudents.getChildren()){
            if (node instanceof Label) {
                Label lab = (Label) node;
                lab.setFont(Font.font("Arial",20));
            }
        }

        VBox setUp = new VBox(30);
        setUp.getChildren().addAll(title,viewStudents);

        Scene scene2 = new Scene(setUp,700,500);
        stage.setTitle("Student Manager");
        stage.setScene(scene2);
        stage.show();
    }
}
