package cn.hylexus.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import net.glxn.qrgen.QRCode;

public class Test1 {

	@Test
	public void test1() {
		try {
			int width = 300, height = 300;
			String content = "你好";
			String format = "png";

			Map<EncodeHintType, Object> map = new HashMap<>();
			map.put(EncodeHintType.CHARACTER_SET, "utf-8");
			map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			map.put(EncodeHintType.MARGIN, 2);

			BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, map);
			MatrixToImageWriter.writeToStream(matrix, format, new FileOutputStream("/Users/qm/tmp/qr.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test2() {

		@SuppressWarnings("rawtypes")
		Map map = new HashMap();

		map.put(EncodeHintType.CHARACTER_SET, "utf-8");

		BinaryBitmap binaryBitmap = null;

		try {
			File file = new File("/Users/qm/tmp/qr.png");
			BufferedImage bufferedImage = ImageIO.read(file);

			binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

			Result result = new MultiFormatReader().decode(binaryBitmap, map);

			System.out.println(result.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从输入流解析二维码
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 */
	@SuppressWarnings("unchecked")
	public Result parseQRCode(InputStream inputStream) throws IOException, NotFoundException {
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();

		map.put(EncodeHintType.CHARACTER_SET, "utf-8");

		BinaryBitmap binaryBitmap = null;

		BufferedImage bufferedImage = ImageIO.read(inputStream);

		binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

		Result result = new MultiFormatReader().decode(binaryBitmap, map);

		return result;
	}

	/**
	 * 生成二维码并写到指定的输出流
	 * 
	 * @param width
	 *            二维码宽度
	 * @param height
	 *            二维码高度
	 * @param content
	 *            二维码内容
	 * @param dest
	 *            输出目标,可以是
	 *            {@link FileOutputStream}、{@link ServletOutputStream}等任何输出流
	 * @throws IOException
	 * @throws WriterException
	 */
	public void generateQRCode(int width, int height, String content, OutputStream dest)
			throws IOException, WriterException {

		Map<EncodeHintType, Object> map = new HashMap<>();
		// 编码方式
		map.put(EncodeHintType.CHARACTER_SET, "utf-8");
		// 纠错级别--中级
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		// 内边距
		map.put(EncodeHintType.MARGIN, 2);

		// 生成二维码
		BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, map);
		// 写入到任何输出流皆可
		MatrixToImageWriter.writeToStream(matrix, "png", dest);
	}

	@Test
	public void test3() {
		try {
			QRCode.from("https://github.com/kenglxn/QRGen")//
					.withSize(400, 400)//
					.withHint(EncodeHintType.CHARACTER_SET, "UTF-8")//
					.withErrorCorrection(ErrorCorrectionLevel.M)//
					.withHint(EncodeHintType.MARGIN, 2)//
					.writeTo(new FileOutputStream(new File("/Users/hylexus/tmp/t.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
