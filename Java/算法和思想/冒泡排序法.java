/*
ð������
������ÿһ�������е�Ԫ�ض��ͺ��Ԫ�ؽ��бȽϣ����С�ڣ�����λ�����磺{8,6,2,5,33,1};
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
	public static void paixu(int[] he)              //�ô����������ð������
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
	public static void xu(int he[])				//������������е�ÿ��ֵ
	{
		for (int x=0;x<he.length ;x++ )
		{
			System.out.print(he[x]+"\t");
		}
	}

}