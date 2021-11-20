package com.app.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Leetcode_3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public static void main(String[] args) {
        int length1 = lengthOfLongestSubstring("abcabcbb");
        log.info("length:{}", length1);
        int length2 = lengthOfLongestSubstring("bbbbb");
        log.info("length:{}", length2);
        int length3 = lengthOfLongestSubstring("pwwkew");
        log.info("length:{}", length3);
        int length4 = lengthOfLongestSubstring("dvdf");
        log.info("length:{}", length4);
        int length5 = lengthOfLongestSubstring("ckilbkd");
        log.info("length:{}", length5);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring0(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charIndexMap = new HashMap<>(s.length());
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (charIndexMap.containsKey(sChar)) {
                left = Math.max(left, charIndexMap.get(sChar) + 1);
            }
            charIndexMap.put(sChar, i);
            int length = i - left + 1;
            max = Math.max(max, length);
        }
        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        char[] tmpChars = new char[128];
        int startIndex = 0;
        int maxLength = 0;
        char[] targetChars = s.toCharArray();
        for (int i = 0; i < targetChars.length; i++) {
            char targetChar = targetChars[i];
            int targetInt = (int) targetChar;
            if (tmpChars[targetInt] != 0) {
                for (int j = startIndex; j < i; j++) {
                    tmpChars[(int) targetChars[j]] = 0;
                    if (targetChar == targetChars[j]) {
                        startIndex = j + 1;
                        j = i;
                    }
                }
            }
            tmpChars[targetInt] = targetChar;
            int length = i - startIndex + 1;
            if (maxLength < length) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] dictAscArray = new char[128];
        int pervStartIndex = 0;
        int maxLength = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char dataChar = charArray[i];
            int charAscDictInt = (int) dataChar;
            if (dictAscArray[charAscDictInt] != 0) {
                for (int j = pervStartIndex; j < i; j++) {
                    char dictChar = charArray[j];
                    int dicCharAscInt = (int) dictChar;
                    dictAscArray[dicCharAscInt] = 0;
                    if (dataChar == dictChar) {
                        pervStartIndex = j + 1;
                        j = i;
                    }
                }
            }
            dictAscArray[charAscDictInt] = dataChar;
            int length = i - pervStartIndex + 1;
            if (maxLength < length) {
                maxLength = length;
            }
        }
        return maxLength;
    }

}
