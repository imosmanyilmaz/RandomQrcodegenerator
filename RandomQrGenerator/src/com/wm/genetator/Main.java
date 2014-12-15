package com.wm.genetator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class Main {

	static Random rnd;
	static ArrayList<String> mlist;
	//generated numbers
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final int SIZE =6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mlist = new ArrayList<>();
		
		rnd = new Random();
		for (int i = 0; i < 500; i++) {
			mlist.add(randomString(SIZE));
			generateQRs(mlist.get(i));
		}

		
	}


	public static String randomString(int len) {
		String appended;
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		sb.append(AB.charAt(rnd.nextInt(AB.length())));
		appended = sb.toString();
		if (mlist.contains(appended))
		randomString(SIZE);
		return appended;

	}
	
	
 public  static void  generateQRs(String text){
	 //Your qr code data
	 ByteArrayOutputStream out = QRCode.from("www.savemypets.org/tagId/"+text) .to(ImageType.PNG).stream();
	 
	   try {
		   //Output data
           FileOutputStream fout = new FileOutputStream(new File("/Users/arneca/Desktop/Qrs/"+text+".PNG"));
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


