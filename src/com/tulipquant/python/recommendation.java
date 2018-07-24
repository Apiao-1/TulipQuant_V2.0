package com.tulipquant.python;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.tulipquant.util.operateFile;

public class recommendation {
	public static String recommend() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(new String[] {"/bin/sh","-c",
				"cd /home/recommendation && python recommendation.py"});
		process.waitFor();
		String result = operateFile.read("/home/recommendation/preFinal.txt","UTF-8");
		File dele1 = new File("/home/recommendation/feature.txt");
		FileWriter fw1 = new FileWriter(dele1);
		fw1.write("");
		fw1.flush();
		fw1.close();
		File dele2 = new File("/home/recommendation/preFinal.txt");
		FileWriter fw2 = new FileWriter(dele2);
		fw2.write("");
		fw2.flush();
		fw2.close();
		return result;
	}
}
