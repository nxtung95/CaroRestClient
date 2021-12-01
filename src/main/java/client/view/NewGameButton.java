package client.view;

import client.controller.BtnNewGameActionListener;

import java.awt.*;

public class NewGameButton extends BaseButton {
    private BtnNewGameActionListener btnNewGameAction;

    @Override
    public void init() {
        // Thiết lập thông số tọa độ, kích thước panel
        System.out.println("Khởi tạo button new game...");
        btnNewGameAction = new BtnNewGameActionListener();

        setBounds(10, 10, 120, 50);
        setBackground(Color.LIGHT_GRAY);
        setText("New game");
    }

    @Override
    public void addEvents() {
        if (btnNewGameAction != null) {
            addMouseListener(btnNewGameAction);
        }
    }

    @Override
    public void addComps() {

    }
}
