package Mypackage;

import java.util.Random;
import java.util.Scanner;

public class game {

	public static void main(String[] args) {
		Random console=new Random();
		int rand=console.nextInt(1000);
		Scanner scan=new Scanner(System.in);
		System.out.println("please input integer in 1000:");
		int input=scan.nextInt();
		int i=0;
		while(true) {
			if(input<rand) {
				System.out.println("The integer is too small,intput a new number ");
				input=scan.nextInt();
				i++;
			}
			else if(input>rand) {
				System.out.println("The integer is too big,intput a new number");
				input=scan.nextInt();
				i++;
			}
			else {
				System.out.println("You're right ");
				i++;
				break;
			}
		if(i>=20)
			break;
		}
		if(i<10)
			System.out.println("You're cute");
		else
			System.out.println("You can do better than this");
		System.out.println("You guess"+i);
		
	}

}
