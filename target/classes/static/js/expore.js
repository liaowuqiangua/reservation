$(document).ready(function(){
  $("#search").click(function(){
    var s= $("#searchText").val();
    console.log(s);
    jsonToDom('','asd','http://47.93.190.20:9999/group1/M00/00/00/rBA9b1wD6NOAfTT8ABMstAbtciU570.png',s,'');
  });
  var $container = $('.masonry-container');
  $container.imagesLoaded( function () {
  $container.masonry({
        columnWidth: '.item',
        itemSelector:'.item',
        isAnimated: true
        });
  });
});
function jsonToDom(storeID,storeName,pic,description,label){
//    var parentdiv=$('<div class="col-md-4 col-sm-6"><div class="card"><img class="card-img-top" style="margin: 0 auto;height:180px ;width:318px" src="'+pic+'" alt="Card image cap"><div class="card-body"><h4 class="card-title">'+storeName+'</h4><p class="card-text">'+label+'</p><a href="#" class="btn btn-primary">'+description+'</a></div></div></div><div class="clearfix visible-xs-block"></div>');
    var parentdiv=$('          <div class="col-md-4 col-sm-6 item"><div class="thumbnail"><img src="http://lorempixel.com/200/200/abstract" alt=""><div class="caption"><h3>Thumbnail label</h3><p>'+description+'</p><p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p></div></div></div>');
    $("#goods").append(parentdiv);
}

var creatediv= function(){
    var parentdiv=$('<div></div>');        //创建一个父div
    parentdiv.attr('id','parent');        //给父div设置id
    parentdiv.addclass('parentdiv');    //添加css样式

    var childdiv=$('<div></div>');        //创建一个子div
    childdiv.attr('id','child');            //给子div设置id
    childdiv.addclass('childdiv');    //添加css样式
    childdiv.appendto(parentdiv);        //将子div添加到父div中

    parentdiv.appendto('body');            //将父div添加到body中
}