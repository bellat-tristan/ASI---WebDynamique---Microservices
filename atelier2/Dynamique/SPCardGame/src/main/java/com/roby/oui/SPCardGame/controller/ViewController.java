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

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
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

    @RequestMapping(value = {"/view"}, method = RequestMethod.GET)
    public String view(Model model, HttpSession session) {
        return "cardView";
    }

    @RequestMapping(value = {"/addCardView"}, method = RequestMethod.GET)
    public String addCard(Model model, HttpSession session) {
        return "cardForm";
    }

    @RequestMapping(value = { "/listAllCardView"}, method = RequestMethod.GET)
    public String viewList(Model model, HttpSession session) {
        return "cardViewList";
    }

    @RequestMapping(value = { "/userView"}, method = RequestMethod.GET)
    public String user(Model model, HttpSession session) {
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
