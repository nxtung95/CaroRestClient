
package client.controller;

import client.obj.DanhCoRequest;
import client.obj.DanhCoResponse;
import client.constant.Constant;
import client.view.ChessBoardView;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Đấy các dữ liệu khi người dùng thao tác ở giao diện xuống tầng model Lấy các
 * dữ liệu đã qua xử lý từ tầng model lên giao diện
 *
 *
 */
public class HandleActionListener implements MouseListener {
	// Khai báo các thuộc tính
	private ChessBoardView gui;
	private static int turn = 0; //0: X, 1: O

	/**
	 * Phương thức khởi tạo bàn cờ logic, gui, đọc thế cờ từ file.
	 * 
	 * @param gui
	 *            giao diện bàn cờ
	 */
	public HandleActionListener(ChessBoardView gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String type;
		if (turn == 0) {
			type = Constant.QUAN_X;
			turn = 1;
		} else {
			type = Constant.QUAN_O;
			turn = 0;
		}
		int[] xy = dieuChinhQuanCoHopLe(e.getX(), e.getY());
		int x = xy[0];
		int y = xy[1];
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();

			DanhCoRequest danhCoRequest = new DanhCoRequest(x, y, type);
			System.out.println("Request danhCo: " + new Gson().toJson(danhCoRequest));
			// Dữ liệu đính kèm theo yêu cầu.
			HttpEntity<DanhCoRequest> requestBody = new HttpEntity<>(danhCoRequest, headers);

			// Gửi yêu cầu với phương thức POST.
			DanhCoResponse res = restTemplate.postForObject("http://localhost:8081/danhCo", requestBody, DanhCoResponse.class);
			System.out.println("Response danhCo: " + new Gson().toJson(res));
			if (res == null || "500".equals(res.getCode())) {
				System.out.println("Something error!");
				gui.showError("Có lỗi xảy ra...");
				return;
			}
			if ("403".equals(res.getCode())) {
				gui.showError(res.getDesc());
				return;
			}

			gui.paintChess(gui.getGraphics(), x, y, type);
			if ("201".equals(res.getCode())) {
				gui.showMessage(res.getDesc());
				return;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			gui.showError("Có lỗi xảy ra...");
		}
	}

	public void restartGame() {

	}

	private int[] dieuChinhQuanCoHopLe(int x, int y) {

		// Khai bảo tọa độ chứa tọa độ đã điều chỉnh
		int[] XY = new int[2];

		// Vị trí cột và hàng của tọa độ x,y hiện tại trên bàn cờ
		int posColX = x / Constant.SIZE_O_CO;
		int posRowY = y / Constant.SIZE_O_CO;

		// Tọa độ X,Y sau khi đã điều chỉnh vào giữa ô cờ
		int coordX = posColX * Constant.SIZE_O_CO + Constant.SIZE_O_CO / 2;
		int coordY = posRowY * Constant.SIZE_O_CO + Constant.SIZE_O_CO / 2;

		// Gán tọa độ đã điều chỉnh
		XY[0] = coordX;
		XY[1] = coordY;

		// Trả về tọa độ đã điều chỉnh
		return XY;
	}

	/**
	 * Xử lý logic của sự kiến khi rê chuột vào
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Xử lý logic của sự kiện khi rê chuột ra
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Xử lý logic của sự kiện nhấn giữ chuột
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Xử lý logic của sự kiện khi thả nhấn giữ chuột
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
