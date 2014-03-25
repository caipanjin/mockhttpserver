/**
 *
 *     平安付
 * Copyright (c) 2013-2014 PingAnFu,Inc.All Rights Reserved.
 */
package com.caipanjin.mockhttpserver.mockhttpserver.config;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 * ConfigManager
 * Author: 蔡盘进 (email:caipanjin125@pingan.com.cn)
 * Date: 14-3-25
 * Time: 上午11:43
 */
public class ConfigManager {
    private static Map<String, Config> configMap = Maps.newConcurrentMap();
    static{
        Config config = new Config();
        config.setReqUri("/risk-rcfs/query/queryCustRate.htm");
        config.setId("test");
        config.setMethod("POST");
        config.setResponse("{\"totalFailureAmt\":\"0\",\"transType\":\"01\",\"_retCode\":\"000000\",\"customerId\":\"9999999\",\"_errMsg\":\"请求成功\",\"totalSuccessCnt\":\"0\",\"totalSuccessAmt\":\"0\",\"_sysRet\":\"OK\",\"totalAmt\":\"0\",\"totalCnt\":\"0\",\"totalFailureCnt\":\"0\",\"regionType\":\"PASS_BY_10MINS\"}");
        addConfig(config);
    }

    public static void addConfig(Config config){
        Preconditions.checkNotNull(config);
        configMap.put(config.getReqUri(), config);
    }

    public static void removeConfig(String id){
        Preconditions.checkNotNull(id);
        Set<Config> configSet = Sets.newHashSet(configMap.values());
        for(Config config : configSet){
            if(config.getId().equals(id)){
                configMap.remove(config);
            }
        }

    }

    public static void removeConfig(Config config){
        Preconditions.checkNotNull(config);
        configMap.remove(config.getReqUri());
    }

    public static Config getConfig(String reqUri, Map<String,String> matchParams){
        //TODO:add params match logic
        return configMap.get(reqUri);
    }
}
