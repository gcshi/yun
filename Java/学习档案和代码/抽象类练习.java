package pack1;
/*
���������һ�������࣬������븲�Ǹ����еĳ��󷽷�;
���������붨���ڳ������������������
����ؼ��֣�  abstract ;
*/
class  shili
{
	public static void main(String[] args) 
	{
		jicheng p=new jicheng();
		p.biaoshi();
		p.show();
		//����ni tt=new ni();�������޷�ʵ����
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
	{System.out.println("�Լ��ķ���");}
	public void show()
	{System.out.println("�̳���");}

}