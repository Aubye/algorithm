package com.app.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Leetcode_6 {

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     */
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String result = convert(str, 3);
        log.info("result:{}", result);
        String result1 = convert1(str, 3);
        log.info("result1:{}", result1);
        boolean flag = result.equals(result1);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rowList = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rowList.add(new StringBuilder());
        }
        int curRow = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            rowList.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                flag = !flag;
            }
            curRow += flag ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rowList) {
            result.append(row);
        }
        return result.toString();
    }

}
