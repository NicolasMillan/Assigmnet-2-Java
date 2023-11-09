package com.example.motorcycle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<ApiResponse> listView;

    @FXML
    private TextField searchMakeTextField;

    @FXML
    private TextField searchModelTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setImage(new Image("https://www.pngplay.com/wp-content/uploads/12/Bugs-Bunny-No-PNG-Photo-Image.png"));
    }

    @FXML
    void showMotorcycles(ActionEvent event) {
        listView.getItems().clear();//Clear all the items from the list view
        String searchMakeString = searchMakeTextField.getText(); // Add the value from the user to a variable
        String searchModelString = searchModelTextField.getText(); // Add the value from the user to a variable

        //create api response object
        ApiResponse apiResponse = ApiUtility.getDataFromAPIQuick(searchMakeString, searchModelString);

        // add movie objects to listView
        listView.getItems().addAll(apiResponse);
    }
}

