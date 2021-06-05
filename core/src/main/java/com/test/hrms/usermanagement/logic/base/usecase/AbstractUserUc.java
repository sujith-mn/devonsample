package com.test.hrms.usermanagement.logic.base.usecase;

import javax.inject.Inject;

import com.test.hrms.general.logic.base.AbstractUc;
import com.test.hrms.usermanagement.dataaccess.api.repo.UserRepository;

/**
 * Abstract use case for Users, which provides access to the commonly necessary data access objects.
 */
public class AbstractUserUc extends AbstractUc {

  /** @see #getUserRepository() */
  @Inject
  private UserRepository userRepository;

  /**
   * Returns the field 'userRepository'.
   * 
   * @return the {@link UserRepository} instance.
   */
  public UserRepository getUserRepository() {

    return this.userRepository;
  }

}
