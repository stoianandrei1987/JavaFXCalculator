import javafx.event.ActionEvent;

import java.math.BigDecimal;

public class Controller {

    public void btnOnePressed(ActionEvent actionEvent) {

    }

    public void btnTwoPressed(ActionEvent actionEvent) {
    }

    public void btnThreePressed(ActionEvent actionEvent) {
    }

    public void btnPlusPressed(ActionEvent actionEvent) {
    }

    public void btnFourPressed(ActionEvent actionEvent) {
    }

    public void btnFivePressed(ActionEvent actionEvent) {
    }

    public void btnSixPressed(ActionEvent actionEvent) {
    }

    public void btnSevenPressed(ActionEvent actionEvent) {
    }

    public void btnEightPressed(ActionEvent actionEvent) {
    }

    public void btnNinePressed(ActionEvent actionEvent) {
    }

    public void btnZeroPressed(ActionEvent actionEvent) {
    }


    public void btnMinusPressed(ActionEvent actionEvent) {
    }

    public void btnMultiplyPressed(ActionEvent actionEvent) {
    }

    public void btnEqualPressed(ActionEvent actionEvent) {
    }


    public void btnDividePressed(ActionEvent actionEvent) {
    }

    public void btnDotPressed(ActionEvent actionEvent) {
    }

    public void btnCLPressed(ActionEvent actionEvent) {
    }

    public static String perform(String operand1, String operand2, Operation op) {

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
            default: return "error";

        }

    }

}
