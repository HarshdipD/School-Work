#include <stdio.h>
#include <string.h>

//PROTOTYPES
void Reverse(char*, int, int);


int main()
{	
	// INITIALZING THE STRINGS
	printf("Initializing two arrays...\n");
	char Buffer1[] = {'t','h','i','s',' ','i','s',' ','t','h','e',' ','f','i','r','s','t',' ','b','u','f','f','e','r','\0'}; 
	char Buffer2[] = {"this is the second buffer"};
	printf("Arrays Initialized\n");

	/*Declaring the Buffer3 here*/
	char Buffer3[80];

	/*Asking user to enter string 3*/
	printf("Enter string to Buffer 3: ");
	scanf("%[^\n]%*c", Buffer3);
	

	printf("Buffer1 : %s\n", Buffer1);
	printf("Buffer2 : %s\n", Buffer2);
	printf("Buffer3 : %s\n", Buffer3);
	

	/*Declaring the pointer*/
	char *pBuffer = &Buffer3;
	
	/*Prinitng the buffer from pointer*/
	printf("pBuffer = ");
	while((*pBuffer) != '\0')
	{
		printf("%c", *pBuffer);
		pBuffer++;
	}
	printf("\n");



	//PART 3 (REVERSING)

	char s[1000], r[1000];
   int begin, end, count = 0;
 
	printf("Input a string\n");
	gets(s);
 
   // Calculating string length
 
	while (s[count] != '\0')
		count++;
 
	end = count - 1;
 
	for (begin = 0; begin < count; begin++) {
		r[begin] = s[end];
		end--;
   }
 
	r[begin] = '\0';
 	printf("Reverse is: ");
	printf("%s\n\n", r);





	printf("***Same function using recursion***\n");
	//Using recursion
	char a[100];
 	printf("Enter string to reverse\n");
	gets(a);
 
	Reverse(a, 0, strlen(a)-1);
 	printf("Reversed string is: ");
	printf("%s\n", a);


	return 0;
}




/*Reverses the string (Recursive)
Input: from main
Output: Sends the reverse to main
*/
void Reverse(char *x, int begin, int end)
{
   char c;
 
   if (begin >= end)
      return;
 
   c          = *(x+begin);
   *(x+begin) = *(x+end);
   *(x+end)   = c;
 
   Reverse(x, ++begin, --end);
}
