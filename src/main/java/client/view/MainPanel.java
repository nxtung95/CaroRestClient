/**
 * Copyright(C) 2018 Luvina Software Company
 * 
 * MainPanel.java , Jul 13, 2018 nxtung
 */
package client.view;

import java.awt.*;

/**
 * Khởi tạo panel chính của giao diện
 * 
 * @author nxtung
 *
 */
public class MainPanel extends BasePanel {
	// Khai báo các thuộc tính
	private ChessBoardView pBoard;

	/**
	 * Thiết lập các thông số MainPanel
	 */
	@Override
	public void init() {
		setBackground(Color.WHITE);
		// Default setting
		setLayout(null);
	}

	/**
	 * Thiết lập các events của panel
	 */
	@Override
	public void addEvents() {
		// Khoi tao su kien

	}

	/**
	 * Thêm các thành phần vào MainPanel
	 */
	@Override
	public void addComps() {
		// Khoi tao va add Comps
		pBoard = new ChessBoardView();
		// Add vao MainPanel
		add(pBoard);
	}

}
