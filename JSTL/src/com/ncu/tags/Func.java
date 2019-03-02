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
		//��ȡPageContext ����
		PageContext pc=(PageContext) this.getJspContext();
		
		//��ȡ����(request)����
		ServletRequest request=pc.getRequest();
		
		//�Զ��庯��
		String addr=request.getRemoteAddr();
		
		
		//��ȡ��׼�����
		JspWriter out=pc.getOut();
		
		//���
		out.print(addr);
		
	}

}
