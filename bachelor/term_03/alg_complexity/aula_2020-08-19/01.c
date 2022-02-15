int main()
{
	void somavet(int v[n], int *k)
	{
		int i;
		*k = 0;

		for (int i = 0; i <= n; i++)
		{
			*k = (*k) + v[i];
		}
	}

	int localiza(int v[n], int x) 
	{
		int i;

		for (i = 0; i < n; i++)
		{
			if (x == v[i])
			{
				return i;
			}
		
		} 

		return -1;

	}

	return 0;
}
