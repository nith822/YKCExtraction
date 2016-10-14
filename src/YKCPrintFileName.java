import java.io.IOException;

//print file names of .ykc files
public class YKCPrintFileName {

	
	public static void main(String[]args) {
		
		try {
			//param args[0] Path to .ykc file
			for(Ykc.FileEntry f : Ykc.fromFile(args[0]).header().entries()) {
				System.out.println(f.filename());
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
