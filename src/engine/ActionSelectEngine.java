package engine;

import dao.BankDBReader;
import display.ActionSelectWindow;
import display.ActionWithSaveBalanceWindow;
import display.GetMoneyWindow;
import display.SendMoneyToAnotherCardWindow;
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

        if (action == actionSelectWindow.getGetMoneyFromBalanceButton()) {
            GetMoneyWindow getMoneyWindow = new GetMoneyWindow();
            getMoneyWindow.createGetMoneyWindow();
            actionSelectWindow.getFrame().setVisible(false);
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
            JOptionPane.showConfirmDialog(null,
                    "Забрати карту із приймача",
                    "Take card",
                    JOptionPane.PLAIN_MESSAGE);
            actionSelectWindow.getFrame().setVisible(false);
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.createWelcomeWindow();
            return;
        }
        if (action == actionSelectWindow.getStartWorkWithSavingBalanceButton()) {
            actionSelectWindow.getFrame().setVisible(false);
            ActionWithSaveBalanceWindow actionWithSaveBalanceWindow = new ActionWithSaveBalanceWindow();
            actionWithSaveBalanceWindow.createActionWithSaveBalanceWindow();
            return;
        }
        if (action == actionSelectWindow.getSentMoneyToAnotherCardButton()) {
            SendMoneyToAnotherCardWindow sendMoneyToAnotherCardWindow = new SendMoneyToAnotherCardWindow();
            sendMoneyToAnotherCardWindow.createSendMoneyToAnotherCardWindow();
            actionSelectWindow.getFrame().setVisible(false);
        }
    }
}
