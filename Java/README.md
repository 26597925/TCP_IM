# TCP_IM_JAVA

Author:**hopeful**  
Create Date:2016-04-11

# Description

This is the Java branch of the TCP_IM, the main target is create a .so library which use JNI to make sure a Java program can call the function in TCP_IM protocol.

There is a test Java Program used to debug the library.

# Command

## make
* make java program  
	`make` or `make java` will help you create a java program which is used to test the program.Make sure your jdk was right.
* make .so library  
	`make so` will help you create a .so library in ./so dir.
* make .jar library
	`make jar` will help you create the im.jar in ./ dir.
* clean  
	`make clean` will help you clear all files created by `make xxx` command

## run
* run java program  
	* make java program first.  
	* use `java Main` to run the program.  


not ending
