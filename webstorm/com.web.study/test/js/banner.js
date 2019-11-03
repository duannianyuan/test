// 获取图片列表
var imageList = document.querySelector(".fourth .item2");
// 获取切换icon
var left = document.querySelector(".banner_onclick #left");
var right = document.querySelector(".banner_onclick #right");
/**
 * 上播放
 */
left.addEventListener("click", function() {
    // 相对当前元素的第一张banner
    var first = imageList.firstElementChild;
    var last = imageList.lastElementChild;
    imageList.appendChild(first, last);
})

/**
 * 下播放
 */
right.addEventListener("click", function() {
    // 当前列表的第一个元素
    var first = imageList.firstElementChild;
    // 当前列表的最后一个元素
    var last = imageList.lastElementChild;
    // 当前元素的上一个元素
    var prev = last.previousElementSibling;
    // 先交换当前元素和上一个元素
    // imageList.insertBefore(last, prev);
    // 同时将当前元素放到第一个元素之前
    imageList.insertBefore(last, first);
})





