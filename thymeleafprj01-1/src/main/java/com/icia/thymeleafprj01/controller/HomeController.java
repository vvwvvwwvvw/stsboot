package com.icia.thymeleafprj01.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.thymeleafprj01.dto.ProductDto;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
			log.info("home()");
			model.addAttribute("id","user");
		return "index";
	}
	
	@GetMapping("second")
	public String second(Model model) {
		log.info("second()");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String date = "<h2>" + sdf.format(now) + "</h2>";
		model.addAttribute("date", date);
		
		//Map을 사용한 전송(data를 묶어서 보낼때)
		Map<String, String> rmap = new HashMap<>();
		rmap.put("pname", "치약");
		rmap.put("brand", "LG화학");
		rmap.put("price", "3000");
		model.addAttribute("product", rmap);
		
		return "second";
	}
	
	@GetMapping("third")
	public ModelAndView third() {
		log.info("third()");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("third");
		
		//Dto에 데이터 담기
		ProductDto pdto1 = new ProductDto();
		pdto1.setPname("세탁기");
		pdto1.setBrand("삼성");
		pdto1.setPrice(450000);
		pdto1.setAmount(10);
		
		mv.addObject("prod1", pdto1);
		
		ProductDto pdto2 = new ProductDto();
		pdto2.setPname("냉장고");
		pdto2.setBrand("LG");
		pdto2.setPrice(850000);
		pdto2.setAmount(5);
		
		mv.addObject("prod2", pdto2);
		
		//자바스크립트 영역으로 넘기는 데이터
		 mv.addObject("msg", "경고창에 출력할 내용");
		
		return mv;
		
	}
} // class end
