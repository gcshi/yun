/*
需求：循环输入两个整数，必须是4位数，该数不得包含重复数字和0（例如5543或者5043都是不合法的输入）
      然后输出两个数中完全相同的数字个数（以A表示），以及数字相同位置不同的数字个数（以B表示）
      如果输入的两个整数都为0，则结束程序。
思路：首先由屏幕输入两个整数。
	  判断ab是否都为0，是程序结束，不是继续。
	  用选择比较法，算出相同数字个数......
*/
import java.util.Scanner;
class  QQ524849580
{
	public static void main(String[] args) 
	{
		int a,b;
		int [] c=new int[5];                       //定义2个数据接收int数据并分割保存
		int [] d=new int[4];
		while (true)
		{
			Scanner in=new Scanner(System.in);
		    System.out.print("请输入一个不包含重复和零的四位数，按回车结束：");
			a=in.nextInt();		
		    System.out.print("请再输入另一个不包含重复和零四位数：");
			b=in.nextInt();
			if (a==0 && b==0)
				break;
			
			if (pd(a,b,c,d)==-1)
			{
				  System.out.println("脑残看不懂中文???没救了，Ctrl+C退出吧!!");
			}
			else
		     	 System.out.println(jg(c,d));
				


		}
	}
	public static int pd(int a ,int b ,int[] c,int []  d)
	{
		if (a>10000 || a<1000 || b>10000 || b<1000)
		{
			return -1;
		}
		c[4]=1000;
		for (int x=0;x<d.length ;x++)
		{
			c[x]=a/c[4]%10;
			d[x]=b/c[4]%10;					
			c[4] /= 10;	
			if (c[x]==0 || d[x]==0)
			{
				return -1;
			}
	
		}
		for (int x=0; x<d.length;x++ )
		{
			for (int tt=x+1;tt<d.length;tt++ )
			{
				if (c[x]==c[tt] | d[x]==d[tt])
				{
					return -1;
				}
			}
		}
		return 1;

	}
	/*  */
	public static String jg(int[] c,int[] d)
	{
		int pp=0,cc=0;
		for (int x=0; x<4; x++)
		{
			for (int y=0;y<4 ;y++ )
			{
				if(c[x]==d[y] && c[x]!=d[x])
					pp++;

			}
			if (c[x]==d[x])
				cc++;
		}

		String p1=cc+"A"+pp+"B";
		return p1;
	
	}
	
}
