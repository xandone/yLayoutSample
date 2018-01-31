####基本用法
1.控制位置的比例
app:layout_constraintHorizontal_bias="0.1"</br>
水平比例0.1(父容器为1)</br>
2.控制组件自身宽高比
app:layout_constraintDimensionRatio="1.2:1"</br>
自身宽高比为1.2:1</br>
3.组件直接的约束，类似于weight</br>
app:layout_constraintHorizontal_weight="1"</br>
app:layout_constraintHorizontal_weight="2"</br>
两个组件水平排列的比例为1:2</br>
4.关于约束组件的gone：</br>
android:layout_marginRight="10dp" </br>
配合 app:layout_goneMarginRight="110dp"一起使用，</br>
在约束的布局gone时，起用goneMargin，</br>
但是一定要预先设置对应方向上的margin</br>
*如果只设置了app:layout_goneMarginRight没有设置android:layout_marginRight，则无效。（alpha版本的bug，1.0.1版本已经修复</br>
5.控件的宽高有三种方式为其设置： </br>
确定尺寸 </br>
WRAP_CONTENT </br>
0dp，就等于MATCH_CONSTRAINT</br>
不支持MATCH_PARENT</br>
想要该组件MATCH_PARENT效果，需以parent作为自己的约束：</br>
app:layout_constraintLeft_toLeftOf="parent"</br>
app:layout_constraintRight_toRightOf="parent"</br>
6.Guideline</br>
Guideline只能用于ConstraintLayout中，是一个工具类，不会被显示，仅仅用于辅助布局。
