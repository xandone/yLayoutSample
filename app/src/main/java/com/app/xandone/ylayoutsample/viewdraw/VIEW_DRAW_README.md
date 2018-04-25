### View的重绘
invalidate()方法</br>
会执行draw过程，重绘View树。</br>
当View的appearance发生改变，比如状态改变（enable，focus），背景改变，隐显改变等需要更新界面显示，就可以直接调用invalidate方法。</br>
View（非容器类）调用invalidate方法只会重绘自身，ViewGroup调用则会重绘整个View树。</br>

requestLayout()</br>
当View的边界，也可以理解为View的宽高，发生了变化，不再适合现在的区域，可以调用requestLayout方法重新对View布局。</br>
View执行requestLayout方法，会向上递归到顶级父View中，再执行这个顶级父View的requestLayout，
所以其他View的onMeasure，onLayout也可能会被调用。</br>