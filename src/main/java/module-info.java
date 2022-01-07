module com.example.hangman {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.jetbrains.annotations;


    opens com.example.hangman to javafx.fxml;
    exports com.example.hangman;
}