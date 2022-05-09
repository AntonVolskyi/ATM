package display;

import engine.ActionWithSaveBalanceEngine;

import javax.swing.*;
import java.awt.*;

public class ActionWithSaveBalanceWindow {

    private JPanel mainWindow;
    private JPanel actionWrapper;
    private JPanel leftButtonWrapper;
    private JPanel rightButtonWrapper;
    private JPanel endWorkWrapper;
    private JFrame frame;
    private Dimension dimension;
    private JButton transfer100Button;
    private JButton transfer200Button;
    private JButton transfer500Button;
    private JButton transfer1000Button;
    private JButton inputSumButton;
    private JButton toActionSelectWindowButton;
    private JButton endWorkButton;
    private JButton checkBalanceButton;
    private ActionWithSaveBalanceEngine actionWithSaveBalanceEngine;

    public JPanel createActionWithSaveBalanceWindow() {

        mainWindow = new JPanel(new BorderLayout());
        frame = new JFrame("Select Action");
        dimension = new Dimension(700,500);
        transfer100Button = new JButton("Перевести 100");
        transfer200Button = new JButton("Перевести 200");
        transfer500Button = new JButton("Перевести 500");
        transfer1000Button = new JButton("Перевести 1000");
        inputSumButton = new JButton("Ввести суму переказу");
        toActionSelectWindowButton = new JButton("Повернутися до вікна вибору дії");
        endWorkButton = new JButton("Завершити сеанс");
        checkBalanceButton = new JButton("Перевірити баланс ощад. рахунку");
        actionWrapper = new JPanel(new FlowLayout());
        leftButtonWrapper = new JPanel(new GridLayout(2,1,10,20));
        rightButtonWrapper = new JPanel(new GridLayout(2,1,10,20));
        endWorkWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actionWithSaveBalanceEngine = new ActionWithSaveBalanceEngine(this);

        leftButtonWrapper.add(transfer100Button);
        leftButtonWrapper.add(transfer200Button);

        rightButtonWrapper.add(transfer500Button);
        rightButtonWrapper.add(transfer1000Button);

        actionWrapper.add(inputSumButton);
        actionWrapper.add(toActionSelectWindowButton);
        actionWrapper.add(checkBalanceButton);

        endWorkWrapper.add(endWorkButton);

        mainWindow.add("East", rightButtonWrapper);
        mainWindow.add("West", leftButtonWrapper);
        mainWindow.add("South", actionWrapper);
        mainWindow.add("North", endWorkWrapper);

        endWorkButton.addActionListener(actionWithSaveBalanceEngine);
        transfer100Button.addActionListener(actionWithSaveBalanceEngine);
        transfer200Button.addActionListener(actionWithSaveBalanceEngine);
        transfer500Button.addActionListener(actionWithSaveBalanceEngine);
        transfer1000Button.addActionListener(actionWithSaveBalanceEngine);
        toActionSelectWindowButton.addActionListener(actionWithSaveBalanceEngine);
        inputSumButton.addActionListener(actionWithSaveBalanceEngine);
        checkBalanceButton.addActionListener(actionWithSaveBalanceEngine);

        frame = new JFrame("ATM V 2.0");
        frame.add(mainWindow);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(dimension);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return mainWindow;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getTransfer100Button() {
        return transfer100Button;
    }

    public JButton getTransfer200Button() {
        return transfer200Button;
    }

    public JButton getTransfer500Button() {
        return transfer500Button;
    }

    public JButton getTransfer1000Button() {
        return transfer1000Button;
    }

    public JButton getInputSumButton() {
        return inputSumButton;
    }

    public JButton getToActionSelectWindowButton() {
        return toActionSelectWindowButton;
    }

    public JButton getEndWorkButton() {
        return endWorkButton;
    }

    public JButton getCheckBalanceButton() {
        return checkBalanceButton;
    }
}
