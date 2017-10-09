package com.javacircle.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.javacircle.ws.model.Profile;

public class Java8Test {

	public static void main(String[] args) {

		Profile p = new Profile();
		p.setFirstName("Suriya");

		if (p != null && p.getFirstName() != null) {
			p.setLastName("Bala");
			System.out.println(p);
		}
		// Java 8 Optional

		Profile p1 = null;
		Optional<Profile> profile = Optional.ofNullable(p1);

		
		profile.ifPresent(pr -> {
			pr.setFirstName("Suriya");
			pr.setLastName("Bala");
			System.out.println(pr);
		});

		// Java 8 Map List
		Profile pr1 = new Profile();
		pr1.setFirstName("Shylu");
		Profile pr2 = new Profile();
		pr2.setFirstName("Suriya");
		List<Profile> profileList = new ArrayList<>();
		profileList.add(pr1);
		profileList.add(pr2);

		List<Profile> newList = new ArrayList<>();

		for (Profile pro : profileList) {
			pro.setLastName("Bala");
			newList.add(pro);
		}

		System.out.println(newList);

		// Java 8 style
		Optional<List<Profile>> optionalList = Optional.ofNullable(profileList);

		List<Profile> list = optionalList.map(li -> li.stream().map(l -> {
			l.setLastName("Bala");
			return l;
		}).collect(Collectors.toList())).orElse(new ArrayList<>());

		System.out.println(list);
		
	}

}
