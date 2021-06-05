package com.test.hrms.usermanagement.dataaccess.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.test.hrms.general.dataaccess.api.ApplicationPersistenceEntity;
import com.test.hrms.usermanagement.common.api.UserRole;

@Entity
@Table(name = "UserRole")
public class UserRoleEntity extends ApplicationPersistenceEntity implements UserRole {

  private String name;

  private Boolean active;

  private List<UserEntity> users;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return active
   */
  @Override
  public Boolean getActive() {

    return this.active;
  }

  /**
   * @param active new value of {@link #getactive}.
   */
  @Override
  public void setActive(Boolean active) {

    this.active = active;
  }

  /**
   * @return users
   */
  @OneToMany(mappedBy = "userRole", fetch = FetchType.EAGER)
  public List<UserEntity> getUsers() {

    return this.users;
  }

  /**
   * @param users new value of {@link #getusers}.
   */
  public void setUsers(List<UserEntity> users) {

    this.users = users;
  }
}
