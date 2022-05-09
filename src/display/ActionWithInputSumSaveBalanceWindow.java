package display;

import engine.ActionWithInputSumSaveBalanceEngine;
import engine.GetInputMoneySumEngine;

import javax.swing.*;
import java.awt.*;

public class ActionWithInputSumSaveBalanceWindow {


    private JFrame frame;
    private JButton submitButton;
    private JButton cancelButton;
    private JLabel inputMessage;
    private JTextField inputField;
    private JPanel buttonWrapper;
    private JPanel messageWrapper;
    private JPanel wrapperButtonWrapper;
    private JPanel mainWindow;
    private ActionWithInputSumSaveBalanceEngine actionWithInputSumSaveBalanceEngine;

    public JPanel createActionWithInputSumSaveBalanceWindow() {
        frame = new JFrame("Input money sum");
        submitButton = new JButton("Підтвердити");
        cancelButton = new JButton("Відмінити");
        inputMessage = new JLabel("Введіть суму: ");
        inputField = new JTextField(10);
        buttonWrapper = new JPanel(new GridLayout(1,2,5,0));
        wrapperButtonWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        messageWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainWindow = new JPanel(new BorderLayout());
        actionWithInputSumSaveBalanceEngine = new ActionWithInputSumSaveBalanceEngine(this);

        buttonWrapper.add(submitButton);
        buttonWrapper.add(cancelButton);

        wrapperButtonWrapper.add(buttonWrapper);

        messageWrapper.add(inputMessage);
        messageWrapper.add(inputField);

        mainWindow.add("South", wrapperButtonWrapper);
        mainWindow.add(messageWrapper);

        submitButton.addActionListener(actionWithInputSumSaveBalanceEngine);
        cancelButton.addActionListener(actionWithInputSumSaveBalanceEngine);

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

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JTextField getInputField() {
        return inputField;
    }
}
