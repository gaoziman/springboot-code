package org.javatop.record;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-17 14:47
 * @description :
 */
public class SwitchTest01 {

    public static void main(String[] args) {
        int week = 3;
        String memo = "";
        switch (week) {
            case 1 -> memo = "星期日，休息";
            case 2, 3, 4, 5, 6 -> memo = "工作日";
            case 7 -> memo = "星期六，休息";
            default -> throw new IllegalArgumentException("无效的日期：");
        }
        System.out.println("week = " + memo);
    }
}
