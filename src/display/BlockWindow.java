package display;

import engine.BlockEngine;

import javax.swing.*;
import java.awt.*;

public class BlockWindow {
    private JPanel mainWindow;
    private JPanel wrapperForMessage;
    private JPanel wrapperFroConfirmButton;
    private JLabel infoMessage;
    private JFrame frame;
    private JButton confirmButton;
    private BlockEngine blockEngine;

    public JPanel createBlockWindow() {
        mainWindow = new JPanel(new BorderLayout());
        wrapperForMessage = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 200));
        frame = new JFrame("Card blocked");
        confirmButton = new JButton("Підтвердити");
        wrapperFroConfirmButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        blockEngine = new BlockEngine(this);
        infoMessage = new JLabel("Ваша карта була заблокована. " +
                "Для допомоги звернітся за номером: +38(099)-**-**-*** " +
                "або у найближчий відділ банкомату");
        confirmButton.addActionListener(blockEngine);

        wrapperForMessage.add(infoMessage);

        wrapperFroConfirmButton.add(confirmButton);

        mainWindow.add(wrapperForMessage);
        mainWindow.add("South", wrapperFroConfirmButton);

        frame.add(mainWindow);
        frame.setSize(850, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return mainWindow;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}

