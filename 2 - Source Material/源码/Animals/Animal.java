public class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;  // this关键字指向当前类的实例
    }
    
    public void makeSound() {
        System.out.println("动物发出声音");
    }
} 