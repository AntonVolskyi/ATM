package display;

import engine.ActionSelectEngine;

import javax.swing.*;
import java.awt.*;

public class ActionSelectWindow {

    private JPanel mainWindow;
    private JPanel actionButtonWrapper;
    private JPanel messageWrapper;
    private JPanel endWorkWrapper;
    private JButton checkBalanceButton;
    private JButton getMoneyButton;
    private JButton endWorkButton;
    private JLabel message;
    private JFrame frame;
    private Dimension dimension;
    private ActionSelectEngine actionSelectEngine;

    public JPanel createActionSelectWindow() {
        mainWindow = new JPanel(new BorderLayout());
        actionButtonWrapper = new JPanel(new FlowLayout());
        messageWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 200));
        endWorkWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        checkBalanceButton = new JButton("Перевірити залишок");
        getMoneyButton = new JButton("Зняти кошти");
        endWorkButton = new JButton("Завершити сеанс");
        message = new JLabel("Виберіть дію");
        frame = new JFrame("Select Action");
        dimension = new Dimension(700,500);
        actionSelectEngine = new ActionSelectEngine(this);

        messageWrapper.add(message);

        actionButtonWrapper.add(getMoneyButton);
        actionButtonWrapper.add(checkBalanceButton);

        getMoneyButton.addActionListener(actionSelectEngine);
        checkBalanceButton.addActionListener(actionSelectEngine);
        endWorkButton.addActionListener(actionSelectEngine);

        endWorkWrapper.add(endWorkButton);

        mainWindow.add("South", actionButtonWrapper);
        mainWindow.add("North", endWorkWrapper);
        mainWindow.add(messageWrapper);

        frame = new JFrame("ATM V 2.0");
        frame.add(mainWindow);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(dimension);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return mainWindow;
    }

    public JButton getCheckBalanceButton() {
        return checkBalanceButton;
    }

    public void setCheckBalanceButton(JButton checkBalanceButton) {
        this.checkBalanceButton = checkBalanceButton;
    }

    public JButton getGetMoneyButton() {
        return getMoneyButton;
    }

    public void setGetMoneyButton(JButton getMoneyButton) {
        this.getMoneyButton = getMoneyButton;
    }

    public JButton getEndWorkButton() {
        return endWorkButton;
    }

    public void setEndWorkButton(JButton endWorkButton) {
        this.endWorkButton = endWorkButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
