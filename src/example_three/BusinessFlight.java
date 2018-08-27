package example_three;

public class BusinessFlight extends Flight {

	public BusinessFlight(int id) {
		super(id);
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		if (passenger.isVip()) {
			return passengersList.add(passenger);
		}
		return false;
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
		return false;
	}

}
