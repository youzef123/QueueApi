package Queue;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Bank {
	public static void main(String[] Tayuan) {
		Scanner in = new Scanner(System.in);
		JOptionPane jop = new JOptionPane();
		QueAdt q = new QueAdt();
		String choice = "",name="",id="",input="",option="",all="";
		double deposit=0;
	    double funds = 0;
	    int bool=0;
	    String[] menu = {"Create new account","Login","Display","End"}; //our menu
	    String[] transact = {"Withraw","Deposit","Deactivate account","Back"}; //our selections
		String[] deactivate = {"Yes", "No"}; //deactivation confirmation
		
		
		while (!choice.equals("End")){
		    id = (q.getPriority()!=0)? "Priority ID:"+q.getPriority():"Priority ID: Empty"; //if it is equal to zero string will be empty
			choice=jop.showInputDialog(null,new JTextArea(id+"\nChoose"),"Menu",1,null,menu,menu[0]).toString();
			
			switch(choice){
			case "Create new account":
				name = jop.showInputDialog(("Enter Your Full Name"));
				deposit = Double.parseDouble(jop.showInputDialog(null, "Enter initial deposit"));
				q.enqueue(deposit, name);
				break;
				
			case "Login":
				if(!q.isEmpty()) 
				{ 
				
				do {
			
				option=
			    
				jop.showInputDialog(null,new JTextArea(q.getCustomer()+id),"Choose Transaction",1,null,transact,transact[0]).toString();
			
				if(!q.isEmpty()) {
				switch(option) {
				case "Withraw":
				funds = 0; ///funds is our transaction amount
				funds = Double.parseDouble(jop.showInputDialog(null, "How much would you like to withraw?")); 
				bool = q.Withraw(funds);
				if(bool==1){
					jop.showMessageDialog(null,"Insufficient funds!",null,JOptionPane.ERROR_MESSAGE);
					
				}
				break;
				case "Deposit":
				funds = 0;
				funds = Double.parseDouble(jop.showInputDialog(null, "How much you would like to deposit?")); 
				q.Deposit(funds);
				break;
				case "Deactivate account": 
					int n = JOptionPane.showOptionDialog(null, //confirmation
						    "Are you sure","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
						    null,
						    deactivate,
						    deactivate[0]);
		        	if(n==0){ // The answer is Yes
		        		q.dequeue();
		        		option="Back"; //Deactivated success going back
		        	}
		        	break;
					}//end of switch 
				} //increment when entering transaction
				else if(q.isFull()){
					jop.showMessageDialog(null,"Our system is full!",null,JOptionPane.ERROR_MESSAGE);
				}
				
					else {
						jop.showMessageDialog(null,"There is no existing account!",null,JOptionPane.ERROR_MESSAGE);
						}
				
				}while(!option.equals("Back"));	
				q.priorityTrack(); //The tracker if the Transaction is done
				}
				
				else {
				jop.showMessageDialog(null,"There is no existing account!",null,JOptionPane.ERROR_MESSAGE);
				}
			case "Display":  //Displaying all accounts
			    all = q.getTry();
				jop.showMessageDialog(null,new JTextArea(all));
				break;
		
			}//end of the mother switch
			
		}//end of mother while
		
		
	}//end of main
}//end of class
