$(function() {
    var tableOption = {
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": false,
            "info": false,
            "autoWidth": false,
            "processing": true,
            "pageLength": 10,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                }
            },
            "fnDrawCallback": function(table) {
                    $("#" + table.sTableId + "_paginate").append("到第 <input type='text' id='" + table.sTableId + "-changePage" + "' class='input-text' style='width:50px;height:27px'>页<a class='btn btn-default shiny' href='javascript:void(0);' id='" + table.sTableId + "_dataTable-btn' style='text-align:center;border: unset;'>确认</a>");
                    //     if (window.resCountForAllPositions == 0) {
                    //         window.resCountForAllPositions = 1;
                    //         $('#strategy-positions-update').ReStable({
                    //             rowHeaders: false,
                    //             keepHtml: true,
                    //             maxWidth: 600
                    //         });
                    //     }
                    $('#' + table.sTableId + '_dataTable-btn').click(function(e) {
                                var pageTotal = Math.ceil(table.fnRecordsDisplay() / table._iDisplayLength);
                                var changePage = $("#" + table.sTableId + "-changePage").val();
                                var redirectpage = 0;
                                if (changePage && changePage > 0 && changePage <= pageTotal) {
                                    redirectpage = changePage - 1;
                                } else if (changePage > pageTotal) {
                                    redirectpage = pageTotal - 1;
                                }
                                $("#" + table.sTableId).dataTable().fnPageChange(redirectpage);
                                $("#" + table.sTableId + "_wrapper .tabletolist").remove();
                                if ($(window).width() <= parseInt(600, 10)) {
                                    $("#" + table.sTableId).ReStable({
                                                rowHeaders: false,
                        keepHtml: true,
                        maxWidth: 600
                    });
                }
            });
        },
        // "ajax": '../ajax/data/arrays.txt'
    }
    $(".subscribe-btn,#thank-author-btn").click(function() {
        alert("请登录后重试！")
    });
    $('#strategy-positions-update').DataTable(tableOption);
    $('#strategy-sell').DataTable(tableOption);
    $('#strategy-transactions').DataTable(tableOption);
});