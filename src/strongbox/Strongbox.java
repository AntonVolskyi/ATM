package strongbox;

import java.io.*;

public class Strongbox {
    public double ATMMoneyReader(){

        double ATMMoney  = 0;

        FileReader myFile = null;
        BufferedReader buff = null;

        try {
            myFile = new FileReader("ATMMoney.txt");
            buff = new BufferedReader(myFile);

            while (true){
                String line = buff.readLine();
                if (line == null) break;
                ATMMoney = Double.parseDouble(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                buff.close();
                myFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ATMMoney;
    }

    public void ATMMoneyWriter(double ATMMoney){
        FileWriter myFile = null;
        BufferedWriter buff = null;

        try {

            myFile = new FileWriter("ATMMoney.txt");
            buff = new BufferedWriter(myFile);

            buff.write(String.valueOf(ATMMoney));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                buff.flush();
                buff.close();
                myFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
