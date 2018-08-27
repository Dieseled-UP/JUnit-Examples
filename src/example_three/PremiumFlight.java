package example_three;

public class PremiumFlight extends Flight {

	public PremiumFlight(int id) {
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
		if (passenger.isVip()) {
			return passengersList.remove(passenger);
		}
		return false;
	}

}
