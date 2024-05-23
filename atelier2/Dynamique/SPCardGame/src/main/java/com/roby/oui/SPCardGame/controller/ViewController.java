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

    @RequestMapping(value = { "/buycard"}, method = RequestMethod.GET)
    public String buycard(Model model) {
        return "buy";
    }

    @RequestMapping(value = { "/sellcard"}, method = RequestMethod.GET)
    public String sellcard(Model model) {
        return "sell";
    }
}
