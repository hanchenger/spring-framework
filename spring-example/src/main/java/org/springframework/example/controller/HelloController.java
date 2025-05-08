package org.springframework.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("name")
public class HelloController {

	@GetMapping("/a")
	@ResponseBody
	public String a(HttpServletRequest request) {
		request.getSession().setAttribute("name","andy");
		return "success";
	}

    @GetMapping("/test")
	@ResponseBody
    public String index(Date date,HttpServletRequest request, Model model) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		String user = (String) model.getAttribute("user");
		System.out.println(user);

		String name = (String)request.getSession().getAttribute("name");
		return name;  // 返回 /WEB-INF/views/index.jsp
    }

	@GetMapping("/test2")
	@ResponseBody
	public String test2(String a) {
		return a;
	}

	@GetMapping("/test3")
	@ResponseBody
	public String test3(Date date) {
		return date + "andy";
	}

	@RequestMapping("/test4/{id}")
	@ResponseBody
	public String test4(@PathVariable("id") String id) {
		return id + ", andy";
	}

	@RequestMapping("/test5")
	@ResponseBody
	@SuppressWarnings("rawtypes")
	public String test5(@RequestParam Map map) {
		return map + ", andy";
	}

	@RequestMapping("/test6")
	@ResponseBody
	@SuppressWarnings("rawtypes")
	public String test6(@RequestHeader String a) {
		return a + ", andy";
	}
	@ModelAttribute("name")
	public String addString() {
		return "andy";  // 返回 /WEB-INF/views/index.jsp
	}
	@RequestMapping("/test7")
	@ResponseBody
	@SuppressWarnings("rawtypes")
	public String test7(Map map) {
		return map + ", welcome";
	}

	@RequestMapping("/test8")
	@ResponseBody
	@SuppressWarnings("rawtypes")
	public Map test8(String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("name","andy");
		return map;
	}

	@RequestMapping("/test9")
	public String test9(Model model) {
		Object value = model.getAttribute("name");
		model.addAttribute("name","xxxx");
		return "index";
	}

	/**
	 * 测试转发
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/aa")
	public String aa(HttpServletRequest request,Model model) {
//		request.setAttribute("name","andy");
		model.addAttribute("name","andy");
		return "forward:/app/bb";
	}

	@GetMapping("/bb")
	@ResponseBody
	public String bb(HttpServletRequest request,Model model) {
//		String name = (String)request.getAttribute("name");
		String name = (String) model.getAttribute("name");
		return name;
	}

	/**
	 * 测试重定向
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/cc")
	public String cc(HttpServletRequest request,Model model) {
		model.addAttribute("name","andy");
		return "redirect:/app/dd";
	}

	@GetMapping("/dd")
	@ResponseBody
	public String dd(HttpServletRequest request,Model model) {
//		String name = (String)request.getAttribute("name");
		String name1 = request.getParameter("name");
		return name1;
	}
}
