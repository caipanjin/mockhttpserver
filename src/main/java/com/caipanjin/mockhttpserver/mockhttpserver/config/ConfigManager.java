/**
 *
 *     平安付
 * Copyright (c) 2013-2014 PingAnFu,Inc.All Rights Reserved.
 */
package com.caipanjin.mockhttpserver.mockhttpserver.config;

import com.google.common.base.Preconditions;
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

    public static Config getConfig(String reqUri){
        return configMap.get(reqUri);
    }
}
