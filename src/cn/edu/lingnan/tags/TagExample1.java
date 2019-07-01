package cn.edu.lingnan.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagExample1 extends TagSupport{

	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println("20180530");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}
	
	public int doEndTag() throws JspException {
		return Tag.EVAL_PAGE;
	}
}