package com.wm.genetator;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRCodeJava {
    public static void main(String[] args) {
    	//Test 1 QR code 
        ByteArrayOutputStream out = QRCode.from("Hello World").to(ImageType.PNG).stream();
 
        try {
        	//Write here your output path
            FileOutputStream fout = new FileOutputStream(new File("/Users/arneca/QR_Code.PNG"));
            fout.write(out.toByteArray());
            fout.flush();
            fout.close();
 
        } catch (FileNotFoundException e) {
            // Do Logging
        	e.printStackTrace();
        } catch (IOException e) {
            // Do Logging
        	e.printStackTrace();
        }
    }
}
