package org.javatop.record;

import java.util.Optional;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-17 14:17
 * @description : record类
 * 优点:
 *  带有全部参数的构造方法
 *  public 访问器
 *  toString(),hashCode(),equals()
 *  无 set，get 方法。没有遵循 Bean 的命名规范
 *  final 类，不能继承 Record，Record 为隐士的 final 类。除此之外与普通类一样
 *  不可变类，通过构造创建 Record
 *  final 属性，不可修改
 *  不能声明实例属性，能声明 static 成员
 */
public record Student(Integer id, String name, String email, Integer age) {
    public static void main(String[] args) {
//        Student lisi = new Student(1001, "lisi", "lisi@qq.com", 20);
//        System.out.println("lisi = " + lisi.toString());
//        Student zhangsan = new Student(1002, "zhangsan", "lisi@qq.com", 20);
//        System.out.println("zhangsan = " + zhangsan.toString());
//        System.out.println("lisi.equals(zhangsan) = " + lisi.equals(zhangsan));
//        System.out.println("lisi.name() = " + lisi.name());
//        System.out.println("zhangsan.name() = " + zhangsan.name());


        Student lisi = new Student(1001, "lisi", "lisi@qq.com", 20);
//        System.out.println(lisi.concat());
        //调用静态方法
        System.out.println(Student.emailUpperCase(lisi.email()));
    }

    public String concat() {
        return String.format("姓名：%s，年龄是：%d", this.name, this.age);
    }

    /**
     * 静态方法
     */
    public static String emailUpperCase(String email) {
        return Optional.ofNullable(email).orElse("no email").toUpperCase();
    }

}
