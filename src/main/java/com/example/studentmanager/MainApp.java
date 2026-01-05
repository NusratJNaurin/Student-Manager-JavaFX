package com.example.studentmanager;

import app.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.*;


public class MainApp extends Application {
    private ArrayList<Student> students = new ArrayList<>();
    Font Header = Font.font("Poppins", FontWeight.BOLD, 30);
    Font sectionHeader = Font.font("Arial",FontWeight.BOLD,25);
    Font normal = Font.font("Arial",16);
    Font special = Font.font("Poppins",15);
    private TableView<Student> table;


    public void studentsData(){
        Student s1 = new Student("Ayesha Khan","Computer Science",3.6);
        Student s2 = new Student("Sara Albuainain","Computer Science",3.2);
        Student s3 = new Student("Fatima Khanam","Computer Engineering",4);
        Student s4 = new Student("Afra Sayem","Mechatronics",3.8);
        Collections.addAll(students, s1, s2, s3, s4);
    }


    public VBox createTop() {
        VBox title = new VBox(5);
        Label windowTitle = new Label("Welcome to Student Manager!"); windowTitle.setFont(Header);
        Label subTitle = new Label("Add/Remove students"); subTitle.setFont(special);
        title.getChildren().addAll(windowTitle,subTitle);
        title.setAlignment(Pos.CENTER);

        return title;
    }


    public VBox createCenter(){
        VBox stdFunctions = new VBox(20);

        Label std = new Label("Student Information:"); std.setFont(sectionHeader);

        Label showMessage = new Label();
        showMessage.setTextFill(Color.RED);

        Label name = new Label("Name: "); name.setFont(normal);
        TextField enterName = new TextField(); enterName.setFont(normal);
        Label cgpa = new Label("CGPA: "); cgpa.setFont(normal);
        TextField enterGPA = new TextField(); enterGPA.setFont(normal);
        Label dep = new Label("Department: "); dep.setFont(normal);
        TextField enterDep = new TextField(); enterDep.setFont(normal);
        TextField[] textFields = {enterName, enterGPA, enterDep};

        HBox stdInfo = new HBox(name, enterName, cgpa, enterGPA, dep, enterDep);
        stdInfo.setSpacing(14);
        stdInfo.setAlignment(Pos.CENTER);

        enterName.setOnAction(e-> enterGPA.requestFocus());
        enterGPA.setOnAction(e-> enterDep.requestFocus());

        Button addStd = new Button("Add Student"); addStd.setFont(special);
        Button removeStd = new Button("Remove Student"); removeStd.setFont(special);
        Button clear = new Button("Clear"); clear.setFont(special);

        addStd.setOnAction(e-> handleAddStudent(textFields, showMessage));
        removeStd.setOnAction(e-> handleRemoveStudent(textFields, showMessage));
        clear.setOnAction(e-> handleClear(textFields));

        HBox funcButtons = new HBox(addStd, removeStd, clear);
        funcButtons.setSpacing(15); funcButtons.setAlignment(Pos.CENTER);

        stdFunctions.getChildren().addAll(std, stdInfo, funcButtons, showMessage);
        stdFunctions.setAlignment(Pos.CENTER);

        return stdFunctions;
    }


    public void handleAddStudent(TextField[] tx, Label msg) {
        msg.setText(" ");
        for (TextField textField : tx) {
            if (textField.getText().trim().isEmpty()) {
                textField.requestFocus();
                msg.setText("Please fill all the details");
                return;
            }
        }

        String name = tx[0].getText();
        double cgpa = 0;
        try {
            cgpa = Double.parseDouble(tx[1].getText());
            if (cgpa > 4 || cgpa < 0) {
                msg.setText("Please enter CGPA between 0.00 to 4.00");
                tx[1].clear();
                return;
            }
        } catch (NumberFormatException ex) {
            msg.setText("Please enter a number");
        }
        String dep = tx[2].getText();

        Student s = new Student(name, dep, cgpa);
        table.getItems().add(s);

        msg.setText(" ");
        handleClear(tx);

    }


    public void handleRemoveStudent(TextField[] tx, Label msg) {
        Student remStd = table.getSelectionModel().getSelectedItem();
        if (remStd != null) {
            table.getItems().remove(remStd);
            msg.setText(" ");
        }
        else if (!tx[0].getText().isEmpty()) {
            for (Student s: students){
                if (s.getName().equalsIgnoreCase(tx[0].getText()))
                    table.getItems().remove(s);
            }
            msg.setText(" ");
        } else {
            msg.setText("Please select a student from the table or enter their name.");
        }

    }


    public void handleClear(TextField[] tx){
        for (TextField texts : tx)
            texts.clear();
    }


    public VBox createBottom(){
        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20));

        Label allStd = new Label("Students Data"); allStd.setFont(sectionHeader);


        table = new TableView<>();
        TableColumn<Student, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> deptCol = new TableColumn<>("Department");
        deptCol.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableColumn<Student, Double> cgpaCol = new TableColumn<>("CGPA");
        cgpaCol.setCellValueFactory(new PropertyValueFactory<>("cgpa"));

        table.getColumns().addAll(idCol, nameCol, deptCol, cgpaCol);
        table.getItems().addAll(students);
        table.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14pt;");
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        container.getChildren().addAll(allStd,table);
        container.setAlignment(Pos.CENTER);

        return container;
    }


    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Student Manager");
        studentsData();

        VBox bp = new VBox(25);
        bp.setAlignment(Pos.CENTER);

        bp.getChildren().addAll(
                createTop(),
                createCenter(),
                createBottom()
        );

        bp.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            if (!table.getBoundsInParent().contains(event.getX(), event.getY())) {
                table.getSelectionModel().clearSelection();
            }
        });

        Scene scene2 = new Scene(bp,900,700);
        stage.setScene(scene2);
        stage.show();
    }


}
