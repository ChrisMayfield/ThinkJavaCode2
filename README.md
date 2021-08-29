[![Think Java, 2nd Edition](https://greenteapress.com/wp/wp-content/uploads/2020/06/think_java_covr_large-229x300.png)](https://greenteapress.com/wp/think-java-2e/)

# ThinkJavaCode2

Supporting code for Think Java, 2nd edition.  
Copyright (c) 2020 Allen B. Downey and Chris Mayfield.  
This edition was published in December 2019 by [O'Reilly Media](https://www.oreilly.com/library/view/think-java-2nd/9781492072492/) (ISBN 9781492072508).

## Source Code

This repository contains the code examples from the book and starter code for some exercises. Below are several ways you can work with the code.

### Using Git (Recommended)

Using Git to work with the repository is a great way to get into the habit of using Git, which is used by software developers around the globe. Here's how you can use Git to use the source code:

- You can create a copy of this repository on GitHub by clicking the "Fork" button.
  - If you don't already have a GitHub account, you'll need to create one.
  - After forking, you'll have your own repository on GitHub that you can use to keep track of code you write.
  - Then you can "clone" the repository, which downloads a copy of the files to your computer.

- Alternatively, you could clone the original repository without forking.
  - If you choose this option, you don't need a GitHub account, but you won't be able to save your changes on GitHub.

### Download as ZIP

If you don't want to use Git at all, you can download the code in a ZIP archive using the "Clone or download" button, or this link: [https://thinkjava.org/code2zip](https://thinkjava.org/code2zip).

## Cloning the Repository

To clone a repository, you need Git installed on your computer (see [https://help.github.com/](https://help.github.com/)).  
If you use Git from the command line, you can clone the original repository like this:

```cmd
git clone https://github.com/ChrisMayfield/ThinkJavaCode2.git
```

## Working with the Code

After you clone the repository or unzip the ZIP file, you should have a directory named `ThinkJavaCode2` with a subdirectory for each chapter in the book.

A few notes about the source code regarding what Java version you should use:

- The examples in this book were developed and tested using OpenJDK 11.
- If you are using a more recent version, everything should still work.
- If you are using an older version, some examples might not work, or may have unexpected consequences.

There are a few ways you can work with the code:

### jGRASP

[jGRASP](https://www.jgrasp.org/) is an IDE used by beginners who are just getting started with Java. It isn't as sophisticated as Eclipse or IntelliJ IDEA, but it has enough features to begin learning Java without feeling too overwhelmed.

- To open the source code in jGRASP, simply open jGRASP in the `ThinkJavaCode2` folder, or navigate to that folder in jGRASP's sidebar explorer. From there, you should be able to open the different `.java` files within the repository. You do not need to worry about the `.checkstyle`, `.classpath`, `.project`, or `*.iml` files.

### Eclipse

[Eclipse](https://www.eclipse.org/) is another IDE used by beginners and professionals alike, and is more feature-rich than jGRASP.

- To open the source code in Eclipse, change your workspace to the `ThinkJavaCode2` folder. Eclipse should automatically detect the different chapter folders as projects and should add them accordingly. You do not need to worry about the `*.iml`
- If you want to use CheckStyle with these projects, feel free to install the official [Eclipse Checkstyle Plugin](https://checkstyle.org/eclipse-cs/#!/) and then use the `Checkstyle.xml` file in the root folder as the configuration file.

### IntelliJ IDEA

[IntelliJ IDEA](https://www.jetbrains.com/idea/) is an IDE mainly used by professionals or ambitious beginners. It's not recommended for beginners to use this IDE due to how convoluted the user interface can be, but it is a great tool down the line for Java development.

- To open the source code in IntelliJ IDEA, open the `ThinkJavaCode2` folder as a project, as it has already been pre-configured as a project. It should automatically use your installation of JDK 11. Each of the chapter folders have been labeled as modules, so you can work with the code in each one as if they were a different project, similar to an Eclipse workspace. You do not need to worry about the `.checkstyle`, `.classpath`, or `.project` files in each folder, and they are ignored by IntelliJ's build path.
- If you want to use CheckStyle with these projects, feel free to install the [CheckStyle-IDEA](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea) plugin into your project (Settings -> Plugins). The settings for this project have already been pre-configured and should be recognized automatically when you restart your IDE to enable the plugin.

### Visual Studio Code

[Visual Studio Code](https://code.visualstudio.com/) is an IDE which supports a wide variety of languages, including Java, and is used by many developers of any skill level. It's not made primarily with Java in mind, but you can install the [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack), which includes plugins by Red Hat and Microsoft, to work with Java projects in this IDE.

- Coming soon...
