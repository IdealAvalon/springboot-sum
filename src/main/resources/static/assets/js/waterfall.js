$(function(){
    //获取界面节点
    var li = $("#waterfall_ul").find("li")
    // 得到标签集合的长度
    var page = 1;
    var bool = false;
    //调用接口获取数据
    loadPage();//首次加载
    /**
     * 加载页面的函数
     */
    function loadPage(){
        $.ajax({
            type: "get",
            url: '/pictures',
            data: {"page":page},
            cache: false,
            async : false,
            dataType: "json",
            success: function (data){
            // 将数据写入到div中
            for(var i = 0; i < data.length; i++) {
                var index = getShort(li);//查找最短的li
                //创建新的节点：div>img+p
                var div = document.createElement('div');
                var img = document.createElement('img');
                img.src = data[i].pictureSrc;//img获取图片地址
                // img.src = 'http://120.78.161.117:8888/group1/M00/00/00/rBL6CFs7K5KAPHXvAABHCC7xdws519.jpg';//img获取图片地址
                img.alt = "Loading..."
                //根据宽高比计算img的高，为了防止未加载时高度太低影响最短Li的判断
                img.style.height = data[i].offsetHeight * (230 / data[i].width) + "px";
                div.appendChild(img);
                var p = document.createElement('p');
                p.innerHTML = data[i].describe;//p获取图片标题
                div.appendChild(p);
                //加入到最短的li中
                li[index].appendChild(div);
            }
            bool = true;//加载完成设置开关，用于后面判断是否加载下一页
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }

    window.onscroll = function (){
        var index = getShort(li);
        var minLi = li[index];
        var scrollTop = document.documentElement.scrollTop||document.body.scrollTop;

        if(minLi.offsetHeight+minLi.offsetTop<scrollTop+document.documentElement.clientHeight){
            //开关为开，即上一页加载完成，才能开始加载
            if(bool){
                bool = false;
                page++;
                loadPage();
            }
        }
    }

})
/**
 * 获取数组中高度最小的索引
 * @param {Object} li 数组
 */
function getShort(li) {
    var index = 0;
    var liHeight = li[index].offsetHeight;
    for(var i = 0; i < li.length; i++) {
        if(li[i].offsetHeight < liHeight) {
            index = i;
            liHeight = li[i].offsetHeight;
        }
    }
    return index;
}