/**
程序功能:向屏幕打印如下图形

     *          
    * *         
   * * *
  * * * *
 * * * * *

程序运行过程：先for 处理前面空格  在for 处理后面星星    最后换行!!

*/
class xing
{
  public static void main(String[] args) 
    {
	for(int x=1;x<=5;x++)
	 {
		

		for(int y=x;y<=5;y++)
		  {    
			System.out.print(" ");
 			
		   }
 		for(int y=1;y<=x;y++)
		  {    
			System.out.print("* ");
 			
		   }
		System.out.println();
	  }
     }



}
