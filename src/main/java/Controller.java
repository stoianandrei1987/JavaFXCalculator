import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String foregroundString;
    private String backgroundString;
    private Operation operation;
    private Operation prevOperation;
    boolean changeString;
    private static int num = 1;


    @FXML
    GridPane gridPane;

    @FXML
    TextField field;

    public void update(String s) {


        switch (s) {

            case "+":
                operation = Operation.ADDITION;
                break;

            case "-":
                if(!field.getText().isBlank())
                operation = Operation.SUBTRACTION;
                else foregroundString+="-";
                break;

            case "*":
                operation = Operation.MULTIPLICATION;
                break;

            case "/":
                operation = Operation.DIVISION;
                break;

            case ".":
                if (!foregroundString.contains(".")) foregroundString += ".";
                break;

            case "=":
                foregroundString = perform(backgroundString, foregroundString, prevOperation);
                backgroundString = foregroundString;
                operation = null;
                break;

            default:
                if (operation != null) {
                    if (backgroundString == null || backgroundString.equals("")) {
                        backgroundString = foregroundString;
                        foregroundString = s;

                    } else {
                        backgroundString = perform(backgroundString, foregroundString, prevOperation);
                        foregroundString = s;

                    }
                    prevOperation = operation;
                    operation = null;
                } else foregroundString += s;
                break;
        }


        System.out.println("end update functions --->");
        System.out.println("backgroundStringEnd : " + backgroundString);
        System.out.println("foregroundStringEnd : " + foregroundString);
        System.out.println("operation is : " + operation);
        System.out.println("prevoperation is : " + prevOperation);
        System.out.println("----------------------------------------");
        System.out.println();

        num++;
        field.setText(foregroundString + (operation != null ? (" " + operation.toString()) : ""));
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
        backgroundString = null;
        operation = null;
        field.setText(foregroundString);
    }


    public static String perform(String operand1, String operand2, Operation op) {

        if (op == null || operand1 == null) return operand2;

        if (operand1.matches("\\s*") || operand1 == null) operand1 = "0";
        if (operand2.matches("\\s*") || operand2 == null) operand2 = "0";


        BigDecimal decimal1 = new BigDecimal(operand1), decimal2 = new BigDecimal(operand2);
        String res;

        switch (op) {

            case ADDITION:
                res = decimal1.add(decimal2).toString();
                break;
            case DIVISION:
                res = decimal1.divide(decimal2, 6, RoundingMode.FLOOR).toString();
                break;
            case SUBTRACTION:
                res = decimal1.subtract(decimal2).toString();
                break;
            case MULTIPLICATION:
                res = decimal1.multiply(decimal2).toString();
                break;
            default:
                if (operand1.equals("")) res = operand2;
                res = operand1;
                break;

        }


        if (res.matches("-?([0-9])+.(0)+")) return res.split("\\.")[0];
        else return res;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        foregroundString = "";
        backgroundString = null;
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
