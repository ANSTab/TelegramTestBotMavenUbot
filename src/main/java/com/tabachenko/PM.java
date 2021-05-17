package com.tabachenko;

public class PM {
    private String name;
    private String producer;
    private String type;
    private String fao;
    private String price;
    private String currency;

    public PM(String name, String producer, String type, String fao, String price, String currency) {
        this.name = name;
        this.producer = producer;
        this.type = type;
        this.fao = fao;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFao() {
        return fao;
    }

    public void setFao(String fao) {
        this.fao = fao;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PM{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", type='" + type + '\'' +
                ", fao='" + fao + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
