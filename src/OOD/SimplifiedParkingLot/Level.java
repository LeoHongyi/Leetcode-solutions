/**
 * Level.java
 * 2 / 3
 * One level of a parking lot will have multiple spots. Let's assume half of them are compact and the others being large ones. If there are odd number of spots, make the large spot more.
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
	private final List<ParkingSpot> spots;
	private final int numCompact;
	private final int numLarge;

	Level (int n) {
		this(n/2,n-n/2);
	}
	Level (int numOfCompactSpots,int numOfLargeSpots) {
		List<ParkingSpot> list = new ArrayList<>(numOfCompactSpots+numOfLargeSpots);
		numCompact = numOfCompactSpots;
		numLarge = numOfLargeSpots;
		for (int i = 0; i < numOfCompactSpots; i++) {
			list.add(new ParkingSpot(VehicleSize.Compact));
		}
		for (int i = 0; i < numOfLargeSpots; i++) {
			list.add(new ParkingSpot(VehicleSize.Large));

		}
		spots = Collections.unmodifiableList(list);
	}

	boolean hasSpot(Vehicle v) {
		for (ParkingSpot ps: spots){
			if (ps.fit(v)) {
				return true;
			}
		}
		return  false;
	}

	boolean park(Vehicle v) {
		for (ParkingSpot ps : spots) {
			if (ps.fit(v)) {
				ps.park(v);
				return true;
			}
		}
		return false;
	}

	boolean strictPark(Vehicle v){
		for (ParkingSpot ps : spots) {
			if (ps.strictFit(v)) {
				ps.park(v);
				return true;
			}
		}
		return false;
	}

	Vehicle optimize() {
		for (ParkingSpot ps : spots) {
			if (ps.unoptimizedParking()) {
				Vehicle v = ps.getCurrentVehicle();
				ps.leave();
				return v;
			}
		}
		return null;
	}

	boolean leave(Vehicle v) {
		for (ParkingSpot ps: spots) {
			if (ps.getCurrentVehicle() == v) {
				ps.leave();
				return true;
			}
		}
		return false;
	}
}