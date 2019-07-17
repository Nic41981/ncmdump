package com.little.util;

import java.io.File;
import java.io.FileFilter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static FileIterator fileIterator = new DefaultFileIterator();

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("输入参数为空，请输入参数");
            return;
        }
        Logger.getLogger("org.jaudiotagger").setLevel(Level.WARNING);
        for (String arg : args) {
            File file = new File(arg);
            if (!file.exists()) {
                System.out.println("参数中相关文件未找到,请检查相关路径是否存在权限问题：" + file.getPath());
                continue;
            }
            iteratorFile(file);
        }
    }

    private static void iteratorFile(File rootFile) {
        FileFilter filter = pathname -> pathname.getName().endsWith(".ncm");
        DefaultExecutable fileExecutable = new DefaultExecutable();
        fileIterator.iterator(rootFile, filter, fileExecutable);
    }


}
