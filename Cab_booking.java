/*1st -> Enter your correct phone number
 * 2nd -> Enter the correct  password
 * 3rd -> Enter the traveling date and time
 * 4th -> pick the cab type
 * 5th -> Put the km of traveling
 * 6th -> calculate GST and total bill amount
 * 7th -> If the traveling time is peak time add 1.25% in total amount
 * 8th -> Enter your date of birth
 * 9th -> If your age is >60 You will get 50% discount in your total bill amount 
 */
package com.day2tasks;
import java.util.*;
import java.time.*;
public class Cab_booking {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Log in - level 1
		System.out.println("Enter your phone number");
		long phnno=sc.nextLong();
		String phn = Long.toString(phnno);
		int len=phn.length();
		if((phnno/1000000000)==0 && len!=10) {
			System.out.println("Invalid phone number");
			System.out.println("Enter correct phone number");
		}
		else {
			passcheck();
		}
	}
	public static void passcheck() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the password");
		int pass=sc.nextInt();
		String pw = Integer.toString(pass);
		int l=pw.length();
		if(l==8) {           //to check the password
			booktime();
		}
		else {
			System.out.println("Your password is incorrect");
		}
	}
	public static void booktime() {
		//Booking level 5
		Scanner sc=new Scanner(System.in);
		LocalDate bdate=LocalDate.now();
		LocalTime btime=LocalTime.now();
		System.out.println("Enter the travelling date");
		String tdate=sc.nextLine();
		System.out.println("Enter the traveling time");
		String ttime=sc.nextLine();
		LocalDate trdate=LocalDate.parse(tdate);
		LocalTime trtime=LocalTime.parse(ttime);
		if(trdate.isAfter(bdate) || trtime.isAfter(btime)) {
			System.out.print("your booking date : "+bdate+"		");
			System.out.println("Your booking time : "+btime);
			System.out.print("Your travelling date is : "+trdate+"		");
			System.out.println("Your travelling time is : "+trtime);
			cabtype();
		}
		else {
			System.out.println("You can't book the cab for past times");
		}
	}
	public static void cabtype() {
		// Choosing cab type - level 2
		
		/*If the cab type is MICRO ->1
		 * If the cab type is MINI ->2
		 * If the cab type is PRIME ->3
		 */
		String tab[][]=new String[3][3];
		tab[0][0]="MICRO";
		tab[0][1]="10rs/Km";
		tab[1][0]="MINI";
		tab[1][1]="15rs/Km";
		tab[2][0]="PRIME";
		tab[2][1]="20rs/km";
		tab[0][2]="1";
		tab[1][2]="2";
		tab[2][2]="3";
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tab[i][j]+"   ");
			}
			System.out.print("\n");
		}
		//Price estimator level 3
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the car type");
		int type=sc.nextInt();
		System.out.println("Enter the kilometer");
		double rupee = 0;
		switch(type){
		case 1:{
			double km=sc.nextDouble();
			double rs=km*10;
			//calculating GST level 4
			double gst=rs*0.07;
		    rupee=rs+gst;
			System.out.println("GST is "+gst);
			System.out.println("Your bill amount is "+rupee);
			break;
		}
		case 2:{
			double km=sc.nextDouble();
			double rs=km*15;
			//calculating GST level 4
			double gst=rs*0.07;
		    rupee=rs+gst;
			System.out.println("GST is "+gst);
			System.out.println("Your bill amount is "+rupee);
			break;
		}
		case 3:
		{
			double km=sc.nextDouble();
			double rs=km*20;
			//calculating GST level 4
			double gst=rs*0.07;
			rupee=rs+gst;
			System.out.println("GST is "+gst);
			System.out.println("Your bill amount is "+rupee);
			break;
		}
		default:{
			System.out.println("Please press 1 for MICRO car, 2 for MINI car, 3 for PRIME car");
		}
			
		}
		peakhours(rupee);
	}
	public static void peakhours(double rupee) {
		//peak time - Level 6
		double rs=0;
		System.out.println("Enter the travelling time");
		Scanner sc=new Scanner(System.in);
		String ttym=sc.nextLine();
		LocalTime trtym=LocalTime.parse(ttym);
		int hour=trtym.getHour();
		if(hour>=5 && hour<=7) {
			System.out.println("Your travel is in peak time");
			rs=rupee+(rupee*0.0125);
			System.out.println("Your bill amount is :"+rs);
		}
		seniorcitizen(rs);
		}
	public static void seniorcitizen(double rs) {
		//Senior citizen discount- level 7
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your date of birth");
		String dateofbirth=sc.nextLine();
		LocalDate dob=LocalDate.parse(dateofbirth);
		int byr=dob.getYear();
		LocalDate today=LocalDate.now();
		int tyr=today.getYear();
		int key=tyr-byr;
		System.out.println("You age : " +key );
		if(key>=60) {
			System.out.println("You are senior citizen so you will get 50% discount on your bill");
			double amt=rs*0.5;
			System.out.println("Your final bill amount is: "+amt);
		}
		else {
			System.out.println("Your final bill amount is: "+rs);
		}
		// Payment level 8
		System.out.println("If you want to pay online press 1");
		System.out.println("If you want to pay on time press 0");
		int choice=sc.nextInt();
		long cno=0;
		switch(choice) {
		case 0:
		{
			System.out.println("Your ticket is booked"); //pay on time 
			System.out.println("HAPPY JOURNEY :)");
			break;
		}
		case 1:    //Pay on online
		{
			System.out.println("Enter the expire date"); // To check the card is valid
			String md=sc.next();
			YearMonth monday=YearMonth.parse(md);
			YearMonth thismod=YearMonth.now();
			if(monday.isAfter(thismod)) {
				System.out.println("Enter the card number"); // To check the card is coreect or not
			    cno=sc.nextLong();
			    String cardno = Long.toString(cno);
			    int clen=cardno.length();
			    if(clen==12) {
			    	System.out.println("Payment sucessfull");
			    	System.out.println("Your ticket is booked");
					System.out.println("HAPPY JOURNEY :)");
			    }
			    else {
			    	System.out.println("Invalide card number");
			    }
			}
			else {
				System.out.println("Your card is expired");
			}
		}
		}
		
	}

}
