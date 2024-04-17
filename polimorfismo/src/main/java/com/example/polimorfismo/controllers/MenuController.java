package com.example.polimorfismo.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.polimorfismo.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_actualizar;

    @FXML
    private Button btn_agregar;

    @FXML
    private ListView<String> lista;

    @FXML
    private TextField tex_apellido;

    @FXML
    private TextField tex_name;
    Universidad universidad;
    SaveAndUpdate base;
    @FXML
    void lista(MouseEvent event) {
        if (lista.getSelectionModel().getSelectedIndex() != -1) {
            Estudiante selectedStudent = getStudentFromListview();
            if (selectedStudent != null) {
                tex_name.setText(selectedStudent.getName());
                tex_apellido.setText(selectedStudent.getLasName());
            }
        }
    }
    @FXML
    void btn_actualizar(MouseEvent event) {
        String name = tex_name.getText();
        String apellido = tex_apellido.getText();
        if (!name.isEmpty() || !apellido.isEmpty()) {
            Estudiante selectedStudent = getStudentFromListview();
            if (selectedStudent != null) {
                selectedStudent.setName(name);
                selectedStudent.setLasName(apellido);
                universidad.getBase1().update(selectedStudent);
                universidad.getBase2().update(selectedStudent);
                universidad.getBase3().update(selectedStudent);
                lista.getItems().set(lista.getSelectionModel().getSelectedIndex(), selectedStudent.toString());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Actualizado correctamente");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Campos Vacios");
            alert.showAndWait();
        }
    }
    @FXML
    void btn_agregar(MouseEvent event) {
        String name = tex_name.getText();
        String apellido = tex_apellido.getText();
        if (!name.isEmpty() || !apellido.isEmpty()) {
            Estudiante nuevo = new Estudiante(name, apellido);
            universidad.getBase1().save(nuevo);
            universidad.getBase2().save(nuevo);
            universidad.getBase3().save(nuevo);
            lista.getItems().add(nuevo.toString());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Agregado correctamente");
            alert.showAndWait();
        }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Campos Vacios");
                alert.showAndWait();
            }
    }

    private Estudiante getStudentFromListview() {
        int selectedIndex = lista.getSelectionModel().getSelectedIndex();
        return selectedIndex != -1 && lista.getSelectionModel().getSelectedItem() != null
                ? parseEstudianteFromString(lista.getSelectionModel().getSelectedItem())
                : null;
    }

        private Estudiante parseEstudianteFromString(String selectedItem) {
        String[] parts = selectedItem.split(",");
        String name = parts[0];
        String apellido = parts[1];
        return new Estudiante(name, apellido);
    }

    @FXML
    public void init(Stage stageRoot) {
        universidad = new Universidad(new DataBase1(), new DataBase2(), new DataBase3());
    }
}