package com.tang.bos.utils;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by tang on 17-5-26.
 */
public class FileUtils {

    public static String encodeDownloadFilename(String filename, String agent)
            throws IOException {
        if (agent.contains("Firefox")) { // 火狐浏览器
            filename = "=?UTF-8?B?"
                    + new BASE64Encoder().encode(filename.getBytes("utf-8"))
                    + "?=";
            filename = filename.replaceAll("\r\n", "");
        } else { // IE及其他浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+"," ");
        }
        return filename;
    }
}
