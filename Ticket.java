package myTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Ticket {
		
	    static int id=1;
	    private int pnr=id++; 
	    private String  allot;
	 
		Ticket()
	    {
	    	this.allot=" ";
	    }
 
		public int getPnr() {
			return pnr;
		}
		 public String getAllot() {
				return allot;
		}
		public void setAllot(String allot) {
				this.allot = allot;
		}

		
	
}
	


