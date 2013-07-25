5.times{ println("Hello World") }		

bean {
	class "AccountService"
	id "accountService"
}

Pizza {
	size large
	quantity 3
	toppings "Onions, Jalapenos"
	address {
		city "Norcross"
	}
}

Pizza({
	size(large)
	quantity(3)
	toppings("Onions, Jalapenos")
	address({
		city("Norcross")
	})
})


