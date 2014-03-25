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
        config.setId("queryCustRate");
        config.setMethod("POST");
        config.setResponse("{\"totalFailureAmt\":\"0\",\"transType\":\"01\",\"_retCode\":\"000000\",\"customerId\":\"9999999\",\"_errMsg\":\"请求成功\",\"totalSuccessCnt\":\"0\",\"totalSuccessAmt\":\"0\",\"_sysRet\":\"OK\",\"totalAmt\":\"0\",\"totalCnt\":\"0\",\"totalFailureCnt\":\"0\",\"regionType\":\"PASS_BY_10MINS\"}");
        addConfig(config);

        Config config2 = new Config();
        config2.setReqUri("/risk-rcfs/query/queryCustCnt.htm");
        config2.setId("queryCustCnt");
        config2.setMethod("POST");
        config2.setResponse("{maxSuccessCnt=0, maxCnt=0, successCnt=null, totalCnt=null}");
        addConfig(config2);

        Config config3 = new Config();
        config3.setReqUri("/risk-rcfs/query/queryCustCnt.htm");
        config3.setId("queryCustAmt");
        config3.setMethod("POST");
        config3.setResponse("{successAmt_C=null, totalAmt_C=null, minAmt_C=0, maxSuccessAmt_C=0, minSuccessAmt_C=0, maxAmt_C=0}");
        addConfig(config3);
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
