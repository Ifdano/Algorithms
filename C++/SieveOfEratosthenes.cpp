//Sieve of Eratosthenes

#include <iostream>
#include <stdio.h>

using namespace std;

int getBinary(int);

int main(){
	ios_base::sync_with_stdio(0);
    cin.tie(0);
	
	//простые числа до N
	int numberN;
		
	//ввод N
	cin >> numberN;
		
	//хранение простых чисел
	bool prime[numberN+1];
		
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
			if(i * 1ll * i <= numberN)
				for (int j = i*i; j <= numberN; j+=i)
					prime[j] = false;
		
	//выводим простые числа от 0 до N
	for (int i = 0; i <= numberN; i++)
		if(prime[i])
			printf("%d ", i);
	
	return 0;
}

