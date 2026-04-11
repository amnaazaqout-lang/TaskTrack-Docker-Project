/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ArrayList<Student> studentList = new ArrayList<>();
    private final String FILE_NAME = "students.dat";

    @Override
    public void start(Stage primaryStage) {
        
        studentList = readFromFile();

       
        Label mainTitle = new Label("Student Registration System");
        mainTitle.setId("main-title");

        Label lblId = new Label("Student ID:");
        ComboBox<String> idComboBox = new ComboBox<>();
        idComboBox.setPromptText("Select ID");
        idComboBox.setMaxWidth(Double.MAX_VALUE);
        for (Student s : studentList) { idComboBox.getItems().add(s.getId()); }

        Label lblName = new Label("Name:");
        TextField nameField = new TextField();

        Label lblGender = new Label("Gender:");
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, maleRadio, femaleRadio);

        Label lblLang = new Label("Languages:");
        ListView<String> langListView = new ListView<>();
        langListView.setPrefHeight(100);
        langListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        langListView.getItems().addAll("Java", "JavaFX", "CSS", "Python", "C++");

        Button saveBtn = new Button("Save Changes");
        saveBtn.setId("save-btn");
        saveBtn.setMaxWidth(Double.MAX_VALUE);

        idComboBox.setOnAction(e -> {
            String selectedID = idComboBox.getValue();
            for (Student s : studentList) {
                if (s.getId().equals(selectedID)) {
                    nameField.setText(s.getName());
                    if (s.getGender().equalsIgnoreCase("Male")) maleRadio.setSelected(true);
                    else femaleRadio.setSelected(true);
                    langListView.getSelectionModel().clearSelection();
                    for (String lang : s.getLanguages()) { langListView.getSelectionModel().select(lang); }
                    break;
                }
            }
        });

        saveBtn.setOnAction(e -> {
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            String newId = "10" + (studentList.size() + 1);
            Student newStudent = new Student(newId, nameField.getText(), gender, 
                    new ArrayList<>(langListView.getSelectionModel().getSelectedItems()));
            studentList.add(newStudent);
            idComboBox.getItems().add(newId);
            System.out.println("Saved to file.");
        });

       
        GridPane grid = new GridPane();
        grid.setId("center-panel");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15); grid.setVgap(15); grid.setPadding(new Insets(30));

        grid.add(mainTitle, 0, 0, 2, 1);
        grid.add(lblId, 0, 1);     grid.add(idComboBox, 1, 1);
        grid.add(lblName, 0, 2);   grid.add(nameField, 1, 2);
        grid.add(lblGender, 0, 3); grid.add(genderBox, 1, 3);
        grid.add(lblLang, 0, 4);   grid.add(langListView, 1, 4);
        grid.add(saveBtn, 0, 5, 2, 1);

        Scene scene = new Scene(grid, 500, 550);

      
        try {
           scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception ex) { System.out.println("CSS file not found!"); }

        primaryStage.setOnCloseRequest(e -> saveToFile(studentList));
        primaryStage.setTitle("Student System - Amna Raed");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveToFile(ArrayList<Student> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private ArrayList<Student> readFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Student>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    public static void main(String[] args) { launch(args); }
}