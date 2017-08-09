//九九乘法表
//利用2个for循环输出99乘法表
class test  
{
	public static void main (String[] args)
	{
	    for (int x=1;x<=9 ;x++ ) 
	    {
	        
	        for(int y=1;y<=x;y++)
	        {
	            System.out.print(y+"*"+x+"="+x*y+"\t");
	        }
	        System.out.println();
	    }
	}
}
