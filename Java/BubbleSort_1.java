//Bubble Sort ver.1

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//количество элементов в массиве
		int numberN;
	
		//дополнительная переменная
		int temp;
	
		//ввод количества элементов
		numberN = in.nextInt();
	
		//объявление массива
		int[] numbers = new int[numberN+2];
	
		//ввод элементов массива
		for(int i=0; i<numberN; i++)
			numbers[i] = in.nextInt();
	
		//шаги пузырьковой сортировки
		for(int i=0; i<numberN-1; i++){
			for(int j=1; j<numberN-i; j++){
				if(numbers[j-1] > numbers[j]){
					temp = numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	
		//вывод остортированных элементов
		for(int i=0; i<numberN; i++)
			System.out.print(numbers[i] + " ");
		
		in.close();
	}
}