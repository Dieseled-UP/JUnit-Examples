package example_three;

import java.util.*;

public abstract class Flight {

	private int id;
	Set<Passenger> passengersList = new HashSet<>();

	public Flight(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Set<Passenger> getPassengersSet() {
		return passengersList;
	}

	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);
}
