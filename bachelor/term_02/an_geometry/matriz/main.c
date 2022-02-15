#include <stdio.h>

int main(void) {
   
   int matriz[2][3];
   int i, j;
   
   for(i = 0; i < 2; i++) {
      for(j = 0; j < 3; j++) {
         printf("Informe o valor do elemento (%d,%d): ", i + 1, j + 1);
         scanf("%d", &matriz[i][j]);
      }
   }
   
   printf("Arranjo bidimensional: \n");
   for(i = 0; i < 2; i++) {
      for(j = 0; j < 3; j++) {
         printf("%d ", matriz[i][j]);
         if(j == 2){
            printf("\n");
         }
      }
   }
   return 0;
}
