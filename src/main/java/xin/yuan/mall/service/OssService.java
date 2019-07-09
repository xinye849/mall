package xin.yuan.mall.service;

import xin.yuan.mall.dto.OssCallbackResult;
import xin.yuan.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

public interface OssService {
    OssPolicyResult policy();

    OssCallbackResult callBack(HttpServletRequest request);
}
