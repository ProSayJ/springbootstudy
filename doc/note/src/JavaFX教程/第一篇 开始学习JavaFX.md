# 第一篇 开始学习JavaFX

# 第一部分 什么是JavaFX
## JavaFX概览
JavaFX是一个强大的图形和多媒体处理工具包集合，它允许开发者来设计、创建、测试、调试和部署富客户端程序，并且和Java一样跨平台。

- JavaFX应用程序
- 可用性
- 关键特性
- JavaFX可以构建什么
- 如何运行样例程序
- 如何在IDE中运行样例
- 如何创建JavaFX应用程序
- 资源

参考《理解JavaFX架构》章节可以了解更多关于JavaFX平台架构的信息，并且可以获得关于媒体流、Web展现和用户界面风格的JavaFXAPI的简要描述。

### JavaFX应用程序
由于JavaFX库被写成了Java API，因此JavaFX应用程序代码可以调用各种Java库中的API。例如JavaFX应用程序可以使用Java API库来访问本地系统功能并且连接到基于服务器中间件的应用程序。

JavaFX可以自定义程序外观。层级样式表（CSS）将外观和样式与业务逻辑实现进行了分离，因此开发人员可以专注于编码工作。图形设计师使用CSS来方便地定制程序的外观和样式。如果你具有Web设计背景，或者你希望分离用户界面（UI）和后端逻辑，那么你可以通过FXML脚本语言来表述图形界面并且使用Java代码来表述业务逻辑。如果你希望通过非编码的方式来设计UI，则可以使用JavaFX Scene Builder。在你进行UI设计时，Scene Builder会创建FXML标记，它可以与一个集成开发环境（IDE）对接，这样开发人员可以向其中添加业务逻辑。


### 可用性
JavaFXAPI已经完整地集成到了JRE和JDK之中。由于JDK在所有的主要桌面平台（Windows、Mac OS X和Linux）上都是可用的，使用JDK7及以后版本编译的JavaFX应用程序也可以在所有的主要桌面平台上运行。对ARM平台的支持已经在JavaFX8中可用了。支持ARM的JDK包括JavaFX的基础组件、图形组件和控件组件。

跨平台兼容性使得JavaFX应用的开发人员和用户都可以得到统一的运行时体验。Oracle确保在所有的平台上同步发布和更新，并且为运行关键性应用的公司提供了一个扩展支持程序。

在JDK下载页面中，你可以下到JavaFX样例代码的zip文件。样例应用程序提供了很多样例代码和代码片段来举例说明如何编写JavaFX应用程序。参考“如何运行样例程序”章节来获取更多信息。


### 关键特性
下面的特性都被包含在了JavaFX8及以后发布版本中。在JavaFX8中引入的内容包括：

- Java API：JavaFX是一个Java库，包括用Java写成的类和接口。其API对基于JVM的语言也是友好的，例如JRuby和Scala。

- FXML和Scene Builder：FXML是一种基于XML的声明式标记语言，用于描述JavaFX应用程序的用户界面。设计师可以在FXML中编码或者使用JavaFX Scene Builder来交互式地设计图形用户接口（GUI）。Scene Builder所生成的FXML标记可以与IDE对接，这样开发者可以添加业务逻辑。

- WebView：它是一个使用了WebKitHTML技术的Web组件，可用于在JavaFX应用程序中嵌入Web页面。在WebView中运行的JavaScript可以方便地调用JavaAPI，并且JavaAPI也可以调用WebView中的JavaScript。对附加的HTML5特性的支持，包括Web Socket、Web Worker、Web Font、打印功能等都被添加到了JavaFX8中。参考《增加HTML内容到JavaFX应用程序中（Adding HTML Content to JavaFX Applications）》章节来了解更多信息。

- 与Swing互操作：现有的Swing程序可以通过JavaFX的新特性升级，例如多媒体播放和Web 内容嵌入。在JavaFX8中加入了SwingNode类，它可以将Swing内容嵌入到JavaFX程序中。参考SwingNode API Javadoc和《在JavaFX应用程序中嵌入Swing 内容（Embedding Swing Content in JavaFX Applications）》章节来了解更多信息。

- 内置的UI控件和CSS：JavaFX提供了开发一个全功能应用程序所需的所有主要控件。这些组件可以使用标准的Web技术如CSS来进行装饰。在JavaFX8中，DatePicker和TreeView UI控件是可用的，并且可以使用标准的Web技术如CSS来进行美化。参考《使用JavaFX UI控件（Using JavaFX UI Controls）》章节来了解更多信息。另外CSS样式控制类都变成了公开API，它们可以使用CSS来为对象增加样式。

- Modena主题：在JavaFX8中，提供了新的Modena主题来替换原来的Caspian主题。不过在Application的start()方法中，可以通过加入setUserAgentStylesheet(STYLESHEET_CASPIAN)代码行来继续使用Caspian主题。在com的Modena blog中找到更多信息。

- 3D图像处理能力：在JavaFX8中的3D图像处理API中加入了一些新的API，包括Shape3D (Box, Cylinder, MeshView和Sphere 子类)，SubScene, Material, PickResult, LightBase (AmbientLight 和PointLight子类)，SceneAntialiasing等。在本次发布中Camera类API也得到了更新。要了解更多信息，可以参考《开始学习JavaFX 3D图形（Getting Started with JavaFX 3D Graphics）》文档和对应的JavaDoc，包括scene.shape.Shape3D，javafx.scene.SubScene，javafx.scene.paint.Material，javafx.scene.input.PickResult和javafx.scene.SceneAntialiasing。

- Canvas API：Canvas API允许在由一个图形元素（node）组成的JavaFX场景（Scene）的一个区域中直接绘图。

- Printing API：JavaFX 8中加入了print包并且提供了打印功能公共类。

- Rich Text支持:JavaFX提供了更为强大的文本支持能力，包括双向文字（例如阿拉伯语）、复杂文字脚本，例如Thai、Hindu文字，并且支持多行、多种风格的文本节点。

- 多点触摸：基于底层平台的功能JavaFX提供了对多点触摸的支持。

- Hi-DPI支持：JavaFX 8现在支持Hi-DPI显示。

- 图形渲染硬件加速：JavaFX图像均基于图形渲染流水线（Prism）。JavaFX提供更为平滑的图像并且在显卡或图像处理单元（Graphics processing unit，GPU）支持的情况下通过Prism来获得更快的渲染速度。如果GPU不支持对应的图形处理功能，则Prism会使用软件渲染方式来替代。

- 高性能多媒体引擎：媒体流水线支持对Web媒体内容的播放。它提供了一个基于GStreamer多媒体框架的稳定、低延迟的多媒体处理框架。

- 自包含的应用部署模型：自包含应用包具有应用所需的所有资源、包括一个Java和JavaFX运行时的私有拷贝。它们可作为操作系统原生安装包发布，并提供与原生应用相同的安装和运行体验。

### JavaFX可以构建什么

使用JavaFX你可以构建各种类型的应用程序。一般来说，它们是联网应用，可以跨平台部署，并且可以在一个具有高性能现代UI中展现信息，支持音频、视频、动画等特性。