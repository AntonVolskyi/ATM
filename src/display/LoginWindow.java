package display;

import dao.BankDBReader;
import engine.LoginEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class LoginWindow {

    private JPanel mainWindow;
    private BankDBReader dbReader;
    private JPanel loginPanel;
    private JPanel loginWrapperPanel;
    private JPanel dataInputPanel;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel cardMessage;
    private JLabel passwordMessage;
    private JFrame frame;
    private JComboBox<String> inputCardNumber;
    private JPasswordField inputPin;
    private ArrayList<String> cardNumberList;
    private LoginEngine loginEngine;

    public LoginWindow() {
        dbReader = new BankDBReader();
    }

    public JPanel createLoginWindow() {
        cardNumberList = dbReader.getCardNumbers();
        loginPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        loginWrapperPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dataInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainWindow = new JPanel(new BorderLayout());;
        loginButton = new JButton("Підтвердити");
        cancelButton = new JButton("Відмінити");
        cardMessage = new JLabel("Вибір карти: ");
        passwordMessage = new JLabel("     Введіть PIN: ");
        frame = new JFrame("Login");
        inputCardNumber = new JComboBox(cardNumberList.toArray());
        inputPin = new JPasswordField(10);
        loginEngine = new LoginEngine(this);

        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);

        loginWrapperPanel.add(loginPanel);

        dataInputPanel.add(cardMessage);
        dataInputPanel.add(inputCardNumber);
        dataInputPanel.add(passwordMessage);
        dataInputPanel.add(inputPin);

        mainWindow.add("South", loginWrapperPanel);
        mainWindow.add(dataInputPanel);

        loginButton.addActionListener(loginEngine);
        cancelButton.addActionListener(loginEngine);

        inputPin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (inputPin.getText().length() >= 4) e.consume();
            }
        });

        frame.add(mainWindow);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return mainWindow;
    }

    public BankDBReader getDbReader() {
        return dbReader;
    }

    public void setDbReader(BankDBReader dbReader) {
        this.dbReader = dbReader;
    }

    public LoginEngine getLoginEngine() {
        return loginEngine;
    }

    public void setLoginEngine(LoginEngine loginEngine) {
        this.loginEngine = loginEngine;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public ArrayList<String> getCardNumberList() {
        return cardNumberList;
    }

    public void setCardNumberList(ArrayList<String> cardNumberList) {
        this.cardNumberList = cardNumberList;
    }

    public JPanel getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(JPanel mainWindow) {
        this.mainWindow = mainWindow;
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public JPanel getLoginWrapperPanel() {
        return loginWrapperPanel;
    }

    public void setLoginWrapperPanel(JPanel loginWrapperPanel) {
        this.loginWrapperPanel = loginWrapperPanel;
    }

    public JPanel getDataInputPanel() {
        return dataInputPanel;
    }

    public void setDataInputPanel(JPanel dataInputPanel) {
        this.dataInputPanel = dataInputPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JLabel getCardMessage() {
        return cardMessage;
    }

    public void setCardMessage(JLabel cardMessage) {
        this.cardMessage = cardMessage;
    }

    public JLabel getPasswordMessage() {
        return passwordMessage;
    }

    public void setPasswordMessage(JLabel passwordMessage) {
        this.passwordMessage = passwordMessage;
    }

    public JComboBox<String> getInputCardNumber() {
        return inputCardNumber;
    }

    public void setInputCardNumber(JComboBox<String> inputCardNumber) {
        this.inputCardNumber = inputCardNumber;
    }

    public JPasswordField getInputPin() {
        return inputPin;
    }

    public void setInputPin(JPasswordField inputPin) {
        this.inputPin = inputPin;
    }
}
