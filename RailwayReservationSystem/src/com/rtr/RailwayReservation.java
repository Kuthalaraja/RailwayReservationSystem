package com.rtr;

import java.util.HashMap;
import java.util.Scanner;

public class RailwayReservation {
	
	public static void view()
	{
		System.out.println("To book ticket pls enter 1\nTO view available tickets 2\nTo view 3\nTo Cancel 4\nTo Exit 5");
	}
	
	public static void main(String[] args) {
		HashMap<Integer,Passanger> passangerData = new HashMap<>();
		BookingService bs = new BookingService();
		view();
		Passanger p = new Passanger();
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		while(start!=5) {
			if(start==1) {
				p = bs.getData();
				if(p!=null) {
				passangerData.put(p.getId(), p);
				view();
				start = sc.nextInt();
				}else {
					System.out.println("All seats are reserved");
					start = 5;
				}
			}else if(start ==2) {
				System.out.println(bs.viewTickets());
				view();
				start = sc.nextInt();
				
			}
			else if(start ==3) {
				bs.viewData(passangerData);
				view();
				start = sc.nextInt();
			}
			else if(start==4) {
				System.out.println("Enter ID ");
				int n = sc.nextInt();
				bs.delete(passangerData,n);
				System.out.println("Cancelled sucessfully..");
				view();
				start = sc.nextInt();
			}
		}
		
	}

}
