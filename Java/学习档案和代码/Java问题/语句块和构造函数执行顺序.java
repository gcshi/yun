/*
���龲̬���顢�������飨����ֻ�д����ŵ��ǿ飩�Լ����캯����ִ��˳��
����ĳ�ʼ��˳��  ��1�������֮�󣬰����ϵ��£��Ӹ��ൽ���ִࣩ�б�static���ε���䣻��2����static���ִ����֮��,��ִ��main������
					��3����������new������Ķ��󣬽����ϵ���ִ�й������顢�����������߿���˵����һ�𣩡�
*/
class HelloA {

    public HelloA() {
        System.out.println("HelloA");
    }
    
    { System.out.println("I'm A class"); }
    
    static { System.out.println("static A"); }

}

class HelloB extends HelloA
{
    public HelloB()
	{
        System.out.println("HelloB");
    }
    
    { 
		System.out.println("I'm B class"); 
	}
    
    static 
	{
		System.out.println("static B"); 
	}
	public static void main(String[] args)
	{
		new HelloB();
	}
	
}