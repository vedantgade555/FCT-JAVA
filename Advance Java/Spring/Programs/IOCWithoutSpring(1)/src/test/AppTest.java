package test;

public class AppTest {
	public static void main(String[] args)
	{
		ShoopingCart cart1 = new ShoopingCart(new CreditCardPayment());
		ShoopingCart cart2= new ShoopingCart(new PayPalPayment());
		ShoopingCart cart3 = new ShoopingCart(new CryptoPayment());
		
		// Pay using Credit Card 
		//cart.setPaymentStrategy(new CreditCardPayment());
		cart1.checkout(100);
		cart2.checkout(200);
		cart3.checkout(300);
	 	
	}
}

// We are decide setter method to decide runtime  this is called setter injection
// We can also use constructor called constructor injection
