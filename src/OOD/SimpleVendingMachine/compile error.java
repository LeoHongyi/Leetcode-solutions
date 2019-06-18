Wrong Answer
		Input: Please refer to the following steps to regenerate the test case.
		[
		new Inventory(water,175,1),
		water.fill(),
		inventories.add(water),
		new Inventory(coke,225,1),
		coke.fill(),
		inventories.add(coke),
		new VendingMachine(inventories),
		vm.listInventory(),
		vm.listCanBuy(),
		vm.takeQuarter() repeat 7 times,
		vm.listCanBuy(),
		vm.vend(water),
		vm.takeQuarter() repeat 7 times,
		vm.listInventory(),
		vm.listCanBuy(),
		vm.vend(water),
		vm.takeQuarter()
		]
		Failed:
		expected:<25> but was:<200>