package com.company;

public abstract class CardDecorator implements ICard {

    protected  MultiCard multiCard;

    public CardDecorator(){
        super();
    }

    public CardDecorator(MultiCard multiCard){
        this.multiCard = multiCard;
    }

    @Override
    public String iCardInfo() {
        return multiCard.iCardInfo();
    }
}
