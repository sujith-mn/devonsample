package com.test.hrms.usermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.test.hrms.usermanagement.dataaccess.api.UserEntity;
import com.test.hrms.usermanagement.logic.api.to.UserEto;
import com.test.hrms.usermanagement.logic.api.to.UserSearchCriteriaTo;
import com.test.hrms.usermanagement.logic.api.usecase.UcFindUser;
import com.test.hrms.usermanagement.logic.base.usecase.AbstractUserUc;

/**
 * Use case implementation for searching, filtering and getting Users
 */
@Named
@Validated
@Transactional
public class UcFindUserImpl extends AbstractUserUc implements UcFindUser {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindUserImpl.class);

  @Override
  public UserEto findUser(long id) {

    LOG.debug("Get User with id {} from database.", id);
    Optional<UserEntity> foundEntity = getUserRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), UserEto.class);
    else
      return null;
  }

  @Override
  public Page<UserEto> findUsers(UserSearchCriteriaTo criteria) {

    Page<UserEntity> users = getUserRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(users, UserEto.class);
  }

}
