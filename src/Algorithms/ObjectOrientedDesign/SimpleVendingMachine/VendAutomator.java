package Algorithms.ObjectOrientedDesign.SimpleVendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendAutomator {

	public VendAutomator() {
	}
	public void simulate() {
		List<Inventory> inventories = new ArrayList<>();
		Inventory water = new Inventory("water", 175, 1);
		water.fill();
		inventories.add(water);
		Inventory coke =new Inventory("coke", 225, 1);
		coke.fill();
		inventories.add(coke);
		VendingMachine vm = new VendingMachine(inventories);

		List<String> listInventory = vm.listInventory();
		for (String item : listInventory) {
			System.out.println("ListInventory item: " + item);
		}

		List<String> listCanBuy = vm.listCanBuy();
		for (String item : listCanBuy) {
			System.out.println("listCanBuy item: " + item);
		}

		int inputQuarters = 7;
		for (int i = 0; i < inputQuarters; i++) {
			vm.takeQuarter();
		}
		System.out.println("totalInput: " + vm.moneyBalance + " inputQuarters: " + inputQuarters);

		listCanBuy = vm.listCanBuy();
		for (String item : listCanBuy) {
			System.out.println("listCanBuy item: " + item);
		}

		vm.vend("water");
		System.out.println("refund(): " + vm.refund());
		System.out.println("moneyBalance: " + vm.moneyBalance);

		for (int i = 0; i < inputQuarters; i++) {
			vm.takeQuarter();
		}
		System.out.println("moneyBalance: " + vm.moneyBalance + " inputQuarters: " + inputQuarters);
		listInventory = vm.listInventory();
		for (String item : listInventory) {
			System.out.println("listInventory:  " + item);
		}

		listCanBuy = vm.listCanBuy();
		System.out.println("listCanBuy list size(): " + listCanBuy.size());
		for (String item : listCanBuy) {
			System.out.println("listCanBuy item: " + item);
		}
		System.out.println("moneyBalance: " + vm.moneyBalance);
		int vendWater = vm.vend("water");
		System.out.println("moneyBalance: " + vm.moneyBalance);
		System.out.println("VendingMachine.vend(water): " + vendWater);

		vm.takeQuarter();
		System.out.println("moneyBalance: " + vm.moneyBalance);
	}
}


