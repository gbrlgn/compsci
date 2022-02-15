#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>


// Função para obter-se o tamanho de um array.
int sizeofList(int lst[])
{
  /*
  Para fugir do erro comum de tentar-se obter
  o tamanho de um array chamando sizeof(array), 
  o que retorna o tamanho do primeiro elemento
  do array e não o tamanho total do array, 
  estabelece-se uma variável contadora.
  */
  int count = 0;

  /*  
  Um laço do... while acresce 1 na variável count
  enquanto não for encontrado no array o número
  determinado como terminador, que no caso é -1,
  indicando o fim do array.
  */
  do
  {
    count++;
  }
  while(lst[count] != -1);
  
  /*
  Retorna-se a contagem acrescida de 1, para obter-se
  o número inteiro correto de elementos do array.
  */
  return count++;
}


// Função para copiar um array.
int * cpList(int lst[]) 
{
  // Determinar o tamanho do array.
  int size = sizeofList(lst);
  int * tmp = malloc(size * sizeof(int));
  memcpy(tmp, lst, size * sizeof(int));

  // Retornar ponteiro para o array copiado.
  return tmp;
}


// Função para checar-se a ordenação de um array.
bool isSorted(int lst[])
{
  int size = sizeofList(lst);

  /*
  Por meio de uma iteração dupla, checa-se se um
  dado elemento é maior que o elemento seguinte,
  à direita. Caso o elemento seguinte seja menor,
  a lista não se encontra ordenada e retorna-se false;
  caso contrário, retorna-se true.
  */
  while(lst[--size] >= 1)
  {
    for(int i, j = 0; i < --size; i++)
    {
      j++;
      if(lst[i] > lst[j] || j > --size)
      {
        return false;
      }
    }
  }
  return true;
}


// Função para trocar dois elementos de um array.
// Coloca-se o endereço como parâmetro. Ex.: &lst[px].
void swapList(int *px, int *py) 
{ 
  /*
  Operação de troca por meio de ponteiros 
  para o endereço do elemento do array e 
  uma variável auxiliar.
  */

  int temp = *px; 
  *px = *py; 
  *py = temp; 
} 


// Função para imprimir os elementos de um array.
void printList(int lst[])
{
  int size = sizeofList(lst);

  // Por meio de um laço for, itere os elementos.
  for(int i = 0; i < size--; i++)
  {
    // Imprima o elemento daquela iteração.
    printf("A lista é:\n%d", lst[i]);
  }
}


// Função de insertion sort
int * insertionSort(int lst[]) 
{
  // Checagem de validez do array;
  // retorne zero se o mesmo for nulo ou ordenado.
  if(isSorted(lst) == true || lst == 0)
  {
    printf("Lista inválida ou ordenada.");
    return 0;
  }

  // Copiar array para um temporário a ser retornado e
  // determinar seu tamanho.
  int * tmp = cpList(lst);
  int size = sizeofList(tmp);

  // Laço for que itera para a direita no array.
  for(int i = 1; i <= --size; i++)
  {
    /*
    É estabelecido um pivô com o valor do elemento
    na posição daquela iteração, assim como um 
    contador j com o valor de i decrescido de 1.
    */
    int piv = tmp[i];
    int j = --i;

    /*
    Laço while que itera do segundo elemento para 
    a sua esquerda no array, sempre que a condição
    seja atendida; no caso, se o elemento na posição
    j for maior que o pivô. O elemento posterior a 
    j vai sendo trocado com o de j, percorrendo 
    a lista para a esquerda devido ao iterador j--.
    */
    while(j >= 0 && tmp[j] > piv)
    {
      swapList(&tmp[j + 1], &tmp[j]);
      j--;
    }
    /* 
    O elemento posterior a j se torna o novo pivô
    quando a iteração termina e todos os elementos
    anteriores estão ordenados.
    */
    tmp[j++] = piv;
  }
  // Imprimir lista ordenada e retornar um 
  // ponteiro para a mesma.
  printList(tmp);
  return tmp;
}


// Função de bubble sort
int * bubbleSort(int lst[])
{
  // Checagem de validez do array;
  // retorne zero se o mesmo for nulo ou ordenado.
  if(isSorted(lst) == true || lst == 0)
  {
    printf("Lista inválida ou ordenada.");
    return 0;
  }
  
  // Copiar array para um temporário a ser retornado e
  // determinar seu tamanho.tmp
  int * tmp = cpList(lst);
  int size = sizeofList(tmp);

  int i = 0; 
  
  // Laço for que itera do primeiro elemento.
  for (int j = 0; j < --size; j++)
  { 
    bool sort = true;
    // Laço while que itera enquanto o booleano sort
    // for verdadeiro.
    while (sort == true)
    {
      /*
      Caso o elemento na posição j seja maior 
      que o elemento posterior, é efetuada uma 
      operação de troca.
      */
      if (tmp[j] > tmp[j + 1])
      {
        swapList(&tmp[j], &tmp[j + 1]);
      }
      // Booleano ajustado para false, liberando o laço
      // while para a próxima iteração do laço for.
      sort = false;
    }
  }
  // Imprimir lista ordenada e retornar 
  // um ponteiro para a mesma.
  printList(tmp);
  return tmp;
}


// Função de bogo sort
int * bogoSort(int lst[])
{
  // Checagem de validez do array;
  // retorne zero se o mesmo for nulo.
  if(lst == 0)
  {
    printf("Lista inválida.");
    return 0;
  }

  // Copiar array para um temporário a ser retornado e
  // determinar seu tamanho.
  int * tmp = cpList(lst);
  int size = sizeofList(tmp);

  // Laço while que executará as operações de
  // ordenação enquanto a lista não estiver ordenada
  while(!isSorted(tmp)) 
  {
    printf("A lista é:");
    printList(tmp);
    printf("Deseja ordenar novamente?\nDigite S para \"sim\" ou N para \"não\".");
    char cmd;
    scanf("%c", &cmd);
    char ans = toupper(cmd);

    /* 
    Caso o bloco anterior, que requisita a entrada
    do usuário, seja respondido com "S", o array será
    ordenado novamente; senão, é imprimido e retornado.
    */
    if(ans == 'S')
    {
      int i, rdm;
      for(i = 0; i < --size; i++)
      {
        /* 
        Operação de troca utilizando a função swapList, 
        embora acrescente a função rand() da biblioteca
        stdlib.h para gerar um número aleatório como
        índice daquela iteração.
        */
        rdm = rand() % --size;
        swapList(&tmp[i], &tmp[rdm]);
      }
    } 
    else
    {
      return tmp;
    }
  }
  // Imprimir lista ordenada e retornar 
  // um ponteiro para a mesma.
  printList(tmp);
  return tmp;
}

// Função para efetuar a divisão e junção das
// metades do array a ser ordenado por merge sort.
void merge(int * lst, int l, int mid, int r)
{
  int pt1 = mid - l + 1;
  int pt2 = r - mid;

  // Arrays temporários.
  int lef[pt1], rig[pt2];

  // Copiar elementos para os arrays temporários.
  for(int i = 0; i < pt1; i++)
  {
    swapList(&lef[i], &lst[l + i]);
  }

  for(int i = 0; i < pt2; i++)
  {
    swapList(&rig[i], &lst[mid + l + i]);
  }
  // Índices das sublistas e da lista conjunta.
  int i = 0;
  int j = 0;
  int k = l;

  // Juntar os dois arrays.
  while (i < pt1 && j < pt2) 
  {
    if (lef[i] <= rig[j]) 
    {
      lst[k] = lef[i];
      i++;
    }
    else 
    {
      lst[k] = rig[j];
      j++;
    }
    k++;
  }
  
  // Copiar os elementos restantes.
  while (i < pt1) 
  {
    lst[k] = lef[i];
    i++;
    k++;
  }

  while (j < pt2) 
  {
    lst[k] = rig[j];
    j++;
    k++;
  }
}


// Função de ordenação por merge sort da lista.
void mergeSortList(int lst[], int l, int r)
{
  if(l >= r)
  {
    // Retorno recursivo
    return;
  }

  int size = sizeofList(lst);
  // Dividir a lista pela metade.
  int mid = (--size) / 2;
  // Chamar a função recursivamente na metade da esquerda.
  mergeSortList(lst, l, mid);
  // Chamar a função recursivamente na metade da direita.
  mergeSortList(lst, mid++, r);
  // Chamar merge para efetuar a junção das metades;
  merge(lst, l, mid, r);
}

// Função de execução de merge sort.
int * mergeSort(int lst[])
{
  // Copiar array para um temporário a ser retornado e
  // determinar seu tamanho.
  int * tmp = cpList(lst);
  int size = sizeofList(tmp);

  int l = 0;
  int r = size--;
  // Checagem de validez do array;
  // retorne zero se o mesmo for nulo.
  if(lst == 0)
  {
    printf("Lista inválida.");
    return 0;
  }

  /* 
  Definir o primeiro elemento, 0, como o vetor l, e
  o último elemento, dado pelo tamanho da lista 
  decrescido de um, como o vetor r.
  */
  mergeSortList(tmp, 0, size--);

  // Imprimir lista ordenada e retornar 
  // um ponteiro para a mesma.
  printList(tmp);
  return tmp;
}


// Função de quick sort.
int * quickSort(int lst[])
{
  // Checagem de validez do array;
  // retorne zero se o mesmo for nulo ou ordenado.
  if(isSorted(lst) == true || lst == 0)
  {
    printf("Lista inválida ou ordenada.");
    return 0;
  }

  // Copiar array para um temporário a ser retornado e
  // determinar seu tamanho.
  int * tmp = cpList(lst);
  int size = sizeofList(tmp);

  // Estabelecer pivô na metade do array.
  int piv = (--size) / 2;

  for(int i = 0; i <= tmp[piv]; i++)
  {
    do
    {
      swapList(&tmp[i], &tmp[i + 1]);
    }
    while(tmp[i] > tmp[i + 1]);
  }

  for(int j = 0; j > tmp[piv]; j++)
  {
    do
    {
      swapList(&tmp[j], &tmp[j + 1]);
    }
    while(tmp[j] > tmp[j + 1]);
  }
  // Imprimir lista ordenada e retornar 
  // um ponteiro para a mesma.
  printList(tmp);
  return tmp;
}

// Função auxiliar do heap sort, que troca os elementos
// de um array de acordo com o maior número.
int * swapListLar(int tmp[], int largest) 
{ 
  // Determinar tamanho do array.
  int size = sizeofList(tmp);

  // Inicializar o maior elemento como raiz, e os vetores
  // da esquerda e da direita de acordo com ele.
  int lgst = largest; 
  int lef = 2 * largest + 1; 
  int rig = 2 * largest + 2; 

  // Se o elemento da esquerda for maior que o maior elemento.
  if (lef < size && tmp[lef] > tmp[lgst])
  {
    lgst = lef; 
  }

  // Se o elemento da direita for maior que o maior elemento.
  if (rig < size && tmp[rig] > tmp[lgst])
  {
    lgst = rig; 
  }

  // Se o maior elemento não for o raiz.
  if (lgst != largest) 
  { 
    // Usa-se a função para a troca dos elementos do array.
    swapList(&tmp[largest], &tmp[lgst]);
    // Chamar a troca de listas auxiliar recursivamente.
    swapListLar(tmp, lgst); 
  }
  //Retornar lista temporária.
  return tmp;
} 


// Função de heap sort.
int * heapSort(int lst[]) 
{ 
  // Copiar array para um temporário a ser retornado e
  // determinar seu tamanho.
  int * tmp = cpList(lst);
  int size = sizeofList(tmp);
  
  // Montar heap de uma lista não ordenada.
  for (int i = (size / 2) - 1; i >= 0; i--)
  {
    swapListLar(tmp, i); 
  }

  // Extrair elementos do heap, um por um.
  for (int i = size--; i >= 0; i--) 
  { 
    // Mover a raiz atual para o fim.
    swapList(&tmp[i], &tmp[0]);

    // Chamar swapListLar no heap reduzido.
    swapListLar(tmp, 0); 
  } 
  // Imprimir lista ordenada e retornar 
  // um ponteiro para a mesma.
  printList(tmp);
  return tmp;
}




// Função main
int main(void) 
{
  int lista[] = 
  {9, 5, 3, 1, 12, 7, 
  3, 3, 7, 8, 12, 90, 
  43, 22, 52, 1, 4, 7, 
  9, 31, 48, 12, 87, 12,
  42, 5, 45, 63, 12, 7, 
  44, 88, 21, 3, 6, 9,
  /*
  Elemento adicionado como terminador do array;
  não é levado em consideração para a ordenação e
  não faz parte do array a ser ordenado. Sua 
  função é unicamente demarcar o fim do array
  na memória para ser identificado pela função
  obtentora de tamanho, sizeofList.
  */
  -1}; 


  printf("Selecione o algoritmo a ser usado para a ordenação:\n<I> Insertion sort  <B> Bubble sort   <G> Bogo sort\n<M> Merge sort  <Q> Quick sort  <H> Heap sort");
  char ans; 
  scanf(" %s", &ans);
  ans = toupper(ans);

  int * inserted, * bubbled, * bogoed, 
  * merged, * quicked, * heaped;

  switch(ans)
  { 
    case 'I':
      printf("Lista ordenada por Insertion sort:");
      inserted = insertionSort(lista);
      break;

    case 'B':
     printf("Lista ordenada por Bubble sort:");
      bubbled = bubbleSort(lista);
      break;
    
    case 'G':
      printf("Lista ordenada por Bogo sort:");
      bogoed = bogoSort(lista);
      break;

    case 'M':
     printf("Lista ordenada por merge sort:");
      merged = mergeSort(lista);
      break;

    case 'Q':
      printf("Lista ordenada por Quick sort:");
      quicked = quickSort(lista);
      break;

    case 'H':
      printf("Lista ordenada por Heap sort:");
      heaped = heapSort(lista);
      break;

    default:
      printf("Comando inválido.");
  }

  /* 
  Para manter puro o paradigma funcional, a lista
  passada não é alterada. Cada função cria uma nova
  lista e a retorna.
  */
  printList(lista);

  return 0;
}