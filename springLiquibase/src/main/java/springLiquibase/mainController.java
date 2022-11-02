package springLiquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class mainController {

	@Autowired
	userRepo uRepo;
	@Autowired
	mobileRepo mRepo;
	
	@RequestMapping("/")
	ModelAndView onLoad() {		
		System.out.println("Loading...");
		return new ModelAndView("mainPage.jsp");
	}
	@RequestMapping("/userSubmit")
	ModelAndView userInsert(User u,int mobile_number) {
		ModelAndView mv= new ModelAndView("mainPage.jsp");
		if(mRepo.findById(String.valueOf(mobile_number)).orElse(null) != null) {
			u.setMobile(mRepo.findById(String.valueOf(mobile_number)).orElse(null));
			uRepo.save(u);
		}
		else {
			mv.addObject("error", "No such number");			
		}
		
		System.out.println("User saved...");
		return mv;
	}
	@RequestMapping("/mobileSubmit")
	ModelAndView bankInsert(Mobile m) {
		ModelAndView mv= new ModelAndView("mainPage.jsp");
		if(mRepo.findById(m.getNumber()).orElse(null)==null) {
			mRepo.save(m);
		}
		else {
			mv.addObject("error","Number already exists");
		}
		System.out.println("mobile details saved...");
		return mv;
		
	}
}
