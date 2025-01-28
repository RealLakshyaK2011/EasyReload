import net.chauhandevs.mod.easyreload.fileio.helper.FolderAccessHelper;

import java.io.File;

public class FolderGetTest{
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        FolderAccessHelper helper = new FolderAccessHelper(".vscode");
        File set = helper.getFolder("settings.json").asFolder();
    }
}
