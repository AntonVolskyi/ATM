package engine;

import dao.BankDBReader;
import dao.BankDBWrighter;
import display.ActionSelectWindow;
import display.ReceiptWindow;
import display.SendMoneyToAnotherCardWindow;
import model.Receipt;
import model.RecipientData;
import model.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMoneyToAnotherCardEngine implements ActionListener {

    private SendMoneyToAnotherCardWindow sendMoneyToAnotherCardWindow;
    private BankDBReader dbReader;
    private BankDBWrighter dbWrighter;

    {
        dbReader = new BankDBReader();
        dbWrighter = new BankDBWrighter();
    }

    public SendMoneyToAnotherCardEngine(SendMoneyToAnotherCardWindow sendMoneyToAnotherCardWindow) {
        this.sendMoneyToAnotherCardWindow = sendMoneyToAnotherCardWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action == sendMoneyToAnotherCardWindow.getCancelButton()) {
            ActionSelectWindow actionSelectWindow = new ActionSelectWindow();
            actionSelectWindow.createActionSelectWindow();
            sendMoneyToAnotherCardWindow.getFrame().setVisible(false);
            return;
        }
        if (action == sendMoneyToAnotherCardWindow.getSendButton()) {
            String strCardNumber = sendMoneyToAnotherCardWindow.getInputCardNumber().getText();

            if (!dbReader.isCardExist(strCardNumber)) {
                JOptionPane.showConfirmDialog(null,
                        "Немає даних по введеній вами карті\n" +
                        "Перевірте введені дані",
                        "INCORRECT!",
                        JOptionPane.PLAIN_MESSAGE);
                return;
            }

            RecipientData.CARD_NUMBER = strCardNumber;
            String strSum = sendMoneyToAnotherCardWindow.getInputSum().getText();;
            int sum = Integer.parseInt(strSum);
            UserData.SUM_FOR_TAKING = sum;

            if (Integer.parseInt(dbReader.getCardBalance(UserData.CARD_NUMBER)) < sum) {
                JOptionPane.showConfirmDialog(null,
                        "На вашому балансі недостатньо коштів",
                        "INCORRECT!",
                        JOptionPane.PLAIN_MESSAGE);
                return;
            }

            dbWrighter.setNewBalanceForSender(UserData.CARD_NUMBER, sum);
            dbWrighter.setNewBalanceForRecipient(RecipientData.CARD_NUMBER, sum);
            sendMoneyToAnotherCardWindow.getFrame().setVisible(false);
            ActionSelectWindow actionSelectWindow = new ActionSelectWindow();
            actionSelectWindow.createActionSelectWindow();
            ReceiptWindow receiptWindow = new ReceiptWindow(Receipt.ReceiptType.TANSF_TO_ANOTHER_CARD);
            receiptWindow.createReceiptWindow();
        }
    }
}
