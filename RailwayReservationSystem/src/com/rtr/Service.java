package com.rtr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;


public class Service {

	ArrayList<Integer> aLB = new ArrayList<>(Arrays.asList(1));
	ArrayList<Integer> aMB = new ArrayList<>(Arrays.asList(1));
	ArrayList<Integer> aUB = new ArrayList<>(Arrays.asList(1));
	
	Queue<Integer> aRAC = new LinkedList<>(Arrays.asList(1));
	Queue<Integer> aWL = new LinkedList<>(Arrays.asList(1));

	public String berthAllocation(String berth) {
			if(aLB.size()>0 && berth.equals("L")) {
				  berth += aLB.get(0);
				  aLB.remove(0);
				  return berth;
			}
			else if(aMB.size()>0 && berth.equals("M")) {
				  berth += aMB.get(0);
				  aMB.remove(0);
				  return berth;
			}
			else if(aUB.size()>0 && berth.equals("U")) {
				  berth += aUB.get(0);
				  aUB.remove(0);
				  return berth;
			}
			else if(aLB.size()>0) {
				  berth = "L"+aLB.get(0);
				  aLB.remove(0);
				  System.out.println("Allocated Berth is :" +berth);
				  return berth;
			}
			else if(aMB.size()>0) {
				  berth = "M"+aMB.get(0);
				  aMB.remove(0);
				  System.out.println("Allocated Berth is :" +berth);
				  return berth;
			}
			else if(aUB.size()>0) {
				  berth = "U"+aUB.get(0);
				  aUB.remove(0);
				  System.out.println("Allocated Berth is :" +berth);
				  return berth;
			}
			else if(aRAC.size()>0) {
				  berth = "RAC"+aRAC.poll();
				  System.out.println("No berth is available RAC Allocated :" +berth);
				  return berth;
			}
			else if(aWL.size()>0) {
				  berth = "WL"+aWL.poll();
				  System.out.println("No berth is available You're in waitinglist :" +berth);
				  return berth;
			}
			return "###";
			
		}

	public ArrayList<String> getTickets() {
		ArrayList<String> al = new ArrayList<String>();
		for (int i=0;i<aLB.size();i++) {
			al.add("L"+aLB.get(i));
		}
		for (int i=0;i<aMB.size();i++) {
			al.add("M"+aMB.get(i));
		}
		for (int i=0;i<aUB.size();i++) {
			al.add("U"+aUB.get(i));
		}
		return al;
		
	}

	public void remove(int n, String s,HashMap<Integer,Passanger> map) {
		int i = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
		if(s.contains("WL")) {
			aWL.add(i);
			map.remove(n);
		}
		else if(aRAC.size()==1 && aWL.size()==1) {
			if(s.contains("L")) {
				aLB.add(i);
			}
			else if(s.contains("M")) {
				aMB.add(i);
			}
			else if(s.contains("U")) {
				aUB.add(i);
			}
			map.remove(n);
		}
		else {
			for (Entry<Integer,Passanger> entry : map.entrySet()) {
				if(entry.getValue().getBerthpref().contains("RAC")){
					int n1 = entry.getValue().getId();
					map.get(n1).setBerthpref(s);
					if(aWL.size()==1) {
						String rac = entry.getValue().getBerthpref();
						int n3 = Integer.parseInt(String.valueOf(rac.charAt(rac.length()-1)));
						aRAC.add(n3);
					}
					break;
				}
			}
			if(aWL.size()!=1) {
				for (Entry<Integer,Passanger> entry : map.entrySet()) {
					if(entry.getValue().getBerthpref().contains("WL")){
						int n2 = entry.getValue().getId();
						String swl = entry.getValue().getBerthpref();
						int n3 = Integer.parseInt(String.valueOf(swl.charAt(swl.length()-1)));
						map.get(n2).setBerthpref("RAC"+1);
						aWL.add(n3);
						break;
					}
				}
	   		 }
			map.remove(n);
		}
	}
}
		
	
