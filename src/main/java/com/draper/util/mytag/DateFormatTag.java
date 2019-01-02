package com.draper.util.mytag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTag extends SimpleTagSupport {

    private String pattern;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doTag() throws JspException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        StringWriter sw = new StringWriter();
        getJspBody().invoke(sw);
        String date = simpleDateFormat.format(new Date(Long.valueOf(sw.toString())));
        getJspContext().getOut().write(date);
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

}
