package dev.ryan.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private int expenseId;
    @Setter(AccessLevel.NONE)   //stop the lombok @data from auto-generating this setter
    private double amount;
    private int empId;
    private String approval = "pending";    //new expenses are pending by default
    private long expenseDate;
    private String expenseDescription;

    //Constructor with some args (approval status & date auto generated);
    public Expense(int expenseId, double amount, int empId, String expenseDescription) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.empId = empId;
        this.expenseDescription = expenseDescription;

        //set date to current date upon expense creation
        java.util.Date date = new Date();
        this.expenseDate = date.getTime();
    }

    //Expense amounts not permitted to be negative
    public void setAmount(double amount) {
        if(amount > 0)
            this.amount = amount;
        else
            throw new IllegalArgumentException("Expense amounts can not be negative.");
    }
}
