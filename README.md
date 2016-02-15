# BiliBiliTitleBar

仿BiliBili安卓客户端标题栏

![image](https://github.com/HOOOOOO/BiliBiliTitleBar/blob/master/gif/GIF1.gif)
![image](https://github.com/HOOOOOO/BiliBiliTitleBar/blob/master/gif/GIF2.gif)

这个Demo主要是模仿BiliBili新版安卓客户端的标题栏所实现的功能。但是还是有一部分没做出来，就是当标题栏隐藏时，如果往上滑之后不离开屏幕继续往下滑的时候，标题栏也会跟着滑下来，但是我做的这个没有。之后应该还会继续改。

主要原理是：首先自定义一个布局CustomLayout，之后把标题栏、标签栏和ViewPager放在这个布局中。当点击ViewPager时，动作先传到该布局的onInterceptTouchEvent，return false之后，继续往下传到ViewPager的onInterceptTouchEvent，同样return false, 之后就传到ListView，return true之后接下来的MOVE和UP就不经过ViewPager的onInterceptTouchEvent了，但是当ListView还没滚动时，这些动作还是会经过CustomLayout的onInterceptTouchEvent(具体的原因我还没弄清楚)，这时候就可以在这个函数对该布局调用scroolTo函数。当CustomLayout不再滑动之后，ListView就会开始滑动了，然后就不会再调用CustomLayout的onInterceptTouchEvent。

这里有一个需要注意的地方，就是点击的时候传给CustomLayout的纵坐标和给ListView的纵坐标是不一样的，因为有标题栏和标签栏的缘故。所以当CustomLayout向上滑动时，ListView也在移动，所以手中接触屏幕的地方距离ListView的距离是不变的，这样传给ListView的纵坐标也一直不变，所以ListView是不会滚动的。

去找了一下资料，发现不同于onInterceptTouchEvent()函数，找到目标后就不再调用，dispatchTouchEvent()函数是一直被调用的，然后把处理都搬到这个函数里面，接着再增加一个变量来记录上次传过来的坐标，通过本次坐标，初始坐标和上次记录下来的坐标做比对来判断是否改变了滑动方向，问题就迎刃而解了。

参考的博客：[工匠若水--Android触摸屏事件派发机制详解与源码分析二(ViewGroup篇)](http://blog.csdn.net/yanbober/article/details/45912661)
