package com.cjimgarten.loancalculator.model.data;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by chris on 8/9/17.
 */
public interface LoanDetailsDao extends CrudRepository<String, Integer> {
}
