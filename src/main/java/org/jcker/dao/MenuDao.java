package org.jcker.dao;

import org.jcker.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-02-25 at 9:47 PM
 *
 * @version 1.0
 */
public interface MenuDao extends JpaRepository<Menu, Integer> {

}
