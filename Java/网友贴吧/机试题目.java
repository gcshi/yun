/*     

向屏幕打印输出
*             
***
*****	
*******
*****   
***	   
*	  

*/
class  Demo
{
	public static void main(String[] args) 
	{
		for (int x=1;x<=7 ;x++ )
		{
			if (x<=4)
			{
				for (int y=1;y<=x*2-1; y++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
			else
			{
				System.out.print("*");
				for (int y=7-x;y>0 ;y-- )
				{
					System.out.print("**");
				}
				System.out.println();	
			}

		}
	}
}