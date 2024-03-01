package cn.ubs.patterns.combination;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    private List<Component> children = new ArrayList<>();

    /**
     * 容器新增叶子
     * @param component
     */
    public void add(Component component) {
        children.add(component);
    }

    /**
     * 容器删除叶子
     * @param component
     */
    public void remove(Component component) {
        children.remove(component);
    }


    @Override
    public void operation() {
        System.out.println("容器节点的操作");
        //遍历容器下的动作，容器下还可以有容器
        children.forEach(x->x.operation());
    }
}
