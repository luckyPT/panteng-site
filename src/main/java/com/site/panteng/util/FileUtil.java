package com.site.panteng.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.Files;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Created by mi on 16-11-16.
 */
public class FileUtil {

    public static void createFile(String filePath, String fileName, String content, String charset) {
        // 前置判断
        Preconditions.checkArgument(!Strings.isNullOrEmpty(filePath), "请输入文件路径！");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "请输入文件名！");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(charset), "请输入文件编码方式！");
        try {
            File file = new File(filePath + fileName);
            Files.append(content, file, Charset.forName(charset));
        } catch (Exception ex) {
            try {
                throw ex;
            } catch (Exception e) {
            }
        }
    }
}
