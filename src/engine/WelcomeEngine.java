package engine;

import display.LoginWindow;
import display.WelcomeWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeEngine implements ActionListener {

    private WelcomeWindow welcomeWindow;

    public WelcomeEngine(WelcomeWindow welcomeWindow) {
        this.welcomeWindow = welcomeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action == welcomeWindow.getLoginButton()) {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.createLoginWindow();
            welcomeWindow.getFrame().setVisible(false);
        }
    }
}
