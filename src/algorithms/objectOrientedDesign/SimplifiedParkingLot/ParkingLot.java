/**
 * ParkingLot.java
 * 3 / 3
 * A parking lot should have multiple levels. It should be able to park and leave a vehicle.
 * */
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

public class ParkingLot {
	private final Level[] levels;
	public ParkingLot(int numLevels, int numSpotsPerLevel) {
		levels = new Level[numLevels];
		for (int i = 0; i < numLevels;i++) {
			levels[i] = new Level(numSpotsPerLevel);
		}
	}

	public boolean hasSpot(Vehicle v) {
		for (Level l: levels) {
			if (l.hasSpot(v)) {
				return true;
			}
		}
		if (adjust()) {
			for (Level l: levels) {
				if (l.hasSpot(v)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean park(Vehicle v){
		for (Level l : levels) {
			if (l.hasSpot(v)) {
				l.park(v);
				return  true;
			}
		}
		if (adjust()) {
			for (Level l : levels) {
				if (l.hasSpot(v)) {
					l.park(v);
					return  true;
				}
			}
		}
		return false;
	}

	public boolean leave(Vehicle v) {
		for (Level l : levels) {
			if (l.leave(v)) {
				return true;
			}
		}
		return false;
	}

	private boolean adjust(){
		Vehicle v = null;
		for (Level l : levels) {
			v = l.optimize();
			if (v != null) {
				break;
			}
		}
		if (v != null) {
			for (Level l : levels) {
				if (l.strictPark(v)) {
					return true;
				}
			}
			park(v);
		}
		return false;
	}
}
