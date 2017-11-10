package com.nucleus.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nucleus.entity.score.parameters.ParameterSubCategory;
import com.nucleus.repositories.ParameterSubCategoryRepository;

@RequestMapping("/parameterSubCategory")
@Controller
public class ParameterSubCategoryController {
	@Autowired
	ParameterSubCategoryRepository parameterSubCategoryRepo;
	
	@RequestMapping("/create")				/*On click of the Create Parameter Category button*/
	public String createParameterSubCategory(Map<String, Object> model) {
		model.put("message", "Create Sub Parameter Category Here!");
		model.put("parameterSubCategory", new ParameterSubCategory());
		return "createParameterCategory";					/* HTML file here. */
	}
	
	@RequestMapping("/view/{parameterSubCategoryId}")
	public String viewParameterSubCategory(@PathVariable("parameterSubCategoryId") Long parameterSubCategoryId,Map<String, Object> model) {
		ParameterSubCategory parameterSubCategory= parameterSubCategoryRepo.findOne(parameterSubCategoryId);
		model.put("parameterSubCategory", parameterSubCategory);
		model.put("view", true);
		return "createSubParameterCategory";					/* HTML file here. */
	}
	
	@RequestMapping("/edit/{parameterSubCategoryId}")
	public String editSubParameterCategory(@PathVariable("parameterSubCategoryId") Long parameterSubCategoryId,Map<String, Object> model) {
		ParameterSubCategory parameterSubCategory= parameterSubCategoryRepo.findOne(parameterSubCategoryId);
		model.put("parameterSubCategory", parameterSubCategory);
		model.put("view", false);
		
		return "createSubParameterCategory";					/* HTML file here. */
	}	
	
	@RequestMapping("/save")
	public String saveSubParameterCategory(ParameterSubCategory paramSubCategory){
		parameterSubCategoryRepo.save(paramSubCategory);
		return "loadParameterSubCategory";
	}
	
	@RequestMapping("/display")
	public ModelAndView displayAllParamSubCategory()
	{
		ModelAndView modelView = new ModelAndView("loadParameterSubCategory");
		List<ParameterSubCategory> paramSubList = (List<ParameterSubCategory>) parameterSubCategoryRepo.findAll();
		modelView.addObject("paramSubView", paramSubList);
		return modelView;
	}
        
	@RequestMapping("/viewAll")
	public ModelAndView viewAllParamSubCategory()
	{
		ModelAndView modelView = new ModelAndView("view_all_parameter_sub_category");
		List<ParameterSubCategory> paramSubList = (List<ParameterSubCategory>) parameterSubCategoryRepo.findAll();
		modelView.addObject("paramSubView", paramSubList);
		return modelView;
	}
}
