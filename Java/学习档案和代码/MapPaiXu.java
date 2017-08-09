package Map;
//TreeMap练习-字母出现的次数
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapPaiXu
{

	public static void main(String[] args)
	{ 
		jisuan("akfgdjakdd");
	}

	private static void jisuan(String ttp) 
	{
		//将字符串转为字符数组
		char[] oop=ttp.toCharArray();
		TreeMap<Character,Integer> op=new TreeMap<Character,Integer>();
		//遍历字符数组，存入数据
		for(int x=0;x<oop.length;x++)
		{
			if(op.get(oop[x])==null)
				op.put(oop[x], new Integer(1));
			else
			{
				op.put(oop[x], op.get(oop[x])+1);
			}
		}
		//System.out.println(op);
		Iterator<Entry<Character,Integer>>  op1= op.entrySet().iterator();
		while(op1.hasNext())
		{
			Entry<Character,Integer> op2=op1.next();
			Character op3=op2.getKey();
			Integer op4=op2.getValue();
			System.out.print(op3+"("+op4+")");
			
		}
	}
	

}
