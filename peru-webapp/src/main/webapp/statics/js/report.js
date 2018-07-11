$(function(){

    $.ajax({
        type: "GET",
        url:  "/facebook/accounts",
        success: function(data) {
            if(data.success) {
                for (var i = 0; i < data.data.length; i++) {
                    $("#facebook-accounts").append($("<option></option>")
                        .attr("value",data.data[i].facebookId)
                        .text(data.data[i].facebookId));

                }
            }
        } ,
        error: function(jqXHR, textStatus, errorThrown){
            var msg = JSON.stringify(jqXHR);
            alert(msg);
        }
    });

});

function report(){

    var params = {
        facebook_id:$('#facebook-accounts').val(),
        start_date:$('#start-date').val(),
        start_hour:$('select[name=start-hour]').val(),
        end_date:$('#end-date').val(),
        end_hour:$('select[name=end-hour]').val()
    };

    $('#ad_records').bootstrapTable('destroy');
    $('#ad_records').bootstrapTable({
        // url: '../../js/static/specialManagement/specialManagement.json', // 请求后台的URL（*）
        url: '/query/daily', // 请求后台的URL（*）
        method: 'get', // 请求方式（*）
        //toolbar: '#toolbar', // 工具按钮用哪个容器
        striped: true, // 是否显示行间隔色
        cache: false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: false, // 是否显示分页（*）
        //sortable: false, // 是否启用排序
        //sortOrder: "asc", // 排序方式
        queryParams: params, // 传递参数（*）
        //sidePagination: "server", // 分页方式：client客户端分页，server服务端分页（*）
        //pageNumber: 1, // 初始化加载第一页，默认第一页
        //pageSize: 10, // 每页的记录行数（*）
        //pageList: [10, 25, 50, 100], // 可供选择的每页的行数（*）
        //			height : 456,
        uniqueId: "id", // 每一行的唯一标识，一般为主键列
        search: false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: false, // 是否显示所有的列
        showRefresh: false, // 是否显示刷新按钮
        minimumCountColumns: 2, // 最少允许的列数
        clickToSelect: false, // 设置true 将在点击行时，自动选择rediobox 和 checkbox
        showToggle: false, // 是否显示详细视图和列表视图的切换按钮
        cardView: false, // 是否显示详细视图
        detailView: false, // 是否显示父子表、
        //paginationLoop: true,
        //maintainSelected: true,
        //responseHandler: function(res) { // res 为后台return的值
        //    $.each(res.rows, function(i, row) {
        //        row.state = $.inArray(row.userUuid, selections) !== -1;
        //    });
        //    return res;
        //},
        columns: [{
            field: 'facebookId',
            title: 'Facebook Account'
        }, {
            field: 'adsetId',
            title: 'Adset'
        },{
            field: 'date',
            title: 'Date'
        }, {
            field: 'gmv',
            title: 'GMV'
        }, {
            field: 'spend',
            title: 'Spend'
        }, {
            field: 'budget',
            title: 'Budget'
        }, {
            field: 'impressions',
            title: 'Impressions'
        }, {
            field: 'frequency',
            title: 'Frequency'
        }, {
            field: 'reachs',
            title: 'Reaches'
        }, {
            field: 'clicks',
            title: 'Clicks'
        }, {
            field: 'purchases',
            title: 'Purchases'
        }, {
            field: 'cost_general',
            title: 'Cost_General'
        }, {
            field: 'cost_purchasing',
            title: 'Cost_Purchasing'
        }]
    });

}