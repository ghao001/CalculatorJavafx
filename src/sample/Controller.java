package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button ac;
    @FXML
    private Button del;
    @FXML
    private Button dot;
    @FXML
    private Button percent;
    @FXML
    private Button divide;
    @FXML
    private Button mult;
    @FXML
    private Button add;
    @FXML
    private Button minus;
    private Button[] digitals;
    @FXML
    private TextArea textArea;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button b0;
    private double result;
    private char op;
    private boolean reset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        result=0;
        reset=false;
    }

    public void handleButtonAction(ActionEvent event)
    {
        if(reset)
            textArea.setText("");
        String num=((Button)event.getSource()).getText();
        textArea.appendText(num);
        reset=false;
    }

    public void addAction(){
        equalAction();
        op = '+';
        result = Double.parseDouble(textArea.getText());
        reset=true;
    }
    public void minusAction(){
        equalAction();
        op = '-';
        result = Double.parseDouble(textArea.getText());
        reset=true;
    }
    public void multAction(){
        equalAction();
        op = '*';
        result = Double.parseDouble(textArea.getText());
        reset=true;
    }
    public void divideAction(){
        equalAction();
        op = '/';
        result = Double.parseDouble(textArea.getText());
        reset=true;
    }
    public void equalAction(){
        calculate(Double.parseDouble(textArea.getText()));
        textArea.setText(Double.toString(result));
        reset=true;
    }

    public void acAction(){
        result=0;
        op=' ';
        reset=false;
        textArea.setText("");

    }
    public void calculate(double inNum){
        switch (op){
            case '+':
                result+=inNum;
                break;
            case '-':
                result-=inNum;
                break;
            case '*':
                result*=inNum;
                break;
            case '/':
                result/=inNum;
                break;
            default:
                result = Double.parseDouble(textArea.getText());
        }

    }
}
