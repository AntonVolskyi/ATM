package displays;
/**
 * Lock window, shown when attempts (3) to enter a password are over
 * and informs about the blocking of the card.
 */
import javax.swing.*;
import java.awt.*;

public class BlockWindow extends JWindow {
    public BlockWindow() {
        JPanel windowContent = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 200));
        JLabel messageForBlock = new JLabel("Ваша карта була заблокована. " +
                "Для допомоги звернітся за номером: +38(099)-**-**-*** " +
                "або у найближчий відділ банкомату");
        p1.add(messageForBlock);

        windowContent.add(p1);

        //JWindow blocked = new JWindow();
        add(windowContent);
        setSize(850, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        /*try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisible(false);
         */
        //blocked.setVisible(true);
    }
}

