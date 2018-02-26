```Java
    //当前View处理点击事件
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean consume = false;
        //是否拦截该事件
        if (onIntercepterTouchEvent(ev)) {
            //拦截则调用onTouchEvent进行处理
            consume = onTouchEvent(ev);
        } else {
            //不拦截则当前View的子View处理该点击事件，子View"递归判断"
            consume = child.dispatchTouchEvent(ev);
        }
        return consume;
    }

```

### Touch事件
1.Touch事件传递的相关API有dispatchTouchEvent、onTouchEvent、onInterceptTouchEvent</br>
2.Touch事件相关的类有View、ViewGroup、Activity</br>
3.Touch事件会被封装成MotionEvent对象，该对象封装了手势按下、移动、松开等动作</br>
4.Touch事件通常从Activity#dispatchTouchEvent发出，只要没有被消费，会一直往下传递，到最底层的View.</br>
5.如果Touch事件传递到的每个View都不消费事件，那么Touch事件会反向向上传递,最终交由Activity#onTouchEvent处理.</br>
6.onInterceptTouchEvent为ViewGroup特有，可以拦截事件.</br>
7.Down事件到来时，如果一个View没有消费该事件，那么后续的MOVE/UP事件都不会再给它</br>

### onTouch()和onTouchEvent()
假设一个view设置了setOnTouchEvent()并且重写了onTouchEvent()方法</br>
1.回调onTouch()方法</br>
2.假如onTouch()返回true，表明该事件被消耗，则不会调用onTouchEvent()</br>
3.反之，返回false，则会调用onTouchEvent()</br>
4.onTouchEvent()也有返回值，假如该view的onTouchEvent()返回为false，则改事件会反馈到它的父级viewGroup的onTouchEvent()进行处理</br>
5.如果一直返回false，则一直反馈到Activity</br>
6.处理过程和分发过程恰好相反</br>