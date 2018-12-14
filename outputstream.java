import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class outputstream {
	ArrayList<String> Userinformation = new ArrayList<String>();
	public void outputsave(String a, String b, String c) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		User us1 = new User(a, b, c);
		
		try {
			
			fos = new FileOutputStream("C:\\Users\\AcerBook\\eclipse-workspace\\BankTest\\Datafile\\object.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(us1);

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

		fis = new FileInputStream("C:\\Users\\AcerBook\\eclipse-workspace\\BankTest\\Datafile\\object.dat");
		ois = new ObjectInputStream(fis);
//		System.out.println((User) ois.readObject());
//		System.out.println((User) ois.readObject());
		for(int i=0; i<1; i++) {
		String s = String.valueOf(ois.readObject());
		
		Userinformation.add(s);
		}
		String nameB = Userinformation.get(0).split(":")[1];
		String nameA = nameB.split("\n")[0];
		
		String IDB = Userinformation.get(0).split(":")[2];
		String IDA = IDB.split("\n")[0];
		
		String PWB = Userinformation.get(0).split(":")[3];
		
		System.out.print(nameA);
		System.out.print(IDA);
		System.out.print(PWB);
	
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
