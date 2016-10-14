import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

//Extract data from .ykc files
public class YKCExtraction {

	public static final String EXTRACT_PATH = "/home/harvey/Desktop/javaExtract/";
	
	public static void main(String[]args) {
		try {
			//param args[0] Path to .ykc file
			for(Ykc.FileEntry fileEntry : Ykc.fromFile(args[0]).header().entries()) {
				String fileName = fileEntry.filename().trim();
				Charset.forName("UTF-8").encode(fileName);
				String x = fileName.replaceAll("\\\\", "/");
				fileName = x;
				System.out.println("Proccesing : " + EXTRACT_PATH  + fileName);
				File file = new File(EXTRACT_PATH  + fileName);
				if(!file.getParentFile().exists()) {
					System.out.println("Creating dir: " + file.getParentFile());
					file.getParentFile().mkdirs();
				}
				if(!file.exists()) {
					System.out.println("Creating file: " + file);
					file.createNewFile();
				}
				try(FileOutputStream fos = new FileOutputStream(file)) {
					byte[] str = fileEntry.body();
					fos.write(str);
				}
			}

		} catch(IOException ex) {
			ex.printStackTrace();
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		} 
	}
}
