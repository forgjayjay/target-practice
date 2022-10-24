package com.forg.targetPractice.Entity.User.Services;

import com.forg.targetPractice.Entity.User.User;
import com.forg.targetPractice.Entity.User.UserRepository;

public class LoginValidation{
    public boolean validate(User user, UserRepository userRepo){
        User existingUser = userRepo.findByEmail(user.getValidation());
        if(existingUser!=null){
            if(existingUser.getPassword().equals(user.getPassword())){
                return true;
            }
        } else {
            existingUser = userRepo.findByLogin(user.getValidation());
            if(existingUser.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}