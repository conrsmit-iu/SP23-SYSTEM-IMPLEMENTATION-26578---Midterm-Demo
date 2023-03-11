package ticketManager;

public abstract class PaymentSystem {
	public PaymentSystem() {}
	
	public boolean pay() {
		System.out.println("Payment successful.");
		return true;
		// This is merely a placeholder method
		//It does literally nothing
	}
}
