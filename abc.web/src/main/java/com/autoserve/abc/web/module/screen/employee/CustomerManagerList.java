package com.autoserve.abc.web.module.screen.employee;

import com.alibaba.citrus.service.requestcontext.parser.ParameterParser;
import com.alibaba.citrus.turbine.Context;

/**
 * @author RJQ 2014/12/11 15:05.
 */
public class CustomerManagerList {
    public void execute(Context context, ParameterParser params) {
        String duty = params.getString("duty");
        context.put("duty", duty);
    }
}