package com.example.demomvc.validators;

import com.example.demomvc.repository.UserRepo;
import com.example.demomvc.service.UserService;
import com.example.demomvc.utils.ServiceUtils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import javax.validation.*;

public class UniqueUserConstraintValidator implements ConstraintValidator<UniqueUser, String> {

        UserService userService;

        @Override
        public void initialize(UniqueUser constraint) {
            //Use an utility service to get Spring beans
            userService = ServiceUtils.userService();
        }

        public boolean isValid(String login, ConstraintValidatorContext context) {
            return login != null && userService.userNameNotExists(login);
        }
}
