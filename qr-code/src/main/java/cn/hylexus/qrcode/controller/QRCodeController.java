package cn.hylexus.qrcode.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Controller
public class QRCodeController {

	@GetMapping("/generate-qrcode")
	public void getQRCode(@RequestParam(value = "text", required = false, defaultValue = "hello") String text,
			HttpServletResponse response) throws WriterException, IOException {
		int width = 300, height = 300;
		String format = "png";

		Map<EncodeHintType, Object> map = new HashMap<>();
		map.put(EncodeHintType.CHARACTER_SET, "utf-8");
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		map.put(EncodeHintType.MARGIN, 2);

		BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, map);
		MatrixToImageWriter.writeToStream(matrix, format, response.getOutputStream());
	}

	@GetMapping("qrcode")
	public String toQRCodePage() {
		return "qrcode";
	}
}
