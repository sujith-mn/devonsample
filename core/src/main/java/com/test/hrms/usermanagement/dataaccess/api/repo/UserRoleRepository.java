package com.test.hrms.usermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.test.hrms.usermanagement.dataaccess.api.UserRoleEntity;
import com.test.hrms.usermanagement.logic.api.to.UserRoleSearchCriteriaTo;

/**
 * {@link DefaultRepository} for {@link UserRoleEntity}
 */
public interface UserRoleRepository extends DefaultRepository<UserRoleEntity> {

  /**
   * @param criteria the {@link UserRoleSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link UserRoleEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<UserRoleEntity> findByCriteria(UserRoleSearchCriteriaTo criteria) {

    UserRoleEntity alias = newDslAlias();
    JPAQuery<UserRoleEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    Boolean active = criteria.getActive();
    if (active != null) {
      query.where($(alias.getActive()).eq(active));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   * 
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<UserRoleEntity> query, UserRoleEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "name":
            if (next.isAscending()) {
              query.orderBy($(alias.getName()).asc());
            } else {
              query.orderBy($(alias.getName()).desc());
            }
            break;
          case "active":
            if (next.isAscending()) {
              query.orderBy($(alias.getActive()).asc());
            } else {
              query.orderBy($(alias.getActive()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}