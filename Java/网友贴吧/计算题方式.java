//计算为1-1/2+1/3-1/4.......-1/100的结果
class Demo
{
	public static void main(String[] args)
	{
		int n =100,i=1;
		double sum=0;
		while(i<=n)
		{
			sum+=1.0/(i%2==0?-i:i);
			i++;
		}
		System.out.println(sum);
	}
}
//第二种方法
class suansu
{
	public static void main(String[] args)
	{
		final double q=1;
		double x=2,y=-2,z=3,g=1;
		while(x<=100)
		{
			if(x%2==0)
			no
				g=g+q/y;
				y+=-2;
				x++;
			}
			else
			{
				g=g+q/z;
				z+=2;
				x++;
			}



		}
		System.out.println("算出的数为："+g);
	}
}
