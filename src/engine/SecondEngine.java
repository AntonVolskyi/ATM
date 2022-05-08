package engine;
import display.Displays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondEngine extends FirstEngine implements ActionListener {

    public SecondEngine(Displays d) {
        super(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*
        Клас отвечающий за выбор дейтвий
        открывает WithdrawDisplay или CheckDisplay
         */

        Object src = e.getSource();

        if (src == d.getWithdrawMoney()){
            d.WithdrawDisplay();
        }

        if (src == d.getCheckAccount()){
            d.CheckDisplay(cardMoney);
        }
    }
}

