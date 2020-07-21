package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.exceptions.ComingSoonException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-divar")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MyDivarController {
    @GetMapping("/my-posts")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getMyAds() {
        throw new ComingSoonException();
    }
}
