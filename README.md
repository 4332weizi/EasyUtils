![icon](src/main/res/drawable-xxhdpi/ic_launcher.png)
# android开发常用工具类 #

-------------------------------
## 目录 ##
* net
	* funol
		* utils  
			* [Config](#net.funol.util.Config)
			* [Dimension](#net.funol.util.Dimension)
			* [L](#net.funol.util.L)
			* [NetWork](#net.funol.util.NetWork)
			* [Screen](#net.funol.util.Screen)
		* widget
			* [T](#net.funol.widget.T)

##
###<a name="net.funol.util.Config">Config</a>###
配置类  
1. ```boolean isAppReleased```应用是否已发布，默认为```false```。  
2. ```boolean isDevLogDisplayOn```是否输出日志信息，默认应用发布时关闭。  
3. ```boolean isDevToastDisplayOn```是否显示开发期临时Toast，默认应用发布时关闭。

###<a name="net.funol.util.Dimension">Dimension</a>  ###
单位转换工具   
**使用方法：**  
1. dp转px   
```Dimension.dp2px(Context context, float value);```   
2. px转dp   
```Dimension.px2dp(Context context, float value);```

###<a name="net.funol.util.L">L</a> ###
用于输出日志等信息，主要为了完成app发布后的log清除工作。<p>
**使用方法：**  
主要使用方法有三种(以error信息为例)  
1. 指定`TAG`输出。  
`L.e(String TAG, String msg);`  
2. 不指定`TAG`，传入当前类的实例，实际输出`TAG`为当前类的类名。    `L.e(Object obj, String msg);`  
3. 不传人任何`TAG`信息，输出`TAG`为调用该方法的类的类名。  
`L.e(String msg);`<p>
其中也包含Log中的其他用法，如：`L.e(String tag, String msg, Throwable tr);`,同时也包含另外两种传递Object和不传入任何作为`TAG`参数的传递方法。  
<b>注：</b>`w(String msg, Throwable tr)`与`w(String tag, Throwable tr)`冲突，保留w(String tag, Throwable tr)。<p>
应用发布时将L.java里面的display赋值为false即可使应用不再打印日志信息。  
推荐在[Config](#net.funol.util.Config)内配置`isDevLogDisplayOn`为`false`禁用Log打印。

###<a name="net.funol.util.NetWork">NetWork</a>   ###
获取网络状态  
**使用方法：**   
1. 网络是否连接   
`NetWork.isConnected(Context context);`   
2. 获取网络连接类型   
`NetWork.getType(Context context);`   
 Type.WIFI 网络连接类型为wifi   
 Type.G2 网络连接类型为2G网络    
 Type.G3 网络连接类型为3G网络   
 Type.G4 网络连接类型为4G网络   
 Type.OTHER 网络连接类型为其他网络   
 Type.NONE 网络未连接   
3. 是否为wifi网络   
`NetWork.isWifi(Context context);`  
4. 是否为4G网络  
`NetWork.isG4(Context context);`  
5. 是否为3G网络  
`NetWork.isG3(Context context);`  
6. 是否为2G网络  
`NetWork.isG2(Context context);`  
6. 是否开启GPS  
`NetWork.isGpsEnabled(Context context);`  

###<a name="net.funol.util.Screen">Screen</a>  ###
获取屏幕信息   
**使用方法：**  
1. 获取像素密度   
`Screen.getDensity(Context context);`  
2. 获取像素宽度   
`Screen.getWidthPixels(Context context);`  
3. 获取像素高度   
`Screen.getHeightPixels(Context context);`   
4. 获取状态栏高度   
`Screen.getStatusBarHeight(Activity activity);`   
5. 获取标题栏高度   
`Screen.getTitleBarHeight(Activity activity);`   
6. 获取内容部分高度   
`Screen.getContentHeight(Activity activity);`   

##
###<a name="net.funol.widget.T">T</a>  ###
用于显示Toast，主要为了完成app发布后的Toast清除工作。<p>
**使用方法：**  
`T.show(Context context, String msg);`   

-------------------------------
Copyright &copy; www.funol.net