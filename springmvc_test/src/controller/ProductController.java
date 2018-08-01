package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Product;

@Controller
public class ProductController {
	@RequestMapping("/addProduct")
	//  addProduct.jsp 提交的name和price会自动注入到参数 product里
	// 参数product会默认被当做值加入到ModelAndView 中
	public ModelAndView add(Product product) {
		// 最后跳转到showProduct页面显示用户提交的数据
		ModelAndView mav = new ModelAndView("showProduct");

		return mav;
	}
}
