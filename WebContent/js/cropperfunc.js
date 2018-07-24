var initCropperInModal = function(img, input, modal) {
    var $image = img;
    var $inputImage = input;
    var $modal = modal;
    var options = {
        // aspectRatio: 1, // 纵横比
        viewMode: 2,
        preview: '.img-preview' // 预览图的class名
    };
    // 模态框隐藏后需要保存的数据对象
    var saveData = {};
    var URL = window.URL || window.webkitURL;
    var blobURL;
    $modal.on('show.bs.modal', function() {
        // 如果打开模态框时没有选择文件就点击“打开图片”按钮
        if (!$inputImage.val()) {
            $inputImage.click();
        }
    }).on('shown.bs.modal', function() {
        // 重新创建
        $image.cropper($.extend(options, {
            ready: function() {
                // 当剪切界面就绪后，恢复数据
                if (saveData.canvasData) {
                    $image.cropper('setCanvasData', saveData.canvasData);
                    $image.cropper('setCropBoxData', saveData.cropBoxData);
                }
            }
        }));
    }).on('hidden.bs.modal', function() {
        // 保存相关数据
        saveData.cropBoxData = $image.cropper('getCropBoxData');
        saveData.canvasData = $image.cropper('getCanvasData');
        // 销毁并将图片保存在img标签
        $image.cropper('destroy').attr('src', blobURL);
    });
    if (URL) {
        $inputImage.change(function() {
            var files = this.files;
            var file;
            if (!$image.data('cropper')) {
                return;
            }
            if (files && files.length) {
                file = files[0];
                if (/^image\/\w+$/.test(file.type)) {

                    if (blobURL) {
                        URL.revokeObjectURL(blobURL);
                    }
                    blobURL = URL.createObjectURL(file);

                    // 重置cropper，将图像替换
                    $image.cropper('reset').cropper('replace', blobURL);

                    // 选择文件后，显示和隐藏相关内容
                    $('.img-container').removeClass('hidden');
                    $('.img-preview-box').removeClass('hidden');
                    $('#changeModal .disabled').removeAttr('disabled').removeClass('disabled');
                    $('#changeModal .tip-info').addClass('hidden');

                } else {
                    window.alert('请选择一个图像文件！');
                }
            }
        });
    } else {
        $inputImage.prop('disabled', true).addClass('disabled');
    }
}

var sendPhoto = function() {
    var uPortrait = $('#photo').cropper('getCroppedCanvas', {
        width: 300,
        height: 300
    })
    uPortrait.toBlob(function(blob) {
        // 转化为blob后更改src属性，隐藏模态框
        $('#user-photo').attr('src', URL.createObjectURL(blob));
        $('#changeModal').modal('hide');
    });
}
var sendPhotoCam = function() {
    var imgData = document.getElementById("canvas").toDataURL("image/png"); //base64图片数据
    $('#photoInput1').attr('src', imgData);
    $('#camera').modal('hide');
    $('#user-photo').attr('src', imgData);

    var arr = dataurl.split(','),
        mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]),
        n = bstr.length,
        u8arr = new Uint8Array(n);
    while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
    }
    var obj = new Blob([u8arr], { type: mime });
    var fd = new FormData();
    fd.append("upfile", obj, "image.png");
    $.ajax({
        url: "/file/upfile",
        type: "POST",
        processData: false,
        contentType: false,
        data: fd,
        success: function(data) {
            console.log(data);
        }
    });
}
$(function() {
    initCropperInModal($('#photo'), $('#photoInput'), $('#changeModal'));
    initCropperInModal($('#photo'), $('#photoInput1'), $('#camera'));
});