title: Jetty 源码剖析系列(4) - Connector 如何接收处理网络请求
date: 2018-01-05
tag: 
categories: Jetty
permalink: Jetty/EricCen/connectorru-he-jie-shou-chu-li-wang-luo-qing-qiu
author: Eric Cen
from_url: http://ericcenblog.com/2017/12/01/jettyyuan-ma-pou-xi-xi-lie-4-connectorru-he-jie-shou-chu-li-wang-luo-qing-qiu/
wechat_url: 

-------

摘要: 原创出处 http://ericcenblog.com/2017/12/01/jettyyuan-ma-pou-xi-xi-lie-4-connectorru-he-jie-shou-chu-li-wang-luo-qing-qiu/ 「Eric Cen」欢迎转载，保留摘要，谢谢！


-------

![](http://www.iocoder.cn/images/common/wechat_mp_2017_07_31.jpg)

> 🙂🙂🙂关注**微信公众号：【芋道源码】**有福利：
> 1. RocketMQ / MyCAT / Sharding-JDBC **所有**源码分析文章列表
> 2. RocketMQ / MyCAT / Sharding-JDBC **中文注释源码 GitHub 地址**
> 3. 您对于源码的疑问每条留言**都**将得到**认真**回复。**甚至不知道如何读源码也可以请教噢**。
> 4. **新的**源码解析文章**实时**收到通知。**每周更新一篇左右**。
> 5. **认真的**源码交流微信群。

-------

书接[上文](http://www.iocoder.cn/Jetty/EricCen/connectorru-he-jie-shou-wang-luo-qing-qiu/)，上文分析到`ServerConnector`的`doStart`方法会根据CPU的数量协调出一定数量的`Acceptor`，然后再把`Acceptor`交给线程池去执行：`AbstractConnector.doStart()`:![img](http://ericcenblog.com/content/images/2017/12/----_20171201174203.png)`Acceptor`实现了`Runnable`接口，进去看它的`run`方法:![img](http://ericcenblog.com/content/images/2017/12/1.png)![img](http://ericcenblog.com/content/images/2017/12/2.png)我们注意到它在while循环里面调用了`accept`方法，这个方法就是接收网络请求的入口了：![img](http://ericcenblog.com/content/images/2017/12/3.png)从上图的`accept`方法我们可以看到，它实际上就是调用了`ServerSocketChannel`的`accept`方法，我们终于回归到了`NIO`的基本，注意`ServerSocketChannel`的`accept`方法是阻塞的，直到接收到一个建立连接的请求，它就会返回一个`SocketChannel`，然后调用`accepted`方法，继续进入`accepted`方法看看：![img](http://ericcenblog.com/content/images/2017/12/4.png)先把`SocketChannel`设置为`nonBlocking`的，然后从`SocketChannel`里拿出`Socket`设置一些TCP属性：![img](http://ericcenblog.com/content/images/2017/12/5.png)比如会把该`socket`设置为`TCP_NODELAY`，这个是要disable [Nagle's algorithm](https://en.wikipedia.org/wiki/Nagle%27s_algorithm)。设置完`Socket`后，就会调用`SelectorManager`的`accept`方法：![img](http://ericcenblog.com/content/images/2017/12/6.png)![img](http://ericcenblog.com/content/images/2017/12/7.png)到这里，我们看到了`ManagedSelector`这个类，这个类是干嘛的呢？而`SelectManager`又是哪来的？我们回过头来看一下`ServerConnector`的构造方法：![img](http://ericcenblog.com/content/images/2017/12/8.png)可以看到`_manager`是在`ServerConnector`的构造方法里通过调用`newSelectorManager`方法得到的，而`newSelectorManager`方法里实际就是直接`new`出来：![img](http://ericcenblog.com/content/images/2017/12/9.png)再看回`ServerConnector`的构造方法里，`_manager`会被加进`ServerConnector`的`managedBean`里面，在调用`ServerConnector`的`doStart`方法时，它的`managedBean`也会被启动(被调用`start`方法,进而调用它的`doStart`方法)， 那我们就再进去看一下`SelectorManager`的`doStart`方法：![img](http://ericcenblog.com/content/images/2017/12/10.png)它先是通过`newSelector`方法创建`ManagedSelector`,`ManagedSelector`数目是跟CPU数目协调出来的， 然后再把`ManagedSelector`加进`SelectManager`的`managedBean`里面，同样在启动`SelectManager`的`doStart`方法时，`ManagedSelector`的`doStart`方法也会被启动：![img](http://ericcenblog.com/content/images/2017/12/11.png)`ManagedSelector`的`doStart`先通过`SelectorManager`的`newSelector`方法创建出一个`Selector`,这个`selector`就是Java NIO里面的`Selector`：![img](http://ericcenblog.com/content/images/2017/12/12.png)然后`SelectorManager`会execute`_strategy`的`produce`方法(这里用的Java 8的语法)，那么`_strategy`是啥呢？我们看回`ManagedSelector`的构造方法：![img](http://ericcenblog.com/content/images/2017/12/13.png)我们看到`_strategy`是`EatWhatYouKill`？这是什么鬼？这个命名实在是有意思。我们暂且按下不表。我们看到`_strategy`同样会被加进`ManagedSelector`的`managedBean`里面，那就代表启动`ManagedSelector`的时候，`_strategy`的`doStart`方法也会被启动，而`EatWhatYouKill`并没有重写`ContainerLifeCycle`的`doStart`方法，我们再看一下`EatWhatYouKill`的构造方法：![img](http://ericcenblog.com/content/images/2017/12/14.png)我们看到`Producer`被加进`EatWhatYouKill`的`managedBean`里面了，那这个`Producer`又是什么鬼？我们再回到ManagedSelector的构造方法里：![img](http://ericcenblog.com/content/images/2017/12/13-1.png)我们看到`Producer`是`SelectorProducer`， 在前面`ManagedSelecto`r的`doStart`方法里， `selectorManager`执行`EatWhaYouKill`的`produce`方法：![img](http://ericcenblog.com/content/images/2017/12/15.png)我们再看`EatWhatYouKill`的`doProduce`方法：![img](http://ericcenblog.com/content/images/2017/12/16.png)可以看到实际调用的`SelectorProduce`的`produce`方法：![img](http://ericcenblog.com/content/images/2017/12/17.png)当我看到里面调用的select()方法时，真的有种“终于等到你，还好我没放弃”的感觉：）![img](http://ericcenblog.com/content/images/2017/12/18.png)到这里，我们可以看到无论怎么写，最终还是用到最基本的Java NIO。 我们再回头看`SelectProducer`的`produce`方法里调用的`processSelected`方法：![img](http://ericcenblog.com/content/images/2017/12/19.png)它从`key`里面拿出`attachment`，如果`attachment`是`Selectable`的，比如说是一个`EndPoint`的话，它就会调用该`attachment`的`onSelected`方法(这里有个强转型)，在这里，我们的`attachment`是`SocketChannelEndPoint`，那我们看一下它的`onSelected`方法(从`ChannelEndPoint`继承而来)：![img](http://ericcenblog.com/content/images/2017/12/20.png)它会根据selectkey的状态返回不同的Runnable Task， 分别有`runCompleteWriteFillable`, `runFillable`和`runCompleteWrite`三种，![img](http://ericcenblog.com/content/images/2017/12/21.png)![img](http://ericcenblog.com/content/images/2017/12/22.png)![img](http://ericcenblog.com/content/images/2017/12/23.png)`EatWhatYouKill`的`doProduce`方法拿到这个`Runnable Task`后，将会执行它的`run`方法，比如`runFillable`的，它会调用`FillInterest`的`fillable`方法：![img](http://ericcenblog.com/content/images/2017/12/24.png)可以看到它实际调用的是`Callback`的`succeeded`方法。那这个`Callback`又是什么？

下回分解：）