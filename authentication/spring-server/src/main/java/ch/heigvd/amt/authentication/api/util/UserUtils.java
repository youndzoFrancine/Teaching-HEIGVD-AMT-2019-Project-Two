package ch.heigvd.amt.authentication.api.util;

import ch.heigvd.amt.authentication.api.model.User;
import ch.heigvd.amt.authentication.api.model.UserMin;
import ch.heigvd.amt.authentication.entities.UserEntity;

public class UserUtils {

    public static UserEntity toUserEntity(User user){
        UserEntity entity = new UserEntity();
        entity.setFirstname(user.getFirstname());
        entity.setLastname(user.getLastname());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setRole(user.getRole());
        return entity;
    }

    public static UserMin toUserMin(UserEntity userEntity) {
        UserMin user = new UserMin();
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setRole(userEntity.getRole());
        return user;
    }

    public static User toUser(UserEntity userEntity) {
        User user = new User();
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setRole(userEntity.getRole());
        return user;
    }
}
