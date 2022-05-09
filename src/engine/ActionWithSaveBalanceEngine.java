package engine;

import dao.BankDBReader;
import dao.BankDBWrighter;
import display.ActionSelectWindow;
import display.ActionWithInputSumSaveBalanceWindow;
import display.ActionWithSaveBalanceWindow;
import display.ReceiptWindow;
import display.WelcomeWindow;
import model.Receipt;
import model.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionWithSaveBalanceEngine implements ActionListener {

    private ActionWithSaveBalanceWindow actionWithSaveBalanceWindow;
    private BankDBReader dbReader;
    private BankDBWrighter dbWrighter;

    {
        dbReader = new BankDBReader();
        dbWrighter = new BankDBWrighter();
    }

    public ActionWithSaveBalanceEngine() {
    }

    public ActionWithSaveBalanceEngine(ActionWithSaveBalanceWindow actionWithSaveBalanceWindow) {
        this.actionWithSaveBalanceWindow = actionWithSaveBalanceWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object action = e.getSource();

        if (action == actionWithSaveBalanceWindow.getToActionSelectWindowButton()) {
            actionWithSaveBalanceWindow.getFrame().setVisible(false);
            ActionSelectWindow actionSelectWindow = new ActionSelectWindow();
            actionSelectWindow.createActionSelectWindow();
            return;
        }
        if (action == actionWithSaveBalanceWindow.getEndWorkButton()) {
            JOptionPane.showConfirmDialog(null,
                    "Забрати карту із приймача",
                    "Take card",
                    JOptionPane.PLAIN_MESSAGE);
            actionWithSaveBalanceWindow.getFrame().setVisible(false);
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.createWelcomeWindow();
            return;
        }
        if (action == actionWithSaveBalanceWindow.getTransfer100Button()) {
            transferMoneyToSaveBalance(100);
            return;
        }
        if (action == actionWithSaveBalanceWindow.getTransfer200Button()) {
            transferMoneyToSaveBalance(200);
            return;
        }
        if (action == actionWithSaveBalanceWindow.getTransfer500Button()) {
            transferMoneyToSaveBalance(500);
            return;
        }
        if (action == actionWithSaveBalanceWindow.getTransfer1000Button()) {
            transferMoneyToSaveBalance(1000);
            return;
        }
        if (action == actionWithSaveBalanceWindow.getCheckBalanceButton()) {
            String cardSaveBalance = dbReader.getCardSaveBalance(UserData.CARD_NUMBER);
            JOptionPane.showConfirmDialog(null,
                    "Баланс ощад. рахунку\n" +
                    cardSaveBalance,
                    "Save balance",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (action == actionWithSaveBalanceWindow.getInputSumButton()) {
            ActionWithInputSumSaveBalanceWindow actionWithInputSumSaveBalanceWindow = new ActionWithInputSumSaveBalanceWindow();
            actionWithInputSumSaveBalanceWindow.createActionWithInputSumSaveBalanceWindow();
        }
    }

    public void transferMoneyToSaveBalance(int sum) {
        String strCardBalance = dbReader.getCardBalance(UserData.CARD_NUMBER);
        UserData.SUM_FOR_TAKING = sum;
        int cardBalance = Integer.parseInt(strCardBalance);

        if (sum > cardBalance) {
            JOptionPane.showConfirmDialog(null,
                    "На вашому рахунку недостатньо коштів",
                    "No money",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }

        dbWrighter.setNewSaveBalance(UserData.CARD_NUMBER, sum);
        ReceiptWindow receiptWindow = new ReceiptWindow(Receipt.ReceiptType.TRANSF_TO_SAVE_BALANCE);
        receiptWindow.createReceiptWindow();
    }
}
