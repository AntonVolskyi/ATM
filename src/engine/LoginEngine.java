package engine;

import dao.BankDBReader;
import display.ActionSelectWindow;
import display.BlockWindow;
import display.LoginWindow;
import display.WelcomeWindow;
import model.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginEngine implements ActionListener {

    private LoginWindow loginWindow;
    private BankDBReader dbReader;
    private int attempt = 3;

    public LoginEngine(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        dbReader = new BankDBReader();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action == loginWindow.getLoginButton()) {
            loginAction();
            return;
        }
        if (action == loginWindow.getCancelButton()) {
            loginWindow.getFrame().setVisible(false);
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.createWelcomeWindow();
        }
    }

    private void loginAction() {
        int cardIndex = loginWindow.getInputCardNumber().getSelectedIndex();
        String cardNumber = loginWindow.getCardNumberList().get(cardIndex);
        String pin = loginWindow.getInputPin().getText();

        if (pin.length() < 4) {
            JOptionPane.showConfirmDialog(null,
                    "Введенний пароль некоректний",
                    "INCORRECT!",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (dbReader.isCorrectPassword(cardNumber, pin)) {
            loginWindow.getFrame().setVisible(false);
            ActionSelectWindow actionSelectWindow = new ActionSelectWindow();
            actionSelectWindow.createActionSelectionDisplay();
            UserData.CARD_NUMBER = cardNumber;
        } else {
            attempt--;
            if (attempt == 0) {
                BlockWindow blockWindow = new BlockWindow();
                blockWindow.createBlockWindow();
                loginWindow.getFrame().setVisible(false);
                attempt = 3;
            } else {
                JOptionPane.showConfirmDialog(null,
                        "Ви ввели неправильний пароль.\n" +
                                "Залишилося спроб вводу " + attempt,
                        "INCORRECT!",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
