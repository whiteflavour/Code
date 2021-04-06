package com.google.tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期类。
 * 
 * @author 思否
 * @date 2021-3-28
 */
public class HelloTag extends SimpleTagSupport {
    String format = null;

    /**
     * 自定义标签的主要方法。
     *
     * @throws IOException
     */
    @Override
    public void doTag() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        // print 和 write 的唯一区别就是：print 使用了 buffer，而 write 没有。
        this.getJspContext().getOut().print(formatter.format(new Date()));
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
