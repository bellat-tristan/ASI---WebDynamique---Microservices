package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.CardFormDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "cardForm";
    }

    /*@RequestMapping(value = {"/addCards"}, method = RequestMethod.POST)
    public String addCard(Model model, @ModelAttribute("cardForm") CardFormDTO cardForm, HttpSession session) {
        Card p = cardDao.addCard(cardForm.getName(), cardForm.getDescription(), cardForm.getImgUrl(), cardForm.getFamily(), cardForm.getAffinity(), cardForm.getHp(), cardForm.getEnergy(), cardForm.getAttack(), cardForm.getDefence(), cardForm.getPrix());
        model.addAttribute("myCard", p);
        model.addAttribute("pageTitle", "Add card");
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username != null ? username : "Connectez-vous");
        return "cardView";
    }*/

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
}
