/*
需求：输入学生数量，然后依次输入成绩，最后从大到小排序
*/
import java.util.Scanner;
import java.util.Arrays;
class  ll
{
	public static void main(String[] args) 
	{
		System.out.print("请输入学生数量：");
		Scanner in=new Scanner(System.in);
		int xuesheng=in.nextInt();
		int[] cj=new int[xuesheng+1];
		String[] mc=new String[150];
		//循环要求输入成绩
		for (int lio=1,jl=0;lio<cj.length ;lio++ )
		{
			System.out.println("请输入学生成绩：");
			cj[lio]=in.nextInt();
			jl=cj[lio];
			mc[jl]="学生"+lio+"：";
			System.out.print("学生"+lio+"："+cj[lio]+"  ");
			
		}
		System.out.println();
		selectSort(cj,mc);


	}
	public static void selectSort(int[] aa,String[] mc)
	{
		int i,j,t;
		Arrays.sort(aa); 
		for(i=1;i<aa.length;i++)       
		{
			for (j=i+1;j<aa.length ;j++ )
			{
				if (aa[j]>aa[i])
				{
					int x=aa[i];
					aa[i]=aa[j];
					aa[j]=x;

				}
			}
			t=aa[i];
			System.out.print(mc[t]+t+"  ");
		}
	} 
}
