//QuickSort

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//количество элементов в массиве
		int numberN;
		
		//ввод
		numberN = in.nextInt();
		
		//сам массив
		int[] numbers = new int[numberN+2];
		
		//вводим элементы
		for(int i=0; i<numberN; i++)
			numbers[i] = in.nextInt();
		
		//производим быструю сортировку массива
		//с помощью функции, которая возвращает
		//остортированный массив
		numbers = quickSort(numbers, 0, numberN);
		
		//выводим остортированный массив
		for(int i=0; i<numberN; i++)
			System.out.print(numbers[i] + " ");
		
		in.close();
	}
	
	//функция быстрой сортировка
	public static int[] quickSort(int[] arrayA, int begin, int end){
		//опорный элемент
		int medium;
		//левая и правые стороны
		int leftSide;
		int rightSide;
		
		//временная переменная
		int temp;
		
		//задаем начало и конец массива
		leftSide = begin;
		rightSide = end;
		//находим опорный элемент
		medium = arrayA[(leftSide+rightSide)/2];
		
		//пробегаемся по массиву
		//пока левая сторона не дошла до правой
		while(leftSide <= rightSide){
			
			//идем слева и проверяем элементы с опорным
			//идем до тех пор, пока не найдем элемент,
			//который будет больше нашего опорного элемента,
			//что значит, что он стоит не на своем месте
			while(arrayA[leftSide] < medium)
				++leftSide;
			
			//идес справа и сравниваем элементы с опорным
			//идем до тех пор, пока не найдем элемент,
			//который будет меньше опорного, что значит,
			//что он стоит не на своем месте
			while(arrayA[rightSide] > medium)
				--rightSide;
			
			//если мы нашли такие элементы, которые 
			//не стоят на своих местах, значит 
			//мы еще не дошли до опорного элемента
			//меняем эти элементы
			if(leftSide <= rightSide){
				temp = arrayA[leftSide];
				arrayA[leftSide] = arrayA[rightSide];
				arrayA[rightSide] = temp;
				
				//продолжаем поиски и движение к центру
				++leftSide;
				--rightSide;
			}
		}
		
		//теперь, мы разбиваем массив на две части
		//и проводим аналогичные шаги с каждой половиной
		
		//левая половина будет от 0 до rightSide
		if(rightSide > begin)
			quickSort(arrayA, begin, rightSide);
		//правая будет от leftSide до numbenN
		if(leftSide < end)
			quickSort(arrayA, leftSide, end);
		
		//возвращаем отсортированный массив
		return arrayA;
	}
}