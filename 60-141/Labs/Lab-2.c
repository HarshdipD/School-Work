#include <stdio.h>
#include <time.h>
#define N 5
#define M 10

//MAIN MENU
int main()
{
	int menu;
	int array[M][N];

	do{
	printf("Main Menu\n");
	printf("1 : Initialize the array\t\t");
	printf("2 : Print the array\n");
	printf("3 : Randomly populate the array\t\t");
	printf("4 : Sort\n");
	printf("5 : Search\t\t\t\t");
	printf("6 : Left-Shift the elements\n");
	printf("Press 0 to quit.\n");
	scanf("%d", &menu);

	switch (menu){
		case 1: {
			//FORMULA 1 
			Initialize2D(array);
			break;
		}

		case 2:{
			//FORMULA 2
			PrintArray2D(array);
			break;

		}

		case 3:{
			//FORMULA 3
			PopulateRandomValues2D(array);
			break;
		}

		/*case 4:{
			//FORMULA 4
			Sort2D();
			break;

		}*/

		case 5:{
			//FORMULA 5
			LinearSearch2D();
			break;

		}
/*
		case 6:{
			//FORMULA 6
			LeftShift2D();
			break;

		}		*/	
	}
} while (menu != 0);

	printf("Thank you for using my software.");

	return 0;
}

//FUNCTIONS START HERE

void Initialize2D(int A[M][N]){
	printf("Initializing array...\n");
	for (int i = 0; i < M; i++)
	{
		for (int j = 0; j < N; j++)
		{
			A[i][j] = 0;
		}
	}
	printf("Array Initialized\n\n");
}


void PrintArray2D(int A[M][N]){
	printf("Printing array...\n");
	for (int i = 0; i < M; i++)
	{
		for (int j = 0; j < N; j++)
		{
			printf("%d\t", A[i][j]);
		}
		printf("\n");
	}

	
}


void PopulateRandomValues2D(int A[M][N]){

	time_t t;
	srand((int) time(&t));

	for (int i = 0; i < M; i++)
	{
		for (int j = 0; j < N; j++)
		{
			A[i][j] = (rand() % 99) + 1;
	 
		}
	}
	return 0;
}


/*void  Sort2D(int A[M][N]){

}*/


int LinearSearch2D(int A[M][N]){
	int n;
	int found = 0;
	printf("Enter number to search: ");
	scanf("%d", &n);

	for (int i = 0; i < M; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (n == A[i][j])
			{
				printf("%d found at position row %d column %d", n, i, j);
				found++;
			}
		}
	}
	
	if (found == 0)
	{
		printf("%d was not found in the array\n", n);
	}

	//return 0;
}

/*

int LeftShift2D(){

}
*/
