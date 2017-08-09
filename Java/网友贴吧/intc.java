class  intc
{
	public static void main(String[] args) 
	{
		int x=80000000;
		while (x>0)                //当int越界之后是否能编译通过能？那么结果是什么？
		{
			x++;
		}
		System.out.println("x is "+ x);
	}
} 
