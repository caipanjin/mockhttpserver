/**
 *
 *     平安付
 * Copyright (c) 2013-2014 PingAnFu,Inc.All Rights Reserved.
 */
package com.pinganfu.mockhttpserver.config;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XNodeList;
import org.nuxeo.common.xmap.annotation.XObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.pinganfu.mockhttpserver.config.Config
 * Author: 蔡盘进 (email:caipanjin125@pingan.com.cn)
 * Date: 14-3-20
 * Time: 下午10:41
 */
@XObject("Config")
public class Config {
    @XNode("@URI")
    private String reqUri;
    @XNode("@METHOD")
    private String method;
    @XNodeList(value = "Params", type = ArrayList.class, componentType = ReqParam.class)
    private List<ReqParam> reqParams;
    private String response;


    @XObject
    static class ReqParam {
        @XNode("@name")
        private String name;
        @XNode("@value")
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
