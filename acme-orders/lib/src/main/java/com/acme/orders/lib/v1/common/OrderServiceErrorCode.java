package com.acme.orders.lib.v1.common;

/**
 * The enum Order service error code.
 */
public enum OrderServiceErrorCode {

    /**
     * Order state incorrect order service error code.
     */
    ORDER_STATE_INCORRECT("order.state.incorrect"),
    /**
     * Order cart item invalid order service error code.
     */
    ORDER_CART_ITEM_INVALID("order.cart.item.invalid"),
    /**
     * Order cart empty order service error code.
     */
    ORDER_CART_EMPTY("order.cart.empty"),

    /**
     * Unknown order service error code.
     */
    UNKNOWN("unknown");

    private String code;

    OrderServiceErrorCode(String code) {
        this.code = code;
    }

    /**
     * Find by code order service error code.
     *
     * @param code the code
     * @return the order service error code or UNKNOW if not found
     */
    public static OrderServiceErrorCode findByCode(String code) {

        for (OrderServiceErrorCode errorCode : values()) {

            if (errorCode.getCode().equals(code)) {
                return errorCode;
            }
        }

        return UNKNOWN;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }
}
