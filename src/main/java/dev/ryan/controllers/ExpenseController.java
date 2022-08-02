package dev.ryan.controllers;

import dev.ryan.entities.Expense;
import dev.ryan.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expenses")
    public Expense createEmployee(@RequestBody Expense expense){
        return expenseService.registerNewExpense(expense);
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(@RequestParam String status) {
        //If no query param, provide all expenses
        if (status == null){
            return expenseService.getAllExpenses();
        } else {
            //if status provided as query param, provide all expenses with that specific status
            return expenseService.getAllExpensesByApprovalStatus(status);
        }
    }

    @GetMapping("/employees/{id}/expenses")
    public List<Expense> getExpensesByEmployeeId(@PathVariable int id){
        return expenseService.getAllExpensesByEmployeeId(id);
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id){
        return expenseService.getExpenseByExpenseId(id);
    }

    @PutMapping("/expenses/{id}")
    public Expense replaceExpenseById(@PathVariable int id){
        return expenseService.replaceExpense(expenseService.getExpenseByExpenseId(id));
    }

    @PatchMapping("/expenses/{id}/approve")
    public String approveExpense(@PathVariable int id){
        expenseService.approveExpense(expenseService.getExpenseByExpenseId(id));
        return("Expense #" + id + "has been approved.");
    }

    @PatchMapping("/expenses/{id}/deny")
    public String denyExpense(@PathVariable int id){
        expenseService.denyExpense(expenseService.getExpenseByExpenseId(id));
        return("Expense #" + id + "has been denied.");
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable int id){
        expenseService.deleteExpenseById(id);
        return ("Expense #" + id + "successfully deleted.");
    }
}
