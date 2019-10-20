package pers.adlered.bootset.tool;

import java.util.Properties;

/**
 * <h3>bootset</h3>
 * <p>获取操作系统，Windows 0; Linux 1; MacOS 2;</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2019-10-19 20:59
 **/
public class GetSystemType {
    public static int getSystemType() {
        Properties properties = System.getProperties();
        String system = properties.getProperty("os.name").toLowerCase().replaceAll(" ", "");
        if (system.indexOf("win") != -1) {
            return 0;
        } else if (system.indexOf("linux") != -1) {
            return 1;
        } else if (system.indexOf("mac") != -1) {
            return 2;
        } else {
            return -1;
        }
    }
}
