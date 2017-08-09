/**
这是一个可以对数组操作的工具，该类提供了排序，最值等功能
@version:V1.0
*/
public class  shuzugongju
{
	//查找最大值；
	public static int da(int[] arr){
		int y=0;
		for (int x=0;x<arr.length-1 ;x++ ){
			if (arr[x]<arr[y])
			{
				y=x;
			}
		}
		return arr[y];
	}
	//查找最小值；
	public static int xiao(int[] arr)
	{
		int y=0;
		for (int x=0;x<arr.length-1 ;x++ )
		{
			if (arr[x]>arr[y])
			{
				y=x;
			}
		}
		return arr[y];
	}
	//输出数组
	public static void shuchu(int[] arr)
	{
		System.out.print("[");
		for (int x=0;x<arr.length ;x++ )
		{
			if (x!=arr.length-1)
			{
				System.out.print(" "+arr[x]+" ,");
			}
			else 
				System.out.println(" "+arr[x]+" ]");
		}
	}
	//选择排序从小到大排列
	public static void xiaotoda(int[] arr)
	{
		for (int x=0;x<arr.length;x++ )
		{
			for (int y=x+1; y<arr.length;y++ )
			{
				if (arr[x]>arr[y])
				{
					swap(arr,x,y);
				}
			}
		}
	}
	//数组位置交换
	public static void swap(int[] tt,int a,int b)
	{
		int tom=tt[a];
		tt[a]=tt[b];
		tt[b]=tom;
	}
	//选择排序从大到小排列
	public static void datoxiao(int[] arr)
	{
		for (int x=0;x<arr.length;x++ ){
			for (int y=x+1; y<arr.length;y++ ){
				if (arr[x]<arr[y]){
					swap(arr,x,y);
				}
			}
		}
	}
}
