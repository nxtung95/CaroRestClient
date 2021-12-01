/**
 * Copyright(C) 2018 Luvina Software Company
 * 
 * BasePanel.java , Jul 13, 2018 nxtung
 */
package client.view;

import javax.swing.*;

/**
 * Thực thi các phương thức từ interface ICommon
 * 
 * @author nxtung
 *
 */
public abstract class BasePanel extends JPanel implements ICommon {
	/**
	 * Phương thức khởi tạo các phương thức thực thi từ interface ICommon
	 */
	public BasePanel() {
		init();
		addEvents();
		addComps();
	}
}
