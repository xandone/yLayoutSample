###View坐标系关系图
![]()
![]()

###scroller简介
1.scrollTo和scrollBy只能改变View内容的位置，不能改变View在布局中的位置</br>
2.mScrollX=getScrollX()=>等于View左边缘和View内容左边缘在水平方向的距离</br>

###平滑滚动的原理
1) 调用 scroller 的 startScroll()方法定义滚动的起始位置和滚动的距离；</br>
2) 通过 invalidate()或 postInvalidate()方法刷新，调用 draw(Canvas)方法重绘组件；</br>
3) 调用 computeScroll()计算下一个位置的坐标；</br>
4) 再次调用 invalidate()或 postInvalidate()方法刷新重绘；</br>
5) 判断 computeScroll()方法的返回值，如果为 false 表示结束滚动，为 true 表示继续滚动。</br>
Scroller本身不能实现(控制)View的的滑动，它的主要功能是不停计算View"应该"到达哪个坐标，然后调用scrollTo滑动到该坐标点。这个思想和值动画的做法很像。