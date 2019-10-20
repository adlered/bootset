package pers.adlered.bootset.actuator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <h3>KeepUrDiskAlive</h3>
 * <p>创建临时后台启动脚本</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2019-10-19 21:10
 **/
public class CreateBash {
    private int systemType;
    private String[] command;

    public CreateBash(int systemType, String[] command) {
        this.systemType = systemType;
        this.command = command;
    }

    public String create() throws IOException {
        String tempFile = createFile();
        File file = new File(tempFile);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        switch (systemType) {
            case 0:
                fileOutputStream.write("Set ws = CreateObject(\"Wscript.Shell\")\r\n".getBytes());
                for (String i : this.command) {
                    fileOutputStream.write(("ws.run \"" + i + "\",0\r\n").getBytes());
                }
                break;
            case 1:
                Runtime.getRuntime().exec("chmod +x " + tempFile);
                for (String i : this.command) {
                    fileOutputStream.write(("nohup " + i + " > /dev/null 2>&1 &\n").getBytes());
                }
                break;
            case 2:
                Runtime.getRuntime().exec("chmod +x " + tempFile);
                for (String i : this.command) {
                    fileOutputStream.write(("nohup " + i + " > /dev/null 2>&1 &\n").getBytes());
                }
                break;
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        return tempFile;
    }

    private String createFile() throws IOException {
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        String suffix = "";
        switch (systemType) {
            case 0:
                suffix = "vbs";
                break;
            case 1:
                suffix = "sh";
                break;
            case 2:
                suffix = "sh";
                break;
        }
        String filename = "z_bootset_" + random + "." + suffix;
        File tempFile = new File(filename);
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        } else {
            tempFile.delete();
            tempFile.createNewFile();
        }
        return tempFile.getAbsolutePath();
    }
}
