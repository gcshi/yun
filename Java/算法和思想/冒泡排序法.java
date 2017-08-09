/*
冒泡排序法
需求：让每一个数组中的元素都和后个元素进行比较，如果小于，交换位置例如：{8,6,2,5,33,1};
*/

class maopaopaixu 
{	
	public static void main(String[] args) 
	{
		int[] he={8,6,2,5,33,1};
		xu(he);
		paixu(he);
		System.out.println();
		xu(he);
		System.out.println();
	}
	public static void paixu(int[] he)              //让传入数组进行冒泡排序
	{
		for (int x=0;x<he.length-1 ;x++ )
		{
			for (int y=0;y<he.length-x-1 ;y++ )
			{
				if (he[y]>he[y+1])
				{	
					int jiaohuan=he[y];
					he[y]=he[y+1];
					he[y+1]=jiaohuan;
				}
			}
		}
	}
	public static void xu(int he[])				//遍历输出数组中的每个值
	{
		for (int x=0;x<he.length ;x++ )
		{
			System.out.print(he[x]+"\t");
		}
	}

}