package com.nucleus.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nucleus.entity.score.parameters.ParameterCategory;
import com.nucleus.repositories.ParameterCategoryRepository;

@RequestMapping("/parameterCategory")
@Controller
public class ParameterCategoryController {
	@Autowired
	ParameterCategoryRepository parameterCategoryRepo;
	

	@RequestMapping("/create")				/*On click of the Create Parameter Category button*/
	public String createParameterCategory(Map<String, Object> model) {
		model.put("message", "Create Parameter Category Here!");
		model.put("parameterCategory", new ParameterCategory());
		return "createParameterCategory";					/* HTML file here. */
	}
	
	@RequestMapping("/view/{parameterCategoryId}")
	public String viewParameterCategory(@PathVariable("parameterCategoryId") Long parameterCategoryId,Map<String, Object> model) {
		ParameterCategory parameterCategory= parameterCategoryRepo.findOne(parameterCategoryId);
		model.put("parameterCategory", parameterCategory);
		model.put("view", true);
		return "createParameterCategory";					/* HTML file here. */
	}
	
	@RequestMapping("/edit/{parameterCategoryId}")
	public String editParameterCategory(@PathVariable("parameterCategoryId") Long parameterCategoryId,Map<String, Object> model) {
		ParameterCategory parameterCategory= parameterCategoryRepo.findOne(parameterCategoryId);
		model.put("parameterCategory", parameterCategory);
		model.put("view", false);
		
		return "createParameterCategory";					/* HTML file here. */
	}	
	
	@RequestMapping("/save")
	public String saveParameterCategory(ParameterCategory paramCategory){
		parameterCategoryRepo.save(paramCategory);
		return "loadParameterCategory";
	}
	
	@RequestMapping("/display")
	public ModelAndView displayAllParamCategory()
	{
		ModelAndView modelView = new ModelAndView("loadParameterCategory");
		List<ParameterCategory> paramList = (List<ParameterCategory>) parameterCategoryRepo.findAll();
		modelView.addObject("paramView", paramList);
		return modelView;
	}
        
	@RequestMapping("/viewAll")
	public ModelAndView viewAllParamCategory()
	{
		ModelAndView modelView = new ModelAndView("view_all_parameter_category");
		List<ParameterCategory> paramList = (List<ParameterCategory>) parameterCategoryRepo.findAll();
		modelView.addObject("paramView", paramList);
		return modelView;
	}
}
