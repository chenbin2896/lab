//服务层
app.service('labstateService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../labstate/findAll');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../labstate/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../labstate/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../labstate/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../labstate/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../labstate/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../labstate/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
