//Sieve of Eratosthenes

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//простые числа до N
		int numberN;
		
		//ввод N
		numberN = in.nextInt();
		
		//хранение простых чисел
		boolean[] prime = new boolean[numberN+1];
		
		/*
		сначала заполняем весь массив true,
		а потом будем отсеивать не простые числа,
		присваивая им false
		*/
		for (int i = 0; i <= numberN; i++)
			prime[i] = true;
		
		//обознаем 0 и 1 как не простые
		prime[0] = false;
		prime[1] = false;
		
		/*
		теперь, будем идти от 2 и дальше,
		зачеркивая числа, которые делятся на i,
		кроме самого i
		*/
		for (int i = 2; i*i <= numberN; i++)
			if (prime[i])
				if((long)i * i <= numberN)
					for (int j = i*i; j <= numberN; j+=i)
						prime[j] = false;
		
		//выводим простые числа от 0 до N
		for (int i = 0; i <= numberN; i++)
			if(prime[i])
				System.out.print(i + " ");
		
		in.close();
	}
}
	
