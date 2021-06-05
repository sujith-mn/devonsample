package com.test.hrms.usermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.test.hrms.usermanagement.dataaccess.api.UserEntity;
import com.test.hrms.usermanagement.logic.api.to.UserSearchCriteriaTo;

/**
 * {@link DefaultRepository} for {@link UserEntity}
 */
public interface UserRepository extends DefaultRepository<UserEntity> {

  /**
   * @param criteria the {@link UserSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link UserEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<UserEntity> findByCriteria(UserSearchCriteriaTo criteria) {

    UserEntity alias = newDslAlias();
    JPAQuery<UserEntity> query = newDslQuery(alias);

    String username = criteria.getUsername();
    if (username != null && !username.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getUsername()), username, criteria.getUsernameOption());
    }
    String password = criteria.getPassword();
    if (password != null && !password.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getPassword()), password, criteria.getPasswordOption());
    }
    String email = criteria.getEmail();
    if (email != null && !email.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getEmail()), email, criteria.getEmailOption());
    }
    String secret = criteria.getSecret();
    if (secret != null && !secret.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getSecret()), secret, criteria.getSecretOption());
    }
    Boolean twoFactorStatus = criteria.getTwoFactorStatus();
    if (twoFactorStatus != null) {
      query.where($(alias.getTwoFactorStatus()).eq(twoFactorStatus));
    }
    Long userRole = criteria.getUserRoleId();
    if (userRole != null) {
      query.where($(alias.getUserRole().getId()).eq(userRole));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  @Query("SELECT user FROM UserEntity user" + " WHERE user.username = :username")
  UserEntity findByUsername(@Param("username") String username);

  /**
   * Add sorting to the given query on the given alias
   *
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<UserEntity> query, UserEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "username":
            if (next.isAscending()) {
              query.orderBy($(alias.getUsername()).asc());
            } else {
              query.orderBy($(alias.getUsername()).desc());
            }
            break;
          case "password":
            if (next.isAscending()) {
              query.orderBy($(alias.getPassword()).asc());
            } else {
              query.orderBy($(alias.getPassword()).desc());
            }
            break;
          case "email":
            if (next.isAscending()) {
              query.orderBy($(alias.getEmail()).asc());
            } else {
              query.orderBy($(alias.getEmail()).desc());
            }
            break;
          case "secret":
            if (next.isAscending()) {
              query.orderBy($(alias.getSecret()).asc());
            } else {
              query.orderBy($(alias.getSecret()).desc());
            }
            break;
          case "twoFactorStatus":
            if (next.isAscending()) {
              // query.orderBy($(alias.getUserRole()).asc());
            } else {
              // query.orderBy($(alias.getUserRole()).desc());
            }
            break;
          case "userRole":
            if (next.isAscending()) {
              query.orderBy($(alias.getUserRole().getId().toString()).asc());
            } else {
              query.orderBy($(alias.getUserRole().getId().toString()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
