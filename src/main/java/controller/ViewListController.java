package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.MyList;

import java.util.List;

public class ViewListController {

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> coldone;

    @FXML
    private TableColumn<?, ?> colhad;

    @FXML
    private TableView<?> tblhistory;

    public void btnReloadOnAction(ActionEvent actionEvent) {
        colhad.setCellValueFactory(new PropertyValueFactory<>("addListText"));
        coldone.setCellValueFactory(new PropertyValueFactory<>(""));

        List<MyList> todoList = DBConnection.getInstance().getConnection();
        ObservableList<MyList> todoObservableList = FXCollections.observableArrayList();

        todoList.forEach(obj->{
            todoObservableList.add(obj);
        });

        //tblhistory.setItems(todoObservableList);


    }
}
