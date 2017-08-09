/*
方程组为  1\ y-x=3;  2\2x-y=1;     
计算xy的值并输出，结果x\y必须为int整数型；
*/

class  fcz
{
	public static void main(String[] args) 
	{
		int x=0,y;
		while (true)
		{
			x++;	//每次让x自增，以改变y值
			y=x+3;
			if(2*x-y==1 && x>0)
			{			 
			 System.out.println("x="+x+","+"y="+y);
			 break;
			}
		}
		System.out.println("结束啦");
	}
}
