package dev.ryan.repos;

import dev.ryan.entities.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends CrudRepository <Expense,Integer> { }