package com.recyclerviewtest.http;

/**
 * 项目名称：RecyclerviewTest
 * 类描述：
 * 创建人：handongyu
 * 包名：com.recyclerviewtest.http
 * 创建时间：16/3/16 下午9:57
 * 修改备注：
 */
public class HttpResult {

    /**
     * 返回码
     */
    public String code="";
    /** 原始数据 */
    public String dataStr;
    /** 错误提示 */
    public String msg = null;
    /**
     * 具体Bean对象
     */
    public Object bean;

    /**
     * @return true 成功/存在错误
     */
    public boolean isSuccess() {
        if (code.equals("200")){
            return true;
        }else{
            return false;
        }
    }


}
