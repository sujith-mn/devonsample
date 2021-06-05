package com.test.hrms.usermanagement.logic.api.usecase;

import com.test.hrms.usermanagement.logic.api.to.UserEto;

/**
 * Interface of UcManageUser to centralize documentation and signatures of methods.
 */
public interface UcManageUser {

  /**
   * Deletes a user from the database by its id 'userId'.
   *
   * @param userId Id of the user to delete
   * @return boolean <code>true</code> if the user can be deleted, <code>false</code> otherwise
   */
  boolean deleteUser(long userId);

  /**
   * Saves a user and store it in the database.
   *
   * @param user the {@link UserEto} to create.
   * @return the new {@link UserEto} that has been saved with ID and version.
   */
  UserEto saveUser(UserEto user);

}
