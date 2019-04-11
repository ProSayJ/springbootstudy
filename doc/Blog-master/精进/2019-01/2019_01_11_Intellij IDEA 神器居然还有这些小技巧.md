title: Intellij IDEA 神器居然还有这些小技巧
date: 2019-01-11
tags: IntelliJ IDEA
categories: 精进
permalink: Fight/Intellij-IDEA-even-has-these-tricks
author: Sam哥哥
from_url: https://blog.csdn.net/linsongbin1/article/details/80211919
wechat_url: https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247486007&idx=1&sn=54520017683fdc71217a78de1c10221b&chksm=fa497586cd3efc90f5532815a16e610c32d52986f6603c400c7e4bcb2baae3200e2b962723e8&token=933039983&lang=zh_CN#rd

----------

摘要: 原创出处 https://blog.csdn.net/linsongbin1/article/details/80211919 「Sam哥哥」欢迎转载，保留摘要，谢谢！

- [概述](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [我最爱的【演出模式】](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [神奇的Inject language](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [使用快捷键移动分割线](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [ctrl+shift+enter不只是用来行尾加分号的](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [不要动不动就使用IDEA的重构功能](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [去掉导航栏](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [把鼠标定位到project视图里](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [强大的symbol](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [如何找目录](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [自动生成not null判断语句](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)
- [按照模板找内容](http://www.iocoder.cn/Fight/Intellij-IDEA-even-has-these-tricks/)

-------

![](http://www.iocoder.cn/images/common/wechat_mp_2017_07_31.jpg)

> 🙂🙂🙂关注**微信公众号：【芋道源码】**有福利：
> 1. RocketMQ / MyCAT / Sharding-JDBC **所有**源码分析文章列表
> 2. RocketMQ / MyCAT / Sharding-JDBC **中文注释源码 GitHub 地址**
> 3. 您对于源码的疑问每条留言**都**将得到**认真**回复。**甚至不知道如何读源码也可以请教噢**。
> 4. **新的**源码解析文章**实时**收到通知。**每周更新一篇左右**。
> 5. **认真的**源码交流微信群。

-------

# 概述



`Intellij IDEA`真是越用越觉得它强大，它总是在我们写代码的时候，不时给我们来个小惊喜。出于对`Intellij IDEA`的喜爱，我决定写一个与其相关的专栏或者系列，把一些好用的`Intellij IDEA`技巧分享给大家。本文是这个系列的第一篇，主要介绍一些你可能不知道的但是又实用的小技巧。



# 我最爱的【演出模式】


我们可以使用【Presentation Mode】，将`IDEA`弄到最大，可以让你只关注一个类里面的代码，进行毫无干扰的`coding`。

可以使用`Alt+V`快捷键，弹出`View`视图，然后选择`Enter Presentation Mode`。效果如下：
![这里写图片描述](http://static.iocoder.cn/908f1ba050cae6ad87fbc078f0456e84)

这个模式的好处就是，可以让你更加专注，因为你只能看到特定某个类的代码。可能读者会问，进入这个模式后，我想看其他类的代码怎么办？这个时候，就要考验你快捷键的熟练程度了。你可以使用`CTRL+E`弹出最近使用的文件。又或者使用`CTRL+N`和`CTRL+SHIFT+N`定位文件。

如何退出这个模式呢？很简单，使用`ALT+V`弹出view视图，然后选择`Exit Presentation Mode` 即可。但是我强烈建议你不要这么做，因为你是可以在`Enter Presentation Mode`模式下在`IDEA`里面做任何事情的。当然前提是，你对`IDEA`足够熟练。


# 神奇的Inject language



如果你使用`IDEA`在编写`JSON`字符串的时候，然后要一个一个`\`去转义双引号的话，就实在太不应该了，又烦又容易出错。在`IDEA`可以使用`Inject language`帮我们自动转义双引号。
![这里写图片描述](http://static.iocoder.cn/ffa2c04c0f315029fd19cfdfc98a750e)

先将焦点定位到双引号里面，使用`alt+enter`快捷键弹出`inject language`视图，并选中
`Inject language or reference`。
![这里写图片描述](http://static.iocoder.cn/374a7307539d061e1940bfba2e9d47a7)

选择后,切记，要直接按下`enter`回车键，才能弹出`inject language`列表。在列表中选择 `json`组件。
![这里写图片描述](http://static.iocoder.cn/ef214fb9918690fee1668d29b7fe723a)

选择完后。鼠标焦点自动会定位在双引号里面，这个时候你再次使用`alt+enter`就可以看到
![这里写图片描述](http://static.iocoder.cn/400631d0f2ee8ed5764a30877c8768f9)

选中`Edit JSON Fragment`并回车，就可以看到编辑`JSON`文件的视图了。
![这里写图片描述](http://static.iocoder.cn/de4de20d534adda249e9c37b394b32f2)

可以看到`IDEA`确实帮我们自动转义双引号了。如果要退出编辑`JSON`信息的视图，只需要使用`ctrl+F4`快捷键即可。

`Inject language`可以支持的语言和操作多到你难以想象，读者可以自行研究。



# 使用快捷键移动分割线



假设有下面的场景，某个类的名字在`project`视图里被挡住了某一部分。
![这里写图片描述](http://static.iocoder.cn/0f4cef93aa2e3754dc1b7f1b39b451a0)

你想完整的看到类的名字，该怎么做。一般都是使用鼠标来移动分割线，但是这样子效率太低了。可以使用`alt+1`把鼠标焦点定位到`project`视图里，然后直接使用`ctrl+shift+左右箭头`来移动分割线。



# ctrl+shift+enter不只是用来行尾加分号的



`ctrl+shift+enter`其实是表示`为您收尾`的意思，不只是用来给代码加分号的。比如说：
![这里写图片描述](http://static.iocoder.cn/cf39f276281e0b47738afb2848a46304)

这段代码，我们还需要为if语句加上大括号才能编译通过，这个时候你直接输入`ctrl+shift+enter`，`IDEA`会自动帮你收尾，加上大括号的。



# 不要动不动就使用IDEA的重构功能



`IDEA`的重构功能非常强大，但是也有时候，在单个类里面，如果只是想批量修改某个文本，大可不必使用到重构的功能。比如说：
![这里写图片描述](http://static.iocoder.cn/a553594f31da850e03d4fded219236b1)

上面的代码中，有5个地方用到了rabbitTemplate文本，如何批量修改呢？
首先是使用`ctrl+w`选中`rabbitTemplate`这个文本,然后依次使用5次`alt+j`快捷键，逐个选中，这样五个文本就都被选中并且高亮起来了，这个时候就可以直接批量修改了。
![这里写图片描述](http://static.iocoder.cn/76b15789e681e323eac958b9a7c0dd36)



# 去掉导航栏



去掉导航栏，因为平时用的不多。
![这里写图片描述](http://static.iocoder.cn/b0b3462b910fe536001171da7dee124b)

可以把红色的导航栏去掉，让`IDEA`显得更加干净整洁一些。使用`alt+v`，然后去掉`Navigation bar`即可。去掉这个导航栏后，如果你偶尔还是要用的，直接用`alt+home`就可以临时把导航栏显示出来。
![这里写图片描述](http://static.iocoder.cn/93a9a8369228a6f808bce6235a50cae5)

如果想让这个临时的导航栏消失的话，直接使用`esc`快捷键即可。



# 把鼠标定位到project视图里



当工程里的包和类非常多的时候，有时候我们想知道当前类在project视图里是处在哪个位置。
![这里写图片描述](http://static.iocoder.cn/bf3161f0b2bfe3b4719daa71313bedbe)

上面图中的`DemoIDEA`里，你如何知道它是在`spring-cloud-config`工程里的哪个位置呢？
可以先使用`alt+F1`，弹出`Select in`视图，然后选择`Project View`中的`Project`，回车，就可以立刻定位到类的位置了。

![这里写图片描述](http://static.iocoder.cn/4e1e69cc1faa98e53db20f435027821f)

那如何从`project`跳回代码里呢？可以直接使用`esc`退出`project`视图，或者直接使用`F4`,跳到代码里。



# 强大的symbol



如果你依稀记得某个方法名字几个字母，想在`IDEA`里面找出来，可以怎么做呢？
直接使用`ctrl+shift+alt+n`，使用`symbol`来查找即可。
比如说：
![这里写图片描述](http://static.iocoder.cn/2ed6fbd9399a4f17931f5dd3d70ad75c)

你想找到checkUser方法。直接输入`user`即可。
![这里写图片描述](http://static.iocoder.cn/3ea7804dc7acc8f2966ad7a4a3b3785f)

如果你记得某个业务类里面有某个方法，那也可以使用首字母找到类,然后加个`.`，再输入方法名字也是可以的。
![这里写图片描述](http://static.iocoder.cn/b9521b8807f55dfc01c7b6bfdc36dfcd)



# 如何找目录



使用`ctrl+shift+n`后，使用`/`，然后输入目录名字即可.
![这里写图片描述](http://static.iocoder.cn/cf520cd429c30e38253df87415a8c615)



# 自动生成not null判断语句



自动生成not null这种if判断，在`IDEA`里有很多种办法，其中一种办法你可能没想到。
![这里写图片描述](http://static.iocoder.cn/98183d050f07ff9a89ad5f7cd15cc453)

当我们使用rabbitTemplate. 后，直接输入`notnull`并回车，`IDEA`就好自动生成if判断了。
![这里写图片描述](http://static.iocoder.cn/db46edd1feff0ada0abd5fb8d0d223b5)



# 按照模板找内容



这个也是我非常喜欢的一个功能，可以根据模板来找到与模板匹配的代码块。比如说：

> 想在整个工程里面找到所有的try catch语句,但是catch语句里面没有做异常处理的。

catch语句里没有处理异常，是极其危险的。我们可以`IDEA`里面方便找到所有这样的代码。
![这里写图片描述](http://static.iocoder.cn/d8cd7218aa072f4f0a880a5e75d1ef84)

首先使用`ctrl+shift+A`快捷键弹出action框，然后输入`Search Struct`
![这里写图片描述](http://static.iocoder.cn/c96af0e586ff77f455da8e006a6e528d)

选择`Search Structurally`后，回车，跳转到模板视图。
![这里写图片描述](http://static.iocoder.cn/43e7e6b112815d7df5a87de2310251e9)

点击`Existing Templates`按钮，选择`try`模板。为了能找出catch里面没有处理异常的代码块，我们需要配置一下`CatchStatement`的`Maximum count`的值，将其设置为1。

点击`Edit Variables`按钮，在界面修改`Maximum count`的值。
![这里写图片描述](http://static.iocoder.cn/f1df0fe2bf77a1babfa799bc9420f152)

最后点击`find`按钮，就可以找出catch里面没有处理异常的代码了。
![这里写图片描述](http://static.iocoder.cn/9ead9ebbb6fa6a3a9c03fc5c8af1b80b)
