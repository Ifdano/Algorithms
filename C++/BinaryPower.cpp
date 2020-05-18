//binary power

#include <iostream>

using namespace std;

int getPower(int, int);

int main(){
	
	int numberN;
	int numberM;
		
	int result;
		
	cin >> numberN;
	cin >> numberM;
		
	result = getPower(numberN, numberM);
		
	cout << "a ^ n: " << result << endl;
		
}
	
int getPower(int numberA, int powerN){
		
		if(powerN == 0)
			return 1;
		if(powerN % 2 == 1)
			return getPower(numberA, powerN-1) * numberA;
		else{
			int temp = getPower(numberA, powerN/2);
			return temp * temp;
		}
}
