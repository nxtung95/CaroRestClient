package client.view;

import java.awt.*;

/**
 * Khởi tạo panel chính của giao diện
 *
 */
public class MainPanel extends BasePanel {
	// Khai báo các thuộc tính
	private ChessBoardView pBoard;
	private NewGameButton btnNewGame;
	private LoginFormPanel pLoginForm;

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
//		pLoginForm = new LoginFormPanel();
//		add(pLoginForm);
//		// Khoi tao va add Comps
//		pBoard = new ChessBoardView();
//		btnNewGame = new NewGameButton();
//		// Add vao MainPanel
//		add(pBoard);
//		add(btnNewGame);
	}

}
