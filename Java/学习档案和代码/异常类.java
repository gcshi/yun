//异常学习,抛出异常关键字throws,throw,处理异常格式  try{}catch(){}finally{} 
class Demo
{
	public static void main(String[] args)
	{
		/*
		发现当除数为零时，发生算术异常,发生异常要么进行处理，要么交给别人处理
		Exception in thread "main" java.lang.ArithmeticException: / by zero
		System.out.println(jisuan(10,0));
		*/	
		try
		{
			System.out.println(jisuan(10,0));
		}
		catch(ArithmeticException e)
		{
			System.out.println("出现了异常");
		}
	}
	static int jisuan(int a,int b)throws ArithmeticException
	{
		return a/b;
	}
}
//自定义异常,要想使用自定义异常必须集成异常类
class Yichang extends ArithmeticException
{}
class Demo2
{
	public static void main(String[] atgs)throws Exception
	{
		try
		{
			System.out.println(jisuan(10,0));
		}
		catch(ArithmeticException e)//多态相当于 ArithmeticException e=new Yichang();
		{
			System.out.println("出现了异常");
		}
		new zi().show();
		new zi().biaoshi();
	}
	static int jisuan(int a,int b) throws Yichang
	{
		if(b==0)
			throw new Yichang();
		return a/b;
	}
}
//子夫类异常，如果子类继承父类的方法并复写，那么，子类只能抛出父类的异常或改异常的子类
class fu
{
	void show() throws ArithmeticException
	{
		System.out.println("FU");
	}

}
class zi extends fu
{
	void show() throws Yichang //throws Exception编译不能通过，被覆盖的方法未抛出，但是子类Yichang却可以
	{
		System.out.println("ZI");
	}
	void biaoshi() throws Exception
	{
		System.out.println("Dier");//父类中没有的方法可以抛出异常
	}
}
