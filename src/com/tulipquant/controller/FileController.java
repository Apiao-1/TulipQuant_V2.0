package com.tulipquant.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.tulipquant.python.ImageRecognition;
import com.tulipquant.util.Translate;

@Controller
@RequestMapping("/file")
public class FileController {	
	@RequestMapping(value="/upload",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String upload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException, InterruptedException {
		File fi2 = new File("/home/imageclassify/tmp/imagenet/panda.jpg");
		file.transferTo(fi2);
		String result = ImageRecognition.recognize();
		result = Translate.toJson(result);
		fi2.delete();
		return result;
	}
}