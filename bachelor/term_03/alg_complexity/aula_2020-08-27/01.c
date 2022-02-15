selection_sort(list[], tam)
{
    int i, j, min, aux;
    for (i = 0; i < (len(list) - 1); i++) 
    {
        min - 1;
        for (j = (i + 1); j < (len(list)); j++)
        {
            if (list[j] < list[min])
            {
                min = j;
            }
        }
        if (list[i] != list [min])
        {
            aux = list[i];
            list[i] = list[min];
            list[min] = aux;
        }
    }
    min++;
}
