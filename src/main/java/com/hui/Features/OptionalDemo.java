package com.hui.Features;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Optional最佳指南：解决空指针问题的优雅之选
 */
public class OptionalDemo {

    public static void main(String[] args) {
        // 1.创建optional对象: 可以使用静态方法 ofNullable() 创建一个即可空又可非空的 Optional 对象
        String name = null;
        Optional<String> optOrNull = Optional.ofNullable(name);
        System.out.println(optOrNull); // 输出：Optional.empty

        // 2.isPresent() 判断一个 Optional 对象是否存在   取代了 obj != null 的判断
        System.out.println(optOrNull.isPresent());   // 输出：false

        // 3.非空表达式 ifPresent()
        if (optOrNull.isPresent()) {
            System.out.println(optOrNull.get().length());
        }
        // 使用ifPresent 可以替换成：
        optOrNull.ifPresent(str -> System.out.println(str.length()));
        // java9 还可以通过这个方法 ifPresentOrElse(action, emptyAction) 执行两种结果，非空时执行 action，空时执行 emptyAction
        // 4.设置/获取 默认值
        // orElse() 方法用于返回包裹在 Optional 对象中的值，如果该值不为 null，则返回；否则返回默认值。该方法的参数类型和值的类型一致
        // orElseGet() 方法与 orElse() 方法类似，但参数类型不同。如果 Optional 对象中的值为 null，则执行参数中的函数
        String testNull = Optional.ofNullable(name).orElse("haha");
        System.out.println(testNull);
        testNull = Optional.ofNullable(name).orElseGet(() -> "heihei"); // 当Optional 对象的值 不为null值时，则orElseGet内方法不会被调用，性能更佳
        System.out.println(testNull);

        // 5.获取值
        // 该方法是有缺陷的，如 Optional 对象的值为 null，该方法会抛出 NoSuchElementException 异常
        // 建议 orElseGet() 方法获取 Optional 对象的值
        // System.out.println(optOrNull.get());

        // 6.过滤值 filter
        String password = "PASSWORD";
        Optional<String> opt = Optional.ofNullable(password);
        // filter的参数是 lambda表达式
        System.out.println(opt.filter(pwd->pwd.length()>6).isPresent());
        // 同时可以通过 Predicate中的and添加多个过滤条件
        Predicate<String> len6 = pwd ->pwd.length()>6;
        Predicate<String> len9 = pwd ->pwd.length()<9;
        System.out.println(opt.filter(len6.and(len9)).isPresent());
        // 7.转换值 map
        // 将密码转换为小写
        String strTest =  opt.map(str -> str.toLowerCase()).get();
        System.out.println(strTest);
        // map与filter结合使用
        Predicate<String> eq = pwd->pwd.equals("PASSWORD");
        boolean res = opt.map(String::toLowerCase).filter(len6.and(len9)).isPresent();
        System.out.println(res);

    }

    public static Optional<Member> getMemberById() {
        boolean hasName = true;
        if (hasName) {
            // 创建optional对象: of 创建非空的Optional对象
            Optional.of(new Member("哈哈"));
        }
        // 创建optional对象: empty() 创建空的Optional对象
        return Optional.empty();
    }
}

class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}