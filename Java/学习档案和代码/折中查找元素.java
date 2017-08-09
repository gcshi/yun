/*
程序功能：让数组从小到大排序{6,3,9,5,21,1}并且传入一个数，让他在数组中进行查找，如果找到，返回角标的数值，如果没有，返回-1值
思路：让每个角标的值与后一位比较，如果比后位小就交换位置；使用折中查找方法；
折中查找：先让数组从小到大排序，然后计算中间值与传入值的差，然后再对最小数和最大数进行进行调整，在此计算得出的值再与中间值比较，如此反复，如果
最小值超过最大值，说明该数据不存在，返回-1；
*/
class  chazhao
{
	public static void main(String[] args) 
	{
		int[] he ={6,3,9,5,21,1};
		//没有排序前的数组；
		System.out.print("排序前的结果:");
		xu(he);
		//排序过程；
		paixu(he);
		System.out.println();//这个起到换行作用；
		System.out.print("排序后的结果:");
		//排序结束后的结果；
		xu(he);
		int p=cha(he,21);//传入26在he数组里进行查找
		System.out.println(p);			//打印返回值P
	}

	public static void paixu(int he[])
	{
		for (int x=0;x<he.length-1;x++ )
		{
			for (int y=x+1; y<he.length; y++)
			{
				if (he[x]>he[y])
				{
					int jiaohuan=he[x];
					he[x]=he[y];
					he[y]=jiaohuan;
				}

			}

		}
	}

	public static void xu(int he[])
	{
		for (int x=0;x<he.length ;x++ )
		{
			System.out.print(he[x]+"\t");
		}
	}
	public static int cha(int[] he,int key)
	{
		int min,max,mid;
		min=0;max=he.length-1;mid=(min+max)/2;
		while (he[mid]!=key) 
		{
			if (he[mid]<key) 
			{
				min = mid +1;
				mid=(min+max)/2;
			}
			else if (he[mid]>key)
			{
				max = mid-1;
				mid=(min+max)/2;
			}
			if(min > max)
				return -1;
		}
		return mid;
	}
} 
