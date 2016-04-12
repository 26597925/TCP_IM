import cn.edu.lzu.oss.tcp_im.lib.Encrypt;

public class Main {

	public static void main(String[] args)
	{
		//System.out.println(System.getProperty("java.library.path"));
		Encrypt e = new Encrypt("test");
		//System.out.println("java print rand = "+e.getRand());
	}
}
