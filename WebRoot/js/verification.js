$.extend($.fn.validatebox.defaults.rules, {
    //验证手机号
    phoneNum: {
        validator: function(value){
            return /^1[3-8]+\d{9}$/.test(value);
        },
        message: '请输入正确的手机号码.'
    },
    //既验证手机号，又验证座机号
    telNum:{
        validator: function(value){
            return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^(()|(\d{3}\-))?(1[358]\d{9})$)/.test(value);
        },
        message: '请输入正确的电话号码.'
    },
    //验证邮编
    codeNum:{
        validator:function (value) {
            return /^[1-9]\d{5}$/i.test(value);
        },
        message:"邮编必须长短0开端的6位数字."
    },
    //验证传真
    faxNum:{
        validator : function(value) {
            return /^((\d2,3\d2,3)|(\d{3}\-))?(0\d2,30\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message : '传真号码不正确'
    },
    //验证银行账号
    bank_account:{
        validator:function(value,param) {
            return check_bank_account(value);
        },
        message:'请输入正确的银行卡号'
    },


    // filebox验证文件大小的规则函数
    // 如：validType : ['fileSize[1,"MB"]']
    fileSize : {
        validator : function(value, array) {
            var size = array[0];
            var unit = array[1];
            //var unit = "MB";
            if (!size || isNaN(size) || size == 0) {
                $.error('验证文件大小的值不能为 "' + size + '"');
            } else if (!unit) {
                $.error('请指定验证文件大小的单位');
            }
            var index = -1;
            var unitArr = new Array("bytes", "kb", "mb", "gb", "tb", "pb", "eb", "zb", "yb");
            for (var i = 0; i < unitArr.length; i++) {
                if (unitArr[i] == unit.toLowerCase()) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                $.error('请指定正确的验证文件大小的单位：["bytes", "kb", "mb", "gb", "tb", "pb", "eb", "zb", "yb"]');
            }
            // 转换为bytes公式
            var formula = 1;
            while (index > 0) {
                formula = formula * 1024;
                index--;
            }
            // this为页面上能看到文件名称的文本框，而非真实的file
            // $(this).next()是file元素
            return $(this).next().get(0).files[0].size < parseFloat(size) * formula;
        },
        message : '文件大小必须小于 {0}{1}'
    }

});



/**
 * 验证银行卡号
 * @param bankno 要验证的银行卡号
 * @returns
 */
function check_bank_account(bankno){
    var isChecked = false;
    var n = /^[10|18|30|35|37|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58|60|62|65|68|69|84|87|88|94|95|98|99]{0,2}\d{14,17}$/.test(bankno);
    if (n) {
        var lastNum=bankno.substr(bankno.length-1,1);//取出最后一位（与luhm进行比较）
        var first15Num=bankno.substr(0,bankno.length-1);//前15或18位
        var newArr=new Array();
        for(var i = first15Num.length-1;i>-1;i--){//前15或18位倒序存进数组
            newArr.push(first15Num.substr(i,1));
        }
        var arrJiShu=new Array(); //奇数位*2的积 <9
        var arrJiShu2=new Array(); //奇数位*2的积 >9
        var arrOuShu=new Array(); //偶数位数组
        for(var j=0;j<newArr.length;j++){
            if((j+1) % 2 == 1){//奇数位
                if (parseInt(newArr[j])*2<9) {
                    arrJiShu.push(parseInt(newArr[j])*2);
                } else {
                    arrJiShu2.push(parseInt(newArr[j])*2);
                }
            }else{//偶数位
                arrOuShu.push(newArr[j]);
            }
        }
        var jishu_child1=new Array();//奇数位*2 >9 的分割之后的数组个位数
        var jishu_child2=new Array();//奇数位*2 >9 的分割之后的数组十位数
        for(var h=0;h<arrJiShu2.length;h++){
            jishu_child1.push(parseInt(arrJiShu2[h])%10);
            jishu_child2.push(parseInt(arrJiShu2[h])/10);
        }
        var sumJiShu=0; //奇数位*2 < 9 的数组之和
        var sumOuShu=0; //偶数位数组之和
        var sumJiShuChild1=0; //奇数位*2 >9 的分割之后的数组个位数之和
        var sumJiShuChild2=0; //奇数位*2 >9 的分割之后的数组十位数之和
        var sumTotal=0;
        for(var m=0;m<arrJiShu.length;m++){
            sumJiShu=sumJiShu+parseInt(arrJiShu[m]);
        }
        for(var n=0;n<arrOuShu.length;n++){
            sumOuShu=sumOuShu+parseInt(arrOuShu[n]);
        }
        for(var p=0;p<jishu_child1.length;p++){
            sumJiShuChild1=sumJiShuChild1+parseInt(jishu_child1[p]);
            sumJiShuChild2=sumJiShuChild2+parseInt(jishu_child2[p]);
        }
        //计算总和
        sumTotal=parseInt(sumJiShu)+parseInt(sumOuShu)+parseInt(sumJiShuChild1)+parseInt(sumJiShuChild2);
        //计算Luhm值
        var k= parseInt(sumTotal)%10==0?10:parseInt(sumTotal)%10;
        var luhm= 10-k;
        if (lastNum == luhm) {
            isChecked = true;
        } else {
            isChecked = false;
        }
    } else {
        isChecked = false;
    }
    return isChecked;
}