class Bank {
    protected double transactionCharge = 50.0;

    public double getTransactionCharges() {
        return transactionCharge;
    }
}

class ICICI extends Bank {
    @Override
    public double getTransactionCharges() {
        return transactionCharge + 12.0; 
    }
}

class HDFC extends Bank {
    @Override
    public double getTransactionCharges() {
        return transactionCharge + 14.0; 
    }
}
