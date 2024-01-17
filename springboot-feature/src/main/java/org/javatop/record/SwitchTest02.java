package org.javatop.record;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-17 14:47
 * @description :
 */
public class SwitchTest02 {

    public static void main(String[] args) {
        int week = 2;//yield 是 switch 的返回值， yield 跳出当前 switch 块
        String memo = switch (week) {
            case 1:
                yield "星期日，休息";
            case 2, 3, 4, 5, 6:
                yield "工作日";
            case 7:
                yield "星期六，休息";
            default:
                yield "无效日期";
        };
        System.out.println("week = " + memo);
    }
}
