package dev.ryan.services;

import dev.ryan.exceptions.ImmutableExpenseException;
import dev.ryan.repos.ExpenseRepo;
import dev.ryan.entities.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Override
    public Expense registerNewExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public Expense getExpenseByExpenseId(int id) {
        Optional<Expense> possibleExpense = expenseRepo.findById(id);
        if(possibleExpense.isPresent()){
            return possibleExpense.get();
        } else {
            throw new EntityNotFoundException("Expense with ID #" + id + "not found.");
        }
    }

    @Override
    public boolean approveExpense(Expense expense) {

        //check if expense is pending, if not throw exception. Approved/denied expenses can not be updated or deleted.
        if(expense.getApproval().equals("approved") || expense.getApproval().equals("denied")) {
            throw new ImmutableExpenseException(expense.getExpenseId());
        } else {
            expense.setApproval("approved");
            this.expenseRepo.save(expense);
            return true;
        }
    }

    @Override
    public boolean denyExpense(Expense expense) {
        //Check is expense is pending, only pending expenses can be changed
        if(!this.getExpenseByExpenseId(expense.getExpenseId()).getApproval().equals("pending")){
            throw new ImmutableExpenseException(expense.getExpenseId());
        } else {
            expense.setApproval("denied");
            this.expenseRepo.save(expense);
            return true;
        }
    }

    @Override
    public boolean deleteExpenseById(int id) {
        //check if expense is pending before allowing deletion
        if(!this.getExpenseByExpenseId(id).getApproval().equals("pending")){
            throw new ImmutableExpenseException(id);
        } else {
            this.expenseRepo.delete(this.getExpenseByExpenseId(id));
            return true;
        }
    }

    @Override
    public Expense replaceExpense(Expense expense) {
        //check if expense is pending before allowing it to be changed
        if (!expense.getApproval().equals("pending")){
            throw new ImmutableExpenseException(expense.getExpenseId());
        } else {
            return expenseRepo.save(expense);
        }
    }

    @Override
    public List<Expense> getAllExpensesByEmployeeId(int id) {
        //First retrieve a list of all expenses
        List<Expense> expenses = expenseRepo.findAll();

        //filter the list of all expenses and return a list of those with employee id matching the ID parameter
        return expenses
                .stream()
                .filter(e -> e.getEmpId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    @Override
    public List<Expense> getAllExpensesByApprovalStatus(String status) {
        //First retrieve a list of all expenses
        List<Expense> expenses = expenseRepo.findAll();

        //filter the list of all expenses and return a list of those with status matching the status parameter
        return expenses
                .stream()
                .filter(e -> e.getApproval().equals(status))
                .collect(Collectors.toList());
    }
}
