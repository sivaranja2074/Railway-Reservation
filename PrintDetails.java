package myTask;

import java.util.Map;

public class PrintDetails {
    public static  void PassengerDetails() {
    	if(Booking.passengerDetailList.isEmpty()) {
    		System.out.println("No Passenger Details Found");
    		return;
    	}
    	else {
    	
    		 for ( Map.Entry<Integer, Passenger> id :Booking.passengerDetailList.entrySet())
    		 {
    			   Passenger person=Booking.passengerDetailList.get(id.getKey());
    			   if(person.isHavingChild()==true)
    			   {
    				System.out.println("Passenger Id : "+ person.getTicket().getPnr());
       				System.out.println("Passenger Name : "+ person.getName());
       				System.out.println("Passenger Age : "+ person.getAge());
       				System.out.println("Passenger Gender : "+ person.getGender());
       				System.out.println("Having Child : "+ person.isHavingChild());
       				System.out.println("Child Name : "+ person.getChildName());
       				System.out.println("Child Age : "+ person.getChildAge());
       				System.out.println("Child Gender : "+ person.getChildgenderType());
       				System.out.println("Alloted Berth : "+ person.getTicket().getAllot());
       				System.out.println("------------------------------------------------------------------------");
    			   }else
    			   {
    				System.out.println("Passenger Id : "+ person.getTicket().getPnr());
       				System.out.println("Passenger Name : "+ person.getName());
       				System.out.println("Passenger Age : "+ person.getAge());
       				System.out.println("Passenger Gender : "+ person.getGender());
//       			System.out.println("Having Child : "+ person.isHavingChild());
       				System.out.println("Alloted Berth : "+ person.getTicket().getAllot());
       				System.out.println("------------------------------------------------------------------------");
    			   }
    			    
    				
    		 }
   	}
      }
    
	public static void availableTickets()
	{
		System.out.println("No of Lower Berth : "+Booking.TotalLowerBerth);
		System.out.println("No of Middle Berth : "+Booking.TotalMiddleBerth);
		System.out.println("No of Upper Berth : "+Booking.TotalUpperBerth);
		System.out.println("No of RAC Tickets : "+Booking.racTickets);
		System.out.println("No of WaitingList : "+Booking.waitingTickets);
	}
    
}
