package ir.ac.kntu.divar.model.service;

import ir.ac.kntu.divar.auth.UserPrincipal;
import ir.ac.kntu.divar.exceptions.BadInputException;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.user.Divar;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.DivarRepository;
import ir.ac.kntu.divar.model.repo.UserRepository;
import ir.ac.kntu.divar.util.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final DivarRepository divarRepository;

    @Loggable
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

    @Loggable
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = getUser(s);
        return new UserPrincipal().setUser(user);
    }

    @Loggable
    public User getCurrentLoggedOnUser() {
        var cred = getCurrentLoggedOnUserCredentials();
        if (cred == null) {
            return null;
        }
        return userRepository.findById(cred
                .getUser().getId()).orElse(null);
    }

    @Loggable
    public UserPrincipal getCurrentLoggedOnUserCredentials() {
        var ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (ob instanceof UserPrincipal) {
            return ((UserPrincipal) ob);
        }
        return null;
    }

    @Loggable
    public boolean isMarked(String id) {
        User user = getCurrentLoggedOnUser();
        return user != null && user.getDivar().getMarkedAdvertisements().stream()
                .anyMatch(z -> z.getId().toString().equals(id));
    }

    @Loggable
    public void handleCurrentUserMarkedAds(Advertisement ad) {
        User user = getCurrentLoggedOnUser();
        if (user == null) {
            return;
        }
        if (user.getDivar().getMarkedAdvertisements().contains(ad)) {
            user.getDivar().getMarkedAdvertisements().remove(ad);
        } else {
            user.getDivar().getMarkedAdvertisements().add(ad);
        }
        saveUser(user);
    }

    @Loggable
    public void handleCurrentUserRecentAds(Advertisement ad) {
        User user = getCurrentLoggedOnUser();
        if (user == null) {
            return;
        }
        if (user.getDivar().getRecentAdvertisements().size() >= 10) {
            user.getDivar().getRecentAdvertisements().remove(0);
        }
        user.getDivar().getRecentAdvertisements().add(ad);
        saveUser(user);
    }

    @Loggable
    public List<? extends Advertisement> getCurrentLoggedOnUserMarkedAds() {
        User user = getCurrentLoggedOnUser();
        return user.getDivar().getMarkedAdvertisements();
    }

    @Loggable
    public List<? extends Advertisement> getCurrentLoggedOnUserAds() {
        User user = getCurrentLoggedOnUser();
        return user.getDivar().getUserAdvertisements();
    }

    @Loggable
    public List<? extends Advertisement> getCurrentLoggedOnUserRecentAds() {
        User user = getCurrentLoggedOnUser();
        return user.getDivar().getRecentAdvertisements();
    }

    @Loggable
    public void clearCurrentUsersRecentAds() {
        User user = getCurrentLoggedOnUser();
        user.getDivar().getRecentAdvertisements().clear();
        saveUser(user);
    }
}
