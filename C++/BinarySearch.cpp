//binary search

#include <iostream>

using namespace std;

int main(){
	
	int numberN;
		
	int key;
		
	int left;
	int right;
	int medium;
	bool isFound;
		
	cin >> numberN;
		
	int numbers[numberN+2];

	for(int i=1; i<=numberN; i++)
		cin >> numbers[i];
		
	cin >> key;
		
	left = 1;
	right = numberN;
	medium = 0;
	isFound = false;
		
	while(left <= right && !isFound){
		medium = (left+right)/2;
			
		if(numbers[medium] == key)
			isFound = true;
		else{
			if(numbers[medium] > key)
				right = medium - 1;
			else
				left = medium + 1;
		}		
	}
		
	if(numbers[medium] == key)
		cout << "Found! Index is: " << medium << endl;
	else
		cout << "Is not found!" << endl;
}
