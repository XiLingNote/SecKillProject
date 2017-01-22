//存放主要的交互逻辑
//javascript 模块化
var  seckill={
    //封装ajax的url
    URL:{
        now :function () {
            return '/seckill/time/now';
        },
        esposer:function (seckillId) {
            return '/seckill/'+seckillId+'/exposer';
        },
        execution:function (seckillId,md5) {
            return '/seckill/'+seckillId+'/'+md5+'/execution';
        }
    },
    handleSeckillkill:function (seckillId,node) {
        node.hide()
            .html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        $.post(seckill.URL.esposer(seckillId),{},function (result) {
            //回掉函数
                if (result&&result['success']){
                    var exposer=result['data'];
                if (exposer&&exposer['exposed']){
                    //
                    var md5=exposer['md5'];
                    var killUrl=seckill.URL.execution(seckillId,md5);
                    $("#killBtn").one('click',function () {
                        //绑定执行
                        //先禁用按钮
                        $(this).addClass('disabled');
                        //发送请求
                        $.post(killUrl,{},function (result) {
                            if(result&&result['data']) {
                                var killResult = result['data'];
                                var stateInfo = killResult['stateInfo'];
                                var state = killResult['state'];
                                //显示秒杀结果
                                node.html('<span class="label label-success">' + stateInfo + '</span>')
                            }
                        });
                    });
                    node.show();
                }else {
                    //秒杀未开始
                    var now=exposer['now'];
                    var start=exposer['start'];
                    var end=exposer['end'];
                    //重新计算
                    seckill.conudown(seckillId,now,start,end);
                }
            }else {
                console.log('result:'+result);
            }
        });
    }
    ,
    //验证手机号
    validatePhone:function (phone) {
      if (phone&&phone.length>3&&!isNaN(phone)){
          return true;
      }else{
          return false;
      }
    },
    conudown:function (seckillId,nowTime,startTime,endTime) {
            var seckillBox=$('#seckill-box');
        if(nowTime>endTime){
            seckillBox.html('秒杀结束!');
        }else if (nowTime<startTime){
            //秒杀未开始
            var killTime= new Date(startTime+1000);
            seckillBox.countdown(killTime,function (event) {
                var format=event.strftime('秒杀计时:%D天 %H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown',function () {
                seckill.handleSeckillkill(seckillId,seckillBox);
            });
        }else{
                //秒杀开始
            seckill.handleSeckillkill(seckillId,seckillBox);
        }
    },
    //详情页秒杀逻辑
    detail:{
        init: function (params) {
            //用户手机验证和登录，计时操作
            //规划交互流程
            //在cookie中查找手机号
            var killPhone=$.cookie('killPhone');
            var startTime=params['startTime'];
            var endTime=params['endTime'];
            var seckillId=params['seckillId'];
            //验证登陆操作
            if(!seckill.validatePhone(killPhone)){
                //绑定手机号
                //控制输出
                var killPhoneModal =$("#killPhoneModel");
                killPhoneModal.modal({
                show:true,//显示弹// 出层
                backdrop:'static',
                keyboart:false
            });
                $("#killlPhoneBtn").click(function () {
                   var inputPhone=$('#killPhoneKey').val();

                    if (seckill.validatePhone(inputPhone)){
                       //写入cookie
                        $.cookie('killPhone',inputPhone,{express:7,patch:'/seckill'});
                        //刷新页面
                        window.location.reload();
                    }else{
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300);
                    }
                });
            }
            //登陆成功计时交互
            $.get(seckill.URL.now(),{},function (result) {
              if (result&&result['success']){
                    var nowTime=result['error'];
                    //判断时间
                  seckill.conudown(seckillId,nowTime,startTime,endTime);
              } else {
                  console.log('result:'+result);
              }
            })
        }
    }
}