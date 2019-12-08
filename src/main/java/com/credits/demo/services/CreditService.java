package com.credits.demo.services;

import com.credits.demo.dto.CreditRequestDto;
import com.credits.demo.entities.Credit;
import com.credits.demo.entities.User;
import com.credits.demo.repositories.CreditRepository;
import com.credits.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

    private CreditRepository creditRepository;
    private UserRepository userRepository;

    public CreditService(CreditRepository creditRepository,
                         UserRepository userRepository) {
        this.creditRepository = creditRepository;
        this.userRepository = userRepository;
    }

    public Credit create(CreditRequestDto dto) {
        //TODO: создание пользователя
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setFamilyname(dto.getFamilyname());
        user.setId(dto.getId());
        user.setCountry(dto.getCountry());
        //.. все остальные поля

        Credit credit = new Credit();
        credit.setSum(dto.getSum());
        credit.setTerm(dto.getTerm());


        //TODO: добавить кредит пользователю

        user.addCredit(credit);

        return creditRepository.save(credit);
    }

    public List<Credit> getAll() {
        return (List<Credit>) creditRepository.findAll();
    }

    public List<Credit> getByUserId(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return user.getCredits();
        } else {
            throw new EntityNotFoundException("User with id = " + userId + " not found");
        }
    }
}
