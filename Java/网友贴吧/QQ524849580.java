/*
����ѭ����������������������4λ�����������ð����ظ����ֺ�0������5543����5043���ǲ��Ϸ������룩
      Ȼ���������������ȫ��ͬ�����ָ�������A��ʾ�����Լ�������ͬλ�ò�ͬ�����ָ�������B��ʾ��
      ������������������Ϊ0�����������
˼·����������Ļ��������������
	  �ж�ab�Ƿ�Ϊ0���ǳ�����������Ǽ�����
	  ��ѡ��ȽϷ��������ͬ���ָ���......
*/
import java.util.Scanner;
class  QQ524849580
{
	public static void main(String[] args) 
	{
		int a,b;
		int [] c=new int[5];                       //����2�����ݽ���int���ݲ��ָ��
		int [] d=new int[4];
		while (true)
		{
			Scanner in=new Scanner(System.in);
		    System.out.print("������һ���������ظ��������λ�������س�������");
			a=in.nextInt();		
		    System.out.print("����������һ���������ظ�������λ����");
			b=in.nextInt();
			if (a==0 && b==0)
				break;
			
			if (pd(a,b,c,d)==-1)
			{
				  System.out.println("�Բп���������???û���ˣ�Ctrl+C�˳���!!");
			}
			else
		     	 System.out.println(jg(c,d));
				


		}
	}
	public static int pd(int a ,int b ,int[] c,int []  d)
	{
		if (a>10000 || a<1000 || b>10000 || b<1000)
		{
			return -1;
		}
		c[4]=1000;
		for (int x=0;x<d.length ;x++)
		{
			c[x]=a/c[4]%10;
			d[x]=b/c[4]%10;					
			c[4] /= 10;	
			if (c[x]==0 || d[x]==0)
			{
				return -1;
			}
	
		}
		for (int x=0; x<d.length;x++ )
		{
			for (int tt=x+1;tt<d.length;tt++ )
			{
				if (c[x]==c[tt] | d[x]==d[tt])
				{
					return -1;
				}
			}
		}
		return 1;

	}
	/*  */
	public static String jg(int[] c,int[] d)
	{
		int pp=0,cc=0;
		for (int x=0; x<4; x++)
		{
			for (int y=0;y<4 ;y++ )
			{
				if(c[x]==d[y] && c[x]!=d[x])
					pp++;

			}
			if (c[x]==d[x])
				cc++;
		}

		String p1=cc+"A"+pp+"B";
		return p1;
	
	}
	
}
