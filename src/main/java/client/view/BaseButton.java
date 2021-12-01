package client.view;

import javax.swing.*;

public abstract class BaseButton extends JButton implements ICommon {
    public BaseButton() {
        init();
        addEvents();
        addComps();
    }
}
