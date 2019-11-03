// 获取点击事件
var btns = document.querySelectorAll(".banner_onclick .box .btn");
var btn = document.querySelector(".banner_onclick .box");
// console.log(btns);
// console.log(btn);
var length = btns.length;
console.log(length);
/**
 * 当我点击一个btn时，会跳转对应牵连的图片，即将该btn牵连的图片放在最后即可
 */
for (var i=0; i<length; i++) {
    btns[i].addEventListener("click", function () {
        // 同时将最后一个与第一个兄弟元素交换位置
        alert("我是MT");


    })
}

// 自动切换btn
setInterval(function () {
    // 当前列表的第一个元素
    var first = btn.firstElementChild;
// 当前列表的最后一个元素
    var last = btn.lastElementChild;
// 当前元素的上一个元素
    var prev = last.previousElementSibling;
    btn.insertBefore(last, prev);
    btn.insertBefore(last, first);
}, 1500);


