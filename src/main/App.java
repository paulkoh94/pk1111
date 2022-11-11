package main;
import main.checkout.Checkout;


public class App {
	private static Checkout checkout = new Checkout();
	
	public static void main(String[] args) throws Exception {
		checkout.checkout();
	}
}
