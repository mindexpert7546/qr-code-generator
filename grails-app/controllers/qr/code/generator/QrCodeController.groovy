package qr.code.generator


import grails.rest.*
import grails.converters.*

class QrCodeController {
	static responseFormats = ['json', 'xml']

    QrCodeGeneratorService qrCodeGeneratorService
	
  def generate() {
        String text = params.text
        if (text == null) {
            response.status = 400
            render 'Missing required parameter: text'
            return
        }

        try {
            byte[] qrCodeImage = qrCodeGeneratorService.generateQRCode(text, 250, 250)
            response.setContentType("image/png") //The method then sets the HTTP response's content type to "image/png", indicating that the response will contain a PNG image.
            response.getOutputStream().write(qrCodeImage) //. This sends the image data back to the client.
            response.getOutputStream().flush() //Flushing the output stream ensures that all the image data is sent to the client.
        } catch (Exception e) {
            response.status = 500
            render "Error generating QR code: ${e.message}"
        }
    }
}