package com.google;

public abstract class PurchasePower {
    protected static final double BASE = 1000;
    protected PurchasePower successor;

    abstract protected double getAllowable();
    abstract protected String getRole();

    public PurchasePower getSuccessor() {
        return successor;
    }

    public void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < getAllowable()) {
            System.out.println(getRole() + " will approve $" + getAllowable());
        } else if (successor != null) {
            successor.processRequest(request);
        } else {
            System.out.println("Nobody can approve this!!!");
        }
    }
}
