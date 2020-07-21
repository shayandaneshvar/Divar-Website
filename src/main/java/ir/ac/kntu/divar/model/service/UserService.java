package ir.ac.kntu.divar.model.service;

import ir.ac.kntu.divar.exceptions.BadInputException;
import ir.ac.kntu.divar.model.entity.user.Divar;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepository repository;

    public User getUser(String mobile) {
        Pattern pattern = Pattern.compile("09[0-9]{9}");
        if (!pattern.matcher(mobile).matches()) {
            throw new BadInputException("Wrong Number");
        }
        return repository.getByMobile(mobile)
                .orElseGet(() -> saveUser(new User()
                        .setDivar(new Divar()
                                .setMarkedAdvertisements(new ArrayList<>())
                                .setRecentAdvertisements(new ArrayList<>())
                                .setUserAdvertisements(new ArrayList<>()))
                        .setMobile(mobile)));
    }

    public User saveUser(User user) {
        return repository.save(user);
    }
}
