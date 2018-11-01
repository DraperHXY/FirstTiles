package com.draper.web.util.mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class BodyTag extends TagSupport {

    private PageContext pageContext;

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getResponse().getWriter().write("这是我写的一大段信息：ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.doStartTag();
    }
}
