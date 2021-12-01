
package client.view;
import client.constant.Constant;
import client.controller.HandleActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Xây dựng giao diện bàn cờ
 */
public class ChessBoardView extends BasePanel {
	// Khai báo các thuộc tính
	private HandleActionListener controller;

	/**
	 * Xây dựng thông số cho bàn cờ
	 */
	@Override
	public void init() {
		// Khởi tạo đối tượng controller
		System.out.println("Khởi tạo board panel...");
		controller = new HandleActionListener(this);
		// Thiết lập thông số tọa độ, kích thước panel
		setBounds(10, 70, 600, 600);
		// Thiết lập cách hiển thị của panel0
		setLayout(null);
	}

	/**
	 * Thêm sự kiện vào Panel
	 */
	@Override
	public void addEvents() {
		if (controller != null) {
			addMouseListener(controller);
		}
	}

	/**
	 * Thêm các thành phần vào giao diện
	 */
	@Override
	public void addComps() {

	}

	/**
	 * Vẽ các quân cờ trên giao diện
	 * 
	 * @param g
	 *            đối tượng đồ họa ( graphic)
	 * @param x
	 *            tọa độ x
	 * @param y
	 *            tọa độ y
	 * @param typeChess
	 *            kiểu quân cờ
	 */
	public void paintChess(Graphics g, int x, int y, String typeChess) {
		// Vẽ đối tượng lên giao diện
		if (g != null) {
			// Ép kiểu về đối tượng graphics2D để vẽ
			Graphics2D g2d = (Graphics2D) g;
			try {
				// Vẽ ảnh lên bàn cờ
				g2d.drawImage(ImageIO.read(new File("image/" + typeChess + ".PNG")), x - Constant.SIZE_O_CO / 2,
						y - Constant.SIZE_O_CO / 2, Constant.SIZE_O_CO, Constant.SIZE_O_CO, null);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "File ảnh bị lỗi");
			}
		}
	}

	/**
	 * Vẽ ô cờ trên bàn cờ
	 */
	@Override
	public void paint(Graphics g) {
		if (g != null) {
			// Thiết lập màu phông nền của bàn cờ
			g.setColor(Color.LIGHT_GRAY);
			// Lấp đầy màu cho bàn cờ
			g.fillRect(0, 0, 600, 600);

			// Vẽ các cột trên bàn cờ
			g.setColor(Color.LIGHT_GRAY.darker().darker());
			int wScale = Constant.SIZE_O_CO;
			for (int i = 0; i < Constant.SO_COT; i++) {
				g.drawLine(i * wScale, 0, i * wScale, 600);
			}

			// Vẽ các hàng trên bàn cờ
			int hScale = Constant.SIZE_O_CO;
			for (int i = 0; i < Constant.SO_HANG; i++) {
				g.drawLine(0, i * hScale, 600, i * hScale);
			}
		}
	}

	/**
	 * In ra màn hình thông báo lỗi khi đánh cờ
	 */
	public void showError(String err) {
		JOptionPane.showMessageDialog(null, err);
	}

	/**
	 * Đưa ra thông báo cho người chơi lựa chọn
	 * 
	 * @param ketQua
	 *            kết quả của người chơi khi thắng, thua, hòa
	 */
	public void showMessage(String ketQua) {
		// Nếu thắng thì đưa ra lựa chọn cho người chơi
		int type = JOptionPane.showConfirmDialog(null, ketQua + ".Bạn có muốn chơi lại không?", "Thông báo",
				JOptionPane.YES_NO_OPTION);
		switch (type) {
		// Nếu chọn YES thì chơi lại
		case JOptionPane.YES_OPTION: {
			// Chơi lại
			controller.restartGame();
			// Vẽ lại bàn cờ
			repaint();
			break;
		}
		// Chọn NO thì thoát
		case JOptionPane.NO_OPTION: {
			System.exit(0);
			break;
		}
		default: {
			break;
		}
		}
	}

}
