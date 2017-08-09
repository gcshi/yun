/*
需求：将10进制数转换为2进制数

思路：定义2个数据，一个为制表，一个记录十进制的二位数每一位的值
*/

class  zhuanhuan
{
	public static void get(int a)
	{
		char p[]={'0','1'};
		char o[]=new char[32];   
		int arr=o.length;    
		while (a!=0)
		{
			int temp=a&1; 
			o[--arr]=p[temp];
			a=a>>>1;
		}
		for (int x=arr;x<32;x++ )
		{
			System.out.print(o[x]);
		}
	}
	public static void main(String[] args)
	{
		get(8);					//此处传入数即可算出
	}
}
