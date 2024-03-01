package cn.ubs.patterns.combination;

public class Leaf implements Component{
    @Override
    public void operation() {
        System.out.println("叶子节点的操作。。。");
    }
}
