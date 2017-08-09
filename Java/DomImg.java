import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
/*
功能:批量下载网址图片....
PS:没有对异常处理
*/
public class DomImg {

	/*
		根据编译的class文件，传入地址和标题    
	使用命令:	java DomImg http://xxxx.x/xx/ 目录名
		如无意外，就可以批量下载了
	*/
	public static void main(String[] args) throws Exception {
		
		method(args[0], args[1]);
		System.out.println("全部下载已完成!!!!");
	}
	

	//根据地址循环填充在调用方法
	public static void method(String title,String img_url) throws IOException{		
	//	String title = getWebCon(str+".html");
		int a = 0;String str = "";

		//根据title在指定目录下创建文件夹存放图片
		File dir1 = new File("/Users/cwj/Documents/" + title);
		if (!dir1.exists()) {
			dir1.mkdir();
		} 
		dir1= null ;
		
		do {
			str = img_url;
			a++;
			if(a <= 9 ){
				str += "0" + a + ".jpg";
			}else{
				str += a + ".jpg";
			}
			// => 格式类似于  01.jpg  20.jpg 等

		} while (domIMG(new URL(str),a,title));
	}

	//真正的下载图片的方法
	private static boolean domIMG(URL url,int name,String dirname) throws IOException {
		InputStream in =  url.openStream();
		BufferedInputStream bfin = new BufferedInputStream(in);
		
		File a1 = new File("/Users/cwj/Documents/"+dirname + "/" + name + ".jpg");
		FileOutputStream out = new FileOutputStream(a1);
		BufferedOutputStream bfout = new BufferedOutputStream(out,102400);

		byte[] by  =  new byte[1024*20];
		int a ;
		while ( (a = bfin.read(by)) != -1){
			bfout.write(by, 0, a);
		}
		
		bfout.flush();
		out.close();in.close();
		
		//如果哈希值，就退出下载
		if("哈希值".equals(getMd5ByFile(a1))){
			a1.delete();
			return false;
		}
		return true;
		
	}
	
    
    //获得网站标题的信息,可以取得文本内的title内容
    public static String getWebCon(String domain) {
		// System.out.println("开始读取内容...("+domain+")");
		StringBuffer sb = new StringBuffer();
		try {
			java.net.URL url = new java.net.URL(domain);
			BufferedReader in = new BufferedReader(new InputStreamReader(url
					.openStream(),"GBK"));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (Exception e) { // Report any errors that arise
			sb.append(e.toString());
			System.err.println(e);
			System.err.println("Usage:   java   HttpClient   <URL>   [<filename>]");
		}
		String webContent = sb.toString();
		return webContent.substring(webContent.indexOf("<title>") + 7,webContent.indexOf("</title>"));
	}
  
    
    //取文件的md5值
    public static String getMd5ByFile(File file) throws FileNotFoundException {  
        String value = null;  
        FileInputStream in = new FileInputStream(file);  
    try {  
        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
        MessageDigest md5 = MessageDigest.getInstance("MD5");  
        md5.update(byteBuffer);  
        BigInteger bi = new BigInteger(1, md5.digest());  
        value = bi.toString(16);  
    } catch (Exception e) {  
        e.printStackTrace();  
    } finally {  
            if(null != in) {  
                try {  
                in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    return value;  
    }  

} 

