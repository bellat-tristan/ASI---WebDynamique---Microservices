package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.model.CardFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestCrt {

    @Autowired
    private CardDao cardDao;

    @Value("${welcome.message}")
    private String message;

    private static String messageLocal = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);
        model.addAttribute("messageLocal", messageLocal);

        return "index";
    }

    @RequestMapping(value = {"/card"}, method = RequestMethod.GET)
    public String viewCard(Model model) {
        return "card";
    }

    @RequestMapping(value = {"/form-sample"}, method = RequestMethod.GET)
    public String viewSearchCard(Model model) {
        return "form-sample";
    }

    @RequestMapping(value = {"/view"}, method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute("myCard", cardDao.getRandomCard());
        return "cardView";
    }

    @RequestMapping(value = {"/addCard"}, method = RequestMethod.GET)
    public String addcard(Model model) {
        CardFormDTO cardForm = new CardFormDTO();
        model.addAttribute("cardForm", cardForm);
        return "cardForm";
    }

    @RequestMapping(value = {"/addCard"}, method = RequestMethod.POST)
    public String addcard(Model model, @ModelAttribute("cardForm") CardFormDTO cardForm) {
        Card p = cardDao.addCard(cardForm.getName(), cardForm.getDescription(), cardForm.getImgUrl(), cardForm.getFamily(), cardForm.getAffinity(), cardForm.getHp(), cardForm.getEnergy(), cardForm.getAttack(), cardForm.getDefence(), cardForm.getPrix());
        model.addAttribute("myCard", p);
        return "cardView";
    }

    @RequestMapping(value = { "/list"}, method = RequestMethod.GET)
    public String viewList(Model model) {
        model.addAttribute("cardList",cardDao.getCardList() );
        return "cardViewList";
    }

}
