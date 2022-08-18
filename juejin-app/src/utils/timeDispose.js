// 时间戳转为距今多久
let timeInterval = function(dateTime){
    // 如果为null,则格式化当前时间
    if (!dateTime) dateTime = Number(new Date());
    // 如果dateTime长度为10或者13，则为秒和毫秒的时间戳，如果超过13位，则为其他的时间格式
    if (dateTime.toString().length == 10) dateTime *= 1000;
    let timestamp = +new Date(Number(dateTime));

    let timer = (Number(new Date()) - timestamp) / 1000;
    // 如果小于5分钟,则返回"刚刚",其他以此类推
    let tips = '';
    switch (true) {
        case timer < 300:
            tips = '刚刚';
            break;
        case timer >= 300 && timer < 3600:
            tips = parseInt(timer / 60) + '分钟前';
            break;
        case timer >= 3600 && timer < 86400:
            tips = parseInt(timer / 3600) + '小时前';
            break;
        case timer >= 86400 && timer < 2592000:
            tips = parseInt(timer / 86400) + '天前';
            break;
        default:
            if (timer >= 2592000 && timer < 365 * 86400) {
                tips = parseInt(timer / (86400 * 30)) + '个月前';
            } else {
                tips = parseInt(timer / (86400 * 365)) + '年前';
            }
    }
    return tips; 
}

// 显示上午好 下午好 晚上好
let newTime = function(){
    let date = new Date();
    // let h = date.getHours();
    let h =20
    if(h < 12 && h>=6){
        return '上午好'
    }else if(h < 18 && h>=12){
        return '下午好'
    }else{
        return '晚上好'
    }
}

// 格式化文章时间
let setArticleTiem = function(time){
    let date = new Date(time);
    let Y = date.getFullYear();
    let M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1);
    let D = date.getDate();
    let h = date.getHours() + ':';
    let m = date.getMinutes();
    return `${Y}年${M}月${D}日 ${h}${m}`;
}

module.exports = {
    timeInterval,
    setArticleTiem,
    newTime
}