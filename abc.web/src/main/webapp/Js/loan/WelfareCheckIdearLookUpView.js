﻿var MyAction = {
    Init: function () {
        $("#IdearGrid").datagrid({
            method: "GET",
            url: "/Demo/Json/P2PWelfareCheckIdearLookUpView.json",
            height: 370,
            pageSize: 10,
            fitColumns: true,
            rownumbers: true,
            nowrap: false,
            striped: true,
            remoteSort: true,
            view: myview,//重写当没有数据时
            emptyMsg: '没有找到数据',//返回数据字符
            columns: [[
            { field: "loan_no", title: "项目名称", width: 150, align: "center" },
            { field: "loan_name", title: "基金名称", width: 150, align: "center" },
            { field: "loan_emp", title: "联系人", width: 150, align: "center" },
            { field: "loan_phone", title: "联系电话", width: 150, align: "center" },
            { field: "recharge_money", title: "充值金额", width: 150, align: "center" },
            { field: "recharge_date", title: "充值日期", width: 150, align: "center" },
            { field: "check_date", title: "审核状态", width: 150, align: "center" },
            { field: "check_emp", title: "审核人", width: 150, align: "center" },
            { field: "check_state", title: "审核日期", width: 150, align: "center" },
            { field: "check_idear", title: "审核意见", width: 150, align: "center" }
            ]],
            pagination: true,
            singleSelect: true
        })
        var p = $('#IdearGrid').datagrid('getPager');
        $(p).pagination({
            pageSize: 10,
            pageList: [5, 10, 15, 20, 30, 50, 100],
            beforePageText: '第',
            afterPageText: '页    共 {pages} 页',
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
            onBeforeRefresh: function () {
                $(this).pagination('loading');
                $(this).pagination('loaded');
            }
        });
    }
}

MyAction.Init();


