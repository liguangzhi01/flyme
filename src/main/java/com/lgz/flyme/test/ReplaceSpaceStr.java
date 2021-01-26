package com.lgz.flyme.test;

/**
 * @author: liguangzhi01
 * @date: 2021/1/25
 */
public class ReplaceSpaceStr {


    /**
     * 替换空字符串为 “%20”
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuilder str) {
        int spaceCount = 0;
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        if (spaceCount == 0) {
            return str.toString();
        }
        int newLength = strLength + (spaceCount << 1);
        /*
          StringBuilder 默认大小是16，
          StringBuilder的 setLength()方法， 可以扩容。 假设扩容之前长度为oldLength,
          扩容之后长度为newLength, 则会增加(newLength - oldLength)个 '\0'
         */
        str.setLength(newLength);
        while (strLength > 0) {
            if (str.charAt(--strLength) == ' ') {
                str.setCharAt(--newLength, '0');
                str.setCharAt(--newLength, '2');
                str.setCharAt(--newLength, '%');
            } else {
                str.setCharAt(--newLength, str.charAt(strLength));
            }
        }
        return str.toString();
    }
}
