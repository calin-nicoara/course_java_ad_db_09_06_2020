package ro.esolacad.javaad.day4.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public String getProduct(Model model) {
        model.addAttribute("test", "TestFromTheController");

        return "product";
    }
}
