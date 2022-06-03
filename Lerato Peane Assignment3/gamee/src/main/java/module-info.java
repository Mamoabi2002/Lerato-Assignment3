module com.example.gamee {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamee to javafx.fxml;
    exports com.example.gamee;
}