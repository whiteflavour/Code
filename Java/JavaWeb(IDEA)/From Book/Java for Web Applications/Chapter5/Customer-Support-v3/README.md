# Note

注意 属性 的获取与 参数 的获取，即`getAttribute()`与`getParameter()`，若没有`setAttribute()`，而是从 URL 中获取参数，则使用`getParameter()`，否则 空指针异常 。★

---

## 当在 jsp 中使用 超链接 跳转时，注意使用如下形式：

```jsp
<c:url value="">
    <c:param name="" value=""/>
    <c:param name="" value=""/>
    <c:param name="" value=""/>
    . . .
</c:url>

<%-- 切勿使用以下形式，否则各种报错：NullPointerException、IllegalArgumentException ...  --%>
<c:url value="/tickets?action=create&ticketId=<%=Integer.toString(id)%>"/>
```

---

```java
// 注意，此句话，即使不上传文件，filePart 也不为 null ★
Part filePart = request.getPart("file1");

// 所以需要这样判断
if (filePart != null && filePart.getSize() > 0) { // ★
    Attachment attachment = this.processAttachment(filePart);
    ticket.addAttachment(attachment);
}
```

---

## multipart/form-data 、application/x-www-form-urlencoded 提交表单中文乱码问题：★

```java
// 使用如下代码解决
String param = new String(request.getParameter("param").getBytes(StandardCharsets.ISO_8859_1), StandardCharset.UTF_8);
```

原因：multipart/form-data 、application/x-www-form-urlencoded 这两种格式通过 HTTP 传输，默认使用 iso-8859-1 编码格式，需要转换为 UTF-8 格式。

From：https://blog.csdn.net/chenghui0317/article/details/10299103 、 https://www.cnblogs.com/noteless/p/9442528.html 、 https://ask.zol.com.cn/x/3171596.html 。

---

## sendRedirect 引发的 IllegalStateException：

原因：Servlet 中的`response.sendRedirect()`语句执行后，程序会继续向下执行，而不是停止。

解决：在`response.sendRedirect()`后添加`return;`语句，阻止程序继续向下执行：

```java
if (request.getAttribute("username") == null) {
    response.sendRedirect("login");
    return;
}
```

From：https://www.itranslater.com/qa/details/2325865487990785024 

---

