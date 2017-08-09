package pack1;
/*
如果父类是一个抽象类，子类必须覆盖父类中的抽象方法;
抽象对象必须定义在抽象类里，所以类必须抽象
抽象关键字：  abstract ;
*/
class  shili
{
	public static void main(String[] args) 
	{
		jicheng p=new jicheng();
		p.biaoshi();
		p.show();
		//错误：ni tt=new ni();抽象类无法实例化
		}
}
abstract class ni
{
	int x;
	abstract void show();
}
class jicheng extends ni 
{
	public void biaoshi()
	{System.out.println("自己的方法");}
	public void show()
	{System.out.println("继承了");}

}