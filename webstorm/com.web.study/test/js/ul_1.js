/**
 * 自动生成商品列表
 * 当触发事件时，当前展示的商品列表隐藏，js生成一个列表，并显示
 */
// var list1 = document.getElementsByClassName("list1")[0];
// var list2 = document.getElementsByClassName("list2")[0];
var childL1 = document.querySelector(".sixth .child2");
var childL2 = document.querySelector(".eighth .child2");

function fn1(element) {
    element.style.visibility = "visible";
}

var a1 = document.querySelectorAll(".sixth .child2 .item1 a");
var length1 = a1.length;
for (var j=0; j<length1; j++) {
    a1[j].addEventListener("click", function() {
            var list1 = document.querySelector(".sixth .child2 .list1");
            // 隐藏当前列表商品
            list1.style.visibility = "hidden";
            // 创建 ul 和 li 和 div 元素
            var ul = document.createElement("ul");
            ul.classList.add("list1");
            // 双层循环添加 li 和 div 从外到内添加元素
            childL1.appendChild(ul);
            for (var i = 0; i < 6; i++) {
                var li = document.createElement("li");
                ul.appendChild(li);
                for (var j = 0; j < 3; j++) {
                    var div = document.createElement("div");
                    li.appendChild(div);
                }
            }
            // 获取每个 li 元素下的第一个 div 元素，图片div
            var first_div_li = document.querySelectorAll(".list1 li div:nth-child(1)");
            // 获取每个 li 元素下的第二个 div 元素，标题div
            var second_div_li = document.querySelectorAll(".list1 li div:nth-child(2)");
            // 获取每个 li 元素下的第三个 div 元素，价格div
            var third_div_li = document.querySelectorAll(".list1 li div:nth-child(3)");
            var length = first_div_li.length;
            // 循环添加图片
            for (var k=0; k < length; k++) {
                var img = document.createElement("img");
                // 给 img 元素添加 src 属性
                img.src = "../img/pic_" + k+1 + ".jpg";
                img.alt = "图片无法加载";
                first_div_li[k].appendChild(img);
            }
            // 循环添加标题
            for (var m=0; m<length; m++) {
                second_div_li[m].innerHTML = "??????";
            }
            // 循环添加价格
            for (var n=0; n<length; n++) {
                third_div_li[n].innerHTML = "￥0.00";
            }
        }
    )
}



var a2 = document.querySelectorAll(".eighth .child2 .item1 a")
var length2 = a2.length;
/**
 * 为list2添加新的商品
 *
 *
 */
for (var i=0; i<length2; i++) {
    a2[1].addEventListener("click",function () {
        var list2 = document.querySelector(".eighth .child2 .list2");
        list2.style.visibility = "hidden";
        var ul = document.createElement("ul");
        ul.classList.add("list2");
        var img = document.createElement("img");
        // 双层循环添加 li 和 div
        childL2.appendChild(ul);
        for (var i=0; i<6; i++) {
            var li = document.createElement("li");
            ul.appendChild(li);
            for (var j=0; j<3; j++) {
                var div = document.createElement("div");
                li.appendChild(div);
            }
        }
        // 获取每个 li 元素下的第一个 div 元素，图片div
        var first_div_li = document.querySelectorAll(".list2 li div:nth-child(1)");
        // 获取每个 li 元素下的第二个 div 元素，标题div
        var second_div_li = document.querySelectorAll(".list2 li div:nth-child(2)");
        // 获取每个 li 元素下的第三个 div 元素，价格div
        var third_div_li = document.querySelectorAll(".list2 li div:nth-child(3)");
        var length = first_div_li.length;
        // 循环添加图片s
        for (var k=0; k < length; k++) {
            var img = document.createElement("img");
            // 给 img 元素添加 src 属性
            img.src = "../img/bg" + k + ".jpg";
            img.alt = "图片无法加载";
            first_div_li[k].appendChild(img);
        }
        // 循环添加标题
        for (var m=0; m<length; m++) {
            second_div_li[m].innerHTML = "??????";
        }
        // 循环添加价格
        for (var n=0; n<length; n++) {
            third_div_li[n].innerHTML = "￥0.00";
        }
    })
}


