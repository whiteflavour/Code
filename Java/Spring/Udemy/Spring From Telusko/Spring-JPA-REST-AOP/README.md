# NOTE

## Synopsis

包含 Spring Data JPA、Spring REST and Spring AOP 的一个小 Demo ，Following Telusko 。

—— 2021.5.6

## 痛点：

> 记得一定要引入与 Spring Boot 内置 Tomcat 版本一致的 Tomcat Jasper，否则会报 404 Not Found 错误。★★★

---

这错误我他妈找了好久，一直尝试，一开始还以为是项目创建错误，结果创了几遍，未果；

发现控制台 Spring Boot 日志总是输出`WARN: Path with "WEB-INF" or "META-INF": [WEB-INF/view/index.jsp]`，我就知道肯定是这里出了问题，可能是 index.jsp 找不到。

然后将这个 WARN 放 Google 上搜了一下，CSDN 上的小屁孩果然不行，他妈的从别的地方抄过来又没有自己的想法，屌用没有，没有给我启发。

后来看了 StackOverFlow 上的大佬对话，给了我启发，

发现可能是 Tomcat Jasper 依赖的问题，随便导了个 Tomcat Jasper，发现又报了 

> NoClassDefFoundError: jakarta/servlet/jsp/JspFactory 错误

然后发现有点问题，又记得笔记中好像讲过，于是去查了笔记，发现 

> Tomcat Jasper 版本要与 Spring Boot 的内置 Tomcat 版本匹配。★★

于是导入了对应版本的 Tomcat Jasper，错误解决。

**参考资料：**https://stackoverflow.com/questions/29782915/spring-boot-jsp-404

-- 2021.4.21

---

> 注意：Entity 中的类成员名必须与对应的数据库表中的字段名一致，否则报找不到字段错误。★

-- 2021.4.22

