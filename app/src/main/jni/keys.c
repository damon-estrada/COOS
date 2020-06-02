//
// Created by Damon L. Estrada on 6/1/2020.
// references along side of the other files in this director at:
// https://medium.com/programming-lite/securing-api-keys-in-android-app-using-ndk-native-development-kit-7aaa6c0176be
//

#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_shishirstudio_ndktest_MainActivity_getFacebookApiKey(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "TmF0aXZlNWVjcmV0UEBzc3cwcmQx");
}
JNIEXPORT jstring JNICALL
Java_com_shishirstudio_ndktest_MainActivity_getBaseApi(JNIEnv *env, jobject instance) {
 return (*env)->NewStringUTF(env, "TmF0aXZlNWVjcmV0UEBzc3cwcmQy");
}
