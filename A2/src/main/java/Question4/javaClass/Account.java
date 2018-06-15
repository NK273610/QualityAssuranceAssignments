package Question4.javaClass;

import Question4.Interface.Balance;

public abstract class Account implements Balance {

    public float balance;

    @Override
    public float GetBalance() {

        return this.balance;
    }


    public abstract void Credit(float amount);


    public abstract void Debit(float amount);
}
