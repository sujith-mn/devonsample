package com.test.hrms.usermanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.test.hrms.usermanagement.logic.api.to.UserEto;
import com.test.hrms.usermanagement.logic.api.to.UserSearchCriteriaTo;

public interface UcFindUser {

  /**
   * Returns a User by its id 'id'.
   *
   * @param id The id 'id' of the User.
   * @return The {@link UserEto} with id 'id'
   */
  UserEto findUser(long id);

  /**
   * Returns a paginated list of Users matching the search criteria.
   *
   * @param criteria the {@link UserSearchCriteriaTo}.
   * @return the {@link List} of matching {@link UserEto}s.
   */
  Page<UserEto> findUsers(UserSearchCriteriaTo criteria);

}
