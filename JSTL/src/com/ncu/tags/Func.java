package com.ncu.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Func extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//获取PageContext 对象
		PageContext pc=(PageContext) this.getJspContext();
		
		//获取请求(request)对象
		ServletRequest request=pc.getRequest();
		
		//自定义函数
		String addr=request.getRemoteAddr();
		
		
		//获取标准输出流
		JspWriter out=pc.getOut();
		
		//输出
		out.print(addr);
		
	}

}
