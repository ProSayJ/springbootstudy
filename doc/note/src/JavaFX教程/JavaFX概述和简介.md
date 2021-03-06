# JavaFX概述和简介

[JavaFX中文文档](http://www.javafxchina.net/blog/docs)

富互联网应用是那些提供与Web应用程序类似的功能，并可作为桌面应用程序体验的应用。
与用户的正常网络应用程序相比，它们提供更好的视觉体验。这些应用程序可作为浏览器插件或作为虚拟机提供，用于将传统静态应用程序转换为更加增强，流畅，动画和引人入胜的应用程序。

与传统的桌面应用程序不同，RIA不需要任何额外的软件来运行。作为替代需要安装一些软件，如：ActiveX，Java，Flash，这取决于应用程序使用的组件。

在RIA中，图形表示在客户端处理，因为它有一个丰富的图形提供支持的插件。 简而言之，RIA中的数据操作在服务器端执行，而相关对象操纵在客户端端执行。

> **[info] 有三个主要技术可使用于开发RIA。**
- Adobe Flash
- Microsoft Silverlight
- JavaFX
  
## Adobe Flash
这个软件平台由Adobe Systems开发，用于创建富互联网应用程序。 除此之外，还可以构建其他应用程序，如矢量，动画，浏览器游戏，桌面应用程序，移动应用程序和游戏等。这是开发和执行RIA的最常用平台，桌面浏览器渗透率为96％。

## Microsoft Silverlight
像Adobe Flash一样，Microsoft Silverlight也是用于开发和执行富互联网应用程序的软件应用程序框架。最初，这个框架用于流媒体。当前版本还支持多媒体，图形和动画。
这个平台较少使用，用于桌面浏览器渗透率66％。

## JavaFX
JavaFX是一个Java库，可以使用它开发富互联网应用程序。通过使用Java技术，这些应用程序的浏览器渗透率为76％。

### JavaFX是什么？
JavaFX是用于构建富互联网应用程序的Java库。 使用此库编写的应用程序可以跨多个平台一致运行。使用JavaFX开发的应用程序可以在各种设备上运行，如台式计算机，手机，电视，平板电脑等。要使用Java编程语言开发GUI应用程序，程序员依赖于诸如高级窗口工具包(AWT)和Swings之类的库。在JavaFX出现之后，这些Java程序开发就可以有效地利用丰富的类库来开发GUI应用程序。

###需要JavaFX
要开发具有丰富特性的客户端应用程序，程序员过去依赖于各种库来添加诸如媒体，UI控件，Web，2D和3D等功能。JavaFX将所有这些功能包括在单个库中。除了这些，开发人员还可以访问Java库的现有功能，如：Swings。JavaFX提供了一组丰富的图形和媒体API，并通过硬件加速图形利用现代图形处理单元。JavaFX还提供了接口，开发人员可以使用它们组合图形动画和UI控件。可以使用JavaFX和基于JVM的技术，如Java，Groovy和JRuby。 如果开发人员选择JavaFX，没有必要学习额外的技术，因为任何上述技术的先前知识将足以开发使用JavaFX的RIA。

###JavaFX的特性
> **[info] 以下是JavaFX的一些重要功能。** 
- 使用Java语言编写：JavaFX库都是用Java编写的，可用于在JVM上执行的语言，包括Java，Groovy和JRuby。这些JavaFX应用程序也是平台无关的。

- FXML：JavaFX采用称为FXML的语言，这是一种类似声明式标记语言的HTML。这种语言的唯一目的是定义用户界面。

- Scene Builder：JavaFX提供了一个名为Scene Builder(场景生成器)的应用程序。 在将此应用程序集成到IDE(如Eclipse和NetBeans)中时，用户可以访问拖放设计界面，用于开发FXML应用程序(就像Swing Drag＆Drop和DreamWeaver应用程序一样)。

- Swing互操作性：在JavaFX应用程序中，可以使用Swing Node类嵌入Swing内容。 同样，可以使用JavaFX功能(如嵌入式Web内容和丰富的图形媒体)更新现有的Swing应用程序。

- 内置UI控件：JavaFX库UI控件使用它可以开发一个全功能的应用程序。

- 类似CSS的样式：JavaFX提供像样式的CSS。 通过使用它，可以使用CSS的简单知识改进应用程序的设计。

- 画布和打印API： JavaFX提供了Canvas，即时模式样式的渲染API。 在包javafx.scene.canvas中，它包含一组用于canvas的类，可以使用它们直接在JavaFX场景的一个区域内绘制。JavaFX还在javafx.print包中提供用于打印目的的类。

- 丰富的API集合：JavaFX库提供了一组丰富的API来开发GUI应用程序，2D和3D图形等。这套API还包括Java平台的功能。因此，使用此API，可以访问Java语言的功能，如通用，注释，多线程和Lambda表达式。传统的Java集合库已增强，包括可观察列表和映射等概念。使用这些，用户可以观察数据模型中的更改。

- 集成图形库：JavaFX为2d和3d图形提供类。

- 图形管道：JavaFX支持基于硬件加速图形管道(称为Prism)的图形。 当与支持的图形卡或GPU一起使用时，它提供平滑的图形。 如果系统不支持图形卡，则棱镜默认为软件渲染堆栈。
 

###JavaFX历史
JavaFX最初由Chris Oliver开发，当时他正在为一家名为See Beyond Technology Corporation的公司工作，在2005年，这个公司被Sun Microsystems收购了。
这个项目的更多信息，有以下几点 
- 最初，这个项目被命名为F3(表单跟随函数)，它的开发旨在为开发GUI应用程序提供更丰富的界面。
- Sun Microsystems于2005年6月收购了See Beyond公司，将F3项目改造为JavaFX。
- 在2007年，JavaFX正式在Java One会议上宣布，这是一个年度举行的世界网络会议。
- 在2008年，JavaFX与Net Beans集成。同年，JavaFX 1.0的Java标准开发工具包发布。
- 在2009年，Oracle公司收购了Sun Microsystems，并在同一年发布了下一个版本的JavaFX(1.2)。
- 在2010年，JavaFX 1.3开发完成并发布，并在2011年JavaFX 2.0发布。
- 最新版本JavaFX8，在2014年3月18日作为Java的一个组成部分一起发布。