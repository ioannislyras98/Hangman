package com.example.hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.JSONObject;

public class Controller {
    @FXML
    private TextField AddDictionaryID;

    @FXML
    private Label status;

    @FXML
    private Label status2;

    @FXML
    private TextField ChooseDictionaryID;

    @FXML
    private Label labelWord;

    @FXML
    private Label labelPoints;

    @FXML
    private Label labelLives;

    @FXML
    private Label labelcorrectletters;

    @FXML
    private TextField labelletter;

    @FXML
    private Label labelwords;

    @FXML
    private Label statusChoose;

    @FXML
    private ListView<String> listview;

    @FXML
    private Label sevennine;

    @FXML
    public Label six;

    @FXML
    private Label tenmore;

    @FXML
    private Label labelselectedwords;

    @FXML
    private Label labeltries;

    @FXML
    private Label labelDefeats;

    @FXML
    private Label labelwins;

    @FXML
    private Label highscore;

    @FXML
    private ImageView imageHangman;

    @FXML
    private ListView<String> listviewselectedwords;

    private static Stage stage1;
    private static Scene scene1;
    private static Parent root1;
    private static final dictionary d = new dictionary();
    private static final Word word = new Word();
    private static final listPossibleWords PossibleWords = new listPossibleWords();
    private static final LastFiveGames lastfivegames = new LastFiveGames();
    private static final Dictionarypopup Dictionarypopup = new Dictionarypopup();
    private static final Rounds Rounds = new Rounds();

    int points = 0;
    int lives = 0;
    int correctletters = 0;
    int falseletters = 0;
    int words = 0;
    int Tries = 0;
    static String S = new String();

    public void btnCreate(ActionEvent event) throws IOException {
        root1 =FXMLLoader.load(getClass().getResource("Createfile.fxml"));
        scene1 = new Scene(root1);
        stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();
    }
    public void btnStart(ActionEvent event) throws IOException {
        try {
            Tries = 0;
            listview.getItems().clear();
            statusChoose.setText("");
            S = "";
            String w = new String(d.randomWord());
            if (w == null || w.length() == 0) {
                statusChoose.setText("You need to load a dictionary");
            } else {
                Image image = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/zero.png");
                imageHangman.setImage(image);
                falseletters = 0;
                lives = Lives.StartingLives();
                points = Points.StartingPoints();
                correctletters = CorrectLetters.StartingCorrectLetters();
                words = d.DictionaryLength();
                labelLives.setText(String.valueOf(lives));
                labelPoints.setText(String.valueOf(points));
                labelwords.setText(String.valueOf(words));
                labelcorrectletters.setText(String.valueOf(correctletters));
                word.hiddenSave(w);
                PossibleWords.emptylist();
                PossibleWords.storewords(d.showDictionaryWords(), w.length());
                ArrayList<percentageletterposition> list2 = PossibleWords.statistics();
                for (int i = 0; i < w.length(); i++) {
                    S = S + "_";
                }
                word.showSave(S);
                labelWord.setText(S);
                for ( percentageletterposition plp : list2) {
                    listview.getItems().add(plp.toString());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void btnRounds(ActionEvent event) throws IOException {
        Rounds.popup();
    }
    public void ShowRounds(ActionEvent event) throws IOException {
        ArrayList<RoundStats> list1 = lastfivegames.getlastfivegames();
        int wins = 0;
        int defeats = 0;
        int tries = 0;
        int highScore = 0;
        for ( RoundStats plp : list1) {
            wins = plp.getwins() + wins;
            defeats = plp.getdefeats() + defeats;
            tries = plp.gettries() + tries;
            if(highScore < plp.gethighscore()){
                highScore = plp.gethighscore();
            }
            listviewselectedwords.getItems().add(plp.getselectedwords());
        }
        labeltries.setText(String.valueOf(tries));
        labelDefeats.setText(String.valueOf(defeats));
        labelwins.setText(String.valueOf(wins));
        highscore.setText(String.valueOf(highScore));
    }
    public void btnLoad(ActionEvent event) throws IOException {
        root1 =FXMLLoader.load(getClass().getResource("Loadfile.fxml"));
        scene1 = new Scene(root1);
        stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();
    }
    public void DictionaryStats(ActionEvent event) throws IOException {
            if (d.DictionaryLength() == 0) {
                statusChoose.setText("You need to load a dictionary");
            } else {
                Dictionarypopup.popup();
            }

    }
    public void ShowDictionaryStats(){
        ArrayList<String> list1 = d.statsDictionary();
        six.setText(list1.get(0));
        sevennine.setText(list1.get(1));
        tenmore.setText(list1.get(2));
    }
    public void btnSolution(ActionEvent event) throws IOException {
        if (S.contains("_")){
            S = word.hiddenWord();
            labelWord.setText(S);
            PossibleWords.emptylist();
            listview.getItems().clear();
            Image image0 = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/six.png");
            imageHangman.setImage(image0);
            points = 0;
            labelPoints.setText(String.valueOf(points));
            lastfivegames.addlastfivegames(S, Tries, 0, 1, points);
            statusChoose.setText("You lost");
        }
        else{
            statusChoose.setText("There is not a word");
        }
    }
    public void Exit(ActionEvent event) throws IOException {
        Application.exit();
    }
    public void buttonChoose(ActionEvent event) throws IOException {
        try {
            String text = labelletter.getText();
            String[] splited = text.split("\\W+");
            if (splited[0] == null || splited[1] == null) {
                statusChoose.setText("You need to write the position and a letter");
                return ;
            }
            if(d.DictionaryLength()==0){
                statusChoose.setText("You need to load a dictionary");
                return ;
            }
            if(word.hiddenWord().length()== 0){
                statusChoose.setText("You need to click start first");
                return ;
            }
            else {
                try {
                    int number = Integer.parseInt(splited[0]);
                    char character = word.showWord().charAt(number - 1);
                    if (number <= 0 || number > word.hiddenWord().length()) {
                        statusChoose.setText("there is not this position");
                    } else if (character != '_') {
                        statusChoose.setText("You already find this position");
                    } else if (splited[1].length() != 1) {
                        statusChoose.setText("You need a letter");
                    } else {
                        Tries = Tries + 1;
                        statusChoose.setText(" ");
                        splited[1] = splited[1].toUpperCase();
                        boolean temp = FindLetter.find(word.hiddenWord(), splited[1], number - 1); //check if the letter is correct
                        if (temp) { //if the letter is correct
                            statusChoose.setText("correct");
                            correctletters = CorrectLetters.AddCorrectLetters();
                            labelcorrectletters.setText(String.valueOf(correctletters * 100 / (correctletters + falseletters) + "%"));
                            ArrayList<percentageletterposition> list2 = PossibleWords.showstatistics();
                            points = Points.Points(number, splited[1], list2);
                            labelPoints.setText(String.valueOf(points));
                            char[] myChars = S.toCharArray();
                            myChars[number - 1] = splited[1].charAt(0);
                            S = String.valueOf(myChars);
                            word.showSave(S);
                            if (!S.contains("_")) {
                                statusChoose.setText("You won");
                                lastfivegames.addlastfivegames(S, Tries, 1, 0, points);
                            }
                            labelWord.setText(S);
                            PossibleWords.correctletter(splited[1].charAt(0), number);
                            list2 = PossibleWords.statistics();
                            listview.getItems().clear();
                            for (percentageletterposition plp : list2) {
                                listview.getItems().add(plp.toString());
                            }
                        } else {
                            lives = Lives.RemoveLives();
                            labelLives.setText(String.valueOf(lives));
                            falseletters = falseletters + 1;
                            labelcorrectletters.setText(String.valueOf(correctletters * 100 / (correctletters + falseletters) + "%"));
                            switch (lives) {
                                case 5:
                                    System.out.println("5");
                                    Image image5 = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/one.png");
                                    imageHangman.setImage(image5);
                                    break;
                                case 4:
                                    Image image4 = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/two.png");
                                    imageHangman.setImage(image4);
                                    break;
                                case 3:
                                    Image image3 = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/three.png");
                                    imageHangman.setImage(image3);
                                    break;
                                case 2:
                                    Image image2 = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/four.png");
                                    imageHangman.setImage(image2);
                                    break;
                                case 1:
                                    Image image1 = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/five.png");
                                    imageHangman.setImage(image1);
                                    break;
                                case 0:
                                    Image image0 = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/six.png");
                                    imageHangman.setImage(image0);
                                    break;
                            }
                            statusChoose.setText("false");
                            points = Points.RemovePoints();
                            labelPoints.setText(String.valueOf(points));
                            if (lives == 0) {
                                statusChoose.setText("You lost");
                                S = word.hiddenWord();
                                word.showSave(S);
                                labelWord.setText(S);
                                Image image = new Image("C:/Users/30698/IdeaProjects/hangman/src/main/resources/images/six.png");
                                imageHangman.setImage(image);
                                points = 0;
                                labelPoints.setText(String.valueOf(points));
                                lastfivegames.addlastfivegames(S, Tries, 0, 1, points);
                            }
                            PossibleWords.falseletter(splited[1].charAt(0), number);
                            ArrayList<percentageletterposition> list2 = PossibleWords.statistics();
                            listview.getItems().clear();
                            for (percentageletterposition plp : list2) {
                                listview.getItems().add(plp.toString());
                            }
                        }
                    }
                } catch (NumberFormatException nfe) {
                    statusChoose.setText("You need to write the position and a letter");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            statusChoose.setText("You need to write the position and a letter");
        }
    }
    public void buttonLoad(ActionEvent event) throws IOException{
        d.deleteDictionary();
        String text = ChooseDictionaryID.getText();
        String savePath = "src/main/resources/medialab/";
        File myObj = new File(savePath+text+".txt");
        Scanner scan = null;
        try {
            scan = new Scanner(myObj);
            if (myObj.exists()) {
                while(scan.hasNextLine()){
                    d.storeDictionary(scan.nextLine());
                }
                stage1.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            status2.setText("The file does not exist.");
        }
    }
    public void buttonAdd(ActionEvent event) throws IOException {
        try {
            String text = AddDictionaryID.getText();
            String url = "https://openlibrary.org/books/" + text + ".json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //Read JSON response
            JSONObject myResponse = new JSONObject(response.toString());
            JSONObject Description = myResponse.getJSONObject("description");
            String Value = (String) Description.get("value");
            Value = Value.toUpperCase();
            String[] description = Value.split("\\W+");
            HashSet<String> ar = new HashSet<String>(); //InvalidCountExeception
            for (String ss : description) {
                if (ss.length() >= 6) { //InvalidRangeException
                    ar.add(ss);
                }
            }
            int count1 = 0;
            int count2 = 0;
            for (String ss : ar) {
                if (ss.length() >= 6) {//InvalidRangeException
                    count1++;
                }
                if (ss.length() >= 9) {
                    count2++;
                }
            }
            /* UndersizeException */
            if (count1 < 20) {
                status.setText("Dictionary did not add because the words were less than 20");
            }
            /*UnbalancedException*/
            if (count2 <= (count1 / 5)) {
                status.setText("Dictionary did not add because the words longer than 9 letters were not enough");
            }
            if (count2 >= (count1 / 5) && count1 >= 20) {
                String savePath = "src/main/resources/medialab/";
                File myObj = new File(savePath + text + ".txt");
                if (myObj.createNewFile()) {
                    PrintWriter pw = new PrintWriter(myObj);
                    Iterator<String> it = ar.iterator();
                    while (it.hasNext()) {
                        pw.println(it.next());
                    }
                    status.setText("Dictionary added");
                    pw.close();
                    stage1.close();
                } else {
                    status.setText("Dictionary already exists.");
                }
            }
        }
        catch (FileNotFoundException e) {
            status.setText("Something went wrong.");
        }
    }

}