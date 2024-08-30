package controller;

//import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import model.MyList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDoListController {

    public VBox vBoxList2;
    @FXML
    private TextField txtAddTask;

    @FXML
    private VBox vBoxList1;

    @FXML
    void btnAddTaskOnAction(ActionEvent event) {
        MyList toDoList = new MyList(txtAddTask.getText());
        HBox hbox = new HBox(10);
        Label newLabel = new Label(toDoList.getAddList());
           CheckBox newCheckBox = new CheckBox("");

        hbox.getChildren().addAll(newCheckBox, newLabel);

        vBoxList1.getChildren().add(hbox);


        newCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Label additionalLabel = new Label( newLabel.getText() + " - Done ");

                vBoxList2.getChildren().add(additionalLabel);

                vBoxList1.getChildren().remove(hbox);
                hbox.getChildren().remove(newLabel);

                newCheckBox.setDisable(true);

                String SQL = "INSERT INTO CompletedTaskList (task_title, completion_date) VALUES (?, ?)";
                Connection connection=null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","12345");
                    PreparedStatement psTm = connection.prepareStatement(SQL);
                    psTm.setObject(2,toDoList.getAddList());


                } catch (SQLException e) {
                   throw new RuntimeException(e);
                }
                System.out.println(hbox);


            } else {

            }
        });
    }

    private void loadTable(){

    }
}
