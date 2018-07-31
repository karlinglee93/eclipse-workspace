package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Apple;

@Controller
public class AppleController {
	@RequestMapping("/addApple")
	public ModelAndView add(Apple apple) {
		ModelAndView mav = new ModelAndView("showApple");

		return mav;
	}
}
