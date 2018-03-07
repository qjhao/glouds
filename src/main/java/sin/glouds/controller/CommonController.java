package sin.glouds.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	@ResponseBody
	@RequestMapping("/fileUpload")
	public String fileReceive(HttpServletRequest request, @RequestParam MultipartFile file) {
		System.out.println("开始");
		String basePath = "F://sins/sins/receives/";
		String fileName = file.getOriginalFilename();
		File targetFile = new File(basePath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "receive success, file:" + targetFile.getName();
	}
}
