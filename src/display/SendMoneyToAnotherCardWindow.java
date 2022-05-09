package display;

import engine.SendMoneyToAnotherCardEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SendMoneyToAnotherCardWindow {

    private JPanel mainWindow;
    private JPanel loginPanel;
    private JPanel loginWrapperPanel;
    private JPanel dataInputPanel;
    private JButton sendButton;
    private JButton cancelButton;
    private JLabel cardMessage;
    private JLabel sumMessage;
    private JFrame frame;
    private JTextField inputCardNumber;
    private JTextField inputSum;
    private SendMoneyToAnotherCardEngine sendMoneyToAnotherCardEngine;

    public JPanel createSendMoneyToAnotherCardWindow() {
        loginPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        loginWrapperPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dataInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainWindow = new JPanel(new BorderLayout());;
        sendButton = new JButton("Підтвердити");
        cancelButton = new JButton("Відмінити");
        cardMessage = new JLabel("Номер карти: ");
        sumMessage = new JLabel("     Сума переказу: ");
        frame = new JFrame("Send money");
        sendMoneyToAnotherCardEngine = new SendMoneyToAnotherCardEngine(this);
        inputSum = new JTextField(10);
        inputCardNumber = new JTextField(15);

        loginPanel.add(sendButton);
        loginPanel.add(cancelButton);

        loginWrapperPanel.add(loginPanel);

        dataInputPanel.add(cardMessage);
        dataInputPanel.add(inputCardNumber);
        dataInputPanel.add(sumMessage);
        dataInputPanel.add(inputSum);

        mainWindow.add("South", loginWrapperPanel);
        mainWindow.add(dataInputPanel);

        sendButton.addActionListener(sendMoneyToAnotherCardEngine);
        cancelButton.addActionListener(sendMoneyToAnotherCardEngine);

        frame.add(mainWindow);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return mainWindow;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getInputCardNumber() {
        return inputCardNumber;
    }

    public JTextField getInputSum() {
        return inputSum;
    }
}
