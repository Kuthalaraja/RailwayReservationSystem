package com.rtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookingService {
	Service s = new Service();

	public Passanger getData() {
		Passanger p = new Passanger();
		Scanner sc = new Scanner(System.in);
			System.out.println("Name  :");
			String name = sc.next();
			System.out.println("Gender :");
			String gender = sc.next();
			System.out.println("Age :");
			int age = sc.nextInt();
			System.out.println("Berth preference :");
			String berthpref = sc.next();
			p.setId(p.getId());
			p.setName(name);
			p.setGender(gender);
			p.setAge(age);
			p.setBerthpref(s.berthAllocation(berthpref));
			if(p.getBerthpref().equals("###")) {
				return null;
			}
		return p;
	}
	
	public void viewData(HashMap<Integer,Passanger> map) {
		for (Passanger Pas : map.values()) {
			System.out.println(Pas.toString());
		}
	}
	
	public ArrayList<String> viewTickets() {
		return s.getTickets();
	}

	public void delete(HashMap<Integer,Passanger> map, int n) {
		Passanger p = map.get(n);
		s.remove(n,p.getBerthpref(),map);
		
	}
	
}
