package com.ilearn.chk.studentbarcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class BarcodeService {

    public BufferedImage generateBarcodeImage(String barcodeText) throws WriterException, IOException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 1000, 1000);

        BufferedImage tmp =MatrixToImageWriter.toBufferedImage(bitMatrix);

        File f = new File("tmp-chk.png");
        ImageIO.write(tmp, "PNG", f);
        return tmp;
    }
}

