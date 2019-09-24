package serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;


class User implements Serializable{
	private static final long serialVersionUID = 3761676802887966985L;
	private String username;
	private transient String phone;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//序列化时调用
	private void writeObject(ObjectOutputStream out) throws IOException{
		//模拟加密(Base64是java.util包中的一个类)
	    Encoder en=Base64.getEncoder();
	    this.username=en.encodeToString(username.getBytes());
		//序列化
		out.defaultWriteObject();
	}
	//反序列化时调用
	private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException{
		//反序列化
		in.defaultReadObject();
		//模拟解密
		Decoder dc=Base64.getDecoder();
		byte buf[]=dc.decode(username);
		this.username=new String(buf);
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", phone=" + phone + "]";
	}
	
}

public class TestSerializable02 {
  
   public static void main(String[] args) throws Exception{
	    //创建对象
	   User user=new User();
	   user.setUsername("admin");
	   user.setPhone("123456");
	   //将对象序列化
	   ObjectOutputStream out=
	   new ObjectOutputStream(new FileOutputStream("s2.txt"));
	   out.writeObject(user);
	   out.close();
	   
	   //对象反序列化
	   ObjectInputStream in=
	   new ObjectInputStream(new FileInputStream("s2.txt"));
	   User user2=(User)in.readObject();
	   System.out.println(user2);
	   in.close();
   }
	
}










