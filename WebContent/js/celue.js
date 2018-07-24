$(function() {
    $("#strategySubmit").click(function() {
        alert("提交成功！等待审核……可在“个人中心--我的策略”处查看详细情况！");
    });
    $(".classify").click(function(e) {
        var menuStr = $(e.target).attr("id");
        var menuId = "#" + menuStr;
        var menuClass = "." + menuStr;
        $(".classify").find("p").removeClass("active");
        $(menuId).addClass("active");

        $(".strategy").find(".strategy_item").addClass("hidden");
        $(menuClass).removeClass("hidden");
    });
    $(".orderAcc").click(function(e) {
        var menuStr = $(e.target).attr("id");
        var menuId = "#" + menuStr;
        var menuClass = "." + menuStr;
        $(".orderAcc").find("p").removeClass("active");
        $(menuId).addClass("active");
    });
    $(".orderRul").click(function(e) {
        var menuStr = $(e.target).attr("id");
        var menuId = "#" + menuStr;
        var menuClass = "." + menuStr;
        $(".orderRul").find("p").removeClass("active");
        $(menuId).addClass("active");
    });

    $("#all").click(function() {
        $(".strategy_item").removeClass("hidden");

    });
    // $(".tulipDialog-model,#login-wrap").first().addClass("hidden");
    //      $("#menu").css("margin-right", "42px");
    //      $("#userCenter").removeClass("hidden");

})
