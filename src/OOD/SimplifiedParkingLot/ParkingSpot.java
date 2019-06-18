/**
 * ParkingSpot.java
 * 1 / 3
 * A parking spot should have a size of either compact or large for compact and large vehicles.
 *
 * It should have methods associated with its status, i.e. empty, occupied etc.
 *
 * Notice that compact cars can park in large spots but large cars cannot park in compact spots.
 * **/
/**
 * enum VehicleSize {
 *   Compact(1)
 *   Large(2)
 * }
 *
 * public abstract class Vehicle {
 *   public abstract VehicleSize getSize();
 * }
 */
public class ParkingSpot {
	private final VehicleSize size;
	private Vehicle currentVehicle;

	ParkingSpot(VehicleSize size){
		this.size = size;
	}

	boolean fit(Vehicle v) {
		return currentVehicle == null && size.getSize() >= v.getSize().getSize();
	}

	boolean strictFit(Vehicle v){
		return currentVehicle == null && size.getSize() == v.getSize().getSize();
	}

	boolean unoptimizedParking() {
		return currentVehicle != null && currentVehicle.getSize().getSize() < size.getSize();
	}
	void park(Vehicle v){
		this.currentVehicle = v;
	}

	void leave() {
		this.currentVehicle = null;
	}

	Vehicle getCurrentVehicle() {
		return this.currentVehicle;
	}
}