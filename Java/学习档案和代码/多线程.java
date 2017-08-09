//多线程示例，双线程输出语句
class XianCheng extends Thread  //想要使用多线程，第一种继承Thread类
{
	public void run() 
	{
		for (int x=0;x<=70 ;x++ )
		{
			System.out.println(this.getName()+"....two...."+x);
		}
	}
}
class XianCheng1 implements Runnable  //想要使用多线程的第二种方法,使用Runnable接口
{
	public void run()
	{
		for (int x=0;x<=70 ;x++ )
		{
			System.out.println("....one...."+x);
		}
	}
}
class Demo
{
	public static void main(String[] args) 
	{
		/*
		XianCheng p=new XianCheng();		
		XianCheng1 oo=new XianCheng1();
		p.start();                         //p.start 调用多线程，必须覆盖其中的run方法，start启动run方法。
		new Thread(oo).start();				//Thread(Runnable Duixiang) Thread 中有一个构造方法可以传入拥有接口Runnable的类
		*/
		ziyuan zi=new ziyuan();
		che che1=new che(zi);
		yunche yunche1=new yunche(zi);       
		Thread d1=new Thread(che1);
		Thread d2=new Thread(yunche1);
		d1.start(); 
		d2.start();                          //双线程在使用同一资源时，可能出现安全问题
	}
}
//双线程在使用同一资源时，可能出现安全问题例如下
class ziyuan
{
	Object suo=new Object();
	String name;
	String sex;
}
class che implements Runnable
{
	private ziyuan zi;
	che(ziyuan zi)
	{
		this.zi=zi;
	}
	public void run()
	{
		for(int x=0;true;x++)
			{
				synchronized(zi.suo)
				{
					if(x%2==0)
					{
						zi.name="张三";
						zi.sex="男";
					}		
					else
					{
						zi.name="lisi";
						zi.sex="nv";
					}
				}
			}
	}
}
class yunche implements Runnable
{
	private ziyuan zi;
	yunche(ziyuan zi)
	{
		this.zi=zi;
	}
	public void run()
	{
		while(true)
		{
			synchronized(zi.suo)                      //当出现多线程安全问题可以使用synchronized(){}关键字，jdk5之后可以使用lock代替
			{
			System.out.println(zi.name+"........"+zi.sex);
			}
		}
	}
}
