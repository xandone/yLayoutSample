1.view.getTranslationX计算的是该view的偏移量。初始值为0，向左偏移值为负，向右偏移值为正。</br>
2.view.getX相当于该view距离父容器左边缘的距离，等于getLeft+getTranslationX。

tv_title_hide覆盖在tv_title之上，通过比较Math.max(tv_title.getTop(), scrollY)，当scrollView的滑动距离大于该标题距离上边界的距离时，
tv_title_hide体质继续滑动，后面接踵而至的tv_title_hide同样的逻辑，直接覆盖在上一个tv_title_hide之上，其实背面的tv_title依然在滑动.

srcrollView嵌套RecyclerView冲突的问题:</br>
拦截父容器(srcrollView)触摸事件，onInterceptTouchEvent</br>
```Java
 @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }
        }
        return super.onInterceptTouchEvent(e);
    }
    ```Java
	
	当滑动距离小于最小滑动距离mTouchSlop，认为改事需要拦截，禁止传递至RecyclerView
	
	
	-------------------------------------------------------------------------------