/**
����һ�����Զ���������Ĺ��ߣ������ṩ��������ֵ�ȹ���
@version:V1.0
*/
public class  shuzugongju
{
	//�������ֵ��
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
	//������Сֵ��
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
	//�������
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
	//ѡ�������С��������
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
	//����λ�ý���
	public static void swap(int[] tt,int a,int b)
	{
		int tom=tt[a];
		tt[a]=tt[b];
		tt[b]=tom;
	}
	//ѡ������Ӵ�С����
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
