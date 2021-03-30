package com.google.tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloTag extends SimpleTagSupport {
    String format = null;

    @Override
    public void doTag() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        this.getJspContext().getOut().print(formatter.format(new Date()));
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
