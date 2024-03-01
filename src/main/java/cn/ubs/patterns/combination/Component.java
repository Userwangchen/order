package cn.ubs.patterns.combination;


/*
    组合模式的顶级接口
    该模式的是分成了整体-部分层次结构，包含叶子和容器两部分
    容器是包含叶子节点的复合对象

 */
public interface Component {

    /**
     * 叶子节点和容器的通用方法
     */
    void operation();

}
