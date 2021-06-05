package com.test.hrms.usermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.test.hrms.usermanagement.dataaccess.api.UserEntity;
import com.test.hrms.usermanagement.logic.api.to.UserEto;
import com.test.hrms.usermanagement.logic.api.usecase.UcManageUser;
import com.test.hrms.usermanagement.logic.base.usecase.AbstractUserUc;

/**
 * Use case implementation for modifying and deleting Users
 */
@Named
@Validated
@Transactional
public class UcManageUserImpl extends AbstractUserUc implements UcManageUser {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageUserImpl.class);

  @Override
  public boolean deleteUser(long userId) {

    UserEntity user = getUserRepository().find(userId);
    getUserRepository().delete(user);
    LOG.debug("The user with id '{}' has been deleted.", userId);
    return true;
  }

  @Override
  public UserEto saveUser(UserEto user) {

    Objects.requireNonNull(user, "user");

    UserEntity userEntity = getBeanMapper().map(user, UserEntity.class);

    // initialize, validate userEntity here if necessary
    UserEntity resultEntity = getUserRepository().save(userEntity);
    LOG.debug("User with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, UserEto.class);
  }
}
