//选择排序法
class  PaiXu
{
	public static void main(String[] args) 
	{
		//定义一个数组
		int[] sz={6,9,8,5,2};
		Pai tt=new Pai();
		//排序前
		tt.dayin(sz);
		System.out.println();
		//排序步骤
		tt.huan(sz);
		//排序后
		tt.dayin(sz);
	}
}
class Pai
{
	//遍历循环交换位置
	void huan(int[] a)
	{
		for (int x=0;x<a.length ;x++ )
		{
			for (int y=x+1;y<a.length;y++ )
			{
				if (a[y]>a[x])
				{
					int num=a[y];
					a[y]=a[x];
					a[x]=num;
				}
			}
		}
	}
	//打印传入数组语句
	void dayin(int[] a)
	{
		for (int x=0;x<a.length;x++ )
		{
			System.out.print(a[x]+"  ");
		}
	}
}