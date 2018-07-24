package com.tulipquant.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class operateFile {
	public static void write(String filepath,String newstr) throws IOException{
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";
        
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            
            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);
            
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }
	
	public static String read(String path,String coding) throws IOException {
		// 声明一个可变长的stringBuffer对象
		StringBuffer sb = new StringBuffer("");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), coding));
        String string = null;
        // 按行读取，结束的判断是是否为null，按字节或者字符读取时结束的标志是-1
        while ((string = bufferedReader.readLine()) != null) {
            // StringBuffer的append方法，这个比string的“+”要高效
            sb.append(string + "\n");
        }
//        System.out.println(sb.toString());
        bufferedReader.close();
        return sb.toString();
	}
}
