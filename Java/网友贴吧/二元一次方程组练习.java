/*
������Ϊ  1\ y-x=3;  2\2x-y=1;     
����xy��ֵ����������x\y����Ϊint�����ͣ�
*/

class  fcz
{
	public static void main(String[] args) 
	{
		int x=0,y;
		while (true)
		{
			x++;	//ÿ����x�������Ըı�yֵ
			y=x+3;
			if(2*x-y==1 && x>0)
			{			 
			 System.out.println("x="+x+","+"y="+y);
			 break;
			}
		}
		System.out.println("������");
	}
}
