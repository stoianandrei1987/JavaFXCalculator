import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String foregroundString;
    private String backgroundString;
    private Operation operation;
    boolean changeString;

    @FXML
    GridPane gridPane;

    @FXML
    TextField field;

    public void update(String s) {
        switch (s) {

            case "+":
                if (!foregroundString.equals("")) foregroundString += " +";
                operation = Operation.ADDITION;
                changeString = true;

                break;
            case "-":
                if (!foregroundString.equals("")) {
                    foregroundString = " -";
                    operation = Operation.SUBTRACTION;
                    changeString = true;

                } else {
                    foregroundString += "-";
                };
                break;
            case "*":
                if (!foregroundString.equals("")) {
                    foregroundString = " *";
                    changeString = true;

                }

                operation = Operation.MULTIPLICATION;
                break;
            case "/":
                if (!foregroundString.equals("")) {
                    foregroundString = " /";
                    changeString = true;

                }

                operation = Operation.DIVISION;
                break;
            case ".":
                if (!foregroundString.contains(".")) foregroundString += ".";
            case "=":
                if(backgroundString.equals("")) backgroundString = "0";
                foregroundString = perform(backgroundString, foregroundString, operation);
                break;
            default:
                if (foregroundString.equals("0")) foregroundString = s;
                else {
                    if(changeString == true) {
                        backgroundString = perform(backgroundString, foregroundString, operation);
                        foregroundString = "";
                        changeString = false;

                    }
                    foregroundString+=s;

                }

                break;

        } field.setText(foregroundString);
    }

    public void btnOnePressed(ActionEvent actionEvent) {
        update("1");
    }


    public void btnTwoPressed(ActionEvent actionEvent) {
        update("2");
    }


    public void btnThreePressed(ActionEvent actionEvent) {
        update("3");
    }


    public void btnFourPressed(ActionEvent actionEvent) {
        update("4");
    }


    public void btnFivePressed(ActionEvent actionEvent) {
        update("5");
    }


    public void btnSixPressed(ActionEvent actionEvent) {
        update("6");
    }


    public void btnSevenPressed(ActionEvent actionEvent) {
        update("7");
    }


    public void btnEightPressed(ActionEvent actionEvent) {
        update("8");
    }

    public void btnNinePressed(ActionEvent actionEvent) {
        update("9");
    }


    public void btnZeroPressed(ActionEvent actionEvent) {
        update("0");
    }


    public void btnPlusPressed(ActionEvent actionEvent) {
        update("+");
    }


    public void btnMinusPressed(ActionEvent actionEvent) {
        update("-");
    }


    public void btnMultiplyPressed(ActionEvent actionEvent) {
        update("*");
    }


    public void btnEqualPressed(ActionEvent actionEvent) {
        update("=");
    }


    public void btnDividePressed(ActionEvent actionEvent) {
        update("/");
    }


    public void btnDotPressed(ActionEvent actionEvent) {
        update(".");
    }


    public void btnCLPressed(ActionEvent actionEvent) {
        foregroundString = "";
        backgroundString = "";
        operation = null;
        field.setText(foregroundString);
    }

    public static String perform(String operand1, String operand2, Operation op) {

        if(operand1.equals("")) operand1 = "0";
        if(operand2.equals("")) operand1 = "0";
        operand1 = operand1.split(" ")[0];
        operand2 = operand2.split(" ")[0];

        BigDecimal decimal1 = new BigDecimal(operand1), decimal2 = new BigDecimal(operand2);
        switch (op) {
            case ADDITION:
                return decimal1.add(decimal2).toString();
            case DIVISION:
                return decimal1.divide(decimal2).toString();
            case SUBTRACTION:
                return decimal1.subtract(decimal2).toString();
            case MULTIPLICATION:
                return decimal1.multiply(decimal2).toString();
            default:
                return "error";

        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        foregroundString = "";
        backgroundString = "";
        operation = null;
        changeString = false;

        gridPane.addEventFilter(KeyEvent.KEY_TYPED, (event) -> {

            switch (event.getCharacter()) {

                case "-":
                    btnMinusPressed(null);
                    break;
                case "+":
                    btnPlusPressed(null);
                    break;
                case "/":
                    btnDividePressed(null);
                    break;
                case "*":
                    btnMultiplyPressed(null);
                    break;
                case "1":
                    btnOnePressed(null);
                    break;
                case "2":
                    btnTwoPressed(null);
                    break;
                case "3":
                    btnThreePressed(null);
                    break;
                case "4":
                    btnFourPressed(null);
                    break;
                case "5":
                    btnFivePressed(null);
                    break;
                case "6":
                    btnSixPressed(null);
                    break;
                case "7":
                    btnSevenPressed(null);
                    break;
                case "8":
                    btnEightPressed(null);
                    break;
                case "9":
                    btnNinePressed(null);
                    break;
                case "0":
                    btnZeroPressed(null);
                    break;
                case "=":
                    btnEqualPressed(null);
                    break;
                default:
                    break;

            }
        });
    }


}
