# Cheat Sheet 

## QR-Code Generator API : 
******************************************************
1. Create the New Restful Application
2. Dependency : 

  ```bash
     compile 'com.google.zxing:core:3.4.1'
     compile 'com.google.zxing:javase:3.4.1'
```
	
	ref link : https://mvnrepository.com/artifact/com.google.zxing/core/3.4.1
	
3. Create the service for the generationg the qr code : 

4. Crete the controller to call the service to use it for creating the qr code 

5. Make sure URLMapping is working fine 

Complete ref : https://medium.com/nerd-for-tech/how-to-generate-qr-code-in-java-spring-boot-134adb81f10d

## Screenshot : 

![Screenshot (24)](https://github.com/mindexpert7546/qr-code-generator/assets/89348788/c628d51a-9d26-417e-a7c5-67e03434dc92)


# How to run : 

## make sure you hava install 
```bash
| Grails Version: 3.2.6
| Groovy Version: 2.4.7
| JVM Version: 1.8.0_181
```
## Clone this api in you local system 
```bash
git clone https://github.com/mindexpert7546/qr-code-generator.git
```
## Go to the qr folder 
```bash
cd qr-code-generator
```
## for running 
```bash
grails run-app
```
# To test this api by postman 
```bash
http://localhost:8080/qrgen
```
### Above is the url of this api 
Now for final result : After url put /<text> here the text will be converted into the qr 
### Explain : 
Supposed you enter : 
```bash
http://localhost:8080/qrgen/mindexpert
```
In above url mindexpert will be converted into the qr.


## Some importent step : 
1. Crete the object of QRCodeWriter (e.g -  QRCodeWriter qrCodeWriter = new QRCodeWriter())

2. Use qrCodeWriter to generate the qr code and store to the BitMatrix in from of 2D array (e.g-  BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height))

3. Crete the object of ByteArrayOutputStream to stor the qr code in form of byte (e.g-  ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream())

4. Now the time to build complete qr code and store to the byte output Stream (e.g - MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,config))

We have successfuly build the application to generate the qr code in form of the png format 