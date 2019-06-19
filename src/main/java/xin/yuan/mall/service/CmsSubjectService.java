package xin.yuan.mall.service;

import xin.yuan.mall.mbg.model.CmsSubject;

import java.util.List;

public interface CmsSubjectService {
    List<CmsSubject> listAll();

    List<CmsSubject> list(String keyWord, Integer pageNum, Integer pageSize);
}
