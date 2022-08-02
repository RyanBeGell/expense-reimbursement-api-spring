package dev.ryan.services;

import dev.ryan.entities.Expense;
import java.util.List;

public interface ExpenseService {

    Expense registerNewExpense(Expense expense);

    Expense retrieveExpenseByExpenseId(int id);

    void approveExpense(Expense expense);

    void denyExpense(Expense expense);

    void deleteExpenseById(int id);

    Expense replaceExpense(Expense expense);

    List<Expense> getAllExpensesByEmployeeId(int id);

    List<Expense> getAllExpenses();

    List<Expense> getAllExpensesByApprovalStatus(String status);

}
