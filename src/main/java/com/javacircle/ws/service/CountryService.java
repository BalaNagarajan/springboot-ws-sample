package com.javacircle.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacircle.ws.client.CountryClient;
import com.javacircle.ws.model.Country;

@Service
public class CountryService {

	@Autowired
	CountryClient countryClient;

	public Country getCountryByCode(Country countryObj) {

		countryClient.getCountryBycode(countryObj);
		return countryObj;

	}

}
