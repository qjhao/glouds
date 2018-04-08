package sin.glouds.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sin.glouds.common.Global;
import sin.glouds.util.FileUtil;

@Controller
@RequestMapping("fileupload")
public class FileuploadController extends BaseController {

	@ResponseBody
	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String contentType = file.getContentType();
		System.out.println(contentType);
		String fileName = file.getOriginalFilename();
		String filePath = Global.getUserDir() + "/fileupload/";
		System.out.println(filePath);
		try {
			FileUtil.saveFile(file.getBytes(), filePath, fileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
