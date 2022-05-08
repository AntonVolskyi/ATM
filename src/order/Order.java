package order;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    /*
    Объект что создаёт чек и с действиями пользователля
     */
    private String cardNum;
    private SimpleDateFormat data;
    private SimpleDateFormat hour;
    private String money;
    private String cardMoney;
    private Date d = new Date();

    public void setAll(String cardNum, String money, String cardMoney) {
        /*
        Метод принимающий даные о карте для дальнейшей работы с ними
         */
        this.cardNum = cardNum;
        this.money = money;
        this.cardMoney = cardMoney;
    }

    private double worker(){
        /*
        Вычисляет остаток на счету
         */
        double money1 = Double.parseDouble(money);
        double cardMoney1 = Double.parseDouble(cardMoney);

        double out = cardMoney1 - money1;
        return out;
    }

    public void output(){
        /*
        Шаблон чека
         */
        data = new SimpleDateFormat("EEE, MMM d, ''yy");
        String formattedDate = data.format(d);
        hour = new SimpleDateFormat("hh:mm:ss a");
        String formattedHour = hour.format(d);

        System.out.println("             Банк АТМ             " + "\n" +
                "==================================" + "\n" +
                "Номер карты: " + cardNum + "\n" +
                "Было снято: " + money + "\n" +
                "Остаток на счету: " + worker() + "\n" +
                "Дата проведения операции: " + formattedDate + "\n" +
                "Время проведения операции: " + formattedHour);
    }
}
