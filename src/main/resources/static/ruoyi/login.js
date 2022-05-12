
$(function() {
    validateRule();
    $(".i-checks").iCheck({checkboxClass:"icheckbox_square-green-login"});
	$('.imgcode').click(function() {
		var url =  "/code/getVerify?"+ Math.random();
		$(".imgcode").attr("src", url);
	});
});

$.validator.setDefaults({
    submitHandler: function() {
		login();
    }
});

function login() {
    //alert(11111111);
    //debugger;
	$.modal.loginloading($("#btnSubmit").data("loading"));
	var username = $("input[name='loginName']").val().trim();
    var password = $("input[name='pwd']").val().trim();
    var validateCode = $("input[name='validateCode']").val();
    var rememberMe = $("input[name='rememberme']").is(':checked');
    $.ajax({
        type: "post",
        url: "/oa/login",
        data: {
            "name": username,
            "pwd": password,
            "validateCode" : validateCode,
            "rememberMe": rememberMe
        },
        success: function(r) {
            //console.log(11111111111111);
            //console.log(r);
            if (r.code == 0) {
                location.href ='/oa/index';
                //alert(2222222);
            } else {
            	$.modal.closeLoading();
            	$('.imgcode').click();
            	$.modal.msg(r.msg);
            }
        }
    });
}

//验证
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            loginName: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            loginName: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}
