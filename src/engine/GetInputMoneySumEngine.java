package engine;

import display.GetInputMoneySumWindow;
import display.GetMoneyWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetInputMoneySumEngine implements ActionListener {

    GetInputMoneySumWindow getInputMoneySumWindow;

    public GetInputMoneySumEngine(GetInputMoneySumWindow getInputMoneySumWindow) {
        this.getInputMoneySumWindow = getInputMoneySumWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();
        String strSum = getInputMoneySumWindow.getInputField().getText();;
        int sum = Integer.parseInt(strSum);

        if (action == getInputMoneySumWindow.getSubmitButton()) {
            if ((sum % 10) != 0) {
                JOptionPane.showConfirmDialog(null,
                        "ВВЕДІТЬ СУМУ КРАТНУ 10",
                        "WARN!",
                        JOptionPane.PLAIN_MESSAGE);
                return;
            }
            GetMoneyEngine getMoneyEngine = new GetMoneyEngine();
            getMoneyEngine.getSumFromCard(sum);
            getInputMoneySumWindow.getFrame().setVisible(false);
            return;
        }
        if (action == getInputMoneySumWindow.getCancelButton()) {
            getInputMoneySumWindow.getFrame().setVisible(false);
            GetMoneyWindow getMoneyWindow = new GetMoneyWindow();
            getMoneyWindow.createGetMoneyWindow();
        }
    }
}
