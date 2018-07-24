var chart = echarts.init(document.getElementById('main'));

var option = {
    tooltip: {},
    series: [{
        type: 'wordCloud',
        gridSize: 20,
        sizeRange: [15, 60],
        // rotationRange: [-90, 90],
        rotationRange: [0, 0],
        // shape: 'pentagon',
        // width: 600,
        // height: 400,
        drawOutOfBound: true,
        textStyle: {
            normal: {
                color: function() {
                    return 'rgb(' + [
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160)
                    ].join(',') + ')';
                }
            },
            emphasis: {
                shadowBlur: 10,
                shadowColor: '#333'
            }
        },
        data: [{
                name: '美的集团',
                value: 10000,
                textStyle: {
                    normal: {
                        color: 'black'
                    },
                    emphasis: {
                        color: 'red'
                    }
                }
            },
            {
                name: '中国平安',
                value: 6181
            },
            {
                name: '紫光国芯',
                value: 4386
            },
            {
                name: '工商银行',
                value: 4055
            },
            {
                name: '赣锋锂业',
                value: 2467
            },
            {
                name: '韶钢松山',
                value: 2244
            },
            {
                name: '万科A',
                value: 1898
            },
            {
                name: '中通国脉',
                value: 1484
            },
            {
                name: '国盛金控',
                value: 1112
            },
            {
                name: '四维图新',
                value: 965
            },
            {
                name: '士兰微',
                value: 947
            },
            {
                name: '中国联通',
                value: 582
            },
            {
                name: '农业银行',
                value: 555
            },
            {
                name: '中兴通讯',
                value: 550
            },
            {
                name: '万华化学',
                value: 462
            },
            {
                name: '方大炭素',
                value: 366
            },
            {
                name: '美的集团',
                value: 360
            },
            {
                name: '华新水泥',
                value: 282
            },
            {
                name: '天润乳业',
                value: 273
            },
            {
                name: '深深房',
                value: 271
            },
            {
                name: '爱尔眼科',
                value: 263
            },
            {
                name: '青岛海尔',
                value: 258
            },
            {
                name: '北方华创',
                value: 255
            }
        ]
    }]
};

chart.setOption(option);

// window.onresize = chart.resize;