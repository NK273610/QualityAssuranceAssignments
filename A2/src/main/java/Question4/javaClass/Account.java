package Question4.javaClass;

import Question4.Interface.Balance;

public abstract class Account  {

    public float balance;

    
    public abstract void Credit(float amount);


    public abstract void Debit(float amount);
}
