package display;

import engine.WelcomeEngine;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow {

    private JPanel mainWindow;
    private JPanel loginButtonWrapper;
    private JPanel messageWrapper;
    private JButton loginButton;
    private JLabel message;
    private Dimension dimension;
    private JFrame frame;
    private WelcomeEngine welcomeEngine;

    public JPanel createWelcomeWindow() {
        mainWindow = new JPanel(new BorderLayout());
        loginButtonWrapper = new JPanel(new FlowLayout());
        messageWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 200));
        message = new JLabel("Вставте карту в приймач");
        loginButton = new JButton("Вставити карту");
        dimension = new Dimension(700,500);
        welcomeEngine = new WelcomeEngine(this);

        loginButtonWrapper.add(loginButton);

        messageWrapper.add(message);

        mainWindow.add("South", loginButtonWrapper);
        mainWindow.add(messageWrapper);

        loginButton.addActionListener(welcomeEngine);

        frame = new JFrame("ATM V 2.0");
        frame.add(mainWindow);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(dimension);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return mainWindow;
    }

    public WelcomeEngine getWelcomeEngine() {
        return welcomeEngine;
    }

    public void setWelcomeEngine(WelcomeEngine welcomeEngine) {
        this.welcomeEngine = welcomeEngine;
    }

    public JPanel getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(JPanel mainWindow) {
        this.mainWindow = mainWindow;
    }

    public JPanel getLoginButtonWrapper() {
        return loginButtonWrapper;
    }

    public void setLoginButtonWrapper(JPanel loginButtonWrapper) {
        this.loginButtonWrapper = loginButtonWrapper;
    }

    public JPanel getMessageWrapper() {
        return messageWrapper;
    }

    public void setMessageWrapper(JPanel messageWrapper) {
        this.messageWrapper = messageWrapper;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JLabel getMessage() {
        return message;
    }

    public void setMessage(JLabel message) {
        this.message = message;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
