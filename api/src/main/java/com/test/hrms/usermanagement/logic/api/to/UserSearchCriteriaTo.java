package com.test.hrms.usermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;
import com.test.hrms.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.test.hrms.usermanagement.common.api.User}s.
 */
public class UserSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String username;

  private String password;

  private String email;

  private String secret;

  private Boolean twoFactorStatus;

  private Long userRoleId;

  private StringSearchConfigTo usernameOption;

  private StringSearchConfigTo passwordOption;

  private StringSearchConfigTo emailOption;

  private StringSearchConfigTo secretOption;

  /**
   * @return usernameId
   */

  public String getUsername() {

    return username;
  }

  /**
   * @param username setter for username attribute
   */

  public void setUsername(String username) {

    this.username = username;
  }

  /**
   * @return passwordId
   */

  public String getPassword() {

    return password;
  }

  /**
   * @param password setter for password attribute
   */

  public void setPassword(String password) {

    this.password = password;
  }

  /**
   * @return emailId
   */

  public String getEmail() {

    return email;
  }

  /**
   * @param email setter for email attribute
   */

  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return secretId
   */

  public String getSecret() {

    return secret;
  }

  /**
   * @param secret setter for secret attribute
   */

  public void setSecret(String secret) {

    this.secret = secret;
  }

  /**
   * @return twoFactorStatusId
   */

  public Boolean getTwoFactorStatus() {

    return twoFactorStatus;
  }

  /**
   * @param twoFactorStatus setter for twoFactorStatus attribute
   */

  public void setTwoFactorStatus(Boolean twoFactorStatus) {

    this.twoFactorStatus = twoFactorStatus;
  }

  /**
   * getter for userRoleId attribute
   * 
   * @return userRoleId
   */

  public Long getUserRoleId() {

    return userRoleId;
  }

  /**
   * @param userRole setter for userRole attribute
   */

  public void setUserRoleId(Long userRoleId) {

    this.userRoleId = userRoleId;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getUsername() username}.
   */
  public StringSearchConfigTo getUsernameOption() {

    return this.usernameOption;
  }

  /**
   * @param usernameOption new value of {@link #getUsernameOption()}.
   */
  public void setUsernameOption(StringSearchConfigTo usernameOption) {

    this.usernameOption = usernameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getPassword() password}.
   */
  public StringSearchConfigTo getPasswordOption() {

    return this.passwordOption;
  }

  /**
   * @param passwordOption new value of {@link #getPasswordOption()}.
   */
  public void setPasswordOption(StringSearchConfigTo passwordOption) {

    this.passwordOption = passwordOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getEmail() email}.
   */
  public StringSearchConfigTo getEmailOption() {

    return this.emailOption;
  }

  /**
   * @param emailOption new value of {@link #getEmailOption()}.
   */
  public void setEmailOption(StringSearchConfigTo emailOption) {

    this.emailOption = emailOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getSecret() secret}.
   */
  public StringSearchConfigTo getSecretOption() {

    return this.secretOption;
  }

  /**
   * @param secretOption new value of {@link #getSecretOption()}.
   */
  public void setSecretOption(StringSearchConfigTo secretOption) {

    this.secretOption = secretOption;
  }

}
