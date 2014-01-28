package net.acardenas.accountspayable.mvc;

import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HelloController
{
    @Autowired
    private EventDataservice eventDataservice;
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model)
    {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String printList(ModelMap aModelMap)
    {
        LOG.debug("printList");
        aModelMap.addAttribute("list", new ArrayList<String>());
        return "eventView";
    }
}