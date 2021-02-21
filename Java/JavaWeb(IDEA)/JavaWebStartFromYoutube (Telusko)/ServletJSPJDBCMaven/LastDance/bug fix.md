# Bug 修复之路

## java.lang.NoClassDefFoundError: Could not initialize class com.google.util.JDBCUtils

最开始，运行 Tomcat 服务器，页面报错 （404？还是什么，忘了），想到肯定是 JDBCUtils 类出了问题，在网上找了好久，也尝试了很久，都没有成功，非常落魄，与失望，差点放弃。修整了几天后，再次鼓起勇气来寻找 bug，在网上查找资料，终于在 StackOverflow 上找到了答案，拿过来试了一下，果然成功了。

---

即：在加载资源的时候，静态代码块中，将`getSystemResourceAsStream()`方法改为`getResourceAsStream()`方法。

原因：webapp 是一个 目录层级 ，使用`getSystemResourceAsStream()`在运行的时候只会寻找一层，但在编译的时候是没有问题的，我自己也尝试过。 —— https://stackoverflow.com/questions/7615040/difference-between-classloader-getsystemresourceasstream-and-getclass-getresou ）

建议：使用`getResourceAsStream()`方法替代`getSystemResourceAsStream()`方法，因为`getResourceAsStream()`方法使用的是该代码所属的 Class 相同的类加载器，即包含了`getSystemResourceAsStream()`方法。

## 驱动不能加载问题 (No suitable driver found for jdbc:mysql://localhost:3306/login?characterEncoding=utf8) 解决：

不料，能够进入登录页面了 ( 这里为 login.jsp )，却无法登录进去，即使是使用的与数据库匹配的用户名与密码。果然 bug 一环扣一环，永远改不完呐。这样也重复上述步骤，上网 。。。尝试 。。。终于，在今天，2021-2-17，看 Java Web 高级编程的时候，看到了断点调试，于是想来学习一下断点，看了看 Frank 大佬的 B 站首页，终于在他的 C 语言课程中找到了 VS 2019 断点调试 ，依旧，讲解得是异常的清楚。然后我又想到前天重装系统之前，将所有的代码都发布到了 Github 上去，于是想到最后那个 Navin 的 Maven Login Demo ，即使未做完，也应该添加点文档，然后又配置了一下 Tomcat 重新运行了一下，突然发现，IDEA 中 Server 运行过程中的日志，报了详细的错误，这才恍然大悟，根据错误在网上搜索资料，解决了这个问题。

---

在 JDBCUtils 类中的`getConnection()`方法中的`DriverManager.getConneciton()`语句前面增加`Class.forName(driver)`语句，来加载驱动。 —— https://stackoverflow.com/questions/5556664/how-to-fix-no-suitable-driver-found-for-jdbcmysql-localhost-dbname-error-w 第二条回答。

虽然在 Frank 给的例子中没有加上这句话，但那是 Java SE，放在 Web 服务器上就行不通了。★

## 时区问题 (The server time zone value '?  ???????' is unrecognized or represents more than one time zone.) ：

然后又发生了时区问题，依旧，在网上查找了资料过后，成功解决。

---

在 连接语句 后面加上`serverTimezone=UTC`，即：`jdbc:mysql://localhost:3306/login?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC` 。 —— https://www.cnblogs.com/EasonJim/p/6906713.html

## EL 问题：

到这里，终于，成功登录，bug 解决完之后的一阵狂喜。只是没想到，EL 竟然无法获取属性，而是直接打印在页面上：`${student}`，我想，肯定时 EL 出了问题，找了半天资料，没有一丝办法。最终，终于发现了解决方案：

在 welcome.jsp 页面最前面的 Directive 中添加`isELIgnored="false"`，即：`<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>` —— https://blog.csdn.net/weixin_42950079/article/details/102649892?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_baidulandingword-0&spm=1001.2101.3001.4242

到这里，终于修复完了所有的 bug ，完成了这个 Demo，这就是 Java Web 吗，我终于理解 Frank 的那句话了：到了 Web 阶段就没有书了。