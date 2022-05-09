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
    private JButton getMoneyFromBalanceButton;
    private JButton startWorkWithSavingBalanceButton;
    private JButton endWorkButton;
    private JButton sentMoneyToAnotherCardButton;
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
        getMoneyFromBalanceButton = new JButton("Зняти кошти");
        endWorkButton = new JButton("Завершити сеанс");
        startWorkWithSavingBalanceButton = new JButton("Ощадний рахунок");
        sentMoneyToAnotherCardButton = new JButton("Переказ на іншу карту");
        message = new JLabel("Виберіть дію");
        frame = new JFrame("Select Action");
        dimension = new Dimension(700,500);
        actionSelectEngine = new ActionSelectEngine(this);

        messageWrapper.add(message);

        actionButtonWrapper.add(getMoneyFromBalanceButton);
        actionButtonWrapper.add(checkBalanceButton);
        actionButtonWrapper.add(startWorkWithSavingBalanceButton);
        actionButtonWrapper.add(sentMoneyToAnotherCardButton);

        getMoneyFromBalanceButton.addActionListener(actionSelectEngine);
        checkBalanceButton.addActionListener(actionSelectEngine);
        endWorkButton.addActionListener(actionSelectEngine);
        startWorkWithSavingBalanceButton.addActionListener(actionSelectEngine);
        sentMoneyToAnotherCardButton.addActionListener(actionSelectEngine);

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

    public JButton getGetMoneyFromBalanceButton() {
        return getMoneyFromBalanceButton;
    }

    public JButton getEndWorkButton() {
        return endWorkButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getStartWorkWithSavingBalanceButton() {
        return startWorkWithSavingBalanceButton;
    }

    public JButton getSentMoneyToAnotherCardButton() {
        return sentMoneyToAnotherCardButton;
    }
}
