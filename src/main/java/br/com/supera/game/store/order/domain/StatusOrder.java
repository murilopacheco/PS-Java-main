package br.com.supera.game.store.order.domain;

public enum StatusOrder {

    AGUARDANDO ("Aguardando"),
    CANCELADO ("Cancelado"),
    PAGO ("Pago");

    private String description;

    StatusOrder(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
