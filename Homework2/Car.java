/*	Andy Liang
	111008856
	CSE 260
	Homework #2 */

public class Car{
	private String vin;
	private String make;
	private int year, ticketsReceived;
	private Ticket[] tickets;

	public Car(String vin, String make, int year){
		this.vin = vin;
		this.make = make;
		this.year = year;
		tickets = new Ticket[30];
		ticketsReceived = 0;
	}

	public String getVin(){
		return vin;
	}

	public String getMake(){
		return make;
	}

	public int getYear(){
		return year;
	}

	public Ticket[] getTicketArr(){
		return tickets;
	}

	public int getNumTickets(){
		return ticketsReceived;
	}

	public int getTotalCost(){
		int total = 0;
		for(int i = 0; i < ticketsReceived; i++){
			if(tickets[i] != null){
				total += tickets[i].getCost();
			}
		}
		return total;
	}

	public void addTicket(Ticket newTicket){
		if(ticketsReceived >= tickets.length){
			Ticket[] biggerArr = new Ticket[ticketsReceived*2];
			for(int i = 0; i < tickets.length; i++){
				biggerArr[i] = tickets[i];
				tickets = biggerArr;
			}
		}
		tickets[ticketsReceived++] = newTicket;
		return;
	}

	public void deleteTicket(int ticketNum){
		for(int i = 0; i < ticketsReceived; i++){
			if(tickets[i] != null && tickets[i].getTicketNum() == ticketNum){
				tickets[i] = null;
			}
		}
	}

	public void deleteAllTickets(){
		ticketsReceived = 0;
		for(int i = 0; i < tickets.length; i++){
			tickets[i] = null;
		}
		return;
	}

}