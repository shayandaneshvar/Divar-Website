package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/my-divar")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MyDivarController {
    private final UserService userService;

    @GetMapping("/my-posts")
    @PreAuthorize("hasAnyAuthority('USER')")
    public String getMyAds(Model model) {
        System.out.println(userService.getCurrentLoggedOnUserCredentials().getAuthorities().toArray()[0]);
        List<? extends Advertisement> ads =
                userService.getCurrentLoggedOnUserAds();
        model.addAttribute("ads", ads);
        model.addAttribute("type", 1);
        return "my-divar";
    }

    @GetMapping("/recents")
    @PreAuthorize("hasAuthority('USER')")
    public String getMyRecentAds(Model model) {
        List<? extends Advertisement> ads =
                userService.getCurrentLoggedOnUserRecentAds();
        model.addAttribute("ads", ads);
        model.addAttribute("type", 3);
        return "my-divar";
    }

    @GetMapping("/bookmarks")
    @PreAuthorize("hasAuthority('USER')")
    public String getMyMarkedAds(Model model) {
        List<? extends Advertisement> ads =
                userService.getCurrentLoggedOnUserMarkedAds();
        model.addAttribute("ads", ads);
        model.addAttribute("type", 2);
        return "my-divar";
    }

    @RequestMapping("/recents?clear")
    public String clearRecentAds(){
        userService.clearCurrentUsersRecentAds();
        return "redirect:/my-divar/recents";
    }

}
