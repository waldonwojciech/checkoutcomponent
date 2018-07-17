package com.checkoutcomponent.model.cart.state;

public enum CartState {

    OPEN("OPEN"), CLOSED("CLOSED");
    private String name;

    CartState(String status) {
        name = status;
    }

    public String toString() {
        return name;
    }

    public CartState fromString(String value) {
        switch (value) {
            case ("OPEN"):
                return CartState.OPEN;
            case ("CLOSED"):
                return CartState.CLOSED;
            default:
                throw new IllegalArgumentException("Invalid cart state.");
        }
    }
}
