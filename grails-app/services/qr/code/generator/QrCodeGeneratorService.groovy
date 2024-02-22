package qr.code.generator

import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import java.io.ByteArrayOutputStream

class QrCodeGeneratorService {

    byte[] generateQRCode(String text, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter() // QRCodeWriter is the class of zxing, it providing the functionality to create the qr code 

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height)
         // it is used to generate the qr code 
         // Here BitMatrix is the 2D array to storing the qr in from of array 
        //  which is a 2D array representation of the QR code where each cell represents a bit/pixel in the QR code. True/1 values in the matrix represent black pixels, and false/0 values represent white pixels.

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream()
        //The ByteArrayOutputStream is the sub class of OutPutStream which is used to store de qr in from of byte 
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream)
        //Here which is a 2D array representation of the QR code where each cell represents a bit/pixel in the QR code. True/1 values in the matrix represent black pixels, and false/0 values represent white pixels.
        
        return pngOutputStream.toByteArray()
    }
}
