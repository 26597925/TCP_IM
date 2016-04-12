CC=gcc
JAVA=javac

java:Main.java
	$(JAVA) Main.java

so:cn_edu_lzu_oss_tcp_im_lib_Encrypt.o encrypt.o md5.o
	$(CC) -shared -o so/libjencrypt.so cn_edu_lzu_oss_tcp_im_lib_Encrypt.o encrypt.o md5.o && rm -r *.o
cn_edu_lzu_oss_tcp_im_lib_Encrypt.o:./so/cn_edu_lzu_oss_tcp_im_lib_Encrypt.c ./so/cn_edu_lzu_oss_tcp_im_lib_Encrypt.h
	$(CC) -fPIC -c ./so/cn_edu_lzu_oss_tcp_im_lib_Encrypt.c -I$(JAVA_HOME)/include/ -I$(JAVA_HOME)/include/linux/
encrypt.o:../lib/encrypt.c ../lib/encrypt.h
	$(CC) -fPIC -c ../lib/encrypt.c
md5.o:../lib/md5.h ../lib/md5.c
	$(CC) -fPIC -c ../lib/md5.c

jar:cn/edu/lzu/oss/tcp_im/lib/Encrypt.java
	$(JAVA) ./cn/edu/lzu/oss/tcp_im/lib/Encrypt.java
	jar -cvf im.jar cn/edu/lzu/oss/tcp_im/lib/Encrypt.class

clean:
	rm -f ./so/libjencrypt.so ./cn/edu/lzu/oss/tcp_im/lib/Encrypt.class ./Main.class ./im.jar
