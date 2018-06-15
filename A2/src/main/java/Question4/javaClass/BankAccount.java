package Question4.javaClass;

import Question4.Interface.Balance;

public class BankAccount extends Account  {

    public void Credit(float amount) {

        balance += amount;

    }

    public void Debit(float amount) {

        balance -= amount;

    }
}
