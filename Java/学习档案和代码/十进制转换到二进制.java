/*
���󣺽�10������ת��Ϊ2������

˼·������2�����ݣ�һ��Ϊ�Ʊ�һ����¼ʮ���ƵĶ�λ��ÿһλ��ֵ
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
		get(8);					//�˴��������������
	}
}
