//面试题，请问主函数的三句输出语句个是什么？
class Demo
{
	private static String out="";
	static void foo(int a)
	{
		try
		{
			if (a==1)
				throw new Exception();
			out+="1";
		}
		catch (Exception E)
		{
			out+="3";
			return;
		}
		finally
		{
			out+="5";
		}
		out+="7";

	}
	public static void main(String[] args)
	{
		foo(0);
		System.out.println(out);
		foo(1);
		System.out.println(out);
		foo(2);
		System.out.println(out);
	}

}