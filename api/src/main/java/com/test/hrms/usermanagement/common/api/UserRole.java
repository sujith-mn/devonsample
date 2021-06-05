package com.test.hrms.usermanagement.common.api;

import com.test.hrms.general.common.api.ApplicationEntity;

public interface UserRole extends ApplicationEntity {

  /**
   * @return nameId
   */

  public String getName();

  /**
   * @param name setter for name attribute
   */

  public void setName(String name);

  /**
   * @return activeId
   */

  public Boolean getActive();

  /**
   * @param active setter for active attribute
   */

  public void setActive(Boolean active);

}
