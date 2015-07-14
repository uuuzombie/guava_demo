package com.sky.demo.io.parsejstack;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.io.LineProcessor;
import com.google.common.primitives.Ints;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rg on 15/7/12.
 */
public class ThreadLineProcessor implements LineProcessor<Multimap<String,ThreadInfo>>{

    Multimap<String, ThreadInfo> result = HashMultimap.create();

    String lastLine;

    @Override
    public Multimap<String, ThreadInfo> getResult() {
        return result;
    }

    @Override
    public boolean processLine(String line) throws IOException {
        String currentLine = line.trim();
        if (lastLine != null && lastLine.contains("waiting on condition")) {
            if (currentLine.contains("java.lang.Thread.State:")) {
                ThreadInfo threadInfo = parseThreadInfo(lastLine, currentLine);
                int index1 = lastLine.lastIndexOf('[');
                int index2 = lastLine.lastIndexOf(']');

                String conditionId = lastLine.substring(index1 + 1,index2);
                result.put(conditionId, threadInfo);
            }
        }
        lastLine = currentLine;
        return true;
    }

    public ThreadInfo parseThreadInfo(String lastLine, String currentLine){
        int indexTid = lastLine.indexOf("tid=");
        String threadId = lastLine.substring(indexTid + 4, indexTid + 4 + 18);
        String threadName = lastLine.substring(lastLine.indexOf("\"") + 1,lastLine.lastIndexOf("\""));
        String threadState = currentLine.substring(currentLine.indexOf(":") + 2);

        ThreadInfo threadInfo = ThreadInfo.getInstance(threadId, threadName, threadState);
        return threadInfo;
    }

    public List<String> sort(Multimap<String, ThreadInfo> multimap){
        final Multiset<String> multiset = multimap.keys();
        List<String> list = Lists.newArrayList();
        list.addAll(multiset.elementSet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Ints.compare(multiset.count(o1), multiset.count(o2));
            }
        });
        return list;
    }
}
