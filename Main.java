package myTask;

import java.util.InputMismatchException;
import java.util.Scanner;

import myTask.Passenger.Gender;
import myTask.Passenger.berthPrefrence;
public class Main {

	static final String USERNAME="Zoho";
	static final String PASSWORD="123";
	
	
	
  public static void main(String[] args) {
	  
	  System.out.println("********WELCOME TO THE SOUTH CENTRAL RAILWAY RESERVATION SYSTEM!!*********");
	  System.out.println("			HAVE A SAFE JOURNEY!!			");
	  System.out.println();
	  
	  Scanner scanner=new Scanner(System.in);
 	  Booking test=new Booking(); 
 	  boolean bool=true;
 	  while(bool)
 	  {
 		System.out.println("\n1. Admin\n2. Passenger\n");
       int choose = scanner.nextInt();
       switch(choose)
       {
       case 1:
       {
    	   while(true)
       		{
       			System.out.println("UserName : ");
     			String username=scanner.next();
     			System.out.println("Password : ");
     			String password=scanner.next();
     			if(Main.PASSWORD.equals(password) && Main.USERNAME.equals(username)) {
     				System.out.println("Enter the Number of Seats : ");
     				int seats=scanner.nextInt();
     				test.seatAllot(seats);
     				  break;
     				
     			}else
     			{
     				System.out.println("Invalid Username or password,Please enter the correct username or password ");
     			}
       	}
       		break;
       }
       	case 2:
       				{bool=false;break;}
       
     
    }
 } 
 	  bool=true;
 
 	      while(bool)
 	      {
 		
			 System.out.println(" \n1.Book  \n2.Cancel \n3.BookedTickets \n4.AvailableTickets \n5.Exit");
			 int choice=0;
			 try {
//				 System.out.println("siva");
				 choice = scanner.nextInt();
	             if (choice < 1 && choice > 5) {
	               throw new IllegalArgumentException();
	             }
				 }catch(IllegalArgumentException e){
					  System.out.println("This is an invalid entry. Please try again.");
					  }
              switch(choice)
              {
              case 1:
              {
            	
   			     Passenger person=new Passenger();
   			     person.setTicket(new Ticket());
   			     System.out.println("Enter the passenger name");
   			     person.setName(scanner.next());
   				 System.out.println("Enter the passenger Age");
   				 person.setAge(scanner.nextInt());
   				 System.out.println("select your Gender: 1.Female 2.Male");
   				 int choiceGender=scanner.nextInt();
   				 if(choiceGender==1) {
   					 person.setGender(Gender.FEMALE);
   					 System.out.println("Press 1:If You have a child and age below 5 Press 2:If You are unmarried or haven't a child");
   					 int fchoice=scanner.nextInt();
   					 if(fchoice==1) {
   						 person.setHavingChild(true);
   						 System.out.println("Enter the Child Name");
   						 person.setChildName(scanner.next());
   						 while(true)
   						 {
   							 System.out.println("Enter the Child Age");
      						 int childAge=scanner.nextInt();
      						 if(childAge<=5)
       						 {
      							 person.setChildAge(childAge);
      							 break;
       							 
       						 }else
       						 {
       							System.out.println("Please book the new ticket because 5 years old child only booked a ticket with parents ");
       							
       						 }
   						 }
   						 
   						 System.out.println("select your Gender: 1.Female 2.Male");
   						 int childGender=scanner.nextInt();
   						 if(childGender==1) {
   							 person.setChildgenderType(Gender.FEMALE);
   						 }else
   						 {
   							 person.setChildgenderType(Gender.MALE);
   						 }
   					 }else
   					 {
   						 person.setHavingChild(false);
   					 }
   					 
   					 
   				 }else
   				 {
   					 person.setGender(Gender.MALE);
   					 person.setHavingChild(false);
   				 }
   			    System.out.println("select your type of berth: 1.Lower Berth  2.Middle Berth 3.Upper Berth");
   			    int choiceBerth=scanner.nextInt();
   			    if(choiceBerth==1) {
   			    	person.setBerthPreference(berthPrefrence.LOWER);
    				 }else if(choiceBerth==2)
   				 {
    					person.setBerthPreference(berthPrefrence.MIDDLE);
   				 }else if(choiceBerth==3)
   				 {
   					 person.setBerthPreference(berthPrefrence.UPPER);
   			
   				 }

   			     test.bookTicket(person);
   			      break;
   			   
   		    
              }
              case 2:
              {
              while(true) {	
              	try
              	{  
              		System.out.println("Enter the passenger Id");
              		 int id=scanner.nextInt();
              		 test.cancelTicket(id); 
              		 break;
              	 }catch(InputMismatchException e)
              	 {
              		System.out.println("invalid input!Please enter the corret Id");
              	 }
              }
      			 
      			
              	break;
              	
              }
              case 3:
              {
              	PrintDetails.PassengerDetails();
              	break;
              }
              case 4:{
              	PrintDetails.availableTickets();
              	break;
              }
              case 5:
              {
            	  bool=false;break;
              }
              }
// 		}catch(IllegalArgumentException e){
//			  System.out.println("This is an invalid entry. Please try again.");
//		  }
			  
 	 
 	 }
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	  
 	   
  }
}
