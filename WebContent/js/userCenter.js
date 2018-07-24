function getCookie(cookie_name) {
    var results = document.cookie.match('(^|;) ?' + cookie_name + '=([^;]*)(;|$)');
    if (results)
        return (unescape(results[2]));
    else
        return null;
}

function changePage(menuStr) {
    var menuId = "#" + menuStr;
    var menuClass = "." + menuStr;
    $(".user_body_left").find(".user_menu_item").removeClass("active");
    $(menuId).addClass("active");
    $(".profile").find(".profile").addClass("hidden");
    $(menuClass).removeClass("hidden");
}

function updateMainPage() {
    $('.btn_edit').before("Apiao");
    $('#user-photo').attr("src", uPortrait);
    $('.item a').eq(0).text(uStrategy.length);
    $('.item a').eq(1).text(uFavorite.length);
    $('.item a').eq(2).text(uSubscribe.length);
    $('.item a').eq(3).text(uTransaction.length);
}

function updateWallet(){
    // updateTransaction();
    var money = data.user.uMoney
    $(".balance").text(money);
    if (money > 0){
        $(".wallet-head-kiting p".addClass("hidden"));
    }else{
        $(".wallet-head-kiting p".removeClass("hidden"));   
    }

}

function updateStrIntroduce(){
	var data = JSON.parse(localStorage.data)
	localStorage.clear()
    $('.celue_item1 .title_p').text(data.strategy[0].title);
    $('.celue_item1 .trade').text(data.strategy[0].classify.classfyName1);
    $('.celue_item1 .backtest').text(data.strategy[0].classify.classfyName2);
    $('.celue_item1 .user_box').attr("src",data.strategy[0].portrait);
    $('.celue_item1 .user_box span').text(data.strategy[0].auther);
    $('.celue_item1 .celue_item_tile img').attr("src",data.strategy[0].img);
    $('.celue_item1 .items .profitYear').text(data.strategy[0].profitYear);
    $('.celue_item1 .items .withdraw').text(data.strategy[0].withdraw);
    $('.celue_item1 .items .money').text(data.strategy[0].money);
    $('.celue_item1 items_last .limit').text(data.strategy[0].limit);
    $('.celue_item1 items_last .getCode').text(data.strategy[0].price);
    
    $('.celue_item2 .title_p').text(data.strategy[1].title);
    $('.celue_item2 .trade').text(data.strategy[1].classify.classfyName1);
    $('.celue_item2 .backtest').text(data.strategy[1].classify.classfyName2);
    $('.celue_item2 .user_box').attr("src",data.strategy[1].portrait);
    $('.celue_item2 .user_box span').text(data.strategy[1].auther);
    $('.celue_item2 .celue_item_tile img').attr("src",data.strategy[1].img);
    $('.celue_item2 .items .profitYear').text(data.strategy[1].profitYear);
    $('.celue_item2 .items .withdraw').text(data.strategy[1].withdraw);
    $('.celue_item2 .items .money').text(data.strategy[1].money);
    $('.celue_item2 items_last .limit').text(data.strategy[1].limit);
    $('.celue_item2 items_last .getCode').text(data.strategy[1].price);
}


function updateSettingPage(){
    $("#accountForm input").eq(0).value(data.user.uPhone);
    $("#accountForm input").eq(1).value(data.user.uName);
    $("#accountForm input").eq(2).value(data.user.uSign);
}

function ajaxSetting(){
    $("#btnAccountSubmit").click(function(){
        $.ajax({
            type:"post",
            url:"",
            dataType:"json",
            data:{
                "user":[{
                    "uName": $('#accountForm input').eq(1).value(),
                    "uSign": $('#accountForm input').eq(2).value(),
                    "uPhone": uPhone,
                }]
            }
        })
    });

    $("#changePsw").click(function(){
        $.ajax({
            type:"post",
            url:"",
            dataType:"json",
            data:{
                "user":[{
                    "uOldPassword": $('#accountForm input').eq(0).value(),
                    "uNewPassword": $('#accountForm input').eq(2).value(),
                    "uPhone": uPhone,
                }]
            }
        })
    });

}

function updateTransaction(){
    // var trans1 = "<tr><td>" + data.user.uSubscribe.[0].bDate;
    // var trans2 = "<tr><td>2018.1.18</td><td>订阅策略</td><td>500</td><td>成功</td></tr>"
    // for(var i = 0;i<data.user.uSubscribe.length;i++){
    //     var trans = "<tr><td>" + data.user.uSubscribe.[i].bDate;
    //     $(".transaction tbody").append(trans);
    // }
    $.each(data.user.uTransaction,function(i,n){
        var trans = "<tr><td>" + n.bDate+"</td><td>"+n.sName+ "<a href="+ n.sUrl+ "</a></td><td>"+n.sPay+"</td><td>"+n.bTime+"</td></tbody>";
        $(".transaction tbody").append(trans);
    })
}

// function updateMainPage(){

// }

$(function() {
            var uName = getCookie("uName");
            var uPhone = getCookie("uPhone");

            // $.ajax({
            //     type: "get",
            //     url: "",
            //     dataType: "json",
            //     data: {
            //         "user": [{
            //             "uPhone": uPhone,
            //             "uName": uName,

            //         }]
            //     },
            //     success: function(data) {
            //         if (data.success) {
            //             var uPortrait = data.user.uPortrait;
            //             updateMainPage();

                            // updateTransaction();

            //             // var customerPhone = data.user.uPhone;
            //             // window.location.href = 'http://localhost/index.html'; //正确登录后页面跳转至 
            //         } else {
            //             alert("用户名或密码错误！");
            //             // if (tel != data.tel) { //判断是用户名还是密码错误，提示相应信息 
            //             //     alert(data.message);
            //             //     $tel.val("");
            //             //     $pwd.val("");
            //             //     return false;
            //             // }
            //             // if (pwd != data.pwd) {
            //             //     alert(data.message);
            //             //     $pwd.val("");
            //             //     return false;
            //             // }
            //         }
            //     },
            //     error: function() {
            //         alert("异常！");
            //     }
            // });

         $(".tulipDialog-model,#login-wrap").first().addClass("hidden");
         $("#menu").css("margin-right", "42px");
         $("#userCenter").removeClass("hidden");
            $(".user_menu_item").click(function(e) {
                    var menuStr = $(e.target).attr("id");
                    changePage(menuStr);
                }); 
             $(".IntroStrategy").click(function(e) {
                    // var menuStr = $(e.target).attr("id");
                    updateStrIntroduce();
                });                

            })

$().ready(function(event) {
    $("#PwdForm").validate({
        rules: {
            oldPsd: {
                required: true,
                minlength: 6,
                maxlength: 18
            },
            newPsd: {
                required: true,
                minlength: 6,
                maxlength: 18
            },
            confirmPsd: {
                required: true,
                equalTo: "[name='newPsd']",
                minlength: 6,
                maxlength: 18
            }
        },
        messages: {
            oldPsd: {
                required: "请输入密码",
                minlength: "密码至少6位",
                maxlength: "密码至多18位"
            },
            newPsd: {
                required: "请输入密码",
                minlength: "密码至少6位",
                maxlength: "密码至多18位"
            },
            confirmPsd: {
                required: "请输入密码",
                equalTo: "*请再次输入相同的值",
                minlength: "密码至少6位",
                maxlength: "密码至多18位"
            },
        },
        // success: function(label) {
        //     $(".btn-confirm").removeAttr("disabled");

        // }

    });

})