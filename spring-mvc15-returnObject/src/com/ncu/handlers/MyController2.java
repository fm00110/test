package com.ncu.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncu.bean.Displa;
import com.ncu.bean.Moudle;
import com.ncu.bean.Produce;
import com.ncu.bean.Province;
import com.ncu.bean.User;

@Controller
 //命名空间，即传过来的请求必须添加这个前缀,再加上资源名
public class MyController2{
	
	
	
	@RequestMapping(value="/datagrid.do")
	@ResponseBody
	public Object doreturnlist(){
		List<Produce> l1 = new ArrayList<Produce>();
		for(int i = 0;i<100;i++){
			l1.add(new Produce("value11", "value12", "value13", "value14", "value15", "value16"));
		}
	
		return l1;
	}
	
	/*@RequestMapping(value="/datagrid.do")
	@ResponseBody
	public Object doreturnmap(){

		Produce p1 = new Produce("value11","value12","value13","value14","value15","value16");
		Produce p2 = new Produce("value21","value22","value23","value24","value25","value26");
		Produce p3 = new Produce("value31","value32","value33","value34","value35","value36");
		Produce p4 = new Produce("value41","value42","value43","value44","value45","value46");
		Produce p5 = new Produce("value51","value52","value53","value54","value55","value56");
		Map<String,Produce> map = new HashMap<String, Produce>();
		map.put("p1", p1);
		map.put("p2", p2);
		map.put("p3", p3);
		map.put("p4", p4);
		map.put("p5", p5);
		return map;
	}*/
	@RequestMapping(value="/displ.do")
	@ResponseBody
	public Object returndis(){
		List<Displa> l1 = new ArrayList<Displa>();
		for(int i = 0;i<100;i++){
			l1.add(new Displa("value11", "value12", "value13", "value14", "value15", "value16","value17"));
		}
		return l1;
	}
	@RequestMapping(value="/combox.do")
	@ResponseBody
	public Object returnCombox(HttpServletRequest request){
		String v_state = request.getParameter("name");
		System.out.println(v_state);
		if("AL".equals(v_state)){
			return new Displa("value11", "value12", "value13", "value14", "value15", "value16","value17");
		}
		else{
			return new Displa("value21", "value22", "value23", "value24", "value25", "value26","value27");
		}
		
		
	}
	
	@RequestMapping(value="/getslect.do")
	@ResponseBody
	public Object returngetselect(HttpServletRequest request){
		return "hello";
		
		
	}
	
	@RequestMapping(value="/combobox.do")
	//@ResponseBody
	public void returnCombo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		List<Province> l1 = new ArrayList<Province>();
		Province p1 = new Province("p1");
		Province p2 = new Province("p2");
		Province p3 = new Province("p3");
		Province p4 = new Province("p4");
		Province p5 = new Province("p5");
		Province p6 = new Province("p6");
		Province p7 = new Province("p7");
		Province p8 = new Province("p8");
		l1.add(p1);
		l1.add(p2);
		l1.add(p3);
		l1.add(p4);
		l1.add(p5);
		
		l1.add(p6);
		l1.add(p7);
		l1.add(p8);
		request.getSession().setAttribute("l1", l1);
		response.sendRedirect("combourl.jsp");
		
	}
	
	
	@RequestMapping(value="comboload.do")
	//@ResponseBody
	public void returnCombo2(HttpServletRequest request,HttpServletResponse response) throws IOException{	
		List<Province> l2 = new ArrayList<Province>();
		Province p1 = new Province("p1");
		Province p2 = new Province("p2");
		Province p3 = new Province("p3");
		Province p4 = new Province("p4");
		Province p5 = new Province("p5");
		Province p6 = new Province("p6");
		Province p7 = new Province("p7");
		Province p8 = new Province("p8");
		l2.add(p1);
		l2.add(p2);
		l2.add(p3);
		l2.add(p4);
		l2.add(p5);		
		l2.add(p6);
		l2.add(p7);
		l2.add(p8);
		request.getSession().setAttribute("l2", l2);
		response.sendRedirect("comunion2.jsp");
		
	}
	
	
	@RequestMapping(value="/combo.do")
	//@ResponseBody
	public void returnCombox(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		List<Province> l2 = new ArrayList<Province>();
		Province p1 = new Province("p1");
		Province p2 = new Province("p2");
		Province p3 = new Province("p3");
		Province p4 = new Province("p4");
		Province p5 = new Province("p5");
		Province p6 = new Province("p6");
		Province p7 = new Province("p7");
		Province p8 = new Province("p8");
		l2.add(p1);
		l2.add(p2);
		l2.add(p3);
		l2.add(p4);
		l2.add(p5);
		
		l2.add(p6);
		l2.add(p7);
		l2.add(p8);
		request.getSession().setAttribute("l2", l2);
		response.sendRedirect("comunion.jsp");
		
	}
	
	
	
	@RequestMapping("/comunion.do")
	@ResponseBody
	public Object returnUnion(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		if("p1".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("方敏"); 
			Moudle m2 = new Moudle("方敏");
			Moudle m3 = new Moudle("方敏");
			Moudle m4 = new Moudle("方敏");
			Moudle m5 = new Moudle("方敏");
			Moudle m6 = new Moudle("方敏");
			Moudle m7 = new Moudle("方敏");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p2".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("张飞"); 
			Moudle m2 = new Moudle("张飞");
			Moudle m3 = new Moudle("张飞");
			Moudle m4 = new Moudle("张飞");
			Moudle m5 = new Moudle("张飞");
			Moudle m6 = new Moudle("张飞");
			Moudle m7 = new Moudle("张飞");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p3".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("澎湃"); 
			Moudle m2 = new Moudle("澎湃");
			Moudle m3 = new Moudle("澎湃");
			Moudle m4 = new Moudle("澎湃");
			Moudle m5 = new Moudle("澎湃");
			Moudle m6 = new Moudle("澎湃");
			Moudle m7 = new Moudle("澎湃");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p4".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("雷文"); 
			Moudle m2 = new Moudle("雷文");
			Moudle m3 = new Moudle("雷文");
			Moudle m4 = new Moudle("雷文");
			Moudle m5 = new Moudle("雷文");
			Moudle m6 = new Moudle("雷文");
			Moudle m7 = new Moudle("雷文");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p5".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("关于"); 
			Moudle m2 = new Moudle("关于");
			Moudle m3 = new Moudle("关于");
			Moudle m4 = new Moudle("关于");
			Moudle m5 = new Moudle("关于");
			Moudle m6 = new Moudle("关于");
			Moudle m7 = new Moudle("关于");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p6".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("计划"); 
			Moudle m2 = new Moudle("计划");
			Moudle m3 = new Moudle("计划");
			Moudle m4 = new Moudle("计划");
			Moudle m5 = new Moudle("计划");
			Moudle m6 = new Moudle("计划");
			Moudle m7 = new Moudle("计划");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p7".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("科技"); 
			Moudle m2 = new Moudle("科技");
			Moudle m3 = new Moudle("科技");
			Moudle m4 = new Moudle("科技");
			Moudle m5 = new Moudle("科技");
			Moudle m6 = new Moudle("科技");
			Moudle m7 = new Moudle("科技");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else{
			return null;
		}
	}
	
	
	
	@RequestMapping("/comunion2.do")
	@ResponseBody
	public Object returnUnion2(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		if("p1".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("方敏"); 
			Moudle m2 = new Moudle("方敏");
			Moudle m3 = new Moudle("方敏");
			Moudle m4 = new Moudle("方敏");
			Moudle m5 = new Moudle("方敏");
			Moudle m6 = new Moudle("方敏");
			Moudle m7 = new Moudle("方敏");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p2".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("张飞"); 
			Moudle m2 = new Moudle("张飞");
			Moudle m3 = new Moudle("张飞");
			Moudle m4 = new Moudle("张飞");
			Moudle m5 = new Moudle("张飞");
			Moudle m6 = new Moudle("张飞");
			Moudle m7 = new Moudle("张飞");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p3".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("澎湃"); 
			Moudle m2 = new Moudle("澎湃");
			Moudle m3 = new Moudle("澎湃");
			Moudle m4 = new Moudle("澎湃");
			Moudle m5 = new Moudle("澎湃");
			Moudle m6 = new Moudle("澎湃");
			Moudle m7 = new Moudle("澎湃");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p4".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("雷文"); 
			Moudle m2 = new Moudle("雷文");
			Moudle m3 = new Moudle("雷文");
			Moudle m4 = new Moudle("雷文");
			Moudle m5 = new Moudle("雷文");
			Moudle m6 = new Moudle("雷文");
			Moudle m7 = new Moudle("雷文");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p5".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("关于"); 
			Moudle m2 = new Moudle("关于");
			Moudle m3 = new Moudle("关于");
			Moudle m4 = new Moudle("关于");
			Moudle m5 = new Moudle("关于");
			Moudle m6 = new Moudle("关于");
			Moudle m7 = new Moudle("关于");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p6".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("计划"); 
			Moudle m2 = new Moudle("计划");
			Moudle m3 = new Moudle("计划");
			Moudle m4 = new Moudle("计划");
			Moudle m5 = new Moudle("计划");
			Moudle m6 = new Moudle("计划");
			Moudle m7 = new Moudle("计划");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else if("p7".equals(name)){
			List<Moudle> l1 = new ArrayList<Moudle>();
			Moudle m1 = new Moudle("科技"); 
			Moudle m2 = new Moudle("科技");
			Moudle m3 = new Moudle("科技");
			Moudle m4 = new Moudle("科技");
			Moudle m5 = new Moudle("科技");
			Moudle m6 = new Moudle("科技");
			Moudle m7 = new Moudle("科技");
			l1.add(m1);l1.add(m2);l1.add(m3);l1.add(m4);l1.add(m5);l1.add(m6);l1.add(m7);
			return l1;
		}
		else{
			return null;
		}
	}
	
	
}
