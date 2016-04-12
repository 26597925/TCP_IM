/**
* File Name:Encrypt.java
* CopyRright (c)2016:
* File Index:01
* Author:hopeful
* Create Date:2016-04-11
* Description:
	* Created to call a .so library and realize the encrpyt and decrypt interface
* Version:1.0
*/
package cn.edu.lzu.oss.tcp_im.lib;

/**
* Class Name:Encrypt
* JDK version used:java 1.8.0_71
* Author:hopeful
* Create Date:2016-04-11
* Version:1.0
*/
public class Encrypt {

	static {
		//String path = System.getProperty("user.dir");
		//if(!path.endsWith("/")) path += "/";
		System.loadLibrary("jencrypt");
	}

	private String rand;

	private int[] key;

	private static native String mkrand();

	private static native int[] mkpvtkey(String rand,String pwd);

	private static native int encrypt(String data,int[] key);

	private static native int decrypt(String data,int[] key);

	/**
	* Description:This Constructor use a password given by user and then make
	* a random 20 bytes String `rand`.Then the `rand` and `password` will be
	* used to make a private key.
	*
	* @param password the password which is set by user.
	*/
	public Encrypt(String password) {
		rand = mkrand();
		System.out.println("java print rand = "+rand);
		key = mkpvtkey(rand,password);
		System.out.println("java debug");
	}

	/**
	* Description:Encrypt the data with the key which was created in constructor
	* function and change the plaintext to ciphertext.
	*
	* @param data the plaintext wait to encrypt and will be change to 
	* ciphertext after encrypt.
	* @see tempEncrypt
	*/
	public void encrypt(String data) {
		encrypt(data,key);
	}

	/**
	* Description:Decrypt the data with the key which was created in constructor
        * function and change the ciphertext to plaintext.
	*
	* @param data the ciphertext wait to decrypt and will be change to
	* plaintext after decrypt.
	*/
	public void decrypt(String data) {
		decrypt(data,key);
	}

	/**
	* Description:Get the `rand` which was created in constructor function.And
	* it will be needed when client send a data packet to server.
	*
	* @return the `rand` which was created in constructor function.
	*/
	public String getRand() {
		return rand;
	}
	
	/**
	* Description:Temporarily encrypt data with the temporary key which
	* is given by server.
	*
	* @param data the plaintext wait to encrypt and will be change to 
        * ciphertext after encrypt.
	* @param tkey the temorary key which is given by server.
	* @see encrypt
	*/
	public static void tempEncrypt(String data,int[] tkey) {
		encrypt(data,tkey);
	}
}
