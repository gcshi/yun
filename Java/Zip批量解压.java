import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
/**
 * 
 * 该JAVA程序，可以将目录下的所有Zip压缩包都解压到当前目录并删除原文件
 * @author gcshi
 * @version 1.0
 * */
public class JieYaZip {

	
	public static void main(String[] args) throws ZipException, IOException {
		
		// 方法 传入 目录，  会自动的将所有Zip压缩包解压
		shibie("D:\\用户目录\\下载\\e");
		
		System.out.println("---------------\n全部解压完成");
	}

	/**
	 * 递归方法判断文件类型并决定是否启动Zip解压功能
	 * @param String 需要一个字符串类型的路径
	 * */
	public static void shibie(String path) throws IOException{
		File s = new File(path);
		for(File file : s.listFiles()){
			// 是文件 并以.zip结束 就使用解压
			if (file.isFile() && file.getName().endsWith(".zip")) {
				myzijide(file);
			//否则递归再次进入目录
			}else if(file.isDirectory()){
				shibie(file.getAbsolutePath());
			}
		
		}
	}
	
	/**
	 *  真正的解压方法   会删除解压完的所有Zip文档
	 *  @param File 一个。zip的 文件
	 * */
	public static void myzijide (File file) throws IOException{
	
		ZipInputStream zip = new ZipInputStream(new FileInputStream(file));
		ZipEntry en = null ;
		BufferedOutputStream out =null ;
		// 循环读取ZIP文件中的内容
		while( (en=zip.getNextEntry()) != null ){
			if (en.isDirectory()) {
				File f = new File(file.getParent() + "\\" + en.getName()) ;	
				if(!f.exists())f. mkdirs();
				continue;
			}
			// 发现好多文件夹存在 Thumbs ， 定一个识别将他过滤 
			//  文件名中含有Thumbs 将 不 解压
			if (en.getName().contains("Thumbs")) {
				continue;
			}
			
			//实际的输出方法
			out = new BufferedOutputStream(new FileOutputStream(file.getParent() +"\\" + en.getName() ));
			
			int i = -1;
			byte[] b = new byte[1024] ;
			while( ( i =  zip.read(b) ) != -1 ){
				out.write(b,0,i);
			}
			out.close();
		}
		zip.close();
		
		//删除文件
		String tishi = file.delete() ? "yes" : "no" ;
		System.out.println(file.getName() + "解压完成并删除 ？" + tishi );

	}

}
