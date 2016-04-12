#include "cn_edu_lzu_oss_tcp_im_lib_Encrypt.h"
#include "../../lib/im.h"

JNIEXPORT jstring JNICALL Java_cn_edu_lzu_oss_tcp_1im_lib_Encrypt_mkrand
  (JNIEnv *env, jclass cls) {
	char rand[20]={'a','b','c'};
	mkrand(rand);
	printf("c print rand = %s\n",rand);
	const char *crand = rand;
	return (*env)->NewStringUTF(env,crand);
}

JNIEXPORT jintArray JNICALL Java_cn_edu_lzu_oss_tcp_1im_lib_Encrypt_mkpvtkey
  (JNIEnv *env, jclass cls, jstring rand, jstring pwd) {
	jintArray result = (*env)->NewIntArray(env,4);
	uint32_t key[4]={1,2,3,4};
	int i;
        printf("c print key = %08x%08x%08x%08x\n",key[0],key[1],key[2],key[3]);
	const char *crand = (*env)->GetStringUTFChars(env,rand,NULL);
	const char *cpwd = (*env)->GetStringUTFChars(env,pwd,NULL);
	printf("c print crand = %s\n",crand);
	printf("c print cpwd = %s\n",cpwd);
	mkpvtkey(crand,cpwd,key);
	(*env)->SetIntArrayRegion(env,result,0,4,key);
	printf("c print key[%d]\n",(*env)->GetArrayLength(env,result));
	printf("c print key = %08x%08x%08x%08x\n",key[0],key[1],key[2],key[3]);
	(*env)->ReleaseStringUTFChars(env,rand,crand);
	(*env)->ReleaseStringUTFChars(env,pwd,cpwd);
	printf("c debug\n");
	return result;
}

JNIEXPORT jint JNICALL Java_cn_edu_lzu_oss_tcp_1im_lib_Encrypt_encrypt
  (JNIEnv *env, jclass cls, jstring data, jintArray key) {

}

JNIEXPORT jint JNICALL Java_cn_edu_lzu_oss_tcp_1im_lib_Encrypt_decrypt
  (JNIEnv *env, jclass cls, jstring data, jintArray key) {

}
