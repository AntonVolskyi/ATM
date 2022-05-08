package engine;

import dao.BankDBReader;
import display.ActionSelectWindow;
import display.WelcomeWindow;
import model.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSelectEngine implements ActionListener {

    private ActionSelectWindow actionSelectWindow;
    private BankDBReader dbReader;

    public ActionSelectEngine(ActionSelectWindow actionSelectWindow) {
        this.actionSelectWindow = actionSelectWindow;
        dbReader = new BankDBReader();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action == actionSelectWindow.getGetMoneyButton()) {
            //TODO: Create window and engine for getting money from card
        }
        if (action == actionSelectWindow.getCheckBalanceButton()) {
            JOptionPane.showConfirmDialog(null,
                    "Баланс вашого рахунку\n"
                    + dbReader.getCardBalance(UserData.CARD_NUMBER),
                    "Card Balance",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (action == actionSelectWindow.getEndWorkButton()) {
            actionSelectWindow.getFrame().setVisible(false);
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.createWelcomeWindow();
            return;
        }
    }
}
