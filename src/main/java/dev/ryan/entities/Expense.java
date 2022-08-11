package dev.ryan.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int expenseId;
    private String approval = "pending";    //new expenses are pending upon creation
    private long expenseDate;
    private String expenseDescription;

    @Setter(AccessLevel.NONE)   //stop the lombok @Setter from auto-generating this setter
    private double amount;

    @OneToOne
    @JoinColumn(name="id")
    private int empId;

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
