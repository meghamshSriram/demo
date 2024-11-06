package first;

class A{
	void run() {
		System.out.println("running");
	}
}

public class Reverse extends A {
	void run() {
		System.out.println("running aa");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse obj=new Reverse();
		run();
		
		
		

	}

}
