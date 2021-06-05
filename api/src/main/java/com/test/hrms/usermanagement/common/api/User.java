package com.test.hrms.usermanagement.common.api;

import com.test.hrms.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  /**
   * @return usernameId
   */
  public String getUsername();

  /**
   * @param username setter for username attribute
   */
  public void setUsername(String username);

  /**
   * @return passwordId
   */
  public String getPassword();

  /**
   * @param password setter for password attribute
   */
  public void setPassword(String password);

  /**
   * @return emailId
   */
  public String getEmail();

  /**
   * @param email setter for email attribute
   */
  public void setEmail(String email);

  /**
   * @return secretId
   */
  public String getSecret();

  /**
   * @param secret setter for secret attribute
   */
  public void setSecret(String secret);

  /**
   * @return twoFactorStatusId
   */
  public boolean getTwoFactorStatus();

  /**
   * @param twoFactorStatus setter for twoFactorStatus attribute
   */
  public void setTwoFactorStatus(boolean twoFactorStatus);

  /**
   * getter for userRoleId attribute
   *
   * @return userRoleId
   */
  public Long getUserRoleId();

  /**
   * @param userRole setter for userRole attribute
   */
  public void setUserRoleId(Long userRoleId);

  /**
   * @return phoneId
   */
  public String getPhone();

  /**
   * @param phone setter for phone attribute
   */
  public void setPhone(String phone);

  /**
   * @return termsAcceptedId
   */
  public boolean isTermsAccepted();

  /**
   * @param termsAccepted setter for termsAccepted attribute
   */
  public void setTermsAccepted(boolean termsAccepted);

}
