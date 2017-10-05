/*	Andy Liang
	111008856
	CSE 260
	Homework #2 */

public class CarRepairShop {	
	private Car[] cars;
	private Ticket[] tickets;
	private int carCount, carsInShop, ticketCount;

	public CarRepairShop(){
		cars = new Car[100];
		tickets = new Ticket[100];
		carCount = 0; // Counter for cars array. Will always increase.
		carsInShop = 0; // Number of cars in cars array.
		ticketCount = 1;
	}

	public int searchVin(String vin){
		for(int i = 0; i < carCount; i++){
			if(cars[i] != null && cars[i].getVin().equals(vin)){
				return i;
			}
		}
		return -1;
	}

	public int addNewCar(String vin, String make, int year) {
		if(searchVin(vin) != -1){
			return -1;
		}
		Car newCar = new Car(vin, make, year);
		cars[carCount++] = newCar;
		return ++carsInShop;
	}

	public void addTicket(Ticket newTicket){
		if(ticketCount > tickets.length){
			Ticket[] biggerArr = new Ticket[ticketCount*2];
			for(int i = 0; i < tickets.length; i++){
				biggerArr[i] = tickets[i];
				tickets = biggerArr;
			}
		}
		tickets[ticketCount - 1] = newTicket;
		return;
	}
	
	public int addRepairTicket(String vin, double cost, String description) {
		int index = searchVin(vin);
		if(index == -1){
			return -1;
		}
		Ticket newTicket = new Ticket(cost, description, ticketCount);
		cars[index].addTicket(newTicket);
		addTicket(newTicket);
		ticketCount++;
		return ticketCount - 1;
	}
	
	public int searchTicket(int ticketNum){
		for(int i = 0; i < ticketCount - 1; i++){
			if(tickets[i] != null && tickets[i].getTicketNum() == ticketNum){
				return i;
			}
		}
		return -1;
	}

	public double getRepairCost(int ticketNum) {
		int index = searchTicket(ticketNum);
		if(index == -1){
			return -1.0;
		}
		return tickets[index].getCost();
	}
	
	public double getTotalRepairCosts(String vin) {
		int index = searchVin(vin);
		if(index == -1){
			return -1;
		}
		return cars[index].getTotalCost();
	}

	public String getWorstCarMake() {
		Car worstCar = null;
		if(carsInShop == 0){
			return null;
		}
		for(int i = 0; i < carCount; i++){
			if(worstCar == null
				|| (cars[i] != null && cars[i].getNumTickets() > worstCar.getNumTickets())){
				worstCar = cars[i];
			}
		}
		if(worstCar == null)
			return null;
		else
			return worstCar.getMake();
	}
	
	public boolean updateRepairCost(int ticketNum, double newCost) {
		int index = searchTicket(ticketNum);
		if(index == -1){
			return false;
		}
		tickets[index].setCost(newCost);
		return true;
	}
	
	public boolean deleteRepair(int ticketNum) {
		int index = searchTicket(ticketNum);
		if(index == -1){
			return false;
		}
		tickets[index] = null;
		for(int i = 0; i < carCount; i++){
			if(cars[i] != null){
				cars[i].deleteTicket(ticketNum);
			}
		}
		return true;
	}
	
	public boolean deleteAllRepairsForCar(String vin) {
		int index = searchVin(vin);
		if(index == -1){
			return false;
		}
		cars[index].deleteAllTickets();
		return true;
	}
	
	public boolean deleteCarAndRepairs(String vin) {
		int index = searchVin(vin);
		if(index == -1){
			return false;
		}
		Car carToDel = cars[index];
		Ticket[] carTickets = carToDel.getTicketArr();
		for(int i = 0; i < carTickets.length; i++){
			if(carTickets[i] != null){
				for(int j = 0; j < tickets.length; j++){
					if(tickets[j] != null && (carTickets[i].getTicketNum() == tickets[j].getTicketNum())){
						tickets[j] = null;
						break;
					}
				}
			}
		}
		cars[index] = null;
		return true;
	}
}