//GCD, LCM

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//наши числа
		int numberN;
		int numberM;
		
		//НОД и НОК
		int resultGcd;
		int resultLcm;
		
		//вводим их
		numberN = in.nextInt();
		numberM = in.nextInt();
		
		//вычисляем НОД и НОК
		resultGcd = gcd(numberN, numberM);
		resultLcm = lcm(numberN, numberM);
		
		//выводим
		System.out.println(resultGcd);
		System.out.println(resultLcm);
		
		in.close();
	}
	
	//наша фукнция поиска НОД
	public static int gcd(int numberA, int numberB){
		if(numberB==0)
			return numberA;
		else
			return gcd(numberB, numberA%numberB);
	}
	
	//наша функция поиска НОК
	public static int lcm(int numberA, int numberB){
		//проверка на то, чтобы НОД не был равен нулю,
		//иначе это ошибка
		if(numberA==0 && numberB==0)
			return 0;
		else
			return (numberA/gcd(numberA, numberB))*numberB;
	}
	
}