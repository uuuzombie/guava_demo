package com.sky.demo.io.parsejstack;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Collection;
import java.util.List;

/**
 * Created by rg on 15/7/12.
 */
public class FileUtil {

    public static Multimap<String, ThreadInfo> multimap;
    public static List<String> list;

    /**
     * 读取并处理输入文件
     * @param path
     * @throws java.io.IOException
     */
    public static void readFile(String path) throws IOException {
        URL resource = FileUtil.class.getResource(path);  //j.stack
        Preconditions.checkNotNull(resource);

        File inputFile = new File(resource.getFile());
        Preconditions.checkState(inputFile.exists() && inputFile.isFile());

        ThreadLineProcessor threadLineProcessor = new ThreadLineProcessor();
        multimap = Files.readLines(inputFile, Charsets.UTF_8, threadLineProcessor); //或者Charset.forName("UTF-8"),
        list = threadLineProcessor.sort(multimap);
    }

    /**
     * 结果输出到文件
     * @param path
     * @throws java.io.FileNotFoundException
     */
    public static void writeFile(String path) throws FileNotFoundException {
        URL resource = FileUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);

        File outputFile = new File(resource.getFile());
        Preconditions.checkState(outputFile.exists() && outputFile.isFile());

        PrintStream printStream = null;
        try {
            printStream = new PrintStream(outputFile);

            for (String key : list) {
                printStream.println(String.format("conditionid:%s,count:%s:", key,multimap.get(key).size()));

                Collection<ThreadInfo> collection = multimap.get(key);
                for (ThreadInfo threadInfo : collection) {
                    printStream.println(String.format("%s|%s|%s", threadInfo.getThreadId(),threadInfo.getThreadName(),threadInfo.getThreadState()));
                }
            }

        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
