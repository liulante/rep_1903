package com.emp.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.entity.User;

@Controller
public class UserController {
	
	//��ת����¼ҳ��
	@RequestMapping("/user/toLogin")
	public String toLogin(){
		return "Login";
	}

	@RequestMapping("/user/login")
	public String login(User user,Model model){
		
		//��ȡ��ǰ�û�  Subject ���� ���� "/user/login"����Ķ���(�û�������)
		Subject subject=SecurityUtils.getSubject();
		//����һ�����ƶ���
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			//Ϊ��ǰ�û�������֤����Ȩ
			subject.login(token);
			//�ض�����ҳԱ���б�
			return "redirect:/emp/conditionList";			
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("msg", "�û������������");
			return "Login";
		}
	}

}
