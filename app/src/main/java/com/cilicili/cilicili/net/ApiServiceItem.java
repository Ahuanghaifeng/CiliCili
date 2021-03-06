package com.cilicili.cilicili.net;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangyu on 2017/4/18.
 */

public class ApiServiceItem {

    public static final int DEV = 1;
    public static final int LINE = 2;
    private static volatile ApiServiceItem mInstance;
    /**
     * 当前环境 key, url 数据容器
     */
    private Map<String, String> mDomainMap = new ConcurrentHashMap<>();

    /**
     * 当前默认环境
     */
    public int currentType = LINE;
    private int mPlatform;

    public static ApiServiceItem getInstance() {
        if (null == mInstance) {
            mInstance = new ApiServiceItem();
        }
        return mInstance;
    }

    public void init() {
        init(currentType);
    }

    public void init(int type) {
        currentType = type;
        initData(currentType);
        //初使化网络请求
        BaseApiHelper.getInstance().initHostList(mDomainMap);
    }

    private void initData(int type) {
        switch (type) {
            case DEV: {
                /** 开发 **/
                setDomain(getTestDomainBean());
            }
            break;
            case LINE:
                setDomain(getDevDomainBean());
                break;
        }
    }

    private DomainBean getDevDomainBean() {
        DomainBean devDomainBean = new DomainBean();
        devDomainBean.setPay("https://promotersapi.91y.com/");
        return devDomainBean;
    }

    /**
     * 获取测试服务器
     *
     * @return
     */
    private DomainBean getTestDomainBean() {
        DomainBean devDomainBean = new DomainBean();
        devDomainBean.setPay("https://testpromotersapi.91y.com/");
        return devDomainBean;
    }

    private void setDomain(DomainBean domainBean) {
        mDomainMap.put(ApiServiceBean.PAY_DOMAIN_KEY, domainBean.getPay());  //支付
    }
}
