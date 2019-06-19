/**
 * FileName: OmsCompanyAddressServiceImpl
 * Author:   knight xiong
 * 收货地址实现类
 * Date:     2019/6/14 13:56
 * History:
 */
package xin.yuan.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.mbg.mapper.OmsCompanyAddressMapper;
import xin.yuan.mall.mbg.model.OmsCompanyAddress;
import xin.yuan.mall.mbg.model.OmsCompanyAddressExample;
import xin.yuan.mall.service.OmsCompanyAddressService;

import java.util.List;
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper omsCompanyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        OmsCompanyAddressExample omsCompanyAddressExample = new OmsCompanyAddressExample();
        return omsCompanyAddressMapper.selectByExample(omsCompanyAddressExample);

    }
}
