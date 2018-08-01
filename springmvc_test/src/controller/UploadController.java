package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.UploadedImageFile;

@Controller
public class UploadController {
	@RequestMapping("/uploadImage")
	// 第二个参数为已经注入好的实体类UploadedImageFile 中的image
	public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)
			throws IllegalStateException, IOException {
		// 获取一个随机文件名
		String name = RandomStringUtils.randomAlphanumeric(10);
		String newFileName = name + ".jpg";

		// 获取web 目录下的image 目录，用于存放上传后的文件
		File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
		newFile.getParentFile().mkdirs();
		// 复制文件
		file.getImage().transferTo(newFile);

		ModelAndView mav = new ModelAndView("showUploadedFile");
		mav.addObject("imageName", newFileName);
		System.out.println(newFile);

		return mav;
	}
}
