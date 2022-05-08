package engine;

import display.Displays;
import order.Order;
import dao.BankDBWrighter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EngForWithdraw extends SecondEngine implements ActionListener {
    private double cardMoney1;
    private BankDBWrighter bankDBWrighter = new BankDBWrighter();
    /*
    Движок отвечающий з снятие денег
    и подтверждения выдачи чека
     */

    public EngForWithdraw(Displays d) {
        super(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        cardMoney1 = Double.parseDouble(cardMoney);

        Object src = e.getSource();

        if (src == d.getTake100()) {
            int howMany = 100;
            HowMany(howMany);
        }
        if (src == d.getTake200()) {
            int howMany = 200;
            HowMany(howMany);
        }
        if (src == d.getTake500()) {
            int howMany = 500;
            HowMany(howMany);
        }
        if (src == d.getTake1000()) {
            int howMany = 1000;
            HowMany(howMany);
        }
        if (src == d.getInputHowMany()){
            HowMany(cardNumber,cardMoney);
        }
    }

    private void OrderCheck(String cardNumber, int howMany, String cardMoney){
        /*
        Метод отвечающий за подтверждения надо ли друковать чек или нет
         */
        JFrame frame = new JFrame(" ");

        JButton OK = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        JLabel message = new JLabel("Выдруковать чек");

        JPanel p = new JPanel(new GridLayout(1,2,5,0));

        p.add(OK);
        p.add(cancel);

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1.add(p);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.add(message);

        JPanel windowContent = new JPanel(new BorderLayout());
        windowContent.add("South", p1);
        windowContent.add(p2);

        frame.add(windowContent);
        frame.setSize(300,150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order order = new Order();
                order.setAll(cardNumber,Integer.toString(howMany),cardMoney);
                order.output();
                frame.setVisible(false);
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    private void HowMany(String cardNumber, String cardMoney11){
        /*
        Окно для ввода количества денег
        что хочет снять пользователь
         */
        d.getFrame().setEnabled(false);
        JFrame frame = new JFrame("InputMoney");

        JButton OK = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        JLabel message = new JLabel("Введите суму: ");
        JLabel message2 = new JLabel("Сума должна быть кратна 10");
        JTextField inputField = new JTextField(10);
        JPanel p = new JPanel(new GridLayout(1,2,5,0));

        p.add(OK);
        p.add(cancel);

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1.add(p);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.add(message);
        p2.add(inputField);
        p2.add(message2);

        JPanel windowContent = new JPanel(new BorderLayout());
        windowContent.add("South", p1);
        windowContent.add(p2);

        frame.add(windowContent);
        frame.setSize(300,150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int howMany = Integer.parseInt(inputField.getText());

                if (howMany > cardMoney1){
                    JOptionPane.showConfirmDialog(null,
                            "На вашем счету недостаточно средств",
                            "No money",
                            JOptionPane.PLAIN_MESSAGE);
                }else if (howMany > ATMMoney){
                    JOptionPane.showConfirmDialog(null,
                            "В банкомате недостаточно средств для выдачи этой сумы",
                            "No money",
                            JOptionPane.PLAIN_MESSAGE);
                }else if (howMany <= cardMoney1){
                    if ((howMany % 10) != 0){
                        JOptionPane.showConfirmDialog(null,
                                "ВВЕДИТЕ ЧИСЛО КРАТНОЕ 10",
                                "ERROR!",
                                JOptionPane.PLAIN_MESSAGE);
                    }else {
                        d.getFrame().setEnabled(true);
                        ATMMoney -= howMany;
                        strongbox.ATMMoneyWriter(ATMMoney);
                        frame.setVisible(false);
                        bankDBWrighter.ChangeBalance(cardNumber,howMany);
                        cardMoney =  bankDBReader.getCardBalance(cardNumber);
                        OrderCheck(cardNumber,howMany,cardMoney11);
                    }
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                d.getFrame().setEnabled(true);
            }
        });
    }

    private void HowMany(int howMany){
        if (howMany > cardMoney1) {
            JOptionPane.showConfirmDialog(null,
                    "На вашем счету недостаточно средств",
                    "No money",
                    JOptionPane.PLAIN_MESSAGE);
        }else if (howMany > ATMMoney){
            JOptionPane.showConfirmDialog(null,
                    "В банкомате недостаточно средств для выдачи этой сумы",
                    "No money",
                    JOptionPane.PLAIN_MESSAGE);
        }else if (howMany <= cardMoney1 && howMany <= ATMMoney) {

            ATMMoney -= howMany;
            strongbox.ATMMoneyWriter(ATMMoney);

            OrderCheck(cardNumber,howMany,cardMoney);
            bankDBWrighter.ChangeBalance(cardNumber,howMany);
            cardMoney =  bankDBReader.getCardBalance(cardNumber);

            JOptionPane.showConfirmDialog(null,
                    "Возьмите ваши деньги",
                    "Take Money",
                    JOptionPane.PLAIN_MESSAGE);
        }

    }
}
