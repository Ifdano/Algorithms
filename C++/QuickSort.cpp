//quickSort

#include <iostream>

using namespace std;

//в —++ нельз€ возвращать массив, поэтому, мы
//просто задаем один массив и пользуемс€ им до конца
//с помощью указателе… указываем, что данный массив и есть тот
//самый массив, который мы объ€вили в начале программы
//остальное без изменений
void quickSort(int *arrayA, int begin, int end){
	
	int medium;
	int leftSide;
	int rightSide;
	
	int temp;
	
	leftSide = begin;
	rightSide = end;
	medium = arrayA[(leftSide+rightSide)/2];
	
	while(leftSide <= rightSide){
		while(arrayA[leftSide] < medium)
			++leftSide;
		while(arrayA[rightSide] > medium)
			--rightSide;
		
		if(leftSide <= rightSide){
			temp = arrayA[leftSide];
			arrayA[leftSide] = arrayA[rightSide];
			arrayA[rightSide] = temp;
			
			++leftSide;
			--rightSide;
		}
		
	}
	
	if(rightSide > begin)
		quickSort(arrayA, begin, rightSide);
	if(leftSide < end)
		quickSort(arrayA, leftSide, end);
}

int main(){
	
	int numberN;
	
	cin >> numberN;
	
	int arrayA[numberN+2];
	
	for(int i=0; i<numberN; i++)
		cin >> arrayA[i];
		
	quickSort(arrayA, 0, numberN);
	
	for(int i=0; i<numberN; i++)
		cout << arrayA[i] << " ";
}
