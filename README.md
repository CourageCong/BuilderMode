
## 设计模式之路（二）——Builder建造者模式
[csdn传送门](http://blog.csdn.net/dacongge/article/details/78980831)

今天我们再讲一种常用并且实用的设计模式——Builder建造者模式。使用这种设计模式可以帮助我们更好的管理数据，可以用于有很多属性的类的创建，创建过程简洁清晰。但是仅仅是这些还不足以体现这个设计模式真正的精髓所在，在我看来，**灵活性才是Builder模式的精髓**。下面我们来讲一种场景，大家就会有比较深入的理解了。

假设我们要开发一款游戏，游戏中有十种角色，每一种角色都有身高、衣服、裤子、帽子、鞋、腰带、会使用的武器等属性，但是不同的角色间属性有区别。这些难不到我们，写一个角色类，把对应的属性写在构造方法中，然后实例化十个对象对应十种角色，大功告成。

但是现实往往是残酷的，这时产品过来告诉你其中有一个角色需要增加一个会飞的属性，我们的第一反应是重载一个带会不会飞属性的构造方法。但是，万一以后还需要新增一些角色，或者对已有角色的属性有增删，那么我们不可能每次都去重载构造方法，因为我们需要在构造方法中来回的传递数据，一旦构造方法过多，每一次新增属性我们都需要承担修改和新增构造方法的风险，后期很难维护和扩展，也不现实。那么，我们想到了一种解决办法，我们可以直接使用**默认的空构造方法**，然后通过get/set方法来设置属性，这样新增属性我们只需要同步新增get/set方法即可，角色有没有设置我们并不需要关心。
简略代码如下：
```java
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

    public Charactor() {
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
}
```
创建角色：
```java
Charactor charactor = new Charactor();
        charactor.setClothes("军大衣");
        charactor.setHeight(180);
        charactor.setShoes("阿迪王");
        charactor.setTrousers("短裤");
        charactor.setWeapon(null);
```
这样没有完全问题，但是如果使用我们的建造者模式，在属性更多的时候将会更加容易去管理，而且实例化的时候也会更加容易。下面我们就看一下，建造者模式应该怎样来写。
```java
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
```
我们只需要在角色类中新建一个内部静态类Builder，由于通用的建造者模式的内部类名字都写成Builder，所以建造者模式也被成为Builder模式。在Builder中我们需要针对外部类的每一个属性都写一个供外设置的方法，然后所有的返回参数都是Builder，最后再写一个build()方法，用于创建外部类对象。这样当我们创建对象的时候就不再需要一句一句的写了，我们只需要一行代码就可以完成。同时我们还需要把外部类的构造方法声明为private，这样就只能通过Builder类来创建对象了。
```java
Charactor charactor = new Charactor.Builder()
                .clothes("军大衣")
                .height(180)
                .shoes("阿迪王")
                .trousers("短裤")
                .weapon(null)
                .build();

```
是不是眼前一亮，美观易读。接下来就需要自己去尝试一下了。

