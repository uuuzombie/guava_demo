package com.sky.demo.io.parsejstack;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by rg on 15/7/12.
 */
public class FileUtilTest {

    @Test
    public void test_ParseJstack() throws IOException {

        String inputPath = "/j.stack";
        String outputPath = "/result.txt";

        FileUtil.readFile(inputPath);

        FileUtil.writeFile(outputPath);
    }
}
