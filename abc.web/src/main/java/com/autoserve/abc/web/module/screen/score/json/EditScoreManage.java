package com.autoserve.abc.web.module.screen.score.json;

import com.alibaba.citrus.turbine.dataresolver.Params;
import com.autoserve.abc.dao.dataobject.OperateLogDO;
import com.autoserve.abc.dao.dataobject.ScoreConfigDO;
import com.autoserve.abc.service.biz.intf.score.ScoreConfigService;
import com.autoserve.abc.service.biz.intf.sys.OperateLogService;
import com.autoserve.abc.service.biz.result.BaseResult;
import com.autoserve.abc.web.helper.LoginUserUtil;
import com.autoserve.abc.web.util.IPUtil;
import com.autoserve.abc.web.util.ResultMapper;
import com.autoserve.abc.web.vo.JsonBaseVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author RJQ 2014/12/16 20:55.
 */
public class EditScoreManage {
    @Resource
    private ScoreConfigService scoreConfigService;

    @Resource
    private OperateLogService operateLogService;

    @Resource
    private HttpServletRequest request;


    public JsonBaseVO execute(@Params ScoreConfigDO scoreConfigDO) {
        BaseResult baseResult = scoreConfigService.modifyScoreConfig(scoreConfigDO);
        JsonBaseVO vo = ResultMapper.toBaseVO(baseResult);
        vo.setMessage("修改成功！");

        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setOlEmpId(LoginUserUtil.getEmpId());//操作人ID
        operateLogDO.setOlIp(IPUtil.getUserIpAddr(request));//操作人IP地址
        operateLogDO.setOlModule("积分管理");//操作模块
        operateLogDO.setOlOperateType("修改");//操作类型：添加/修改/删除
        operateLogDO.setOlContent("修改了ID为" + scoreConfigDO.getScId() + "的积分兑现配置");//具体操作内容
        operateLogService.createOperateLog(operateLogDO);

        return vo;
    }
}
