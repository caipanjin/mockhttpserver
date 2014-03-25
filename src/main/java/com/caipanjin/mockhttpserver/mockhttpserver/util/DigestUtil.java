/**
 *
 *	平安付
 * Copyright (c) 2013-2014 PingAnFu,Inc.All Rights Reserved.
 */
package com.caipanjin.mockhttpserver.mockhttpserver.util;



/**
 * DigestUtil
 * Author: 蔡盘进 (email:caipanjin125@pingan.com.cn)
 * Date: 2014/3/25
 * Time: 14:29
 */
public class DigestUtil {

    public static void digestServiceIn(String digestInfo, long elapseTime, boolean success){
       System.err.println(digestInfo + ";"+ elapseTime +"ms;" + (success?"Y":"N"));//TODO
    }
}
