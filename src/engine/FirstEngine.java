package engine;

import display.BlockWindow;
import display.Displays;
import dao.BankDBReader;
import strongbox.Strongbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
Клас и его наследники отвечающие за действия кнопок на панели.
 */

public class FirstEngine implements ActionListener {

    protected Displays d;
    protected static String cardNumber;
    protected static String cardMoney;
    protected static double ATMMoney;
    protected BankDBReader bankDBReader = new BankDBReader();
    protected Strongbox strongbox = new Strongbox();

    private Frame frame;
    private int t = 3;

    public FirstEngine(Displays d) {
        this.d = d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        ATMMoney = strongbox.ATMMoneyReader();

        if (src == d.getButtonCenter()) {
            /*
             Вызывается окно для выбора номера карты
             и ввода пароля.
             Введёный пароль сверяется с тем что содержится в базе даных
             и привязан к номеру карты.
             Для считывания номеров карты и сверения паролей используется
             язык SQL и база даных MySQL
             */
            frame = new JFrame("Cards");

            //Создание окна выбора для номера карты и ввода пароля
            JButton OK = new JButton("OK");
            JButton cancel = new JButton("Cancel");
            JLabel choice = new JLabel("Выбор карты: ");
            JComboBox cards = new JComboBox(arrCardNumber());
            JLabel password = new JLabel("Введите пароль: ");
            JPasswordField inputPass = new JPasswordField(10);
            JPanel p = new JPanel(new GridLayout(1, 2, 5, 0));

            p.add(OK);
            p.add(cancel);

            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            p1.add(p);

            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            p2.add(choice);
            p2.add(cards);
            p2.add(password);
            p2.add(inputPass);

            JPanel windowContent = new JPanel(new BorderLayout());
            windowContent.add("South", p1);
            windowContent.add(p2);

            frame.add(windowContent);
            frame.setSize(300, 150);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            inputPass.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (inputPass.getText().length() >= 4) e.consume();
                }
            });

            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardNumber = arrCardNumber()[cards.getSelectedIndex()];
                    if (bankDBReader.isCorrectPassword(cardNumber, inputPass.getText())) {
                        d.SecondDisplay();
                        frame.setVisible(false);
                        cardMoney = bankDBReader.getCardBalance(cardNumber);
                    } else {
                        t--;
                        if (t == 0) {
                            BlockWindow blockWindow = new BlockWindow();
                            blockWindow.createBlockWindow();
                            t = 3;
                        } else {
                            JOptionPane.showConfirmDialog(null,
                                    "Вы ввели неверный пароль.\n" +
                                            "Осталось попыток ввода " + t,
                                    "NOT CORRECTLY!",
                                    JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }
            });
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                }

            });
        }
    }

    private String[] arrCardNumber() {
     /*
    Метод отвечающий за переписывания колекции в масив
    так как JComboBox не принимает колекции
     */

        String arrCardNumber[] = new String[bankDBReader.getCardNumbers().size()];
        for (int i = 0; i < bankDBReader.getCardNumbers().size(); i++) {
            arrCardNumber[i] = (String) bankDBReader.getCardNumbers().get(i);
        }
        return arrCardNumber;
    }
}

