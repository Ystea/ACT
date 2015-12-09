package regina;

public class Main {
	
	
	public static void main(String[] args) {
		Pizza pizza = new Pizza("data.in");
		Certificat cert = pizza.random();
		System.out.println(cert);
	}
}
