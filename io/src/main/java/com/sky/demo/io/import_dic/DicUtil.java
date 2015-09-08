package com.sky.demo.io.import_dic;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by rongguang on 2015/9/8.
 */
public class DicUtil {

    public static Map<String, Integer> importDic(final String path) {
        Map<String, Integer> result = Maps.newHashMap();

        URL resource = DicUtil.class.getResource(path);
        Preconditions.checkNotNull(resource);

        File inputFile = new File(resource.getFile());
//        File inputFile = new File(path);
        Preconditions.checkArgument(inputFile.exists() && inputFile.isFile());

        try {
            result = Files.readLines(inputFile, Charsets.UTF_8, new LineProcessor<Map<String, Integer>>() {
                Map<String, Integer> result = Maps.newHashMap();
                @Override
                public boolean processLine(String line) throws IOException {
//                    line = line.replaceAll("\t", " ");            //容错
//                    List<String> list = Splitter.on(" ").omitEmptyStrings().trimResults().splitToList(line);

                    List<String> list = Splitter.on("\t").omitEmptyStrings().trimResults().splitToList(line);
                    result.put(list.get(0), Integer.valueOf(list.get(1)));
                    return true;
                }

                @Override
                public Map<String, Integer> getResult() {
                    return result;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
