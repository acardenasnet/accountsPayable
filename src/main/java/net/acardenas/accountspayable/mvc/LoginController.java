package net.acardenas.accountspayable.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by acardenas on 2/6/14.
 */
@Controller
@RequestMapping("/")
public class LoginController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model)
    {
        model.addAttribute("message", "Hello world!");
        return "login";
    }
}
