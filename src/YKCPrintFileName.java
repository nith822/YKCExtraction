import java.io.IOException;

public class YKCPrintFileName {

	public static void main(String[]args) {
		
		try {
			for(Ykc.FileEntry f : Ykc.fromFile(args[0]).header().entries()) {
				System.out.println(f.filename());
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
