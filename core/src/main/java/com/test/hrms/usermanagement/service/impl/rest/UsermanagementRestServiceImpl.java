package com.test.hrms.usermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.test.hrms.usermanagement.logic.api.Usermanagement;
import com.test.hrms.usermanagement.logic.api.to.UserEto;
import com.test.hrms.usermanagement.logic.api.to.UserSearchCriteriaTo;
import com.test.hrms.usermanagement.service.api.rest.UsermanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Usermanagement}.
 */
@Named("UsermanagementRestService")
public class UsermanagementRestServiceImpl implements UsermanagementRestService {

  @Inject
  private Usermanagement usermanagement;

  @Override
  public UserEto getUser(long id) {

    return this.usermanagement.findUser(id);
  }

  @Override
  public UserEto saveUser(UserEto user) {

    return this.usermanagement.saveUser(user);
  }

  @Override
  public void deleteUser(long id) {

    this.usermanagement.deleteUser(id);
  }

  @Override
  public Page<UserEto> findUsers(UserSearchCriteriaTo searchCriteriaTo) {

    return this.usermanagement.findUsers(searchCriteriaTo);
  }
}