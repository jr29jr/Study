#include <iostream>
#include <stdio.h>
#define DMAX 1000//max of day

using namespace std;

int dayAry[DMAX];
int testcase; 
int D,T;//day,team
double minD=100000;

void minAvg(int day);
int main(void){
	cin>>testcase;
	for(int i=0;i<testcase;i++){
		cin>>D>>T;
		for(int i=0;i<D;i++)
			cin>>dayAry[i];
		for(int i=T;i<=D;i++){
			minAvg(i);
		}
		printf("%0.8f\n",minD);
	  	minD=1000000;
	}
	return 0;
}
void minAvg(int day){
	double sum;
	for(int i=0;i<=D-day;i++){
		sum=0;
		for(int j=i;j<i+day;j++){
			sum+=dayAry[j];	
		}
		sum/=day;
		if(minD > sum)
			minD=sum;
	}
}
