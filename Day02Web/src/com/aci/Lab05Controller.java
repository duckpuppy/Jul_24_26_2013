package com.aci;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab05.GuessingGame;

@Controller
@RequestMapping("/game")
public class Lab05Controller {
	private GuessingGame guessingGame;
	@Autowired
	public void setGuessingGame(GuessingGame guessingGame) {
		this.guessingGame = guessingGame;
	}
	@RequestMapping(method=RequestMethod.POST)
	public String play(@RequestParam("guess")String number,HttpSession session){
		session.setAttribute("error","");
		
		int guess = -1;
		try {
			guess = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			session.setAttribute("error","Invalid Input");
			session.setAttribute("message","");
			return "game/index";
		}
		finally{
			guessingGame.play(guess);
			session.setAttribute("attempts","Attempts: " + guessingGame.getAttempts());
		}
		session.setAttribute("message",guessingGame.getMessage());
		return "game/index";
	}
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		System.out.println("****** " + guessingGame.getClass());
		System.out.println(guessingGame.getClass().getSuperclass().getName());
		return "game/index";
	}
}
