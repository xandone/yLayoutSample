#### View坐标系关系图(图片来自网络)
![](https://github.com/xandone/yLayoutSample/blob/master/app/src/main/java/com/app/xandone/ylayoutsample/scroller/20160221170553904.jpg)
![](https://github.com/xandone/yLayoutSample/blob/master/app/src/main/java/com/app/xandone/ylayoutsample/scroller/20160104113905961.jpg)

#### 关于Android中的滑动
1.Scroller 类并不负责“滚动”这个动作，只是根据要滚动的起始位置和结束位置生成中间的过
渡位置， 从而形成一个滚动的动画。
2.一个 View 的滚动不是自身发起的动作，而是由父容器驱动子组件来完成，换句话说需要Scroller和ViewGroup
的配合才能产生滚动这个过程。所以，不要误以为是View自己在滚动显然不是，而是容器让子组件滚动，
主动权在 ViewGroup 手中
3.scrollTo和scrollBy只能改变View内容的位置，不能改变View在布局中的位置</br>
4.滚动往往分别两个阶段：第一个阶段是手指在屏幕上滑动，容器内的子组件跟随手指的速率
一起滑动，当手指松开后， 进入第二个阶段——惯性滚动，滚动不会马上停止，而是给出一个负
的加速度，滚动速度会越来越慢，直到最后处于静态状态。

#### scroller简介
1.scrollTo(x,y):滚动到</br>
2.scrollBy(dx,dy):滚动了</br>
3.mScrollX=getScrollX()=>等于View左边缘和View内容左边缘在水平方向的距离</br>

#### 平滑滚动的原理
1) 调用 scroller 的 startScroll()方法定义滚动的起始位置,滚动的距离和时间等参数；</br>
2) 通过 invalidate()或 postInvalidate()方法刷新，调用 draw(Canvas)方法重绘组件；</br>
3) draw()方法里面调用 computeScroll()计算下一个位置的坐标；</br>
4) computeScroll()中计算时间判断滑动时间是否结束，未结束时再次调用 invalidate()或 postInvalidate()方法刷新重绘；</br>
5) 判断 computeScroll()方法的返回值，如果为 false 表示结束滚动，为 true 表示继续滚动。</br>
Scroller本身不能实现(控制)View的的滑动，它的主要功能是不停计算View"应该"到达哪个坐标，然后调用scrollTo滑动到该坐标点。这个思想和值动画的做法很像。
