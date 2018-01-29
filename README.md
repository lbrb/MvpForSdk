# MvpForSdk
sdk实现mvp的一种方式

一般第三方sdk，都不会要求宿主app注册大量activity。界面一般是从一个dialog跳转到另一个dialog。

实现思路：
1.MVP中P相当于业务，所以场景之间的跳转是以P为入口的，P提供了dissmiss和show方法。
2.场景之间传递业务信息模仿android源码实现，使用showViewForResult(P, 1), setResult(2), onMvpResult(int requestCode, int resultCode)
