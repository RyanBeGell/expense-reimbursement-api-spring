package dev.ryan.exceptions;

public class ImmutableExpenseException extends RuntimeException{
    public ImmutableExpenseException(int id){
        super("Expense #" + id + " has already been approved or denied and can not be changed.");
    }
}
