package Queue;

/**
 * @author Tayuan
 * this is our bank system using QUEUE algorithm
 */
public class QueAdt {
	private double balance[];
	private int front,rear,capacity,currentSize;
	private String[] names; //this is our client names
	private int[] id;	//this is their id embedded through
	private int priority,track; //this is our the priority number and id tracker
	private String display;
	public QueAdt(){
		track=0;
		priority=1;
		capacity=5;
		currentSize=0;
		names = new String[capacity];
		id = new int[capacity];
		balance = new double[capacity];
		front = -1;
		rear = -1;
	}
	public QueAdt(int capacity){		
		this.capacity=capacity;
		track=0;
		priority=1;
		names = new String[capacity];
		id = new int[capacity];
		currentSize=0;
		balance = new double[this.capacity];
		front = -1;
		rear = - 1;
	}
	public boolean isEmpty() { return front == -1;	}
	public boolean isFull() { return front == 0 && rear==capacity-1;}
	public void enqueue(double data, String name) { //if we are creating account enqueue will be called with name and initial depo
		if(isFull()){								
			                 // i created JOption error message in the main if it is full
		}
	
			if(rear == -1) {
				front = 0;
				rear = 0;
				track=1;
				priority = 1;
				balance[rear] = data; // our initial balance
				names[rear] = name; //names is store into an array
			
			}
			else if(rear + 1 < capacity) {
				priority++;
				++rear;    //pag naa nay sulod atoang stack mu dungag		
				balance[rear] = data; //atoang sunod na client
				names[rear] = name;
				
			}
			currentSize++;  //ma dungagan ang sudlanan
			id[priority-1]=priority; // ang  0 mahimong 1
		}
	
	public double dequeue(){
		double hold = 0;
		if(isEmpty())    //ok nani sya naa tay jop error message pg empty sa main
			System.err.println("Queue is empty");
		else {
			if( front == rear) {
				front = -1;
				rear = -1;
			}
			else {
				hold = balance[track-1];
				for(int i = track-1;i<rear;i++) { // initialazing from track because we delete one value
					balance[i]=balance[i+1];   
					names[i]=names[i+1];
					id[i]=id[i+1];
				}

				rear--;
				priority=id[track-1]; // naa may natanggal so nailis atoang priority number
			}
		}
		return hold;
	}
	public String display() {
		String hold="";
		if(!isEmpty()) {
		for(int i = front; i<= rear; i++) {
				hold+=balance[i]+" ";
			}
		}
		else {
			hold = "Queue is empty";
		}
		return hold;
	}
	public double frontValue(){ return balance[front];}
	public double rearValue() { return balance[rear];}
	public double peek() {
		if(isEmpty()) {
			System.err.println("Queue is empty");
			return -1;
		}
		else {
			return balance[front];
		}
		
	}
	public double last() {
		if(isEmpty()) {
			System.err.println("Queue is empty");
			return -1;
		}
		else {
		return balance[rear];
		}
	}
	public int getPriority(){ //priority number queing
		if(isEmpty()){    //pag wala nasyay papel saiyang kinabuhi 
			track = 0; //dili naka niya priority
		}
		return track;
	}
	public int getCurrentSize(){
		return currentSize;
	}
	public int getCapacity(){
		return capacity;
	}
	public void priorityTrack(){
		if(!isEmpty()) { //pag naay sulod
		if(track<=rear) {
			track++;              //madungagan pag naay ni login
		}
		else {
			track=1;            //kung naka gamit na tanan mubalik sa sugod
		}
		}
	
	}

	public void Deposit(double money) {	
		    balance[track-1] +=money;		//atoang current na client
	}
	public int Withraw(double money) {
		if(money > 0 && balance[track-1]>money) {
			balance[track-1] -= money;   //atoang current na client
			return 0;
		}
		else {      
			return 1; //if insufficient funds
		}
	}
	public String getTry(){   //mao ni ang Display method
		 display = "";
		display+="Name\t\tBalance\t\tAccount number\n";
		if(!isEmpty()) {
		for(int i = front;i<=rear;i++) {   //idisplay niya from sugod
		 display += names[i] + "\t" + balance[i] + "\t\t" + id[i] +"\n"; 	
		} 
		}
		
		return display;
	}
	public String getCustomer(){ //mu greet ni sya sa customer ug para mahibal an kinsa ang nag log in
	 display = "";  
		display = (!isEmpty())?
		 "Hi there "+names[track-1]+"\n" + getBalance():"Empty";
		
		
		return display;
	}
	public String getBalance(){     //mukuha sa balance
		String display = "";
		display = "Your remaining balance is :" + balance[track-1]+"\n";
		return display;
	}
}


