/*	Andy Liang
	111008856
	CSE 260
	Homework #2 */

public class Ticket{
	private double cost;
	private String description;
	private int ticketNum;

	public Ticket(double cost, String description, int ticketNum){
		this.cost = cost;
		this.description = description;
		this.ticketNum = ticketNum;
	}

	public double getCost(){
		return cost;
	}

	public void setCost(double newCost){
		cost = newCost;
	}

	public String getDescription(){
		return description;
	}

	public int getTicketNum(){
		return ticketNum;
	}
}