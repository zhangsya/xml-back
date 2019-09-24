package serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
/**
 * 当我们需要手动自己序列化指定属性时，会
 * 让我们的类实现Externalizable接口
 * @author tarena
 */
class Employee implements Externalizable{
	private int id;
	private String name;
	//..........
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {//必须提供
	}
	//序列化时调用
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
	}
	//反序列化时调用
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	   this.id=in.readInt();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
public class TestSerializable03 {
   
	public static void main(String[] args)throws Exception {
		 Employee e=new Employee();
		 e.setId(100);
		 e.setName("tmooc");
		 //将对象序列化
		   ObjectOutputStream out=
		   new ObjectOutputStream(new FileOutputStream("s2.txt"));
		   out.writeObject(e);
		   out.close();
		   
		   //对象反序列化
		   ObjectInputStream in=
		   new ObjectInputStream(new FileInputStream("s2.txt"));
		   Employee user2=(Employee)in.readObject();
		   System.out.println(user2);
		   in.close();
	}
	
}
