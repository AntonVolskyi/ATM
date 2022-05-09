package model;

import dao.BankDBReader;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    public enum ReceiptType {
        GETTING_MONEY("Зняття коштів"),
        TRANSF_TO_SAVE_BALANCE("Переказ на ощад. рахунок");

        private final String operationName;

        ReceiptType(String operationName) {
            this.operationName = operationName;
        }

        public String getOperationName() {
            return operationName;
        }
    }

    private ReceiptType operationType;
    private BankDBReader dbReader;

    {
        dbReader = new BankDBReader();
    }

    public Receipt(ReceiptType operationType) {
        this.operationType = operationType;
    }

    public void createAndPrintReceipt() {
        Date currentDate = new Date();
        SimpleDateFormat data = new SimpleDateFormat("MMM, d, yyyy");
        String formattedDate = data.format(currentDate);
        SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
        String formattedHour = hour.format(currentDate);

        System.out.println("             Банк АТМ             " + "\n" +
                "==================================" + "\n" +
                "Тип операції: " + operationType.getOperationName() + "\n" +
                "Сума операції: " + UserData.SUM_FOR_TAKING + "\n" +
                "Номер карти: " + UserData.CARD_NUMBER + "\n" +
                "Залишок на рахунку: " + dbReader.getCardBalance(UserData.CARD_NUMBER) + "\n" +
                "Дата проведення операції: " + formattedDate + "\n" +
                "Година проведення операції: " + formattedHour);
    }
}
