package engine;

import display.ActionWithInputSumSaveBalanceWindow;
import display.ActionWithSaveBalanceWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionWithInputSumSaveBalanceEngine implements ActionListener {

    ActionWithInputSumSaveBalanceWindow actionWithInputSumSaveBalanceWindow;

    public ActionWithInputSumSaveBalanceEngine(ActionWithInputSumSaveBalanceWindow actionWithInputSumSaveBalanceWindow) {
        this.actionWithInputSumSaveBalanceWindow = actionWithInputSumSaveBalanceWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object action = e.getSource();
        String strSum = actionWithInputSumSaveBalanceWindow.getInputField().getText();;
        int sum = Integer.parseInt(strSum);

        if (action == actionWithInputSumSaveBalanceWindow.getSubmitButton()) {
            ActionWithSaveBalanceEngine actionWithSaveBalanceEngine = new ActionWithSaveBalanceEngine();
            actionWithSaveBalanceEngine.transferMoneyToSaveBalance(sum);
            actionWithInputSumSaveBalanceWindow.getFrame().setVisible(false);
            return;
        }
        if (action == actionWithInputSumSaveBalanceWindow.getCancelButton()) {
            actionWithInputSumSaveBalanceWindow.getFrame().setVisible(false);
            ActionWithSaveBalanceWindow actionWithSaveBalanceWindow = new ActionWithSaveBalanceWindow();
            actionWithSaveBalanceWindow.createActionWithSaveBalanceWindow();
        }
    }
}
