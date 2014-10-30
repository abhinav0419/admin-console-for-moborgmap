package com.mob.admin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mob.admin.model.Title;
import com.mob.admin.service.TitleService;

@Controller
public class TitleController {

	@Autowired
	private TitleService titleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIndex() {
		return "index";
	}

	@RequestMapping(value = "/title", method = RequestMethod.GET)
	public String loadTitle(Map<String, Object> model) {
		model.put("titleList", titleService.getAllTitle());
		return "viewtitle";
	}

	@RequestMapping(value = "/addTitle", method = RequestMethod.POST)
	public String addTitle(Map<String, Object> model,@RequestParam("") String titleName) {
		Title title = new Title();
		title.setTitleName(titleName);
		try {
			titleService.addTitle(title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.put("titleList", titleService.getAllTitle());
			model.put("error", "error");
			return "viewtitle";
		}
		model.put("titleList", titleService.getAllTitle());
		return "viewtitle";
	}

	@RequestMapping(value = "/editTitle", method = RequestMethod.POST)
	public String editOfficeLocations(Map<String, Object> model,
			@RequestParam("titleId") String titleId,
			@RequestParam("titleName") String titleName) {
		System.out.println(titleId + "sdhajks" + titleName);
		Title title = new Title();
		title.setTitleId(Long.parseLong(titleId));
		title.setTitleName(titleName);

		titleService.updateTitle(title);
		try {
			model.put("titleList", titleService.getAllTitle());
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error", "Something went wrong please try after sometime");
			return "error";
		}
		return "viewtitle";
	}

	@RequestMapping(value = "/deletetitle", method = RequestMethod.POST)
	public void deleteAjaxTitle(@RequestParam("titleId") String titleId,
			HttpServletResponse response) throws IOException {
		try {

			Title title = new Title();
			title.setTitleId(Long.parseLong(titleId));
			titleService.deleteTitle(title);

			String success = "Deleted";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(success);
		} catch (Exception e) {
			String success = "Error";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(success);
		}
	}
}
