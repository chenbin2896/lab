//服务层
app.service('announcmentService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../announcment/findAll');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../announcment/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../announcment/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../announcment/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../announcment/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../announcment/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../announcment/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
