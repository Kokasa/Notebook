public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name);  // super调用父类的构造方法
        this.breed = breed;  // this指向当前Dog类的实例
    }
    
    @Override
    public void makeSound() {
        super.makeSound();  // super调用父类的方法
        System.out.println("汪汪汪！");  // 添加子类特有的行为
    }
    
    public void showInfo() {
        // this用于访问当前类的属性
        System.out.println("我是一只" + this.breed + "品种的狗，名字叫" + this.name);
    }
} 