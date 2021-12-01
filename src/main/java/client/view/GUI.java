package client.view;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Khởi tạo đối tượng frame chính của giao diện
 * 
 * @author nxtung
 *
 */
public class GUI extends JFrame implements ICommon {
	// Khai báo các thuộc tính.
	public static final int W_FRAME = 620;
	public static final int H_FRAME = 680;
	private static final String TITLE = "Game Caro";
	private MainPanel mainPanel;

	/**
	 * Phương thức khởi tạo GUI
	 */
	public GUI() {
		// Khởi tạo các thông số
		init();
		// Khởi tạo các sự kiện
		addEvents();
		// Khởi tạo các thành phần
		addComps();
	}

	@Override
	public void init() {
		// Khai báo các thông số
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(new CardLayout());

		// Khai báo kiểu giao diện
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Khởi tạo các sự kiện
	 */
	@Override
	public void addEvents() {
		WindowAdapter windowAdapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeGUI();
			}
		};
		// Add events
		addWindowListener(windowAdapter);
	}

	/**
	 * Đóng giao diện chính
	 */
	private void closeGUI() {
		// Default Action
		dispose();
	}

	/**
	 * Khởi tạo các thành phần của GUI
	 */
	@Override
	public void addComps() {
		mainPanel = new MainPanel();
		mainPanel.setPreferredSize(new Dimension(W_FRAME, H_FRAME));
		add(mainPanel);
		pack();
		setLocationRelativeTo(null);
	}

}
