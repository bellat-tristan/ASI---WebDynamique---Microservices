package com.roby.oui.SPCardGame.controller;


import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.model.CardFormDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ViewController {

    @Autowired
    private CardDao cardDao;

    @Value("${welcome.message}")
    private String message;

    private static String messageLocal = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        model.addAttribute("message", message);
        model.addAttribute("messageLocal", messageLocal);
        model.addAttribute("pageTitle", "Accueil");
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        Long userId = (Long) session.getAttribute("userId");
        model.addAttribute("userId", userId);
        Integer credits = (Integer) session.getAttribute("credits");
        model.addAttribute("credits", credits != null ? credits : 0);
        return "index";
    }

   /* @RequestMapping(value = {"/card"}, method = RequestMethod.GET)
    public String viewCard(Model model, HttpSession session) {
        model.addAttribute("pageTitle", "Card");
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        return "card";
    }*/

    /*@RequestMapping(value = {"/form-sample"}, method = RequestMethod.GET)
    public String viewSearchCard(Model model, HttpSession session) {
        model.addAttribute("pageTitle", "Form");
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        return "form-sample";
    }*/

    /*@RequestMapping(value = {"/view"}, method = RequestMethod.GET)
    public String view(Model model, HttpSession session) {
        model.addAttribute("myCard", cardDao.getRandomCard());
        model.addAttribute("pageTitle", "View");
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        return "cardView";
    }*/

    @RequestMapping(value = {"/addCardView"}, method = RequestMethod.GET)
    public String addCard(Model model, HttpSession session) {
        CardFormDTO cardForm = new CardFormDTO();
        model.addAttribute("cardForm", cardForm);
        model.addAttribute("pageTitle", "Add card");
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        Integer credits = (Integer) session.getAttribute("credits");
        model.addAttribute("credits", credits);
        return "cardForm";
    }




    @RequestMapping(value = { "/listAllCardView"}, method = RequestMethod.GET)
    public String viewList(Model model, HttpSession session) {
        model.addAttribute("cardList", cardDao.getCardList());
        model.addAttribute("pageTitle", "List");
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        return "cardViewList";
    }

    @RequestMapping(value = { "/userView"}, method = RequestMethod.GET)
    public String user(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        return "user";
    }
    public String login() {
        return "login"; // Retourne le nom de la vue de la page de connexion (login.html)
    }

    @RequestMapping(value = { "/buycard"}, method = RequestMethod.GET)
    public String buycard(Model model) {
        return "Buy";
    }

    @RequestMapping(value = { "/sellcard"}, method = RequestMethod.GET)
    public String sellcard(Model model) {
        return "Sell";
    }
}
