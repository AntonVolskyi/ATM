package engine;

import display.BlockWindow;
import display.WelcomeWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockEngine implements ActionListener {

    private BlockWindow blockWindow;

    public BlockEngine(BlockWindow blockWindow) {
        this.blockWindow = blockWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action == blockWindow.getConfirmButton()) {
            blockWindow.getFrame().setVisible(false);
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.createWelcomeWindow();
        }
    }
}
