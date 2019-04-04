package com.autoserve.abc.web.module.screen.review;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.autoserve.abc.service.biz.entity.Loan;
import com.autoserve.abc.service.biz.enums.BidType;
import com.autoserve.abc.service.biz.enums.FileUploadClassType;
import com.autoserve.abc.service.biz.enums.FileUploadSecondaryClass;
import com.autoserve.abc.service.biz.intf.loan.LoanQueryService;
import com.autoserve.abc.service.biz.result.PlainResult;

import javax.annotation.Resource;

/**
 * @author yuqing.zheng Created on 2015-01-15,23:36
 */
public class LoanFullCheckView {
    @Resource
    private LoanQueryService loanQueryService;

    public void execute(Context context, @Param("loanId") Integer loanId) {
        context.put("loanId", loanId);
        context.put("bidId", loanId);
        context.put("bidType", BidType.COMMON_LOAN.getType());

        PlainResult<Loan> result = loanQueryService.queryById(loanId);
        if (!result.isSuccess()) {
            return;
        }
        context.put("fileUploadClassType", FileUploadClassType.LOAN.getType());
        context.put("fileUploadSecondaryClass", FileUploadSecondaryClass.IMAGE_DATA.getType());
        context.put("dataId", result.getData().getLoanFileUrl());

    }
}
