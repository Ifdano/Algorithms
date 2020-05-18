//binary search

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//количество элементов в массиве
		int numberN;
		
		//элемент, который мы хотим найти
		int key;
		
		//левая и правая границы массива
		int left;
		int right;
		//середина массива
		int medium;
		//нашли или нет?
		boolean isFound;
		
		//вводим количество элементов
		numberN = in.nextInt();
		
		//сам массив 
		int[] numbers = new int[numberN+2];

		//вводим сами элементы
		for(int i=1; i<=numberN; i++)
			numbers[i] = in.nextInt();
		
		//вводим элемент, который хотим найти
		key = in.nextInt();
		
		//начальная инициализация
		left = 1;
		right = numberN;
		medium = 0;
		isFound = false;
		
		//пока левая граница не дошла до правой
		//или пока мы не нашли элемент
		while(left <= right && !isFound){
			//находим середину массива
			medium = (left+right)/2;
			
			//проверяем, равен ли элемент по середине нашему элементу
			//если да, тогда выходим из цикла
			if(numbers[medium] == key)
				isFound = true;
			else{
				//если не равен, то проверяем, больше наш элемент или нет
				//если больше - отбрасыаем левую часть и проверяем правую
				//если меньше - отбрасываем правую и проверяем левую
				if(numbers[medium] > key)
					right = medium - 1;
				else
					left = medium + 1;
			}		
		}
		
		//из цикла мы выйдем по двум причинам: 
		//когда элементов больше не осталось и мы ничего не нашли
		//когда мы нашли наш элемент
		//поэтому делаем контрольную проверку
		if(numbers[medium] == key)
			System.out.println("Found! Index is: " + medium);
		else
			System.out.println("Is not found!");
		
		in.close();
	}
}