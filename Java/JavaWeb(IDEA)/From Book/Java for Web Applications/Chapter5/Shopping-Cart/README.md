# Feelings and experiences

注意查看 Tomcat 服务器控制台的日志，发现错误，沉着冷静，不要着急，好好休息，好好思考，多尝试。如果自己无法解决，将错误复制下来在网上寻找。

注意路径问题。

---

注意 session 的设置的属性与获得的属性名称的对应问题。（`java.lang.NullPointerException at org.apache.jsp.WEB_002dINF.view.profilEtudiant_jsp._jspService `)

 —— From：https://stackoverflow.com/questions/37957551/java-lang-nullpointerexception-at-org-apache-jsp-web-002dinf-view-profiletudiant

---

注意获取 id 时转换为 Integer 的类型的时注意数字周围的空格，若报`java.lang.NumberFormatException`，则可能在类型转换时字符串数字周围出现了空格，使用`trim()`函数解决：

```java
int id = Integer.parseInt(request.getParameter("objectId").trim());
```

—— From：https://blog.csdn.net/xiaodongvtion/article/details/8835668