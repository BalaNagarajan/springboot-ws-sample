package com.javacircle.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javacircle.ws.model.Country;
import com.javacircle.ws.service.CountryService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CountryController {

	public static final String URL = "/profiles";

	@Autowired
	private CountryService countryService;

	/**
	 * TO get all the profiles Noun based URI's - /profiles
	 * 
	 * @return
	 */
	@RequestMapping(value = "/country/code", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Country getCountryByCode(@RequestBody Country countryObj) {

		System.out.println("-------------Inside Controller----------------");
		if (!StringUtils.isEmpty(countryObj.getCountryCode())) {
			System.out.println("------------Country Code---------" + countryObj.getCountryCode());
			countryObj = countryService.getCountryByCode(countryObj);
		}

		return countryObj;

	}

}
