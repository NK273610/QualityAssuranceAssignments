package Question4.javaClass;

import Question4.Interface.Balance;

public class BankAccount extends Account implements Balance  {
    
    @Override
    public float GetBalance() {

        return this.balance;
    }

    public void Credit(float amount) {

        balance += amount;

    }

    public void Debit(float amount) {

        balance -= amount;

    }
}
