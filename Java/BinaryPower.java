//binary power

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//число
		int numberN;
		//степень, в которую мы хотим возвести число
		int numberM;
		
		//ответ
		int result;
		
		//ввод
		numberN = in.nextInt();
		numberM = in.nextInt();
		
		//используем функцию для возведения в степень
		result = getPower(numberN, numberM);
		
		System.out.println("a ^ n: " + result);
		
		in.close();
	}
	
	//наша функция для возведения в степень
	public static int getPower(int numberA, int powerN){
		
		//если степень равна 0, то возвращаем 1
		//иначе, проверяем наша степень четная или нет
		//если четная, то вычисляем заново a^n/2 * a^n/2
		//если нечетная, то вычисляем a^n-1 * a
		if(powerN == 0)
			return 1;
		if(powerN % 2 == 1)
			return getPower(numberA, powerN-1) * numberA;
		else{
			int temp = getPower(numberA, powerN/2);
			return temp * temp;
		}
	}
}