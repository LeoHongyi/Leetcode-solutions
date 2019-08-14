// you can use includes, for example:
// #include <algorithm>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(int N, string &S) {
    // write your code in C++14 (g++ 6.2.0)
    int i, j;//i is the number of the possible was of seating families
    i = 0;

    if (S[0] == '\0'){//check if string is empty
        i = N * 3;
    }
    else {//if string is not empty
        for (j = 1; j <= N; j++){//loop through the rows and search for the same row seats reserved
            if(j == S[]){//find the same row values with the elements in the string
                //if in the same row, A-C never appears, The number of the families plus 1
                if (not A || B || C){
                    i = i + 1;
                }
            
                //if in the same row, H-K never appears, The number of the families plus 1
                else if (not H || J || K){
                    i = i + 1;
                }
            
                //if in the same row, neither E nor F appears, and D and G don't appear at the same time, The number of the families plus 1
                else if (S){
                    i = i + 1;
                }
            } 
        }
    }
    return i;
}
/* split string by space into words.
#include <stdio.h>
#include <string.h>
int main()
{
    char str1[100];
    char newString[10][10]; 
    int i,j,ctr;
       printf("\n\n Split string by space into words :\n");
       printf("---------------------------------------\n");    
 
    printf(" Input  a string : ");
    fgets(str1, sizeof str1, stdin);	
 
    j=0; ctr=0;
    for(i=0;i<=(strlen(str1));i++)
    {
        // if space or NULL found, assign NULL into newString[ctr]
        if(str1[i]==' '||str1[i]=='\0')
        {
            newString[ctr][j]='\0';
            ctr++;  //for next word
            j=0;    //for next word, init index to 0
        }
        else
        {
            newString[ctr][j]=str1[i];
            j++;
        }
    }
    printf("\n Strings or words after split by space are :\n");
    for(i=0;i < ctr;i++)
        printf(" %s\n",newString[i]);
    return 0;
}*/