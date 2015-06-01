/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Files;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class FilesUpdate {

    /**
     *
     * Get the name of the files in the specified folder and returns a String []
     * with the names of files and extensions
     *
     * @param folderPathName
     * @return
     */
    public String[] filesInFolder(String folderPathName) {
        File folder = new File(folderPathName);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> arrayList = new ArrayList<String>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                arrayList.add(file.getName());
            }
        }

        String[] arrayString = new String[arrayList.size()];
        arrayString = arrayList.toArray(arrayString);

        return arrayString;
    }

}
