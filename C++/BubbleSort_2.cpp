//Bubble Sort ver.2

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
		for(int j=i+1; j<numberN; j++){
			if(numbers[i] > numbers[j]){
				temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
			}
		}
	}
	
	//вывод остортированных элементов
	for(int i=0; i<numberN; i++)
		cout << numbers[i] << " ";
}
