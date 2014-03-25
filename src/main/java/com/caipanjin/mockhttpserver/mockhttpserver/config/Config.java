/**
 *
 *     平安付
 * Copyright (c) 2013-2014 PingAnFu,Inc.All Rights Reserved.
 */
package com.caipanjin.mockhttpserver.mockhttpserver.config;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XNodeList;
import org.nuxeo.common.xmap.annotation.XObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Config
 * Author: 蔡盘进 (email:caipanjin125@pingan.com.cn)
 * Date: 14-3-20
 * Time: 下午10:41
 */
@XObject("Config")
public class Config {
    @XNode("@id")
    private String id;
    @XNode("@URI")
    private String reqUri;
    @XNode("@METHOD")
    private String method;
    @XNodeList(value = "Params", type = ArrayList.class, componentType = ReqParam.class)
    private List<ReqParam> reqParams;
    @XNode("Response")
    private String response;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReqUri() {
        return reqUri;
    }

    public void setReqUri(String reqUri) {
        this.reqUri = reqUri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<ReqParam> getReqParams() {
        return reqParams;
    }

    public void setReqParams(List<ReqParam> reqParams) {
        this.reqParams = reqParams;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @XObject
    static class ReqParam {
        @XNode("@name")
        private String name;
        @XNode("@value")
        private String value;

        ReqParam() {
        }

        ReqParam(String name, String value) {
            this.name = name;
            this.value = value;
        }

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
