package com.javacircle.ws.client;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.javacircle.ws.country.types.GetCountryByCountryCode;
import com.javacircle.ws.country.types.GetCountryByCountryCodeResponse;
import com.javacircle.ws.country.types.ObjectFactory;
import com.javacircle.ws.model.Country;

@Component
public class CountryClient {

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	public void getCountryBycode(Country countryObj) {

		System.out.println("--------------Inside the Client-----------");
		if (!StringUtils.isEmpty(countryObj)) {

			System.out.println("----------Country COde-----"+countryObj.getCountryCode());
			ObjectFactory objFactory = new ObjectFactory();
			GetCountryByCountryCode getCountryByCode = objFactory.createGetCountryByCountryCode();
			getCountryByCode.setCountryCode(countryObj.getCountryCode());

			try {
			System.out.println("--------------Before the service call---------");
			JAXBElement<GetCountryByCountryCodeResponse> xmlResponseObj = (JAXBElement<GetCountryByCountryCodeResponse>) webServiceTemplate
					.marshalSendAndReceive(getCountryByCode);
			System.out.println("--------------After the service call---------");
			GetCountryByCountryCodeResponse getCountryByCountryCodeResponseObj = xmlResponseObj.getValue();
			System.out.println("------------Country Name Is-----"+getCountryByCountryCodeResponseObj.getGetCountryByCountryCodeResult());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			

		}

	}

}
