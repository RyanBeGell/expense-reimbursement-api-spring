package dev.ryan.services;

import dev.ryan.entities.Expense;
import java.util.List;

public interface ExpenseService {

    Expense saveExpense(Expense expense);

    Expense getExpenseByExpenseId(int id);

    boolean approveExpense(Expense expense);

    boolean denyExpense(Expense expense);

    boolean deleteExpenseById(int id);

    List<Expense> getAllExpensesByEmployeeId(int id);

    List<Expense> getAllExpenses();

    List<Expense> getAllExpensesByApprovalStatus(String status);

}
