package display;

import engine.ReceiptEngine;

import javax.swing.*;
import java.awt.*;

public class ReceiptWindow {

    private JFrame frame;
    private JButton submitButton;
    private JButton cancelButton;
    private JLabel message;
    private JPanel buttonWrapper;
    private JPanel wrapperButtonWrapper;
    private JPanel messageWrapper;
    private JPanel mainWindow;
    private ReceiptEngine receiptEngine;

    public JPanel createReceiptWindow() {

        frame = new JFrame("Take receipt");
        submitButton = new JButton("Підтвердити");
        cancelButton = new JButton("Відмінити");
        message = new JLabel("Видрукувати квитанцію?");
        buttonWrapper = new JPanel(new GridLayout(1,2,5,0));
        wrapperButtonWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        messageWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainWindow = new JPanel(new BorderLayout());
        receiptEngine = new ReceiptEngine(this);

        buttonWrapper.add(submitButton);
        buttonWrapper.add(cancelButton);

        wrapperButtonWrapper.add(buttonWrapper);

        messageWrapper.add(message);

        mainWindow.add("South", wrapperButtonWrapper);
        mainWindow.add(messageWrapper);

        submitButton.addActionListener(receiptEngine);
        cancelButton.addActionListener(receiptEngine);

        frame.add(mainWindow);
        frame.setSize(300,150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return mainWindow;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }
}
