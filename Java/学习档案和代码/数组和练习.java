//数组练习，利用遍历的方法，将数组中的所有和累加
class  shuzuhe
{
	public static void main(String[] args) 
	{
		int[] he={6,8,9,10,22,65};	
		int num=0;
		for(int x=0;x<he.length;x++)
		{
			num=num+he[x];
		}
		System.out.println("自动计算的和："+num);
		num=6+8+9+10+22+65;
		System.out.println("手动计算的和："+num);
	}
}
