package Question4.javaClass;

import Question4.javaClass.Account;

public class USDollarAccount extends Account {

    static final float EXCHANGE_RATE = 0.75f;


    public void Credit(float amount) {

        balance += amount * EXCHANGE_RATE;

    }

    public void Debit(float amount) {

        balance -= amount * EXCHANGE_RATE;

    }
}
