package display;

import engine.GetMoneyEngine;

import javax.swing.*;
import java.awt.*;

public class GetMoneyWindow {

    private JPanel mainWindow;
    private JPanel actionWrapper;
    private JPanel leftButtonWrapper;
    private JPanel rightButtonWrapper;
    private JPanel endWorkWrapper;
    private JFrame frame;
    private Dimension dimension;
    private JButton get100Button;
    private JButton get200Button;
    private JButton get500Button;
    private JButton get1000Button;
    private JButton inputSumButton;
    private JButton toActionSelectWindowButton;
    private JButton endWorkButton;
    private GetMoneyEngine getMoneyEngine;

    public JPanel createGetMoneyWindow() {
        mainWindow = new JPanel(new BorderLayout());
        frame = new JFrame("Select Action");
        dimension = new Dimension(700,500);
        get100Button = new JButton("Зняти 100");
        get200Button = new JButton("Зняти 200");
        get500Button = new JButton("зняти 500");
        get1000Button = new JButton("Зняти 1000");
        inputSumButton = new JButton("Ввести суму");
        toActionSelectWindowButton = new JButton("Повернутися до вікна вибору дії");
        endWorkButton = new JButton("Завершити сеанс");
        actionWrapper = new JPanel(new FlowLayout());
        leftButtonWrapper = new JPanel(new GridLayout(2,1,10,20));
        rightButtonWrapper = new JPanel(new GridLayout(2,1,10,20));
        endWorkWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        getMoneyEngine = new GetMoneyEngine(this);

        leftButtonWrapper.add(get100Button);
        leftButtonWrapper.add(get200Button);

        rightButtonWrapper.add(get500Button);
        rightButtonWrapper.add(get1000Button);

        actionWrapper.add(inputSumButton);
        actionWrapper.add(toActionSelectWindowButton);

        endWorkWrapper.add(endWorkButton);

        mainWindow.add("East", rightButtonWrapper);
        mainWindow.add("West", leftButtonWrapper);
        mainWindow.add("South", actionWrapper);
        mainWindow.add("North", endWorkWrapper);

        get100Button.addActionListener(getMoneyEngine);
        get200Button.addActionListener(getMoneyEngine);
        get500Button.addActionListener(getMoneyEngine);
        get1000Button.addActionListener(getMoneyEngine);
        endWorkButton.addActionListener(getMoneyEngine);
        toActionSelectWindowButton.addActionListener(getMoneyEngine);
        inputSumButton.addActionListener(getMoneyEngine);

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

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getGet100Button() {
        return get100Button;
    }

    public void setGet100Button(JButton get100Button) {
        this.get100Button = get100Button;
    }

    public JButton getGet200Button() {
        return get200Button;
    }

    public void setGet200Button(JButton get200Button) {
        this.get200Button = get200Button;
    }

    public JButton getGet500Button() {
        return get500Button;
    }

    public void setGet500Button(JButton get500Button) {
        this.get500Button = get500Button;
    }

    public JButton getGet1000Button() {
        return get1000Button;
    }

    public void setGet1000Button(JButton get1000Button) {
        this.get1000Button = get1000Button;
    }

    public JButton getInputSumButton() {
        return inputSumButton;
    }

    public void setInputSumButton(JButton inputSumButton) {
        this.inputSumButton = inputSumButton;
    }

    public JButton getToActionSelectWindowButton() {
        return toActionSelectWindowButton;
    }

    public void setToActionSelectWindowButton(JButton toActionSelectWindowButton) {
        this.toActionSelectWindowButton = toActionSelectWindowButton;
    }

    public JButton getEndWorkButton() {
        return endWorkButton;
    }

    public void setEndWorkButton(JButton endWorkButton) {
        this.endWorkButton = endWorkButton;
    }
}
