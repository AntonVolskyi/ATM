package displays;

import engines.EngForWithdraw;
import engines.FirstEngine;
import engines.SecondEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Displays {

    /*
    Описание всех самых необходимых начальных даных
     */

    private JPanel windowContent;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p1W;
    private JPanel p2W;


    private JButton buttonCenter;
    private JButton withdrawMoney;
    private JButton checkAccount;
    private JButton take100;
    private JButton take200;
    private JButton take500;
    private JButton take1000;
    private JButton inputHowMany;

    private JButton endWork;
    private JLabel inputCardMessage;
    private JFrame frame;
    private Dimension dimForATM;
    private FirstEngine firstEngine;

    public void FirstDisplay(){
        /*
        Основной дисплей
        Вносится карта и запускается FirstEngine
        */
        windowContent = new JPanel(new BorderLayout());
        p1 = new JPanel(new FlowLayout());
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 200));

        buttonCenter = new JButton("Вставить карту");
        inputCardMessage = new JLabel("Вставьте карту в приёмник");

        dimForATM = new Dimension(700,500);

        p1.add(buttonCenter);

        p2.add(inputCardMessage);

        windowContent.add("South", p1);
        windowContent.add(p2);

        frame = new JFrame("ATM V 1.5");
        frame.add(windowContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(dimForATM);
        frame.setResizable(false);
        //frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        firstEngine = new FirstEngine(this);
        buttonCenter.addActionListener(firstEngine);

    }

    public void SecondDisplay(){
        /*
        Второй дисплей.
        Отвечает за выбор одного из действий
        Снтия денег и проверка счета,
        в зависимости от выбора SecondEngine
        откроет следующее окно
         */
        withdrawMoney = new JButton("Снять деньги");
        checkAccount = new JButton("Проверить остаток");
        endWork = new JButton("Завершить сеанс");


        buttonCenter.setVisible(false);
        inputCardMessage.setText("Выберите действие");

        p1.add(withdrawMoney);
        p1.add(checkAccount);

        p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        p3.add(endWork);

        windowContent.add("South", p1);
        windowContent.add("North", p3);

        frame.add(windowContent);

        SecondEngine secondEngine = new SecondEngine(this);

        withdrawMoney.addActionListener(secondEngine);
        checkAccount.addActionListener(secondEngine);
        endWork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Verification();
            }
        });
    }

    public void CheckDisplay(String cardMoney){
        /*
        Дисплей отвечающий за проверку счёта
        и вывода сумы остатка на екран,
        так же позволяет сразу перейти к снятию денег со счёта
         */
        inputCardMessage.setText("На вашем счету "  + cardMoney);
    }

    public void WithdrawDisplay(){
        /*
        Клас отвечающий за снятие денег.
        Есть кнопки для снятия стандартных сум(Частоиспользуемых)
        и так же есть кнопка для вводы сумы самому
         */
        checkAccount.setVisible(true);
        checkAccount.setText("Вывести остаток на этот экран");
        take100 = new JButton("Снять 100");
        take200 = new JButton("Снять 200");
        take500 = new JButton("Снять 500");
        take1000 = new JButton("Снять 1000");
        inputHowMany = new JButton("Ввести суму");
        p1W = new JPanel(new GridLayout(2,1,10,20));
        p2W = new JPanel(new GridLayout(2,1,10,20));

        withdrawMoney.setVisible(false);

        inputCardMessage.setText("Выберите суму:");

        p1W.add(take100);
        p1W.add(take200);

        p2W.add(take500);
        p2W.add(take1000);

        p1.add(inputHowMany);

        windowContent.add("West", p1W);
        windowContent.add("East", p2W);

        EngForWithdraw engForWithdraw = new EngForWithdraw(this);

        take100.addActionListener(engForWithdraw);
        take200.addActionListener(engForWithdraw);
        take500.addActionListener(engForWithdraw);
        take1000.addActionListener(engForWithdraw);
        inputHowMany.addActionListener(engForWithdraw);
    }

    private void Verification(){
        /*
        Метод для подтверждения того,
        что кнопка "Завершить сеанс" была нажата не случайно
         */
        JFrame frame1 = new JFrame("Verification");

        JButton OK = new JButton("Да");
        JButton cancel = new JButton("Нет");
        JLabel message = new JLabel("Остановить обслуживание?");
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

        frame1.add(windowContent);
        frame1.setSize(300,150);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                frame.setVisible(false);
                JOptionPane.showConfirmDialog(null,
                        "Возьмите свою карту",
                        "Take card",
                        JOptionPane.PLAIN_MESSAGE);
                FirstDisplay();
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
            }
        });
    }

    /*
    Гетеры всех кнопок для корректной работы с класами в пакете Engines
     */
    public JButton getButtonCenter() {
        return buttonCenter;
    }

    public JButton getWithdrawMoney() {
        return withdrawMoney;
    }

    public JButton getCheckAccount() {
        return checkAccount;
    }

    public JButton getTake100() {
        return take100;
    }

    public JButton getTake200() {
        return take200;
    }

    public JButton getTake500() {
        return take500;
    }

    public JButton getTake1000() {
        return take1000;
    }

    public JButton getInputHowMany() {
        return inputHowMany;
    }

    public JFrame getFrame() {
        return frame;
    }
}

