package ir.ac.kntu.divar.model.service;

import ir.ac.kntu.divar.auth.UserPrincipal;
import ir.ac.kntu.divar.exceptions.BadInputException;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.user.Divar;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.DivarRepository;
import ir.ac.kntu.divar.model.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final DivarRepository divarRepository;

    public User getUser(String mobile) {
        Pattern pattern = Pattern.compile("09[0-9]{9}");
        if (!pattern.matcher(mobile).matches()) {
            throw new BadInputException("Wrong Number");
        }
        return userRepository.getByMobile(mobile)
                .orElseGet(() -> {
                    Divar divar = new Divar()
                            .setMarkedAdvertisements(new ArrayList<>())
                            .setRecentAdvertisements(new ArrayList<>())
                            .setUserAdvertisements(new ArrayList<>());
                    divar = divarRepository.save(divar);
                    return saveUser(new User()
                            .setDivar(divar)
                            .setMobile(mobile));
                });
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        User user = getUser(s);
        return new UserPrincipal().setUser(user);
    }

    public User getCurrentLoggedOnUser() {
        var ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (ob instanceof UserPrincipal) {
            UserPrincipal principal = ((UserPrincipal) ob);
            return userRepository.findById(principal.getUser().getId()).stream().peek(System.err::println).findFirst().get();
        }
        return null;
    }

    public boolean isMarked(String id) {
        User user = getCurrentLoggedOnUser();
        return user != null && user.getDivar().getMarkedAdvertisements().stream()
                .anyMatch(z -> z.getId().toString().equals(id));
    }

    public void handleCurrentUserMarkedAds(Advertisement ad) {
        User user = getCurrentLoggedOnUser();
        if (user.getDivar().getMarkedAdvertisements().contains(ad)) {
            user.getDivar().getMarkedAdvertisements().remove(ad);
        } else {
            user.getDivar().getMarkedAdvertisements().add(ad);
        }
        saveUser(user);
    }
}
