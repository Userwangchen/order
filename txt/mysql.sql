-- 1.分组排名函数,这种是重复的数据也会参与排序
select *,ROW_NUMBER() OVER(PARTITION BY your_group_column order by your order_by_column desc) as row_num from your table;
-- 2.分组排名函数，重复数据会有相同排名
select *,RANK() OVER(PARTITION BY your_group_column order by your order_by_column desc) as row_num from your table;