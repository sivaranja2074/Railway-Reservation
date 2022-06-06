package myTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import myTask.Passenger.Gender;
import myTask.Passenger.berthPrefrence;

public class Booking {
	static  int TotalLowerBerth=1;
    static int TotalMiddleBerth;
    static int TotalUpperBerth;   
    static int racTickets=1;
    static int waitingTickets=1;
 
    static Queue<Integer> racList;
    static Queue<Integer> waitingList;
    static List<Integer> BookedTicketList;
    static Map<Integer,Passenger> passengerDetailList;
    public Booking() {
	
		  this.racList=new LinkedList<Integer>();
		  this.waitingList=new LinkedList<Integer>();
		  this.BookedTicketList=new ArrayList<Integer>();
		  this.passengerDetailList=new HashMap<Integer,Passenger>();
		  
}        
    public void seatAllot(int seats)
    {
    	double totalberthseat= seats*0.60;
        double racseat=(int)seats*0.20;
        double wlseat=(int)seats*0.20;
        int lberth=(int)totalberthseat/3;
        this.TotalLowerBerth=lberth;
        this.TotalMiddleBerth=lberth;
        this.TotalUpperBerth=lberth;
        this.racTickets=(int) racseat;
        this.waitingTickets=(int) wlseat;
    }
  public void bookedTicketDetail(Passenger person,String status)  
  {  
	  
	   person.getTicket().setAllot(status);
	   System.out.println("Passenger Id : "+person.getTicket().getPnr());
	   System.out.println("Passenger Name : "+person.getName());
	   System.out.println("Passennger Berth with SeatNo :  "+status);
	  if(status=="RAC") {
		   racList.add(person.getTicket().getPnr());
		   passengerDetailList.put(person.getTicket().getPnr(),person);
			System.out.println("---------------------RAC Tickets Booked Successfully!!------------------");
	  }else if(status=="WL") {
			waitingList.add(person.getTicket().getPnr());
			passengerDetailList.put(person.getTicket().getPnr(),person);
		    System.out.println("---------------------You are in Waiting List!!------------------");
	  }else
	  {
		  BookedTicketList.add(person.getTicket().getPnr());
		 passengerDetailList.put(person.getTicket().getPnr(),person);
//		 if(passengerDetailList.isEmpty())
//			 System.out.println("empty");
		// else
			System.out.println("---------------Your Berth Booked Successfully---------------");
			
	  }
	   
	  
  }
 public void seatAllocation(Passenger person)
 {
	  if(person.getAge()<5) {
		  bookedTicketDetail(person,"No Ticket Allocated");
	  }
	  else if(person.getAge()>60 &&TotalLowerBerth>0) {
		System.out.println("You are age one,So we provide a Lower Berth");
		 bookedTicketDetail(person,"LOWER");
		 TotalLowerBerth--;
	 }
	  else if(person.isHavingChild()&&TotalLowerBerth>0) {
			System.out.println("You have a child,So we provide a Lower Berth");
			 bookedTicketDetail(person,"LOWER");
			 TotalLowerBerth--;
		 }
	  else if((person.getBerthPreference().equals(berthPrefrence.LOWER) && TotalLowerBerth>0)||(person.getBerthPreference().equals(berthPrefrence.MIDDLE) && TotalMiddleBerth>0)||(person.getBerthPreference().equals(berthPrefrence.UPPER) && TotalUpperBerth>0)) {
 
		 if(person.getBerthPreference().equals(berthPrefrence.LOWER)){
			 bookedTicketDetail(person,"LOWER");
			 TotalLowerBerth--;
		 }
		 else if(person.getBerthPreference().equals(berthPrefrence.MIDDLE)){
			 bookedTicketDetail(person,"MIDDLE");
			 TotalMiddleBerth--;
		 }
 
		 else if(person.getBerthPreference().equals(berthPrefrence.UPPER)){
			 bookedTicketDetail(person,"UPPER");
			 TotalUpperBerth--;
		 }
	 }
	 else if(TotalLowerBerth>0)
	 {
		 bookedTicketDetail(person,"LOWER"); // ? extends Number
		 TotalLowerBerth--;
	 }
	 else if(TotalMiddleBerth>0)
	 {
		 bookedTicketDetail(person,"MIDDLE");
		 TotalMiddleBerth--;
	 } 
	 else if(TotalUpperBerth>0)
	 {
		 bookedTicketDetail(person,"UPPER");
		 TotalUpperBerth--;
	 }
	 else if(racTickets>0)
	 {
	 
		 bookedTicketDetail(person,"RAC");
		racTickets--;
	 }
	 else if(waitingTickets>0)
	 {
		bookedTicketDetail(person,"WL");
	   waitingTickets--;
	 }	  
 }

  public  void bookTicket(Passenger person) {
	  if(waitingTickets==0)
	  {
		  System.out.println("No Tickets Available");
		  return;
	  }else
	  {
		  seatAllocation(person);
	  }
	 
			 
}
    
    public void cancelTicket(int cancelId) {
    	if(!passengerDetailList.containsKey(cancelId))
		{
			System.out.println("Passenger Id is Not Found");
		}
    	else
		{
			Passenger person=passengerDetailList.get(cancelId);
			System.out.println("-----------------Cancelled Successfuly !!----------");
		
			if(person.getTicket().getAllot().equals(berthPrefrence.LOWER.toString())) {
				TotalLowerBerth++;
			}
			else if(person.getTicket().getAllot().equals(berthPrefrence.MIDDLE.toString())) {
				TotalMiddleBerth++;
			}
			else if(person.getTicket().getAllot().equals(berthPrefrence.UPPER.toString())) {
				TotalUpperBerth++;
			}
			BookedTicketList.remove(cancelId-1);
			passengerDetailList.remove(cancelId);
			if(racList.size()>0)
			{		
				   cancelId = racList.poll();   
	                Passenger rac = passengerDetailList.get(cancelId);
	                BookedTicketList.add(cancelId);                
	                racTickets++;
	                seatAllocation(rac);
	                passengerDetailList.replace(cancelId, rac);   
	               
	                
				if(waitingList.size()>0) {
					
					
					cancelId =waitingList.poll();
                    Passenger wl= passengerDetailList.get(cancelId);
                    racList.add(cancelId);                    
                    waitingTickets++;
                    seatAllocation(wl);
                    passengerDetailList.replace(cancelId, wl);    
					
				}				
				 
				
			}
		}    	
    }
   
   

    
 
    
    
}
