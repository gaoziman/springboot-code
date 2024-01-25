package org.javatop.record;

import org.junit.jupiter.api.Test;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-17 15:14
 * @description :
 */
public class TextBlockTest {
    /**
     * 用于测试: TextBlock
     */
    @Test
    public void test01() {
        //String name = """lisi"""; Error 不能将文本块放在单行上
        //String name = """lisi20 """; Error 文本块的内容不能在没有中间行结束符的情况下跟随三个开头双引号
        String myname = """
                zhangsan
                20
                """;
        //正确
    }

    /**
     * 用于测试:
     */
    @Test
    public void test02() {
        String s1 = "hello";
        String s2 = "hello";
        //使用equals的比较
        //比较字符串
        boolean b1 = s1.equals(s2);
        System.out.println("b1 = " + b1);
        //使用 == 的比较
        boolean b2 = s1 == s2;
        System.out.println("b2 = " + b2);
        String msg = """
                hello world""";
        //字符串方法 substring
        String sub = msg.substring(0, 5);
        System.out.println("sub = " + sub);
    }

    /**
     * 用于测试:
     */
    @Test
    public void test03() {
        //按 tab 向右移动，保留左侧空格
        String html = """
                <html>
                     <body> 一起学习Java </body>
                </html>
                                """;
        System.out.println(html);
    }

    /**
     * 用于测试:
     */
    @Test
    public void test04() {
        String colors = """
                red
                green
                blue
                """;
        System.out.println(colors);
        //indent(int space)包含缩进,space 空格的数量
        String indent = colors.indent(10);
        System.out.println(indent);
    }

    /**
     * 用于测试:
     */
    @Test
    public void test05() {
        String info = """
                Name:%s
                Phone:%s
                Age:%d
                """.formatted("张三", "13800000000", 20);
        System.out.println("info = " + info);
    }

    /**
     * 用于测试:
     */
    @Test
    public void test06() {
        String str = """
                Spring Boot 是一个快速开发框架 \
                基于\" Spring \"框架，创建 Spring 应用\
                内嵌 Web 服务器，以 jar 或 war 方式运行 \
                                             """;
        System.out.println("str = " + str);
    }

    /**
     *  用于测试:
     */
    @Test
    public void test07() {

    }
}


