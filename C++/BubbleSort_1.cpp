//Bubble Sort ver.1

#include <iostream>

using namespace std;

int main(){
	//количество элементов в массиве
	int numberN;
	
	//дополнительная переменная
	int temp;
	
	//ввод количества элементов
	cin >> numberN;
	
	//объявление массива
	int numbers[numberN+2];
	
	//ввод элементов массива
	for(int i=0; i<numberN; i++)
		cin >> numbers[i];
	
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
		cout << numbers[i] << " ";
}
