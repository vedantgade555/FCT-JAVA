package test;

public class ShoopingCart {

	private PaymentStrategy paymentStrategy;

	public ShoopingCart(PaymentStrategy paymentStrategy) {
		super();
		this.paymentStrategy = paymentStrategy;
	}
//
//	public PaymentStrategy getPaymentStrategy() {
//		return paymentStrategy;
//	}

	// This called Setter Injection
	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	
	public void checkout(int amount)
	{
		paymentStrategy.pay(amount);
	}
}
