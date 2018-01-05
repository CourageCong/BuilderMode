package com.fc.buildermodle;

import java.util.List;

/**
 * Created by fc on 2018/1/5.
 * 角色类
 */

public class Charactor {

    private int height;
    private String clothes;
    private String trousers;
    private String shoes;
    private List<String> weapon;

    private Charactor() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getTrousers() {
        return trousers;
    }

    public void setTrousers(String trousers) {
        this.trousers = trousers;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public List<String> getWeapon() {
        return weapon;
    }

    public void setWeapon(List<String> weapon) {
        this.weapon = weapon;
    }

    public static class Builder{

        private Charactor charactor = null;

        public Builder() {
            this.charactor = new Charactor();
        }

        public Builder height(int height){
            charactor.height = height;
            return this;
        }

        public Builder clothes(String clothes){
            charactor.clothes = clothes;
            return this;
        }

        public Builder trousers(String trousers){
            charactor.trousers = trousers;
            return this;
        }

        public Builder shoes(String shoes){
            charactor.shoes = shoes;
            return this;
        }

        public Builder weapon(List<String> weapon){
            charactor.weapon = weapon;
            return this;
        }

        public Charactor build(){
            return charactor;
        }
    }
}
