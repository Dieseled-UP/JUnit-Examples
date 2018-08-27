package example_three;

import java.util.ArrayList;
import java.util.List;

public abstract class Flight {

	private int id;
	List<Passenger> passengersList = new ArrayList<Passenger>();

	public Flight(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public List<Passenger> getPassengersList() {
		return passengersList;
	}

	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);
}
