package engine;

import dao.BankDBReader;
import dao.BankDBWrighter;
import display.ActionSelectWindow;
import display.GetInputMoneySumWindow;
import display.GetMoneyWindow;
import display.ReceiptWindow;
import display.WelcomeWindow;
import model.Receipt;
import model.UserData;
import atmsafe.ATMSafe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetMoneyEngine implements ActionListener {

    private GetMoneyWindow getMoneyWindow;
    private BankDBReader dbReader;
    private BankDBWrighter dbWrighter;
    private ATMSafe strongbox;

    {
        dbReader = new BankDBReader();
        dbWrighter = new BankDBWrighter();
        strongbox = new ATMSafe();
    }

    public GetMoneyEngine() {
    }

    public GetMoneyEngine(GetMoneyWindow getMoneyWindow) {
        this.getMoneyWindow = getMoneyWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actions = e.getSource();

        if (actions == getMoneyWindow.getGet100Button()) {
            getSumFromCard(100);
            return;
        }
        if (actions == getMoneyWindow.getGet200Button()) {
            getSumFromCard(200);
            return;
        }
        if (actions == getMoneyWindow.getGet500Button()) {
            getSumFromCard(500);
            return;
        }
        if (actions == getMoneyWindow.getGet1000Button()) {
            getSumFromCard(1000);
            return;
        }
        if (actions == getMoneyWindow.getInputSumButton()) {
            GetInputMoneySumWindow getInputMoneySumWindow = new GetInputMoneySumWindow();
            getInputMoneySumWindow.createGetInputMoneySumWindow();
            return;
        }
        if (actions == getMoneyWindow.getEndWorkButton()) {
            JOptionPane.showConfirmDialog(null,
                    "Забрати карту із приймача",
                    "Take card",
                    JOptionPane.PLAIN_MESSAGE);
            getMoneyWindow.getFrame().setVisible(false);
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.createWelcomeWindow();
            return;
        }
        if (actions == getMoneyWindow.getToActionSelectWindowButton()) {
            getMoneyWindow.getFrame().setVisible(false);
            ActionSelectWindow actionSelectWindow = new ActionSelectWindow();
            actionSelectWindow.createActionSelectWindow();
            return;
        }
    }

    public void getSumFromCard(int sum) {
        String strCardBalance = dbReader.getCardBalance(UserData.CARD_NUMBER);
        double moneyInATM = strongbox.ATMMoneyReader();
        UserData.SUM_FOR_TAKING = sum;
        int cardBalance = Integer.parseInt(strCardBalance);

        if (sum > cardBalance) {
            JOptionPane.showConfirmDialog(null,
                    "На вашому рахунку недостатньо коштів",
                    "No money",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        } else if (moneyInATM < sum) {
            JOptionPane.showConfirmDialog(null,
                    "У банкоматі недостатньо коштів",
                    "No money",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }

        moneyInATM -= sum;
        strongbox.ATMMoneyWriter(moneyInATM);
        dbWrighter.setNewBalance(UserData.CARD_NUMBER, sum);

        JOptionPane.showConfirmDialog(null,
                "Візьміть гроші",
                "Take Money",
                JOptionPane.PLAIN_MESSAGE);

        ReceiptWindow receiptWindow = new ReceiptWindow(Receipt.ReceiptType.GETTING_MONEY);
        receiptWindow.createReceiptWindow();
    }
}
