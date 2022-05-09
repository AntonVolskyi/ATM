package engine;

import display.ReceiptWindow;
import model.Receipt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptEngine implements ActionListener {

    ReceiptWindow receiptWindow;

    public ReceiptEngine(ReceiptWindow receiptWindow) {
        this.receiptWindow = receiptWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object action = e.getSource();

        if (action == receiptWindow.getSubmitButton()) {
            Receipt receipt = new Receipt(Receipt.ReceiptType.GETTING_MONEY);
            receipt.createAndPrintReceipt();
        }
        if (action == receiptWindow.getCancelButton()) {
            receiptWindow.getFrame().setVisible(false);
        }
    }
}
