import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class outputstream {

	public void outputsave() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		User us1 = new User("정종문", "a123", "b123");
		User us2 = new User("ABC", "ID2", "pw23");
		try {
			
			fos = new FileOutputStream("C:\\Users\\AcerBook\\eclipse-workspace\\BankTest\\Datafile\\object.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(us1);
			oos.writeObject(us2);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// 스트림을 닫아준다.
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
				}
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
				}
		}

	}

	
	public void outputread() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
	
	try	{

		fis = new FileInputStream("C:\\\\Users\\\\AcerBook\\\\eclipse-workspace\\\\BankTest\\\\Datafile\\\\object.dat");
		ois = new ObjectInputStream(fis);
//		System.out.println((User) ois.readObject());
//		System.out.println((User) ois.readObject());
		
		String s = String.valueOf(ois.readObject());
		String s3 = String.valueOf(ois.readObject());
		
		ArrayList<String> a = new ArrayList<String>();
		
		a.add(s);
		a.add(s3);
		String name = a.get(0).split(":")[1];
		String name3 = name.split("\n")[0];
		System.out.print(name3);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally
	{

		// 스트림을 닫아준다.
		if (fis != null)
			try {
				fis.close();
			} catch (IOException e) {
			}
		if (ois != null)
			try {
				ois.close();
			} catch (IOException e) {
			}
	}

}}
