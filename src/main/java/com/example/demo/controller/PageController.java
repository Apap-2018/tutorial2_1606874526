package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PageController {

	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralgenerator(@RequestParam(value ="a", defaultValue = "0", required = false) Integer a, Model model, @RequestParam(value = "b", defaultValue = "0", required = false) Integer b, @RequestParam(value = "output", required = false) String output) {
		String hasil = "";
		String inisiatorH = "h";
		if(((a == 0) || (a == 1)) && ((b == 0) || (b == 1))) {
			hasil = "hm";
		}
		else {
			// konsep : mau membuat hmmm hmmm dari a= 3 b=2
			// mau h + (mmm) dulu
			if (a == 0) {
				inisiatorH += "m";
			}
			for (int i = 0; i < a; i++) {
				inisiatorH += "m";
			}
			// konsep: mau bikin si inisiatorH sebanyak b kali
			// jadi hmmm hmmm
			for(int i = 0; i < b; i++) {
				hasil += inisiatorH + " ";
			}
		}
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("output", hasil);
		
		return "viralgenerator";
		
	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model){
		if (name.isPresent()){
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	
	}
	
	
	
}