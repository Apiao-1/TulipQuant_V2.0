$(function() {
    $("#changeResButt").click(function() {
        alert("提交成功，感谢您的反馈！");
    });
    $("#changeCamera").click(function() {
        window.location.href = "camera.html";
    });

    $("#uploadImg").click(function() {
        progressBar();
        $("#loading1").removeClass("hidden");
        $.ajaxFileUpload({
            url: '/Tulip-Quant/file/upload',
            type: 'POST',
            secureuri: false, //是否启用安全提交，默认为false  
            fileElementId: 'photoInput', //文件选择框的id属性  
            dataType: 'json', //服务器返回的格式  
            async: false,
            success: function(data) {
                $("#loading1").addClass("hidden");
                $("#photoResult").removeClass("hidden");
                changePhotoResult(data);
                $("#loading2").removeClass("hidden");
                changeStockResult(data);
            }
        })
    });
    $("#uploadImgCam").click(function() {
        progressBar();
        $("#loading1").removeClass("hidden");
        $.ajaxFileUpload({
            url: '/Tulip-Quant/file/upload',
            type: 'POST',
            secureuri: false, //是否启用安全提交，默认为false  
            fileElementId: 'canvas', //文件选择框的id属性  
            dataType: 'json', //服务器返回的格式  
            async: false,
            success: function(data) {
                //              alert(data.company)
                //              console.log(data.company)
                //              console.log(data.photoResult[0])
                // console.log(data);
                // alert("成功");
                $("#loading1").addClass("hidden");
                $("#photoResult").removeClass("hidden");
                changePhotoResult(data);
                $("#loading2").removeClass("hidden");
                changeStockResult(data);
            }
        })
    });
    
})


function changePhotoResult(data) {
    var i = 0;
    while (data.photoResult[i]) {
        var item = data.photoResult[i]
        var text = "<tr><td>" + item.result + "</td><td>" + item.ratio + "</td></tr>"
        $("#photoResult").append(text);
        i++;
    }
}

function changeStockResult(data) {
    var text1 = "<p>上市公司：" + data.company + "</p>";
    var text2 = "<p>股票代码：" + data.code + "</p>";
    var text3 = "<p>主营业务：" + data.major + "</p>"
    $("#StockResult").prepend(text1, text2, text3);
}

function progressBar() {
    $('h3').text('图像识别中，请稍等...');
    var percentage = 0;
    var interval = setInterval(function() {
        if (percentage < 10000) {
            percentage = percentage + 1;
            var widthTemp = (percentage / 100).toFixed(1) + '%';
            $('#progressBar').css('width', widthTemp);
            $('#progressBar').text(widthTemp);
        } else {
            clearInterval(interval);
            $('h3').text('加载完成！正为您传输结果...');
            setTimeout(function() {
                // location = 'helloWorld.html';
                $('h3').text('识别成功!');
                $("#loading2").addClass("hidden");
                $("#StockResult").removeClass("hidden");
                $("#modalTrigger").removeClass("hidden");
            }, 1500);
        }
    }, 10);
}