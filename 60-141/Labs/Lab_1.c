#include <stdio.h>
#include <stdlib.h>
#include <math.h>


//PROTOTYPES

int sum1(int number);
int sum2(int number);
int sum3(int number);
int sum4(int number);
int fibonacci1(int number);
int fibonacci2(int number);
int gcd1(int x, int y);
int gcd2(int x, int y);
int power1(int base, int exponent);
int power2(int base, int exponent);
int display1(int number);
int display2(int number);
int triangle11(int number);
int triangle12(int number);
int triangle21(int number);
int triangle22(int number);

//MAIN FUNCTION

int main() {
	//Main Menu of the program
	int menu, n, i;
	do{
	printf("Main Menu\n");
	printf("NON-RECURSIVE MENU\n");
	printf("1 : Sum of natural numbers\t");
	printf("2 : (i+1)^2\n");
	printf("3 : Fibonacci\t\t\t");
	printf("4 : Greatest common divisor\n");
	printf("5 : Power of a number\t\t");
	printf("6 : Display numbers from n to 1\n");
	printf("7 : Draw Triangle(1)\t\t");
	printf("8 : Draw Triangle(2)\n");
	printf("RECURSIVE MENU\n");
	printf("9 : Sum of natural numbers\t");
	printf("10 : (i+1)^2\n");
	printf("11 : Fibonacci\t\t\t");
	printf("12 : Greatest common divisor\n");
	printf("13 : Power of a number\t\t");
	printf("14 : Display numbers from n to 1\n");
	printf("15 : Draw Triangle(1)\t\t");
	printf("16 : Draw Triangle(2)\n");
	printf("Chose one function to perform or 0 to exit: ");
	scanf("%d", &menu);

	switch (menu){
		case 1: {
			//FORMULA 1 
			printf("Sum of Natural Numbers.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			i = sum1(n);
			printf("Non-Recursive function output: %d\n", i);
			break;
		}
		case 2:{
			//FORMULA 2
			printf("(i + 1)^2.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			i = sum3(n);
			printf("Non-Recursive function output: %d\n", i);
			break;

		}
		case 3:{
			//FORMULA 3
			printf("Fibonacci.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			printf("Non-Recursive function output: \n");
			fibonacci1(n);
			break;
		}
		case 4:{
			//FORMULA 4
			printf("Greatest common divisor.\n");
			int x, y;
			printf("Enter number1: ");
			scanf("%d", &x);
			printf("Enter number2: ");
			scanf("%d", &y);
			i = gcd1(x, y);
			printf("The GCD for %d and %d is (Non-Recursive output): %d\n", x, y, i);
			break;

		}
		case 5:{
			//FORMULA 5
			printf("Power of a number\n");
			int Base, Exp;
			printf("Enter base: ");
			scanf("%d", &Base);
			printf("Enter exponent: ");
			scanf("%d", &Exp);
			i = power1(Base, Exp);
			printf("Non-Recursive function output: %d\n", i);
			break;

		}
		case 6:{
			//FORMULA 6
			printf("Display nunmbers from 1 to n.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			printf("Non-Recursive function output: ");
			display1(n);
			printf("\n");
			break;

		}
		case 7:{
			//FORMULA 7
			printf("Draw triangle(1).\n");
			printf("Enter number: ");
			scanf("%d", &n);
			printf("Non-Recursive function output: \n\n");
			triangle11(n);
			printf("\n\n");
			break;

		}
		case 8:{
			//FORMULA 8
			printf("Draw triangle(2).\n");
			printf("Enter number of *'s on last line: ");
			scanf("%d", &n);
			printf("Non-Recursive function output: \n\n");
			triangle21(n);
			printf("\n\n");
			break;

		}
		case 9: {
			//FORMULA 1 
			printf("Sum of Natural Numbers.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			i = sum2(n);
			printf("Recursive function output: %d\n\n", i);
			break;
		}
		case 10:{
			//FORMULA 2
			printf("(i + 1)^2.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			i = sum4(n);
			printf("Recursive function output: %d\n\n", i);
			break;

		}
		case 11:{
			//FORMULA 3
			printf("Fibonacci.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			printf("Recursive function output: \n");
			int i =0;
			for(int c = 1; c <= n; c++){
				printf("%d", fibonacci2(i));
				i++;
			}
			break;
		}
		case 12:{
			//FORMULA 4
			printf("Greatest common divisor.\n");
			int x, y;
			printf("Enter number1: ");
			scanf("%d", &x);
			printf("Enter number2: ");
			scanf("%d", &y);
			i = gcd2(x, y);
			printf("The GCD for %d and %d is (Recursive output): %d\n", x, y, i);
			break;

		}
		case 13:{
			//FORMULA 5
			printf("Power of a number\n");
			int Base, Exp;
			printf("Enter base: ");
			scanf("%d", &Base);
			printf("Enter exponent: ");
			scanf("%d", &Exp);
			i = power2(Base, Exp);
			printf("Recursive function output: %d\n\n", i);
			break;

		}
		case 14:{
			//FORMULA 6
			printf("Display nunmbers from 1 to n.\n");
			printf("Enter number: ");
			scanf("%d", &n);
			printf("Recursive function output: ");			
			i = display2(n);
			printf("\n");
			break;

		}
		case 15:{
			//FORMULA 7
			printf("Draw triangle(1).\n");
			printf("Enter number: ");
			scanf("%d", &n);
			printf("Recursive function output: \n\n");
			triangle12(n);
			printf("\n\n");
			break;

		}
		case 16:{
			//FORMULA 8
			printf("Draw triangle(2).\n");
			printf("Enter number of *'s on last line: ");
			scanf("%d", &n);
			printf("Recursive function output: \n\n");
			triangle22(n);
			printf("\n\n");
			break;

		}



		
	}
} while (menu != 0);

	printf("Thank you for using my software.");

}

//ALL THE FUNCTIONS START HERE


	/* 	Adds the sum of natural numbers (non-recursive)
   		Input: a number.
  		Output: sum of natural numbers from 1 to the inputted number.
	*/
	int sum1(int number){
		int sum = 0;
		for(int j = 1; j <= number; ++j){
			sum += j;	
		}
		return sum;
	}


	/* 	Adds the sum of natural numbers (recursive)
   		Input: a number.
  		Output: sum of natural numbers from 1 to the inputted number.
	*/
	int sum2(int number){
		if(number == 0){
        	return number;
    } 	else{
        	return number + sum2(number-1);
    	}
	}


	/* 	Calcuates the formula (i+1)^2 (Non-Recursive)
   		Input: a number.
  		Output: The result when applied the number to the formula
	*/
	int sum3(int number){
		int i, total = 0;
		for (int i = 1; i <= number; i++)
		{
			total += (i+1)*(i+1);
		
				
	}
	return total;
}
	

	/* 	Calcuates the formula (i+1)^2 (Recursive)
   		Input: a number.
  		Output: The result when applied the number to the formula
	*/
	int sum4(int number){
		//int total = 0;
		if(number == 1){
			return 4;
		}
		else{
			return ((number+1)*(number+1)) + sum4(number - 1);
		}
	}

	/* 	Finds the fibonnaci sequence (Non-Recursive)
   		Input: a number
  		Output: fibonacci sequence upto the number of terms as in input
	*/
	int fibonacci1(int number){
		int i, t1 = 0, t2 = 1, nextTerm;
		printf("Fibonacci Series: ");

    	for (i = 1; i <= number; ++i)
    	{
    	    printf("%d ", t1);
    	    nextTerm = t1 + t2;
    	    t1 = t2;
    	    t2 = nextTerm;
    	}
    	printf("\n");
    	return 0;	
	}

	/* 	Finds the fibonnaci sequence (Recursive)
   		Input: a number
  		Output: fibonacci sequence upto the number of terms as in input
	*/
	int fibonacci2(int number){
		if (number == 0){
			return 0;
		}

		if( number== 1 || number == 2){
			return 1;
		}
		else{
			return fibonacci2(number-1) + fibonacci2(number-2);

		}
}
		

	/* 	Finds the gretest common divisior (Non-Recursive)
		Input: two numbers
		Output: gives the GCD of the two numbers
	*/
	int gcd1(int a, int b){
	   int temp;
    	while (b != 0)
    	{
        	temp = a % b;

        	a = b;
        	b = temp;
    	}
    	return a;	
	}

	/* 	Finds the gretest common divisior (Recursive)
		Input: two numbers
		Output: gives the GCD of the two numbers
	*/
	int gcd2(int a, int b){
		if (b == 0){
			return a;
		}
		else{
			return gcd2(b, a % b);
		}		
	}

	/* 	Find the power of a number (recursive)
   		Input: base and exponent.
  		Output: result of base reaised to the power of exponent.
	*/
	int power1(int base, int exponent){
		int total = base;
		if(exponent == 0){
			return 1;
		}
		for(int i = 2; i <= exponent; i++){
			
			total *= base;
		}
		return total;
		
	}

	/* 	Find the power of a number (recursive)
   		Input: base and exponent.
  		Output: result of base reaised to the power of exponent.
	*/
	int power2(int base, int exponent){
		if (exponent != 0){
        return (base*power2(base, exponent-1));
    }
    else
        return 1;	
	}

	/* 	Displays numbers from n to 1 (non-recursive)
   		Input: A number
  		Output: Displays numbers from n to 1 
	*/
	int display1(int number){
		for (int i = number; i >= 1; i--)
		{
			printf(" %d ", i);
		}

	}

	/* 	Displays numbers from n to 1 (recursive)
   		Input: A number
  		Output: Displays numbers from n to 1 
	*/
	int display2(int number){
		if(number >= 1){
			printf(" %d ", number);
			display2(number-1);
		}

		
	}

	/* 	Draws an inverted triangle (non-recursive)
   		Input: A number
  		Output: display n number of *'s on the first line, and one less each line until a line with one *
	*/
	int triangle11(int number){
		for(int i = number; i >= 1; i--)
		{
			for(int j = 1; j <= i; j++){
				printf("* ");
								
			}	
			printf("\n");		
		}
		
		return 0;

	}

	/*	Draws an inverted triangle (recursive)
   		Input: A number
  		Output: display n number of *'s on the first line, and one less each line until a line with one *
	*/
	int triangle12(int number){
		if(number<=1){
			printf("*\n");
		}
		else{	
			for(int i = number; i>=1; i--){
				printf("* ");
			}
			printf("\n");
			triangle12(number-1);
		}

	}

	 /*	Draws a triangle (non-recursive)
   		Input: A number
  		Output: a traingle which displays one * on the first line, then one more each line until it displays a line with n *'s
	*/
	int triangle21(int number){
		for(int i = 1; i <= number; i++)
		{
			for(int j = 1; j <= i; j++){
				printf("* ");
								
			}	
			printf("\n");		
		}
		
		return 0;		
	}

	/*	Draws a triangle (recursive)
   		Input: A number
  		Output: a traingle which displays one * on the first line, then one more each line until it displays a line with n *'s
	*/
	int triangle22(int number){
		if(number>1){
			triangle22(number-1);
			while(number >= 1){
				printf("* ");
				number--;
			}
			printf("\n");
		}
		else{
			printf("*\n");		
		}
		
	}


	/*if(number >= 1){
			for(int i = 0; i < number; i++){
				printf("*");
			}
			triangle22(number - 1);*/
	
