package display;

import engine.GetInputMoneySumEngine;

import javax.swing.*;
import java.awt.*;

public class GetInputMoneySumWindow {

    private JFrame frame;
    private JButton submitButton;
    private JButton cancelButton;
    private JLabel inputMessage;
    private JLabel errorMessage;
    private JTextField inputField;
    private JPanel buttonWrapper;
    private JPanel messageWrapper;
    private JPanel wrapperButtonWrapper;
    private JPanel mainWindow;
    private GetInputMoneySumEngine getInputMoneySumEngine;

    public JPanel createGetInputMoneySumWindow() {
        frame = new JFrame("Input money sum");
        submitButton = new JButton("Підтвердити");
        cancelButton = new JButton("Відмінити");
        inputMessage = new JLabel("Введіть суму: ");
        errorMessage = new JLabel("Сума повина бути кратна 10");
        inputField = new JTextField(10);
        buttonWrapper = new JPanel(new GridLayout(1,2,5,0));
        wrapperButtonWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        messageWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainWindow = new JPanel(new BorderLayout());
        getInputMoneySumEngine = new GetInputMoneySumEngine(this);

        buttonWrapper.add(submitButton);
        buttonWrapper.add(cancelButton);

        wrapperButtonWrapper.add(buttonWrapper);

        messageWrapper.add(inputMessage);
        messageWrapper.add(inputField);
        messageWrapper.add(errorMessage);

        mainWindow.add("South", wrapperButtonWrapper);
        mainWindow.add(messageWrapper);

        submitButton.addActionListener(getInputMoneySumEngine);
        cancelButton.addActionListener(getInputMoneySumEngine);

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

    public JTextField getInputField() {
        return inputField;
    }

    public void setInputField(JTextField inputField) {
        this.inputField = inputField;
    }
}
