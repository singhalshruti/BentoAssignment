import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirectoryContents {
	public static void main(String[] args) {
		File currentDir = new File("."); // current directory
		displayFilePath(currentDir);
	}

	public static void displayFilePath(File dir) {
            ArrayList<File> fileList= new ArrayList<>();
            File[] files = dir.listFiles();
            for (File file : files) {
                if (!file.isDirectory()) {
                    fileList.add(file);
                }
            }
            Collections.sort(fileList);
            for(File f: fileList){
                try {
                    System.out.println("FILE PATH: " +f.getCanonicalPath() + "  ,FILE NAME : "+f.getName()+" , LENGTH:" + f.length());
                } catch (IOException ex) {
                    Logger.getLogger(DirectoryContents.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}
 }

