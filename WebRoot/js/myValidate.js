/*检测零件是否重复*/
$.extend($.fn.validatebox.defaults.rules, {    
	keywordIsRepeat: {//数据字典，检测该类型是否存在
		validator: function(value){
			var flag;
        	$.ajax({
        		type: 'POST',   
                url: 'checkKeywordIsRepeat.action',  
                data:'keyword='+value,  
                async:false,  
                success: function(data) {  
                	if (data == 'ok'){
            			flag =  true;
            		}else{
            			flag = false;
            		}
                }
        	});
        	return flag;
		},    
        message: '该类型已存在，请直接选择该类型进行添加'
	},
	loginNameIsRepeat: {//用户管理，检测登录名是否存在
		validator: function(value){
			var flag;
        	$.ajax({
        		type: 'POST',   
                url: 'checkLoginNameIsRepeat.action',  
                data:'loginName='+value,  
                async:false,  
                success: function(data) {  
                	if (data == 'ok'){
            			flag =  true;
            		}else{
            			flag = false;
            		}
                }
        	});
        	return flag;
		},    
        message: '该登录名已存在'
	},
	usernameIsRepeat: {//用户管理，检测登录名是否存在
		validator: function(value){
			var flag;
        	$.ajax({
        		type: 'POST',   
                url: 'checkUsernameIsRepeat.action',  
                data:'username='+value,  
                async:false,  
                success: function(data) {  
                	if (data == 'ok'){
            			flag =  true;
            		}else{
            			flag = false;
            		}
                }
        	});
        	return flag;
		},    
        message: '该用户不存在'
	},
	roleIsRepeat: {//角色管理，用于验证角色名是否存在
		validator: function(value){
			var flag;
        	$.ajax({
        		type: 'POST',   
                url: 'checkRoleIsRepeat.action',  
                data:'roleName='+value,  
                async:false,  
                success: function(data) {  
                	if (data == 'ok'){
            			flag =  true;
            		}else{
            			flag = false;
            		}
                }
        	});
        	return flag;
		},    
        message: '该角色已存在'
	},
	equals: {//更改密码，验证两次密码是否相同    
        validator: function(value,param){    
            return value == $(param[0]).val();    
        },    
        message: '两次密码输入不正确'   
    },
    checkQuotationNoFormat: {//项目信息评审，报价单编号的格式验证
    	validator: function(value){
    		return  /^[Q][N]\d\d\d\d[-]\d\d.*$/.test( value );
    	},    
        message: '输入格式不正确'
    },
    checkQuantityFormat: {//项目信息评审，数量的格式验证
    	validator: function(value){
    		return  /^\d{1,}[\u4e00-\u9fa5]$/.test( value );
    	},    
        message: '输入格式不正确'
    },
    checkWorkCardNo: {//工程工时，验证工咭号，只能输入4位数字
    	validator: function(value){
    		return  /^\d{4}$/.test( value ) && value != '0000';
    	},    
        message: '请输入4位有效数字'
    },
    checkWorkHours: {//工程工时，验证工时，只能输入1-2为数字，小数点后面只能输入1位
    	validator: function(value,param){
    		if ($(param[0]).combobox('getValue') == 1){//正班(小数点前面只能有一位，小数点后面也只能有一位，并且不能大于8)
    			if (value > 8){
    				$.fn.validatebox.defaults.rules.checkWorkHours.message = '正班工时最多八小时';
    				return false;
    			} else if (!/^[0-8]+(\.[0,5])?$/.test( value )){
    				$.fn.validatebox.defaults.rules.checkWorkHours.message = '格式错误，只能是正数并且小数点后面只能一位并且只能是0或者5';
    				return false;
    			}else{
    				var flag = true;
	            	$.ajax({
	            		type: 'POST',   
	                    url: 'checkRemainingTime.action',  
	                    data:{workShiftId:$(param[0]).combobox('getValue'),workHoursDate:$(param[1]).datebox('getValue'),id:$(param[2]).val()},
	                    async:false,  
	                    success: function(data) {
		                	if (8-data-value<0){
		                		$.fn.validatebox.defaults.rules.checkWorkHours.message = '您输入的正班工时超过今天的最大剩余工时'+(8-data);
		                		flag =  false;
		                	}
	                    }
	            	});
	            	return flag;
    			}
    			return true;
    			
    		}else if ($(param[0]).combobox('getValue') == 2){//加班（小数点前面只能1-2位，小数点后面只能有一位，并且不能大于24）
    			if (value > 24){
    				$.fn.validatebox.defaults.rules.checkWorkHours.message = '加班工时不能超过每天最大时间';
    				return false;
    			} else if (!/^[0-9]{1,2}(\.[0,5])?$/.test( value )){
    				$.fn.validatebox.defaults.rules.checkWorkHours.message = '格式错误，只能是正数并且小数点后面只能一位并且只能是0或者5';
    				return false;
    			}else{
    				var flag = true;
	    			$.ajax({
	            		type: 'POST',   
	                    url: 'checkRemainingTime.action',  
	                    data:{workShiftId:$(param[0]).combobox('getValue'),workHoursDate:$(param[1]).datebox('getValue'),id:$(param[2]).val()}, 
	                    async:false,  
	                    success: function(data) {
	                		if (24-data-value<0){
	                    		$.fn.validatebox.defaults.rules.checkWorkHours.message = '您输入的加班工时超过今天的最大剩余工时'+(24-data);
	                    		flag = false;
	                    	}
	                    }
	    			});
	    			return flag;
    			}
    			return true;
    		}
    	},    
        message: ''
    },
    positiveInteger: {//项目评审工时计算的正整数校验
    	validator: function(value){
    		return  /^\d*$/.test( value );
    	},    
        message: '只能输入正整数'
    },
    positiveDecimal:{
    	validator: function(value){
    		return  /^\d*(\.\d{1,})?$/.test( value );
    	},    
        message: '只能输入正小数'
    },
    checkTimes: {//项目评审工时计算的只能1-2位小数的校验
    	validator: function(value){
    		return  /^\d*(\.\d{1,2})?$/.test( value );
    	},    
        message: '最多只能两位小数的正数'
    },
    checkBPMN: {
    	validator: function(value){
    		var values = value.split(".");
    		var suffix = values[values.length-1];
    		if (suffix.toLowerCase() == "bpmn"){
    			return  true;
    		}else{
    			return false;
    		}
    	},    
        message: '只能上传bpmn文件'
    },
    checkPNG: {
    	validator: function(value){
    		var values = value.split(".");
    		var suffix = values[values.length-1];
    		if (suffix.toLowerCase() == "png"){
    			return  true;
    		}else{
    			return false;
    		}
    	},    
        message: '只能上传bpmn文件'
    },
    checkPDF: {
    	validator: function(value){
    		var values = value.split(".");
    		var suffix = values[values.length-1];
    		if (suffix.toLowerCase() == "pdf"){
    			return  true;
    		}else{
    			return false;
    		}
    	},    
        message: '只能上传pdf文件'
    },
    checkExcel: {
    	validator: function(value){
    		var flag = true;
    		var fileNames = value.split(",");
    		for (var i=0;i<fileNames.length;i++){
	    		var fileName = fileNames[i].split(".");
	    		var suffix = fileName[fileName.length-1];
	    		if (suffix.toLowerCase() != "xls"){
	    			flag = true;
	    			return;
	    		}
    		}
    		return flag;
    	},    
        message: '只能上传Excel文件'
    },
    checkWorkCardNoFormat: {//工咭号码的格式验证
    	validator: function(value){
    		return  /^([C][J]|[B][J]|[R][D]|[H][J]|[I])\d\d\d\d[-]\d\d$/.test( value );
    	},    
        message: '输入格式不正确'
    },
    checkStorageWarehouseWorkCardFormat: {//存仓工咭号码的格式验证
    	validator: function(value){
    		return  /^([F][G]|[S][G])\d\d\d\d[-]\d\d$/.test( value );
    	},    
        message: '输入格式不正确'
    },
    checkUsernameIsRepeat: {//差旅(APP)人员用户管理，检测用户名是否存在
		validator: function(value){
			var flag;
        	$.ajax({
        		type: 'POST',   
                url: 'checkUsernameIsRepeat.action',  
                data:'username='+value,  
                async:false,  
                success: function(data) {  
                	if (data == 'ok'){
            			flag =  true;
            		}else{
            			flag = false;
            		}
                }
        	});
        	return flag;
		},    
        message: '该用户名已存在'
	},
	checkWorkNoIsRepeat: {//差旅(APP)人员用户管理，检测工号是否存在
		validator: function(value){
			var flag;
        	$.ajax({
        		type: 'POST',   
                url: 'checkWorkNoIsRepeat.action',  
                data:'workNo='+value,  
                async:false,  
                success: function(data) {  
                	if (data == 'ok'){
            			flag =  true;
            		}else{
            			flag = false;
            		}
                }
        	});
        	return flag;
		},    
        message: '该工号已存在'
	},
	checkNumber:{//差旅的登记价钱的数值校验
		validator: function(value){
			if (!isNaN(value)){
				if ((value*1) <= 0){
					$.fn.validatebox.defaults.rules.checkNumber.message = '不能小于等于0';
					return false;
				}
			}else{
				$.fn.validatebox.defaults.rules.checkNumber.message = '只能输入数字';
				return false;
			}
			return true;
		},    
        message: ''
	},
	checkWorkCardNoFormatAndQN: {//出差会存在QN编号
		validator: function(value){
    		return  /^([C][J]|[B][J]|[R][D]|[H][J]|[I]|[Q][N])\d\d\d\d[-]\d\d$/.test( value );
    	},    
        message: '输入格式不正确'
	},
	checkWorkCardNoFormatForTrainTicket: {//工咭号码的格式验证
    	validator: function(value){
    		return  /^([C][J]|[B][J]|[R][D]|[H][J]|[Q][N]|[I])\d\d\d\d[-]\d\d$/.test( value ) || value == "无工咭";
    	},    
        message: '输入格式不正确，没有工咭时，请填写"无工咭"'
    },
    positiveDecimalForOne:{//只能有一位小数点的正小数
    	validator: function(value){
    		return  /^\d*(\.\d)?$/.test( value );
    	},    
        message: '只能输入小数点后面只有一位的正小数'
	},
	checkFileSize:{//检测文件大小
		validator: function(value,param){
			var b = true;
			var message = "";
			var flag = $("#"+param[1]).val();//获取标识符，
			if (flag == 'add'){//如果标识符为add，则为新增操作,则需要判断是否存在改文件名
				$.ajax({
					type:'POST',//post请求
					url: 'checkFileNameIsRepeat.action',//ajax请求的url
					data: 'fileName='+value,  
					async: false,//异步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							if (data.isRepeat){//重复了
								message = '已经存在该文件名的文件';
								b = false;
							}else{
								b = true;
							}
						}else{
							message = '服务器异常';
							b = false;
						}
					}
				});
			}
			if (b){
				var maxSize = param[0]*1024*1024;
				var file = document.getElementById('filebox_file_id_1').files[0];
				if (file.size <= maxSize){
					return true;
				}else{
					$.fn.validatebox.defaults.rules.checkFileSize.message = '最大只能上传'+param[0]+'M的文件';
					return false;
				}
			}else{
				$.fn.validatebox.defaults.rules.checkFileSize.message = message;
				return false;
			}
    	},    
    	message: ''
	},
	checkMapNameIsRepeat: {//用户管理，检测登录名是否存在
		validator: function(value,param){
			var flag;
        	$.ajax({
        		type: 'POST',   
                url: 'checkMapNameIsRepeat.action',  
                data:param[0]+"="+value,  
                async:false,  
                success: function(data) {  
                	if (data == 'ok'){
            			flag =  true;
            		}else{
            			flag = false;
            		}
                }
        	});
        	return flag;
		},    
        message: '地图名称已存在'
	},
    checkPic: {
    	validator: function(value){
    		var values = value.split(".");
    		var suffix = values[values.length-1];
    		if (suffix.toLowerCase() == "png" || suffix.toLowerCase() == "jpg"){
    			return  true;
    		}else{
    			return false;
    		}
    	},    
        message: '只能上传png、jpg的图片文件'
    },
});