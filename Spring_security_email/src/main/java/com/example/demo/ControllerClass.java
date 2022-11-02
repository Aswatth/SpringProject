package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControllerClass {
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private MessagesRepo msg_repo;
	
	
	public static User user;
	boolean alreadyExist = false;
		
	@RequestMapping("/")
	public ModelAndView loadHome() {
		return new ModelAndView("home.jsp");
	}
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login.jsp");
	}
	@RequestMapping("/signup")
	public ModelAndView signUpPage() {
		ModelAndView mv = new ModelAndView("signUp.jsp");
		if(alreadyExist)
			mv.addObject("error_msg","Mail id already exists");
		return mv; 
	}

	@PostMapping("/create")
	public ModelAndView signUpPage(User user) {
		ModelAndView mv;
		System.out.println(user.getMailID());
		System.out.println(repo.findById(user.getMailID()));
		if(repo.findById(user.getMailID()).orElse(null)==null)
		{
			mv = new ModelAndView("redirect:login");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			System.out.println(user.getPassword());	
			repo.save(user);
			return mv;
		}
		else {
			mv = new ModelAndView("redirect:signup");
			alreadyExist = true;
			return mv;
		}
	}
	@GetMapping("/home")
	public ModelAndView userHomePage(){
		ModelAndView mv = new ModelAndView("userHome.jsp");
		//System.out.println(name);
		mv.addObject("name",user.getName());
		mv.addObject("sender",user.getMailID());
		
		try {
			List<Messages> msgs = msg_repo.findAll();
			List<String> sentMsgs = new ArrayList<>();
			List<String> recvdMsgs = new ArrayList<>();
			
			for(int i =0 ; i<msgs.size();++i) {
				String senderId = msgs.get(i).getSenderId();
				String recvId = msgs.get(i).getRecieverId();
				if(senderId == user.getMailID()) {
					sentMsgs.add(msgs.get(i).getRecieverId()+"-"+msgs.get(i).getMessage());
				}
				if(recvId==user.getMailID()) {
					recvdMsgs.add(msgs.get(i).getSenderId()+"-"+msgs.get(i).getMessage());
				}
			}
			mv.addObject("sentMsgs", sentMsgs);
			mv.addObject("recvdMsgs",recvdMsgs);
		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		List<User> users = repo.findAll();
		List<String> mailIds = new ArrayList<>();
		users.forEach((USER)->mailIds.add(USER.getMailID()));
		mv.addObject("listOfMailID",mailIds);
		
		
		return mv;
		
	}
	@RequestMapping("/send")
	public ModelAndView composeMail(Messages msg) {
		if(repo.findById(msg.getRecieverId()).orElse(null) != null)
			msg_repo.save(msg);
		return new ModelAndView("redirect:home");
	}
	
	@RequestMapping("/logout-success")
	public ModelAndView logOut() {
		//System.out.println("Log out");
		return new ModelAndView("redirect:login");
	}
}
