package pers.adlered.bootset.main;

import pers.adlered.bootset.actuator.CreateBash;
import pers.adlered.bootset.actuator.OnBoot;
import pers.adlered.bootset.tool.GetSystemType;

/**
 * <h3>bootset</h3>
 * <p>设置某个程序在开机时运行，并立即启动</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2019-10-19 20:55
 **/
public class Main {
    public static void main(String[] args) {
        try {
            int type = GetSystemType.getSystemType();
            String bashFile = new CreateBash(type, args).create();
            boolean ok = false;
            System.out.println(bashFile);
            switch (type) {
                case 0:
                    ok = new OnBoot().setAutoStart(true, bashFile);
                    break;
                case 1:
                    ok = new OnBoot().linux(bashFile);
                    break;
                case 2:
                    ok = new OnBoot().linux(bashFile);
                    break;
            }
            System.out.println(ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
