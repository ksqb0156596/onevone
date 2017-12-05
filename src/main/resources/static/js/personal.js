layui.use('upload', function () {
    var upload = layui.upload;
    upload.render({
        elem: '#photo',
        url: '/upload',
        accept: 'images',
        field: 'file',
        before: function () {
            layer.load(2);
        },
        done: function (data) {
            layer.closeAll('loading');
            $("#preview-file").attr('src',$utils.httpUrl + data.message)
            $("#preview-file").attr('img-id',data.message)
        }
    })
    upload.render({
        elem: '#video',
        url: '/upload',
        accept: 'video',
        field: 'file',
        before: function () {
            layer.load(2);
        },
        done: function (data) {
            layer.closeAll('loading');
            $("#preview-fileVideo").attr('src',$utils.httpUrl + data.message)
            $("#preview-fileVideo").attr('img-id',data.message)
        }
    })
    upload.render({
        elem: '#pic',
        url: '/upload',
        accept: 'images',
        multiple: true,
        field: 'file',
        before: function () {
            layer.load(2);
        },
        done: function (data) {
            layer.closeAll('loading');
            $('#showPic').append('<img name="pictures" class="pic" onclick="deletePic(event)" src="' + $utils.httpUrl + data.message + '" img-id="' + data.message + '" />')
        }
    })
})
function previewVideo(){
    $("#preview-fileVideo").attr('src',$utils.httpUrl + document.getElementById("fileVideo").value.trim())
    $("#preview-fileVideo").attr('img-id',document.getElementById("fileVideo").value.trim())
}
layui.use('form', function () {
    var form = layui.form;
    form.on('radio(type)',function(data){
        getOptions(data.value,function(){
            form.render('select');
        })
    });
    form.on('radio(showType)',function(data){
        if(data.value == 0){
            $('#video').show();
            $('#showVideo').show();
            $('#pic').hide()
            $('#showPic').hide()
        }else if(data.value == 1){
            $('#video').hide();
            $('#showVideo').hide();
            $('#pic').show()
            $('#showPic').show()
        }
    })
})
var queryObj = {
    status : 1
}
findList();

function deletePic(e){
    e = window.event || e;
    layer.confirm('确认删除？', {icon: 3, title:'提示'}, function(index){
        $(e.target).remove();
        layer.close(index);
    });
}

function findList(){
    $.ajax({
        url: '/personal/findList',
        data: queryObj
    }).then(function(data){
        var list = data.result;
        $('#table').bootstrapTable('destroy').bootstrapTable({
            searchText:"",
            columns: [{
                field: 'id',
                title: 'id'
            }, {
                field: 'name',
                title: '名称'
            }, {
                field: 'status',
                title: '状态',
                formatter: function(value, row, index){
                    if(row.status == 0)return "禁用"
                    if(row.status == 1)return "启用"
                }
            }, {
                field: 'type',
                title: '类型',
                formatter: function(value, row, index){
                    var type = row.type;
                    switch (type){
                        case 0 : return "摄影"
                        case 1 : return "化妆"
                        case 2 : return "主持"
                        case 3 : return "航拍"
                        case 4 : return "乐队"
                        case 5 : return "摄像"
                        default : return "-"
                    }
                }
            }, {
                field: 'groupName',
                title: '所属工作室'
            },{
                title: '操作',
                events: {
                    'click .label-info': edit,
                    'click .label-danger': del,
                },
                formatter: function(){
                    return '<label class="label label-info">编辑</label><label class="label label-danger">删除</label>';
//                            '<label class="label label-default">不推荐</label><label class="label label-primary" style="display: none">推荐</label> '
                }
            }],
            data: list
        })
    })
}
function del(e, value, row, index){
    $.ajax({
        url: '/personal/delete',
        data:{id:row.id},
        type: 'post'
    }).then(function(data){
        layer.msg("删除成功");
        findList();
    })
}
function edit(e, value, row, index){
    reset();
    var keys = Object.keys(row);
    for(var i in keys){
        var key = keys[i];
        var form = $('[name="' + key + '"]');
        if(key == 'photoUrl'){
            if(row[key] && row[key]!=null){
                $('#preview-file').attr("src",$utils.httpUrl + row[key]);
                $('#preview-file').attr("img-id",row[key]);
            }
            continue;
        }else if(key == 'showType'){
            var showType = row[key];
            $('input[name="showType"][value="' + showType + '"]').click();
            if(showType == 0){
                $('#preview-fileVideo').attr("src",$utils.httpUrl + row.videoUrl);
                $('#preview-fileVideo').attr("img-id",row.videoUrl);
                $('#video').show();
                $('#showVideo').show();
                $('#pic').hide()
                $('#showPic').hide()
            }else if(showType == 1){
                if(row.picUrl != undefined){
                    var pic = row.picUrl.split(',');
                    for(var j in pic){
                        $('#showPic').append('<img name="pictures" class="pic" onclick="deletePic(event)" src="' + $utils.httpUrl + pic[j] + '" img-id="' + pic[j] + '" />')
                    }
                }
                $('#video').hide();
                $('#showVideo').hide();
                $('#pic').show()
                $('#showPic').show()
            }
            continue;
        }
        if(form.is('input')){
            if(form.attr('type') == 'checkbox'){
                form.each(function(item){
                    if(row[key].indexOf(this.value) >  -1){
                        $(this).attr("checked",true);
                    }
                })
            }else if(form.attr('type') == 'radio'){
                form.each(function (item) {
                    if(row[key] == this.value){
                        $(this).attr("checked",true);
                        return;
                    }
                })
            }else{
                $('[name="' + key + '"]').val(row[key]);
            }

        }else if(form.is("select")){
            getOptions(row.type,function(){
                $("#groupId").val(row.groupId);
            })
        }else{
            $('[name="' + key + '"]').text(row[key]);
        }

    }
    layui.use('form', function () {
        layui.form.render();
    })
    showShadow();
}
function upload(id,e){
    e = e || window.event;
    e.preventDefault();
    function success(data){
        $("#preview-" + id).attr("src",$utils.httpUrl + data)
        $("#preview-" + id).attr("img-id",data)
    }
    $utils.upload(id,success);
}
function save(e){
    e = e || window.event;
    e.preventDefault();
    var formData = new FormData(document.forms.detailForm);
    var imgId = $('#preview-file').attr('img-id');
    if(imgId){
        formData.append("photoUrl",imgId);
    }
    imgId = $('#preview-fileVideo').attr('img-id');
    if(imgId){
        formData.append("videoUrl",imgId);
    }

    if($('img[name="pictures"]').length > 0){
        var pic = "";
        $('img[name="pictures"]').each(function (item) {
            pic += $(this).attr("img-id") + ",";
        })
        formData.append("picUrl",pic.substring(0,pic.length - 1));
    }
    formData.delete("file");
    formData.delete("fileVideo");
    $.ajax({
        url: '/personal/save',
        data: formData,
        contentType: false,
        processData: false,
        type: 'post'
    }).then(function(data){
        if(data.status == 1){
            layer.msg("保存成功")
            reset();
            findList();
            closeShadow(null);
        }
    })
}
function showShadow(){
    $("#detail").show(100);
}
function closeShadow(e){
    if(e != null){
        e = e || window.event;
        e.preventDefault();
    }
    $("#detail").hide(100);
    reset();
}
function reset(){
    document.forms.detailForm.reset();
    $('#preview-file').attr('src','');
    $('#preview-fileVideo').attr('src','');
    $('#showPic').html('')
    $('#groupId').html('')
    $('textarea').text('')
}
$('input[name="type"]').on('change',function(){
    getOptions(this.value);
})
function getOptions(type,callback){
    $.ajax({
        url: '/group/findList',
        data: {type:type,status:1}
    }).then(function(data){
        var options = '';
        data = data.result;
        for(var i in data){
            options += '<option value="' + data[i].id + '">' + data[i].name + '</option>'
        }
        $('#groupId').html(options)
        if(callback)callback();
    })
}