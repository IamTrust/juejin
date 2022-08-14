package edu.gdut.juejinserver.utils;

public class JuejinStringUtils {
    /**
     * 解析tagids的字符串变成字符串数组
     * @param tagIds [123,456,789] 或 [123]
     * @return 字符串数组
     */
    public static String[] getTagIdsArray(String tagIds) {
        // tagIds: [123, 456, 789, 2142]
        // 特殊情况：只有一个tag的：[123]
        tagIds = tagIds.substring(1, tagIds.length() - 1);  // 去掉中括号
        // tagIds = tagIds.trim(); // 这个方法只能去除首尾空格
        tagIds = tagIds.replace(" ", "");
        // 处理特殊情况：[123], 根据有没有逗号来判断
        String[] tagIdsArr = null;
        if (tagIds.contains(",")) {
            tagIdsArr = tagIds.split(",");
        } else {
            tagIdsArr = new String[]{tagIds};
        }
        return tagIdsArr;
    }

}
