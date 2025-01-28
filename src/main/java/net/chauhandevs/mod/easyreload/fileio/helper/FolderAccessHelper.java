package net.chauhandevs.mod.easyreload.fileio.helper;

import java.io.File;

public class FolderAccessHelper {


    private final String rootPath;
    private File currentFolder;

    public FolderAccessHelper(String rootPath){
        this.rootPath = rootPath;
        currentFolder = new File(rootPath);
    }

    public FolderAccessHelper getFolder(String name){
        String folderpath = currentFolder.getPath() + "/" + name;
        File folder = new File(folderpath);

        if(folder.exists() && folder.isFile()){
            folder = new File(find(folderpath));
            System.out.println(folder.getPath());
        }

        folder.mkdirs();

        currentFolder = folder;

        return this;
    }

    public void resetToRoot(){
        currentFolder = new File(rootPath);
    }

    public String find(String folderpath){
        if(folderpath.matches(".*[\\\\/]")){
            folderpath = folderpath.substring(0, folderpath.length()-1);
        }

        return folderpath + find(folderpath, 1);
    }

    private int find(String folderpath, int num){
        File f = new File(folderpath + num);

        if(f.exists() && f.isFile()){
            return find(folderpath, ++num);
        }else {
            return num;
        }
    }

    public File asFolder(){
        return currentFolder;
    }

    public File asFolderAndReset(){
        File cf = currentFolder;
        resetToRoot();

        return cf;
    }
}
