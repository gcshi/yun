class  meinv
{
	public static void main(String[] args) 
	{
		int[] aa={6,9,8,55,4};//定义一个数组
		xu(aa);               		
		selectSort(aa);	        //使用排序方法	
		xu(aa);
	}
	static void selectSort(int[] aa)//选择排序法
	{
		int i,j;
		for(i=0;i<aa.length;i++)       
		{
			for (j=i+1;j<aa.length ;j++ )
			{
				if (aa[j]>aa[i])
				{
					int x=aa[i];
					aa[i]=aa[j];
					aa[j]=x;

				}
			}
		}
	} 
	public static void xu(int[] aa)
	{
		for (int x=0;x<aa.length ; x++)
		{
			System.out.print(aa[x]+"  ");
		}
		System.out.println();

	}
}
