package com.tulipquant.python;

import java.io.File;
import java.io.IOException;
import com.tulipquant.util.operateFile;

public class ImageRecognition {
	public static String recognize() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(new String[] {"/bin/sh","-c",
				"cd /home/imageclassify/classify && python imageclassify.py  >> result.txt && python translation.py >> Tresult.txt && python translation_and_match.py >> stock.txt"});
		process.waitFor();
		String result = operateFile.read("/home/imageclassify/classify/Tresult.txt","UTF-8")+operateFile.read("/home/imageclassify/classify/stock.txt","UTF-8");
		File dele1 = new File("/home/imageclassify/classify/stock.txt");
		File dele2 = new File("/home/imageclassify/classify/result.txt");
		File dele3 = new File("/home/imageclassify/classify/Tresult.txt");
		dele1.delete();
		dele2.delete();
		dele3.delete();
        return result;
	}

//	public static void main(String[] args) throws IOException {
//		recognize();
//	}
}
