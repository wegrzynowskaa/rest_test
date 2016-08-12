package pl.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "userManagement";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getFileUploadPage() {
        return "uploadPage";
    }

    @RequestMapping(value = "/uploadMultiple", method = RequestMethod.GET)
    public String getUploadMultiplePage() {
        return "uploadMultiple";
    }
}
